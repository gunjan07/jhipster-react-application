package com.mycompany.myapp.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A PartnerAllocatedQuota.
 */
@Entity
@Table(name = "partner_allocated_quota")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PartnerAllocatedQuota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "last_update_timestamp")
    private LocalDate lastUpdateTimestamp;

    @Column(name = "last_update_id")
    private String lastUpdateId;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JsonIgnoreProperties("partnerAllocatedQuotas")
    private Product productDetails;

    @ManyToOne
    @JsonIgnoreProperties("orders")
    private PartnerOrder partnerOrder;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PartnerAllocatedQuota quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public PartnerAllocatedQuota startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public PartnerAllocatedQuota expiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public PartnerAllocatedQuota lastUpdateTimestamp(LocalDate lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        return this;
    }

    public void setLastUpdateTimestamp(LocalDate lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public PartnerAllocatedQuota lastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
        return this;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public String getStatus() {
        return status;
    }

    public PartnerAllocatedQuota status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getProductDetails() {
        return productDetails;
    }

    public PartnerAllocatedQuota productDetails(Product product) {
        this.productDetails = product;
        return this;
    }

    public void setProductDetails(Product product) {
        this.productDetails = product;
    }

    public PartnerOrder getPartnerOrder() {
        return partnerOrder;
    }

    public PartnerAllocatedQuota partnerOrder(PartnerOrder partnerOrder) {
        this.partnerOrder = partnerOrder;
        return this;
    }

    public void setPartnerOrder(PartnerOrder partnerOrder) {
        this.partnerOrder = partnerOrder;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PartnerAllocatedQuota)) {
            return false;
        }
        return id != null && id.equals(((PartnerAllocatedQuota) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PartnerAllocatedQuota{" +
            "id=" + getId() +
            ", quantity=" + getQuantity() +
            ", startDate='" + getStartDate() + "'" +
            ", expiryDate='" + getExpiryDate() + "'" +
            ", lastUpdateTimestamp='" + getLastUpdateTimestamp() + "'" +
            ", lastUpdateId='" + getLastUpdateId() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
