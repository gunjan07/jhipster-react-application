package com.mycompany.myapp.service.dto;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.PartnerOrder} entity.
 */
public class PartnerOrderDTO implements Serializable {

    private Long id;

    private LocalDate submitDate;

    private LocalDate lastUpdateTimestamp;

    private String lastUpdateId;

    private String salesOrderId;


    private Long partnerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(LocalDate submitDate) {
        this.submitDate = submitDate;
    }

    public LocalDate getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(LocalDate lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public String getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(String salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PartnerOrderDTO partnerOrderDTO = (PartnerOrderDTO) o;
        if (partnerOrderDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), partnerOrderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PartnerOrderDTO{" +
            "id=" + getId() +
            ", submitDate='" + getSubmitDate() + "'" +
            ", lastUpdateTimestamp='" + getLastUpdateTimestamp() + "'" +
            ", lastUpdateId='" + getLastUpdateId() + "'" +
            ", salesOrderId='" + getSalesOrderId() + "'" +
            ", partner=" + getPartnerId() +
            "}";
    }
}
