package ru.ifmo.se.lab2.moves.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public final class XScissor extends PhysicalMove {
    public XScissor() {
        super(Type.BUG, 80, 100);
    }

    /**
     * X-Scissor наносит урон без дополнительного эффекта.
     */

    @Override
    protected String describe() {
        return "стрижет овцу";
    }

}
