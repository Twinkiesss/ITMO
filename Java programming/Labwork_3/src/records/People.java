package records;

import interfaces.MakeCase;

import java.util.Objects;

public record People(String name) implements MakeCase {
    @Override
    public String makeNominate() {
        return name;
    }
    @Override
    public String makeGenitive() {
        return "людей";
    }
    @Override
    public String makeDative() {
        return "людям";
    }
    @Override
    public String makeAccusative() {
        return "людей";
    }
    @Override
    public String makeInstrumental() {
        return "людьми";
    }
    @Override
    public String makePrepositional() {
        return "людях";
    }

    public String getPronoun() {
        System.out.println("те");
        return "те";
    }

    public String speak() {
        return "говорили";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            People that = (People) obj;
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
        return "люди";
    }
}