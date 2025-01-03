package ru.ifmo.se.lab2.moves.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public final class ShadowClaw extends PhysicalMove {
    public ShadowClaw() {
        super(Type.GHOST, 70, 100);
    }

    /**
     * «Теневой коготь» наносит урон и имеет повышенный шанс критического удара (1⁄8 вместо 1⁄24)
     */
    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        return 0.125;
    }


    @Override
    protected String describe() {
        return "ловит летающую муху";
    }
}
