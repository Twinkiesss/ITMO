package records;

import enums.Quality;
import interfaces.MakeCase;

import java.util.Objects;

public record Day(String name) implements MakeCase {
    @Override
    public String makeNominate() {
        return name;
    }

    @Override
    public String makeGenitive() {
        return "дня";
    }

    @Override
    public String makeDative() {
        return "дню";
    }

    @Override
    public String makeAccusative() {
        return name;
    }

    @Override
    public String makeInstrumental() {
        return "днем";
    }

    @Override
    public String makePrepositional() {
        return "днем";
    }

    public String getDescription() {
        return Quality.EVERY.getDescription();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Day that = (Day) obj;
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
        return "день";
    }
}