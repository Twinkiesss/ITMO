import enums.Quality;
import exceptions.EmptyStoryException;
import models.Person;
import records.*;
import story.Sentence;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws EmptyStoryException {
        Sentence tale = new Sentence();

        // Создание персонажей и объектов
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

        // Установка семейных связей
        father.setChildren(new ArrayList<>(Arrays.asList("1 дочь", "7 сыновей")));
        mother.setChildren(new ArrayList<>(Arrays.asList("1 дочь", "7 сыновей")));
        daughter.setFather(father);
        daughter.setMother(mother);
        brothers.setFather(father);
        brothers.setMother(mother);

        // Формирование рассказа
        tale.and(String.join(" ", father.getName(), mother.getName(), mother.notAble(), curse.takeOff(), curse.getDescription(),
                curse.makeGenitive()));
        tale.comma("");
        tale.and("");
        tale.how("");
        tale.differentNo(father.grieve(mother));
        tale.about(String.join(" ", lose.makePrepositional(), Quality.YOURS.getDescription(), father.getChildren().get(1)));
        tale.comma("");
        tale.still(father.calmDown(mother));
        tale.comma(father.lookAt());
        tale.at(String.join(" ", Quality.YOURS.getDescription(), Quality.LOVELY.getDescription(), daughter.getName()));
        tale.dot();

        tale.next(String.join(" ", daughter.getName(), daughter.grownUp()));
        tale.comma(daughter.growStronger());
        tale.and("");
        tale.with(String.join(" ", day.getDescription(), day.makePrepositional(), daughter.become(),
                Quality.BEAUTIFUL.getDescription()));
        tale.and(Quality.BEAUTIFUL.getDescription());
        tale.dot();

        tale.next(String.join(" ", time.getDescription(), time.makeAccusative(), daughter.getName()));
        tale.no(daughter.know());
        tale.comma("");
        tale.that(String.join(" ", brothers.getName(), brothers.exist()));
        tale.comma(father.getName());
        tale.and(String.join(" ", mother.getName(), mother.avoidToSpeak(daughter), mother.talk()));
        tale.dot();

        tale.but("");
        tale.oneDay(daughter.getName() + " " + daughter.hear());
        tale.oneDay(String.join(" ", daughter.getName(), daughter.hear()));
        tale.comma("");
        tale.how(String.join(" ", people.makeNominate(), people.speak()));
        tale.comma("");
        tale.that(String.join(" ", daughter.getName(), Quality.GOOD.getDescription()));
        tale.comma("");
        tale.differentBut(daughter.beGuilty(daughter));
        tale.in(String.join(" ", unhappiness.makeAccusative(), Quality.YOURS.getDescription(), brothers.getName()));
        tale.dot();

        tale.makeStory();
    }
}
