package com.mycompany.myapp.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.Partner} entity.
 */
public class PartnerDTO implements Serializable {

    private Long id;

    private String partnerName;

    private String partnerCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PartnerDTO partnerDTO = (PartnerDTO) o;
        if (partnerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), partnerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PartnerDTO{" +
            "id=" + getId() +
            ", partnerName='" + getPartnerName() + "'" +
            ", partnerCode='" + getPartnerCode() + "'" +
            "}";
    }
}
