package entities;

import entities.interfacesAnimateActions.IWhirlable;
import places.Place;

public class Hive extends Entity implements IWhirlable {
    public Hive(String name, Place location) {
        super(name, location);
    }
    public void whirl()
    {
        System.out.println(getName() + " кружились вокруг локации " + getLocation().getName());
    }
}
