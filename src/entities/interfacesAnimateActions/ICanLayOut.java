package entities.interfacesAnimateActions;

import things.ICanBeLayOutPlace;
import things.food.ICanBeLayedOut;

public interface ICanLayOut {
    void layOut(ICanBeLayedOut layOutThing, ICanBeLayOutPlace layOutPlace);
}
