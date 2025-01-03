package ru.ifmo.se.lab2;

import ru.ifmo.se.lab2.pokemons.*;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        battle.addAlly(new Qwilfish("Bloom", 1));
        battle.addAlly(new Trevenant("Layla", 3));
        battle.addAlly(new Kirlia("Floora", 5));

        battle.addFoe(new Phantump("Stella", 2));
        battle.addFoe(new Ralts("Musa", 4));
        battle.addFoe(new Gardevoir("Roxy", 6));

        battle.go();
    }
}
