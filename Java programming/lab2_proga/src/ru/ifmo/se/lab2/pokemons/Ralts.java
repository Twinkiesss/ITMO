package ru.ifmo.se.lab2.pokemons;

import ru.ifmo.se.lab2.moves.status.Hypnosis;
import ru.ifmo.se.lab2.moves.status.Rest;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Ralts extends Pokemon {
    public Ralts(String name, int level) {
        super(name, level);
        this.setType(Type.PSYCHIC, Type.FAIRY);
        this.setStats(28.0, 25.0, 25.0, 45.0, 35.0, 40.0);
        this.setMove(new Rest(), new Hypnosis());
    }
}
