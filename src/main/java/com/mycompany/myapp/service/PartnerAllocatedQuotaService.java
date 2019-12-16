package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.PartnerAllocatedQuota;
import com.mycompany.myapp.repository.PartnerAllocatedQuotaRepository;
import com.mycompany.myapp.service.dto.PartnerAllocatedQuotaDTO;
import com.mycompany.myapp.service.mapper.PartnerAllocatedQuotaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link PartnerAllocatedQuota}.
 */
@Service
@Transactional
public class PartnerAllocatedQuotaService {

    private final Logger log = LoggerFactory.getLogger(PartnerAllocatedQuotaService.class);

    private final PartnerAllocatedQuotaRepository partnerAllocatedQuotaRepository;

    private final PartnerAllocatedQuotaMapper partnerAllocatedQuotaMapper;

    public PartnerAllocatedQuotaService(PartnerAllocatedQuotaRepository partnerAllocatedQuotaRepository, PartnerAllocatedQuotaMapper partnerAllocatedQuotaMapper) {
        this.partnerAllocatedQuotaRepository = partnerAllocatedQuotaRepository;
        this.partnerAllocatedQuotaMapper = partnerAllocatedQuotaMapper;
    }

    /**
     * Save a partnerAllocatedQuota.
     *
     * @param partnerAllocatedQuotaDTO the entity to save.
     * @return the persisted entity.
     */
    public PartnerAllocatedQuotaDTO save(PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO) {
        log.debug("Request to save PartnerAllocatedQuota : {}", partnerAllocatedQuotaDTO);
        PartnerAllocatedQuota partnerAllocatedQuota = partnerAllocatedQuotaMapper.toEntity(partnerAllocatedQuotaDTO);
        partnerAllocatedQuota = partnerAllocatedQuotaRepository.save(partnerAllocatedQuota);
        return partnerAllocatedQuotaMapper.toDto(partnerAllocatedQuota);
    }

    /**
     * Get all the partnerAllocatedQuotas.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PartnerAllocatedQuotaDTO> findAll() {
        log.debug("Request to get all PartnerAllocatedQuotas");
        return partnerAllocatedQuotaRepository.findAll().stream()
            .map(partnerAllocatedQuotaMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one partnerAllocatedQuota by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PartnerAllocatedQuotaDTO> findOne(Long id) {
        log.debug("Request to get PartnerAllocatedQuota : {}", id);
        return partnerAllocatedQuotaRepository.findById(id)
            .map(partnerAllocatedQuotaMapper::toDto);
    }

    /**
     * Delete the partnerAllocatedQuota by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PartnerAllocatedQuota : {}", id);
        partnerAllocatedQuotaRepository.deleteById(id);
    }
}
