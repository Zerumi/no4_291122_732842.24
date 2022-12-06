package entities;

import entities.interfacesAnimateActions.ICanLayDown;
import entities.interfacesAnimateActions.ICanLayOut;
import places.Place;
import story.Time;
import things.ICanBeLayDownThing;
import things.ICanBeLayOutPlace;
import things.food.ICanBeLayedOut;

import java.util.Arrays;

public class MumiMother extends Entity implements ICanLayOut, ICanLayDown {
    public MumiMother(String name, Place location) {
        super(name, location);
    }

    @Override
    public void layOut(ICanBeLayedOut layOutThing, ICanBeLayOutPlace layOutPlace) {
        System.out.println(this.getName() + " разложил " + layOutThing.getName() + " на " + layOutPlace.getName());
    }

    public void layDown(ICanBeLayDownThing what, Place location) {

    }
    public void layDown(ICanBeLayDownThing what, Place location, Time when, Entity... forWho) {
        System.out.println(when.getName() + " " + getName() + " расстелила " + what.getName() + " для " + Arrays.toString(Arrays.stream(forWho).map(Entity::getName).toArray()));
    }
}
