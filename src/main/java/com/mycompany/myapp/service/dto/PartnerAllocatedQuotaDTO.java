package com.mycompany.myapp.service.dto;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.PartnerAllocatedQuota} entity.
 */
public class PartnerAllocatedQuotaDTO implements Serializable {

    private Long id;

    private Integer quantity;

    private LocalDate startDate;

    private LocalDate expiryDate;

    private LocalDate lastUpdateTimestamp;

    private String lastUpdateId;

    private String status;


    private Long productDetailsId;

    private Long partnerOrderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProductDetailsId() {
        return productDetailsId;
    }

    public void setProductDetailsId(Long productId) {
        this.productDetailsId = productId;
    }

    public Long getPartnerOrderId() {
        return partnerOrderId;
    }

    public void setPartnerOrderId(Long partnerOrderId) {
        this.partnerOrderId = partnerOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO = (PartnerAllocatedQuotaDTO) o;
        if (partnerAllocatedQuotaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), partnerAllocatedQuotaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PartnerAllocatedQuotaDTO{" +
            "id=" + getId() +
            ", quantity=" + getQuantity() +
            ", startDate='" + getStartDate() + "'" +
            ", expiryDate='" + getExpiryDate() + "'" +
            ", lastUpdateTimestamp='" + getLastUpdateTimestamp() + "'" +
            ", lastUpdateId='" + getLastUpdateId() + "'" +
            ", status='" + getStatus() + "'" +
            ", productDetails=" + getProductDetailsId() +
            ", partnerOrder=" + getPartnerOrderId() +
            "}";
    }
}
