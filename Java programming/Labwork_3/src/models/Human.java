package models;

public abstract class Human {
    private final String name;

    public Human(String name) {
        this.name = name;
    }

    abstract String getName();
}
