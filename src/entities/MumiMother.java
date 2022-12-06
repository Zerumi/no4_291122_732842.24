package entities;

import entities.interfacesAnimateActions.ICanLayOut;
import places.Place;
import things.ICanBeLayOutPlace;
import things.food.ICanBeLayedOut;

public class MumiMother extends Entity implements ICanLayOut {
    public MumiMother(String name, Place location) {
        super(name, location);
    }

    @Override
    public void layOut(ICanBeLayedOut layOutThing, ICanBeLayOutPlace layOutPlace) {
        System.out.println(this.getName() + " разложил " + layOutThing.getName() + " на " + layOutPlace.getName());
    }
}
