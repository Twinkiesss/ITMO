package Record;

import Interface.MakeCase;

import java.util.Objects;

public record Unhappiness(String name) implements MakeCase {
    public String makeNominate(){
        return "несчатье";
    };
    public String makeGenitive(){
        return "несчатья";
    };
    public String makeDative(){
        return "несчастью";
    };
    public String makeAccusative(){
        return "несчатье";
    };
    public String makeInstrumental(){
        return "несчатьем";
    };
    public String  makePrepositional(){
        return "несчатье";
    };
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Unhappiness that = (Unhappiness)obj;
            return this.name.equals(that.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }

    public String toString() {
        return "несчастье";
    }

}