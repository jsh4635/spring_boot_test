package com.mysite.sbb.repository;

import com.mysite.sbb.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shjung
 * @since 24. 12. 11.
 */
public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
}
