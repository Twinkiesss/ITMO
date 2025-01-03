package ru.ifmo.se.lab2.moves.special;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class DrainingKiss extends SpecialMove {
    public DrainingKiss() {
        super(Type.FAIRY, 50, 100);
    }

    /**
     * Иссушающий поцелуй наносит урон, и пользователь восстанавливает 75% потерянного здоровья.
     */

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.HP, -((int) (p.getHP() * 0.75)));
    }

    @Override
    protected String describe() {
        return "кусает противника, чтобы украсть его энергию";
    }
}
