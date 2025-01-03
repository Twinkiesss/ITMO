package ru.ifmo.se.lab2.moves.special;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public final class PoisonSting extends PhysicalMove {
    public PoisonSting() { //Type type, double pow, double acc
        super(Type.POISON, 15.0, 100.0);
    }

    /**
     * Ядовитое жало наносит урон и с вероятностью 30% отравляет цель.
     * Ядовитые или стальные покемоны, а также те, у кого есть способность «Невосприимчивость»,
     * или те, кто находится за подставным персонажем, не могут быть отравлены.
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.3 && !p.hasType(Type.POISON) &&
                !p.hasType(Type.STEEL)) Effect.poison(p);
    }

    @Override
    protected String describe() {
        return "вызывает пчелку Майю";
    }
}
