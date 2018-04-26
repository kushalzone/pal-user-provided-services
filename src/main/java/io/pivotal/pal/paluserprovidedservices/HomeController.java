package io.pivotal.pal.paluserprovidedservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    CohortRepository cohortRepository;

    @GetMapping("/")
    public String home() {

    Optional<Cohort> cohort = cohortRepository.findById(1L);

        return "Hello PALs from Wells Fargo in Des Moines " + cohort.get().getName();
    }

}
