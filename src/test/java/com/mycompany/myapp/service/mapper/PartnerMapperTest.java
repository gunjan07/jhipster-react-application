package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class PartnerMapperTest {

    private PartnerMapper partnerMapper;

    @BeforeEach
    public void setUp() {
        partnerMapper = new PartnerMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(partnerMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(partnerMapper.fromId(null)).isNull();
    }
}
