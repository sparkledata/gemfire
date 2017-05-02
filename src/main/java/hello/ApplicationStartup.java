package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        Person alice = new Person("Alice", 40);
        Person bob = new Person("Bob", 1);
        Person carol = new Person("Carol", 13);

        System.out.println("Before linking up with Gemfire...");
        for (Person person : new Person[]{alice, bob, carol}) {
            System.out.println("\t" + person);
        }

        personRepository.save(alice);
        personRepository.save(bob);
        personRepository.save(carol);
    }
}
