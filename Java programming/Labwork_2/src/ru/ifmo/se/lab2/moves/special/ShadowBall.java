package ru.ifmo.se.lab2.moves.special;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class ShadowBall extends SpecialMove {
    public ShadowBall() {
        super(Type.GHOST, 80, 100);
    }

    //Теневой шар наносит урон и с вероятностью 20% снижает специальную защиту цели на один уровень.
    //Статистика может быть снижена минимум до -6 этапов для каждого.

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.2) p.setMod(Stat.SPECIAL_DEFENSE, -1);
    }

    @Override
    protected String describe() {
        return "вызывает Валтора";
    }
}
