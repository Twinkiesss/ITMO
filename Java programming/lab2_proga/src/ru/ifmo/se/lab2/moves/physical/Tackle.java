package ru.ifmo.se.lab2.moves.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public final class Tackle extends PhysicalMove {
    public Tackle() {
        super(Type.NORMAL, 40.0, 100.0);
    }

    /**
     * Атака — один из самых распространённых и базовых приёмов,
     * которые изучает покемон. Он наносит урон без дополнительных эффектов.
     */

    @Override
    protected String describe() {
        return "влетает в противника";
    }
}
