package things.food;

import things.Thing;
import things.unitions.ICanUniteable;

public abstract class Food extends Thing implements ICanBeLayedOut, ICanUniteable {
    protected Food (String name) {
        this.setName(name);
    }
}
