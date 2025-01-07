package interfaces;

import models.Person;

public interface Interact {
    String grieve(Person person);

    String calmDown(Person person);

    String avoidToSpeak(Person person);

    String growStronger();

    String beGuilty(Person person);
}
