package com.mycompany.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class PartnerOrderDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PartnerOrderDTO.class);
        PartnerOrderDTO partnerOrderDTO1 = new PartnerOrderDTO();
        partnerOrderDTO1.setId(1L);
        PartnerOrderDTO partnerOrderDTO2 = new PartnerOrderDTO();
        assertThat(partnerOrderDTO1).isNotEqualTo(partnerOrderDTO2);
        partnerOrderDTO2.setId(partnerOrderDTO1.getId());
        assertThat(partnerOrderDTO1).isEqualTo(partnerOrderDTO2);
        partnerOrderDTO2.setId(2L);
        assertThat(partnerOrderDTO1).isNotEqualTo(partnerOrderDTO2);
        partnerOrderDTO1.setId(null);
        assertThat(partnerOrderDTO1).isNotEqualTo(partnerOrderDTO2);
    }
}
