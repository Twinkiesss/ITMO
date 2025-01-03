package ru.ifmo.se.lab2.moves.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public final class TakeDown extends PhysicalMove {
    public TakeDown() { //Type type, double pow, double acc
        super(Type.NORMAL, 90.0, 85.0);
    }

    /**
     * «Сбить с ног» наносит урон, но пользователь получает 1⁄4 от нанесённого урона в качестве отдачи.
     */
    @Override
    protected void applySelfDamage(Pokemon att, double damage) {
        att.setMod(Stat.HP, (int) (damage / 4));
    }

    @Override
    protected String describe() {
        return "врезается в противника, что оба падают как убитые олени";
    }

}

/*

 */