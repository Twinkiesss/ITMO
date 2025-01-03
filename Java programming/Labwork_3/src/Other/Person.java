package Other;
import Abstract.Human;
import Interface.*;
import Exception.*;
import java.util.ArrayList;
import java.util.Objects;

public class Person extends Human implements Lookable, Talkable, Knowable, Hearable, Liveable, MakeMood, Interact {
    private final String name;
    private Person mother;
    private Person father;
    private ArrayList<String> children;
    public int happiness = 250;


    public Person(String name){
        super("None");
        this.name = name;
    }

    public String getName(){return this.name;}

    public Person getMother(){return this.mother;}

    public Person getFather(){return this.father;}

    public ArrayList<String> getChildren(){return this.children;}

    public void setMother(Person mother){this.mother = mother;}

    public void setFather(Person father){this.father = father;}

    public void setChildren(ArrayList<String> children){this.children = children;}
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


    public String lookAt(){ return "глядючи";}
    public String talk(){return "говорить";}
    public String know(){return "знала";}
    public String hear(){return "услыхала";}
    public String notAble(){
        return "не могли";
    };
    public String grownUp(){ return "подросла";}
    public String become(){return "становилась";}
    public String exist(){return "были";}
    public void changeMood(int i){ happiness += i;}
    public String grieve(Person person) {
        try {
            person.changeMood(-50);
            changeMood(-50);
            if (person.happiness < 0) {
                throw new MinHappinessException(person.happiness);
            }
            return "горевали";
        } catch (MinHappinessException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return "Too sad to grieve!";
        }
    }
    public String calmDown(Person person){
        person.changeMood(50);
        changeMood(50);
        return "утешились";
    }
    public String avoidToSpeak(Person person) {
        try {
            person.changeMood(-50);
            changeMood(-50);
            if (person.happiness < 0) {
                throw new MinHappinessException(person.happiness);
            }
            return "избегали";
        } catch (MinHappinessException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return "Too sad to avoid to speak!";
        }
    }
    public String growStronger(){ return "окрепла";}

    public String beGuilty(Person person) {
        try {
            person.changeMood(-50);
            changeMood(-50);
            if (person.happiness < 0) {
                throw new MinHappinessException(person.happiness);
            }
            return "виновата";
        } catch (MinHappinessException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return "Too sad to be guilty!";
        }
    }
}

