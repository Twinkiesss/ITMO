package ru.ifmo.se.lab2.moves.status;

import ru.ifmo.se.pokemon.*;

public final class Rest extends StatusMove {
    /**
     * Пользователь спит 2 хода, но полностью исцелен.
     */
    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.restore();
        p.setCondition(new Effect().turns(2).condition(Status.SLEEP));
    }

    @Override
    protected String describe() {
        return "устраивает чаепитие";
    }
}
