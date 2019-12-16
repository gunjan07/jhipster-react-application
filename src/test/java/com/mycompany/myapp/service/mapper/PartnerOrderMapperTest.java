package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class PartnerOrderMapperTest {

    private PartnerOrderMapper partnerOrderMapper;

    @BeforeEach
    public void setUp() {
        partnerOrderMapper = new PartnerOrderMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(partnerOrderMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(partnerOrderMapper.fromId(null)).isNull();
    }
}
