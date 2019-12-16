package com.mycompany.myapp.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Partner.
 */
@Entity
@Table(name = "partner")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Partner implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "partner_name")
    private String partnerName;

    @Column(name = "partner_code")
    private String partnerCode;

    @OneToMany(mappedBy = "partner")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PartnerOrder> partnerOrders = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public Partner partnerName(String partnerName) {
        this.partnerName = partnerName;
        return this;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public Partner partnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
        return this;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Set<PartnerOrder> getPartnerOrders() {
        return partnerOrders;
    }

    public Partner partnerOrders(Set<PartnerOrder> partnerOrders) {
        this.partnerOrders = partnerOrders;
        return this;
    }

    public Partner addPartnerOrder(PartnerOrder partnerOrder) {
        this.partnerOrders.add(partnerOrder);
        partnerOrder.setPartner(this);
        return this;
    }

    public Partner removePartnerOrder(PartnerOrder partnerOrder) {
        this.partnerOrders.remove(partnerOrder);
        partnerOrder.setPartner(null);
        return this;
    }

    public void setPartnerOrders(Set<PartnerOrder> partnerOrders) {
        this.partnerOrders = partnerOrders;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Partner)) {
            return false;
        }
        return id != null && id.equals(((Partner) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Partner{" +
            "id=" + getId() +
            ", partnerName='" + getPartnerName() + "'" +
            ", partnerCode='" + getPartnerCode() + "'" +
            "}";
    }
}
