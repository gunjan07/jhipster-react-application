package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class PartnerAllocatedQuotaMapperTest {

    private PartnerAllocatedQuotaMapper partnerAllocatedQuotaMapper;

    @BeforeEach
    public void setUp() {
        partnerAllocatedQuotaMapper = new PartnerAllocatedQuotaMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(partnerAllocatedQuotaMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(partnerAllocatedQuotaMapper.fromId(null)).isNull();
    }
}
