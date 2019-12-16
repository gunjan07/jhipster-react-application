package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.PartnerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Partner} and its DTO {@link PartnerDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PartnerMapper extends EntityMapper<PartnerDTO, Partner> {


    @Mapping(target = "partnerOrders", ignore = true)
    @Mapping(target = "removePartnerOrder", ignore = true)
    Partner toEntity(PartnerDTO partnerDTO);

    default Partner fromId(Long id) {
        if (id == null) {
            return null;
        }
        Partner partner = new Partner();
        partner.setId(id);
        return partner;
    }
}
