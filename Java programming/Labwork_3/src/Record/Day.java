package Record;

import Interface.MakeCase;
import Enum.*;
import java.util.Objects;

public record Day(String name) implements MakeCase {
    public String makeNominate(){
        return "день";
    };
    public String makeGenitive(){
        return "дня";
    };
    public String makeDative(){
        return "дню";
    };
    public String makeAccusative(){
        return "день";
    };
    public String makeInstrumental(){
        return "днем";
    };
    public String makePrepositional(){
        return "днем";
    };

    public String getDescription() {
        return Quality.EVERY.getDescription();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Day that = (Day)obj;
            return this.name.equals(that.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }

    public String toString() {
        return "день";
    }
}