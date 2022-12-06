package entities;

import entities.interfacesAnimateActions.ICanPeelOff;
import entities.interfacesAnimateActions.IShuffable;
import places.Place;
import places.superPlaces.openPlaces.UnknownLocation;

public class Something extends Entity implements ICanPeelOff, IShuffable {

    public Something(String name, Place location) {
        super(name, location);
    }

    public void peelOff()
    {
        System.out.println(getName() + " отделился от локации " + getLocation().getName());
        setLocation(new UnknownLocation("недалеко от " + getLocation().getName()));
    }

    @Override
    public void shuffle() {
        System.out.println(getName() + " прошаркался по локации " + getLocation().getName());
    }
}
