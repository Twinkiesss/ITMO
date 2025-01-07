package records;

import interfaces.MakeCase;

import java.util.Objects;

public record Unhappiness(String name) implements MakeCase {
    @Override
    public String makeNominate() {
        return name;
    }
    @Override
    public String makeGenitive() {
        return "несчатья";
    }
    @Override
    public String makeDative() {
        return "несчастью";
    }
    @Override
    public String makeAccusative() {
        return "несчатье";
    }
    @Override
    public String makeInstrumental() {
        return "несчатьем";
    }
    @Override
    public String makePrepositional() {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Unhappiness that = (Unhappiness) obj;
            return this.name.equals(that.name);
        } else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
    @Override
    public String toString() {
        return "несчастье";
    }

}