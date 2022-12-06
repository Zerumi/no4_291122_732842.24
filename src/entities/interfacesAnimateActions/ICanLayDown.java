package entities.interfacesAnimateActions;

import entities.Entity;
import places.Place;
import story.Time;
import things.ICanBeLayDownThing;

public interface ICanLayDown {
    void layDown(ICanBeLayDownThing what, Place location);

    void layDown(ICanBeLayDownThing what, Place location, Time when, Entity... forWho);
}
