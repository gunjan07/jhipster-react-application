package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.PartnerOrderDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PartnerOrder} and its DTO {@link PartnerOrderDTO}.
 */
@Mapper(componentModel = "spring", uses = {PartnerMapper.class})
public interface PartnerOrderMapper extends EntityMapper<PartnerOrderDTO, PartnerOrder> {

    @Mapping(source = "partner.id", target = "partnerId")
    PartnerOrderDTO toDto(PartnerOrder partnerOrder);

    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "removeOrder", ignore = true)
    @Mapping(source = "partnerId", target = "partner")
    PartnerOrder toEntity(PartnerOrderDTO partnerOrderDTO);

    default PartnerOrder fromId(Long id) {
        if (id == null) {
            return null;
        }
        PartnerOrder partnerOrder = new PartnerOrder();
        partnerOrder.setId(id);
        return partnerOrder;
    }
}
