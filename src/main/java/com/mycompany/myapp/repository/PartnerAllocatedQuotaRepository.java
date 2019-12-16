package com.mycompany.myapp.repository;
import com.mycompany.myapp.domain.PartnerAllocatedQuota;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the PartnerAllocatedQuota entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PartnerAllocatedQuotaRepository extends JpaRepository<PartnerAllocatedQuota, Long> {

}
