package models;

import exceptions.HappinessLevelTooLowException;
import interfaces.*;

import java.util.ArrayList;
import java.util.Objects;

public class Person extends Human implements Lookable, Talkable, Knowable, Hearable, Liveable, MakeMood, Interact {
    private final String name;
    public int happiness = 250;
    private Person mother;
    private Person father;
    private ArrayList<String> children;


    public Person(String name) {
        super("None");
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Person getMother() {
        return this.mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return this.father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public ArrayList<String> getChildren() {
        return this.children;
    }

    public void setChildren(ArrayList<String> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person that)) {
            return false;
        }
        return Objects.equals(this.happiness, that.happiness) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.mother, that.mother) &&
                Objects.equals(this.father, that.father) &&
                Objects.equals(this.children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, happiness, mother, father, children);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + '}';
    }

    @Override
    public String lookAt() {
        return "глядючи";
    }

    @Override
    public String talk() {
        return "говорить";
    }

    @Override
    public String know() {
        return "знала";
    }

    @Override
    public String hear() {
        return "услыхала";
    }

    @Override
    public String notAble() {
        return "не могли";
    }

    @Override
    public String grownUp() {
        return "подросла";
    }

    @Override
    public String become() {
        return "становилась";
    }

    @Override
    public String exist() {
        return "были";
    }

    @Override
    public void changeMood(int i) {
        happiness += i;
    }

    @Override
    public String grieve(Person person) {
        try {
            person.changeMood(-50);
            changeMood(-50);
            if (person.happiness < 0) {
                throw new HappinessLevelTooLowException(person.happiness);
            }
            return "горевали";
        } catch (HappinessLevelTooLowException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return "Too sad to grieve!";
        }
    }

    @Override
    public String calmDown(Person person) {
        person.changeMood(50);
        changeMood(50);
        return "утешились";
    }

    @Override
    public String avoidToSpeak(Person person) {
        try {
            person.changeMood(-50);
            changeMood(-50);
            if (person.happiness < 0) {
                throw new HappinessLevelTooLowException(person.happiness);
            }
            return "избегали";
        } catch (HappinessLevelTooLowException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return "Too sad to avoid to speak!";
        }
    }

    @Override
    public String growStronger() {
        return "окрепла";
    }

    @Override
    public String beGuilty(Person person) {
        try {
            person.changeMood(-50);
            changeMood(-50);
            if (person.happiness < 0) {
                throw new HappinessLevelTooLowException(person.happiness);
            }
            return "виновата";
        } catch (HappinessLevelTooLowException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return "Too sad to be guilty!";
        }
    }
}

