package Record;

import Interface.MakeCase;
import Enum.*;
import java.util.Objects;

public record Curse(String name) implements MakeCase {
    public String makeNominate(){
        return "заклятье";
    };
    public String makeGenitive(){
        return "заклятья";
    };
    public String makeDative(){
        return "заклятью";
    };
    public String makeAccusative(){
        return "заклятье";
    };
    public String makeInstrumental(){
        return "заклятьем";
    };
    public String makePrepositional(){
        return "заклятье";
    };

    public String getDescription() {
        return Quality.YOURS.getDescription();
    }

    public String takeOff(){
        return "снять";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Curse that = (Curse)obj;
            return this.name.equals(that.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }

    public String toString() {
        return "Проклятье";
    }
}