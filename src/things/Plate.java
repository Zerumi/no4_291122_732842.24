package things;

import things.unitions.ICanUniteable;

public class Plate extends Thing implements ICanBeLayOutPlace, ICanUniteable {
    public Plate(String name) {
        super(name);
    }
}
