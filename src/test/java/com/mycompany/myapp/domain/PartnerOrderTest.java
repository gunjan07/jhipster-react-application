package com.mycompany.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class PartnerOrderTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PartnerOrder.class);
        PartnerOrder partnerOrder1 = new PartnerOrder();
        partnerOrder1.setId(1L);
        PartnerOrder partnerOrder2 = new PartnerOrder();
        partnerOrder2.setId(partnerOrder1.getId());
        assertThat(partnerOrder1).isEqualTo(partnerOrder2);
        partnerOrder2.setId(2L);
        assertThat(partnerOrder1).isNotEqualTo(partnerOrder2);
        partnerOrder1.setId(null);
        assertThat(partnerOrder1).isNotEqualTo(partnerOrder2);
    }
}
