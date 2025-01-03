package ru.ifmo.se.lab2.moves.special;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class AcidSpray extends SpecialMove {
    public AcidSpray() { //Type type, double pow, double acc
        super(Type.POISON, 40.0, 100.0);
    }

    /**
     * Кислотный спрей наносит урон и снижает специальную защиту цели на два уровня.
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPECIAL_DEFENSE, -2);
    }

    @Override
    protected String describe() {
        return "выпускает изо рта кислотный фонтан, словно фейерверк кетчупа на празднике";
    }
}