package Record;

import Interface.MakeCase;

import java.util.Objects;

public record Lose(String name) implements MakeCase {
    public String makeNominate(){
        return "утрата";
    };
    public String makeGenitive(){
        return "утраты";
    };
    public String makeDative(){
        return "утрате";
    };
    public String makeAccusative(){
       return "утрату";
    };
    public String makeInstrumental(){
        return "утратой";
    };
    public String makePrepositional(){
        return "утрате";
    };
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Lose that = (Lose)obj;
            return this.name.equals(that.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }

    public String toString() {
        return "потеря";
    }
}