package com.syriabazaar.cars.repository;

import com.syriabazaar.cars.domain.CarType;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CarType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Long> {}
