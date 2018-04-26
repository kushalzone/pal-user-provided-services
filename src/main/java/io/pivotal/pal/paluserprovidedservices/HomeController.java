package io.pivotal.pal.paluserprovidedservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class HomeController {

    @Autowired
    CohortRepository cohortRepository;

    @GetMapping("/")
    public String home() {
        List<Cohort> allItems  = new ArrayList<Cohort>(toList(cohortRepository.findAll()));


        System.out.println( "Hello PALs from Wells Fargo in Des Moines " + Arrays.asList(allItems).toString());
        return "Hello PALs from Wells Fargo in Des Moines " + Arrays.asList(allItems).toString();
    }

    @RequestMapping("/nickname")
    public String nickname() {
        Cohort kushal = cohortRepository.findById(4L).get();
        Cohort scott = cohortRepository.findById(12L).get();

        kushal.setNickName("kushalNickname" + Calendar.getInstance().getTimeInMillis());
        scott.setNickName("nick" + Calendar.getInstance().getTimeInMillis());

        cohortRepository.save(kushal);
        cohortRepository.save(scott);

        return "Successful";


    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

}
