package ru.ifmo.se.lab2.pokemons;

import ru.ifmo.se.lab2.moves.special.DrainingKiss;
import ru.ifmo.se.lab2.moves.status.Charm;
import ru.ifmo.se.lab2.moves.status.Hypnosis;
import ru.ifmo.se.lab2.moves.status.Rest;
import ru.ifmo.se.pokemon.Type;


public final class Gardevoir extends Kirlia {
    public Gardevoir(String name, int level) {
        super(name, level);
        this.setType(Type.GHOST, Type.GRASS);
        this.setStats(43.0, 70.0, 48.0, 50.0, 60.0, 38.0);
        this.setMove(new Rest(), new Hypnosis(), new Charm(), new DrainingKiss());
    }
}