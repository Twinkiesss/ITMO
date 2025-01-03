package ru.ifmo.se.lab2.pokemons;

import ru.ifmo.se.lab2.moves.physical.Tackle;
import ru.ifmo.se.lab2.moves.physical.TakeDown;
import ru.ifmo.se.lab2.moves.special.AcidSpray;
import ru.ifmo.se.lab2.moves.special.PoisonSting;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public final class Qwilfish extends Pokemon {
    public Qwilfish(String name, int level) {
        super(name, level);
        this.setType(Type.WATER, Type.POISON);
        this.setStats(65.0, 95.0, 85.0, 55.0, 55.0, 85.0);
        this.setMove(new TakeDown(), new AcidSpray(), new PoisonSting(), new Tackle());
    }
}
