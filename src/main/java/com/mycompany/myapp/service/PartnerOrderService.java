package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.PartnerOrder;
import com.mycompany.myapp.repository.PartnerOrderRepository;
import com.mycompany.myapp.service.dto.PartnerOrderDTO;
import com.mycompany.myapp.service.mapper.PartnerOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link PartnerOrder}.
 */
@Service
@Transactional
public class PartnerOrderService {

    private final Logger log = LoggerFactory.getLogger(PartnerOrderService.class);

    private final PartnerOrderRepository partnerOrderRepository;

    private final PartnerOrderMapper partnerOrderMapper;

    public PartnerOrderService(PartnerOrderRepository partnerOrderRepository, PartnerOrderMapper partnerOrderMapper) {
        this.partnerOrderRepository = partnerOrderRepository;
        this.partnerOrderMapper = partnerOrderMapper;
    }

    /**
     * Save a partnerOrder.
     *
     * @param partnerOrderDTO the entity to save.
     * @return the persisted entity.
     */
    public PartnerOrderDTO save(PartnerOrderDTO partnerOrderDTO) {
        log.debug("Request to save PartnerOrder : {}", partnerOrderDTO);
        PartnerOrder partnerOrder = partnerOrderMapper.toEntity(partnerOrderDTO);
        partnerOrder = partnerOrderRepository.save(partnerOrder);
        return partnerOrderMapper.toDto(partnerOrder);
    }

    /**
     * Get all the partnerOrders.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PartnerOrderDTO> findAll() {
        log.debug("Request to get all PartnerOrders");
        return partnerOrderRepository.findAll().stream()
            .map(partnerOrderMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one partnerOrder by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PartnerOrderDTO> findOne(Long id) {
        log.debug("Request to get PartnerOrder : {}", id);
        return partnerOrderRepository.findById(id)
            .map(partnerOrderMapper::toDto);
    }

    /**
     * Delete the partnerOrder by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PartnerOrder : {}", id);
        partnerOrderRepository.deleteById(id);
    }
}
