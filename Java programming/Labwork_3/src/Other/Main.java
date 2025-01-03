package Other;

import java.util.ArrayList;
import java.util.Arrays;
import Exception.*;
import Record.*;
import Enum.*;

public class Main {
    public static void main(String[] args) throws EmptyException {
        Sentence tale = new Sentence();

        Person father = new Person("отец");
        Person mother = new Person("мать");
        Person daughter = new Person("дочь");
        Person brothers = new Person("7 братьев");

        Curse curse = new Curse("заклятье");
        Lose lose = new Lose("утрата");
        Day day = new Day("день");
        Time time = new Time("время");
        People people = new People("люди");
        Unhappiness unhappiness = new Unhappiness("несчастье");

        father.setChildren(new ArrayList<>(Arrays.asList("дочь", "7 сыновей")));
        mother.setChildren(new ArrayList<>(Arrays.asList("дочь", "7 сыновей")));
        daughter.setFather(father);
        daughter.setMother(mother);
        brothers.setFather(father);
        brothers.setMother(mother);

        tale.and(father.getName() + " " + mother.getName()+ " " + mother.notAble() + " "
                + curse.takeOff() + " " + curse.getDescription() + " " + curse.makeGenitive());
        tale.comma("");
        tale.and("");
        tale.how("");
        tale.differentNo(father.grieve(mother));
        tale.about(lose.makePrepositional() + " " + Quality.YOURS.getDescription() + " " + father.getChildren().get(1));
        tale.comma("");
        tale.still(father.calmDown(mother));
        tale.comma(father.lookAt() + " ");
        tale.at(Quality.YOURS.getDescription() + " " + Quality.LOVELY.getDescription() + " " + daughter.getName());
        tale.dot();

        tale.next(daughter.getName() + " " + daughter.grownUp());
        tale.comma(daughter.growStronger() + " ");
        tale.and("");
        tale.with(day.getDescription() + " " + day.makePrepositional() + " " + daughter.become() + " "
                + Quality.BEAUTIFUL.getDescription());
        tale.and(Quality.BEAUTIFUL.getDescription());
        tale.dot();

        tale.next(time.getDescription() + " " + time.makeAccusative() + " " + daughter.getName());
        tale.no(daughter.know());
        tale.comma("");
        tale.that(brothers.getName() + " " + brothers.exist());
        tale.comma(father.getName() + " ");
        tale.and(mother.getName() + " " + mother.avoidToSpeak(daughter) + " " + mother.talk());
        tale.dot();

        tale.but("");
        tale.oneDay(daughter.getName() + " " + daughter.hear());
        tale.comma("");
        tale.how(people.makeNominate() + " " + people.speak());
        tale.comma("");
        tale.that(daughter.getName() + " " + Quality.GOOD.getDescription());
        tale.comma("");
        tale.differentBut(daughter.beGuilty(daughter));
        tale.in(unhappiness.makeAccusative() + " " + Quality.YOURS.getDescription() + " " + brothers.getName());
        tale.dot();

        tale.makeStory();

    }
}
