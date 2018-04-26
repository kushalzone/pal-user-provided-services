package io.pivotal.pal.paluserprovidedservices;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository extends CrudRepository<Cohort, Long> {
}
