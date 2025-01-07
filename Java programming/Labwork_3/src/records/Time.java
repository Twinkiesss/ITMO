package records;

import enums.Quality;
import interfaces.MakeCase;

import java.util.Objects;

public record Time(String name) implements MakeCase {
    @Override
    public String makeNominate() {
        return name;
    }
    @Override
    public String makeGenitive() {
        return "времени";
    }
    @Override
    public String makeDative() {
        return "времени";
    }
    @Override
    public String makeAccusative() {
        return name;
    }
    @Override
    public String makeInstrumental() {
        return "временем";
    }
    @Override
    public String makePrepositional() {
        return "времени";
    }

    public String getDescription() {
        return Quality.LONG.getDescription();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Time that = (Time) obj;
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
        return "время";
    }
}