package Record;

import Interface.MakeCase;
import Enum.*;
import java.util.Objects;

public record Time(String name) implements MakeCase {

    public String makeNominate(){
        return "время";
    };
    public String makeGenitive(){
        return "времени";
    };
    public String makeDative(){
        return "времени";
    };
    public String makeAccusative(){
        return "время";
    };
    public String makeInstrumental(){
        return "временем";
    };
    public String makePrepositional(){
        return "времени";
    };

    public String getDescription() {
        return Quality.LONG.getDescription();
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Time that = (Time)obj;
            return this.name.equals(that.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }

    public String toString() {
        return "время";
    }
}