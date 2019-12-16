package com.mycompany.myapp.repository;
import com.mycompany.myapp.domain.PartnerOrder;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the PartnerOrder entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PartnerOrderRepository extends JpaRepository<PartnerOrder, Long> {

}
