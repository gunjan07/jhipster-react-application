package com.mycompany.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class PartnerAllocatedQuotaDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PartnerAllocatedQuotaDTO.class);
        PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO1 = new PartnerAllocatedQuotaDTO();
        partnerAllocatedQuotaDTO1.setId(1L);
        PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO2 = new PartnerAllocatedQuotaDTO();
        assertThat(partnerAllocatedQuotaDTO1).isNotEqualTo(partnerAllocatedQuotaDTO2);
        partnerAllocatedQuotaDTO2.setId(partnerAllocatedQuotaDTO1.getId());
        assertThat(partnerAllocatedQuotaDTO1).isEqualTo(partnerAllocatedQuotaDTO2);
        partnerAllocatedQuotaDTO2.setId(2L);
        assertThat(partnerAllocatedQuotaDTO1).isNotEqualTo(partnerAllocatedQuotaDTO2);
        partnerAllocatedQuotaDTO1.setId(null);
        assertThat(partnerAllocatedQuotaDTO1).isNotEqualTo(partnerAllocatedQuotaDTO2);
    }
}
