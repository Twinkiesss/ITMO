package ru.ifmo.se.lab2.pokemons;

import ru.ifmo.se.lab2.moves.physical.ShadowClaw;
import ru.ifmo.se.lab2.moves.special.DarkPulse;
import ru.ifmo.se.lab2.moves.special.ShadowBall;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Phantump extends Pokemon {
    public Phantump(String name, int level) {
        super(name, level);
        super.setType(Type.GHOST, Type.GRASS);
        this.setStats(43.0, 70.0, 48.0, 50.0, 60.0, 38.0);
        this.setMove(new ShadowBall(), new ShadowClaw(), new DarkPulse());
    }
}
