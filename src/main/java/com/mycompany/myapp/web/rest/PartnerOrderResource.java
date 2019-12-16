package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.PartnerOrderService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.PartnerOrderDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.PartnerOrder}.
 */
@RestController
@RequestMapping("/api")
public class PartnerOrderResource {

    private final Logger log = LoggerFactory.getLogger(PartnerOrderResource.class);

    private static final String ENTITY_NAME = "partnerOrder";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PartnerOrderService partnerOrderService;

    public PartnerOrderResource(PartnerOrderService partnerOrderService) {
        this.partnerOrderService = partnerOrderService;
    }

    /**
     * {@code POST  /partner-orders} : Create a new partnerOrder.
     *
     * @param partnerOrderDTO the partnerOrderDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new partnerOrderDTO, or with status {@code 400 (Bad Request)} if the partnerOrder has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/partner-orders")
    public ResponseEntity<PartnerOrderDTO> createPartnerOrder(@RequestBody PartnerOrderDTO partnerOrderDTO) throws URISyntaxException {
        log.debug("REST request to save PartnerOrder : {}", partnerOrderDTO);
        if (partnerOrderDTO.getId() != null) {
            throw new BadRequestAlertException("A new partnerOrder cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PartnerOrderDTO result = partnerOrderService.save(partnerOrderDTO);
        return ResponseEntity.created(new URI("/api/partner-orders/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /partner-orders} : Updates an existing partnerOrder.
     *
     * @param partnerOrderDTO the partnerOrderDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated partnerOrderDTO,
     * or with status {@code 400 (Bad Request)} if the partnerOrderDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the partnerOrderDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/partner-orders")
    public ResponseEntity<PartnerOrderDTO> updatePartnerOrder(@RequestBody PartnerOrderDTO partnerOrderDTO) throws URISyntaxException {
        log.debug("REST request to update PartnerOrder : {}", partnerOrderDTO);
        if (partnerOrderDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PartnerOrderDTO result = partnerOrderService.save(partnerOrderDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, partnerOrderDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /partner-orders} : get all the partnerOrders.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of partnerOrders in body.
     */
    @GetMapping("/partner-orders")
    public List<PartnerOrderDTO> getAllPartnerOrders() {
        log.debug("REST request to get all PartnerOrders");
        return partnerOrderService.findAll();
    }

    /**
     * {@code GET  /partner-orders/:id} : get the "id" partnerOrder.
     *
     * @param id the id of the partnerOrderDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the partnerOrderDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/partner-orders/{id}")
    public ResponseEntity<PartnerOrderDTO> getPartnerOrder(@PathVariable Long id) {
        log.debug("REST request to get PartnerOrder : {}", id);
        Optional<PartnerOrderDTO> partnerOrderDTO = partnerOrderService.findOne(id);
        return ResponseUtil.wrapOrNotFound(partnerOrderDTO);
    }

    /**
     * {@code DELETE  /partner-orders/:id} : delete the "id" partnerOrder.
     *
     * @param id the id of the partnerOrderDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/partner-orders/{id}")
    public ResponseEntity<Void> deletePartnerOrder(@PathVariable Long id) {
        log.debug("REST request to delete PartnerOrder : {}", id);
        partnerOrderService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
