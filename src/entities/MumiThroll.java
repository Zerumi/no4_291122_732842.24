package entities;

import entities.interfacesAnimateActions.IThinkable;
import entities.interfacesAnimateActions.IWhistlable;
import places.Place;

public class MumiThroll extends Entity implements IWhistlable, IThinkable {
    public MumiThroll(String name) {
        super(name);
    }
    public MumiThroll(String name, Place location) {
        super(name, location);
    }

    @Override
    public void whistle() {
        System.out.println(getName() + " свистел.");
    }

    @Override
    public void think(String thought) {
        System.out.println(getName() + " думал: \"" + thought + "\".");
    }
}
