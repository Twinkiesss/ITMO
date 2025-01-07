package records;

import enums.Quality;
import interfaces.MakeCase;

import java.util.Objects;

public record Curse(String name) implements MakeCase {
    @Override
    public String makeNominate() {
        return name;
    }

    @Override
    public String makeGenitive() {
        return "заклятья";
    }

    @Override
    public String makeDative() {
        return "заклятью";
    }

    @Override
    public String makeAccusative() {
        return name;
    }

    @Override
    public String makeInstrumental() {
        return "заклятьем";
    }

    @Override
    public String makePrepositional() {
        return name;
    }

    public String getDescription() {
        return Quality.YOURS.getDescription();
    }

    public String takeOff() {
        return "снять";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Curse that = (Curse) obj;
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
        return "Проклятье";
    }
}