package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class PartnerAllocatedQuotaTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PartnerAllocatedQuota.class);
        PartnerAllocatedQuota partnerAllocatedQuota1 = new PartnerAllocatedQuota();
        partnerAllocatedQuota1.setId(1L);
        PartnerAllocatedQuota partnerAllocatedQuota2 = new PartnerAllocatedQuota();
        partnerAllocatedQuota2.setId(partnerAllocatedQuota1.getId());
        assertThat(partnerAllocatedQuota1).isEqualTo(partnerAllocatedQuota2);
        partnerAllocatedQuota2.setId(2L);
        assertThat(partnerAllocatedQuota1).isNotEqualTo(partnerAllocatedQuota2);
        partnerAllocatedQuota1.setId(null);
        assertThat(partnerAllocatedQuota1).isNotEqualTo(partnerAllocatedQuota2);
    }
}
