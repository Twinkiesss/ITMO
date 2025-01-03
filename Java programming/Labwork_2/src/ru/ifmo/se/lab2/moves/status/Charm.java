package ru.ifmo.se.lab2.moves.status;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public final class Charm extends StatusMove {
    public Charm() {
        super(Type.FAIRY, 0, 100);
    }

    /**
     * Очарование снижает атаку цели на два уровня.
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, -2);
    }

    @Override
    protected String describe() {
        return "очаровательно улыбается";
    }
}
