package com.mycompany.myapp.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
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

    @Column(name = "sales_order_id")
    private String salesOrderId;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "service_number")
    private String serviceNumber;

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

    public String getOrderDate() {
        return orderDate;
    }

    public PartnerOrder orderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public PartnerOrder serviceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
        return this;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
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
            ", salesOrderId='" + getSalesOrderId() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", serviceNumber='" + getServiceNumber() + "'" +
            "}";
    }
}
