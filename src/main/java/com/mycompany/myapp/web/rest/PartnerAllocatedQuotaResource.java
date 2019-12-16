package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.PartnerAllocatedQuotaService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.PartnerAllocatedQuotaDTO;

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
 * REST controller for managing {@link com.mycompany.myapp.domain.PartnerAllocatedQuota}.
 */
@RestController
@RequestMapping("/api")
public class PartnerAllocatedQuotaResource {

    private final Logger log = LoggerFactory.getLogger(PartnerAllocatedQuotaResource.class);

    private static final String ENTITY_NAME = "partnerAllocatedQuota";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PartnerAllocatedQuotaService partnerAllocatedQuotaService;

    public PartnerAllocatedQuotaResource(PartnerAllocatedQuotaService partnerAllocatedQuotaService) {
        this.partnerAllocatedQuotaService = partnerAllocatedQuotaService;
    }

    /**
     * {@code POST  /partner-allocated-quotas} : Create a new partnerAllocatedQuota.
     *
     * @param partnerAllocatedQuotaDTO the partnerAllocatedQuotaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new partnerAllocatedQuotaDTO, or with status {@code 400 (Bad Request)} if the partnerAllocatedQuota has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/partner-allocated-quotas")
    public ResponseEntity<PartnerAllocatedQuotaDTO> createPartnerAllocatedQuota(@RequestBody PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO) throws URISyntaxException {
        log.debug("REST request to save PartnerAllocatedQuota : {}", partnerAllocatedQuotaDTO);
        if (partnerAllocatedQuotaDTO.getId() != null) {
            throw new BadRequestAlertException("A new partnerAllocatedQuota cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PartnerAllocatedQuotaDTO result = partnerAllocatedQuotaService.save(partnerAllocatedQuotaDTO);
        return ResponseEntity.created(new URI("/api/partner-allocated-quotas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /partner-allocated-quotas} : Updates an existing partnerAllocatedQuota.
     *
     * @param partnerAllocatedQuotaDTO the partnerAllocatedQuotaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated partnerAllocatedQuotaDTO,
     * or with status {@code 400 (Bad Request)} if the partnerAllocatedQuotaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the partnerAllocatedQuotaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/partner-allocated-quotas")
    public ResponseEntity<PartnerAllocatedQuotaDTO> updatePartnerAllocatedQuota(@RequestBody PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO) throws URISyntaxException {
        log.debug("REST request to update PartnerAllocatedQuota : {}", partnerAllocatedQuotaDTO);
        if (partnerAllocatedQuotaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PartnerAllocatedQuotaDTO result = partnerAllocatedQuotaService.save(partnerAllocatedQuotaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, partnerAllocatedQuotaDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /partner-allocated-quotas} : get all the partnerAllocatedQuotas.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of partnerAllocatedQuotas in body.
     */
    @GetMapping("/partner-allocated-quotas")
    public List<PartnerAllocatedQuotaDTO> getAllPartnerAllocatedQuotas() {
        log.debug("REST request to get all PartnerAllocatedQuotas");
        return partnerAllocatedQuotaService.findAll();
    }

    /**
     * {@code GET  /partner-allocated-quotas/:id} : get the "id" partnerAllocatedQuota.
     *
     * @param id the id of the partnerAllocatedQuotaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the partnerAllocatedQuotaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/partner-allocated-quotas/{id}")
    public ResponseEntity<PartnerAllocatedQuotaDTO> getPartnerAllocatedQuota(@PathVariable Long id) {
        log.debug("REST request to get PartnerAllocatedQuota : {}", id);
        Optional<PartnerAllocatedQuotaDTO> partnerAllocatedQuotaDTO = partnerAllocatedQuotaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(partnerAllocatedQuotaDTO);
    }

    /**
     * {@code DELETE  /partner-allocated-quotas/:id} : delete the "id" partnerAllocatedQuota.
     *
     * @param id the id of the partnerAllocatedQuotaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/partner-allocated-quotas/{id}")
    public ResponseEntity<Void> deletePartnerAllocatedQuota(@PathVariable Long id) {
        log.debug("REST request to delete PartnerAllocatedQuota : {}", id);
        partnerAllocatedQuotaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
