package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.PartnerAllocatedQuotaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PartnerAllocatedQuota} and its DTO {@link PartnerAllocatedQuotaDTO}.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class, PartnerOrderMapper.class})
public interface PartnerAllocatedQuotaMapper extends EntityMapper<PartnerAllocatedQuotaDTO, PartnerAllocatedQuota> {

    @Mapping(source = "productDetails.id", target = "productDetailsId")
    @Mapping(source = "partnerOrder.id", target = "partnerOrderId")
    PartnerAllocatedQuotaDTO toDto(PartnerAllocatedQuota partnerAllocatedQuota);

    @Mapping(source = "productDetailsId", target = "productDetails")
    @Mapping(source = "partnerOrderId", target = "partnerOrder")
    PartnerAllocatedQuota toEntity(PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO);

    default PartnerAllocatedQuota fromId(Long id) {
        if (id == null) {
            return null;
        }
        PartnerAllocatedQuota partnerAllocatedQuota = new PartnerAllocatedQuota();
        partnerAllocatedQuota.setId(id);
        return partnerAllocatedQuota;
    }
}
