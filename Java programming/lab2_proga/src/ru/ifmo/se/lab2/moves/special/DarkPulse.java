package ru.ifmo.se.lab2.moves.special;

import ru.ifmo.se.pokemon.*;

public final class DarkPulse extends SpecialMove {
    public DarkPulse() {
        super(Type.DARK, 80, 100);
    }

    /**
     * «Тёмный импульс» наносит урон и с вероятностью 20% заставляет цель вздрогнуть (если цель ещё не двигалась).
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.2 && !p.getCondition().equals(Status.PARALYZE)) Effect.flinch(p);
    }

    @Override
    protected String describe() {
        return "вызывает сатану";
    }

}
