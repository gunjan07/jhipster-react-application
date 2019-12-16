package com.mycompany.myapp.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.PartnerOrder} entity.
 */
public class PartnerOrderDTO implements Serializable {

    private Long id;

    private String salesOrderId;

    private String orderDate;

    private String serviceNumber;


    private Long partnerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(String salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
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
            ", salesOrderId='" + getSalesOrderId() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", serviceNumber='" + getServiceNumber() + "'" +
            ", partner=" + getPartnerId() +
            "}";
    }
}
