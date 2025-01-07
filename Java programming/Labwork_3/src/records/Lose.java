package records;

import interfaces.MakeCase;

import java.util.Objects;

public record Lose(String name) implements MakeCase {
    @Override
    public String makeNominate() {
        return name;
    }

    @Override
    public String makeGenitive() {
        return "утраты";
    }

    @Override
    public String makeDative() {
        return "утрате";
    }

    @Override
    public String makeAccusative() {
        return "утрату";
    }

    @Override
    public String makeInstrumental() {
        return "утратой";
    }

    @Override
    public String makePrepositional() {
        return "утрате";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Lose that = (Lose) obj;
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
        return "потеря";
    }
}