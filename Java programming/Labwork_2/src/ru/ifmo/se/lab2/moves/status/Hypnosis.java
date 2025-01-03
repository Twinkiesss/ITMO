package ru.ifmo.se.lab2.moves.status;

import ru.ifmo.se.pokemon.*;

public final class Hypnosis extends StatusMove {
    public Hypnosis() {
        super(Type.PSYCHIC, 0, 60);
    }

    /**
     * Гипноз усыпляет цель, если попадает в неё. Спящий покемон не может
     * двигаться (за некоторыми исключениями, такими как Храп). Сон длится 1-3 хода.
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPEED, -3);
        Effect.sleep(p);
    }

    @Override
    protected String describe() {
        return "гуглит противника";
    }
}
