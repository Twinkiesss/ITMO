package Record;

import Interface.MakeCase;

import java.util.Objects;

public record People(String name) implements MakeCase {

    public String  makeNominate(){
        return "люди";
    };
    public String  makeGenitive(){
        return "людей";
    };
    public String makeDative(){
        return "людям";
    };
    public String makeAccusative(){
        return "людей";
    };
    public String makeInstrumental(){
        return "людьми";
    };
    public String makePrepositional(){
        return "людях";
    };

    public String getPronoun(){
        System.out.println("те");
        return "те";
    }

    public String speak(){
        return "говорили";
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            People that = (People)obj;
            return this.name.equals(that.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }

    public String toString() {
        return "люди";
    }
}