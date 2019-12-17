package com.mycompany.myapp.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A PartnerOrder.
 */
@Entity
@Table(name = "partner_order")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PartnerOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "submit_date")
    private LocalDate submitDate;

    @Column(name = "last_update_timestamp")
    private LocalDate lastUpdateTimestamp;

    @Column(name = "last_update_id")
    private String lastUpdateId;

    @Column(name = "sales_order_id")
    private String salesOrderId;

    @OneToMany(mappedBy = "partnerOrder")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PartnerAllocatedQuota> orders = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("partnerOrders")
    private Partner partner;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSubmitDate() {
        return submitDate;
    }

    public PartnerOrder submitDate(LocalDate submitDate) {
        this.submitDate = submitDate;
        return this;
    }

    public void setSubmitDate(LocalDate submitDate) {
        this.submitDate = submitDate;
    }

    public LocalDate getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public PartnerOrder lastUpdateTimestamp(LocalDate lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        return this;
    }

    public void setLastUpdateTimestamp(LocalDate lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public PartnerOrder lastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
        return this;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public String getSalesOrderId() {
        return salesOrderId;
    }

    public PartnerOrder salesOrderId(String salesOrderId) {
        this.salesOrderId = salesOrderId;
        return this;
    }

    public void setSalesOrderId(String salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Set<PartnerAllocatedQuota> getOrders() {
        return orders;
    }

    public PartnerOrder orders(Set<PartnerAllocatedQuota> partnerAllocatedQuotas) {
        this.orders = partnerAllocatedQuotas;
        return this;
    }

    public PartnerOrder addOrder(PartnerAllocatedQuota partnerAllocatedQuota) {
        this.orders.add(partnerAllocatedQuota);
        partnerAllocatedQuota.setPartnerOrder(this);
        return this;
    }

    public PartnerOrder removeOrder(PartnerAllocatedQuota partnerAllocatedQuota) {
        this.orders.remove(partnerAllocatedQuota);
        partnerAllocatedQuota.setPartnerOrder(null);
        return this;
    }

    public void setOrders(Set<PartnerAllocatedQuota> partnerAllocatedQuotas) {
        this.orders = partnerAllocatedQuotas;
    }

    public Partner getPartner() {
        return partner;
    }

    public PartnerOrder partner(Partner partner) {
        this.partner = partner;
        return this;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PartnerOrder)) {
            return false;
        }
        return id != null && id.equals(((PartnerOrder) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PartnerOrder{" +
            "id=" + getId() +
            ", submitDate='" + getSubmitDate() + "'" +
            ", lastUpdateTimestamp='" + getLastUpdateTimestamp() + "'" +
            ", lastUpdateId='" + getLastUpdateId() + "'" +
            ", salesOrderId='" + getSalesOrderId() + "'" +
            "}";
    }
}
