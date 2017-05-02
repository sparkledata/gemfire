package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/person")
    public Person personByName(@RequestParam(value = "name") String name) {
        return personRepository.findByName(name);
    }

    @RequestMapping("/person/age")
    public Iterable<Person> personByAge(@RequestParam(value = "gt", required = false) Integer greaterThan,
                                        @RequestParam(value = "lt", required = false) Integer lessThan) {
        if (greaterThan != null && lessThan != null) {
            return personRepository.findByAgeGreaterThanAndAgeLessThan(greaterThan, lessThan);
        }

        if (greaterThan != null) {
            return personRepository.findByAgeGreaterThan(greaterThan);
        }

        if (lessThan != null) {
            return personRepository.findByAgeLessThan(lessThan);
        }

        return personRepository.findAll();
    }
}
