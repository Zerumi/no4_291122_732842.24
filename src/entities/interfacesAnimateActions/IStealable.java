package entities.interfacesAnimateActions;

import entities.Entity;
import things.Thing;

public interface IStealable {
    double getStealProbability();

    boolean tryStealItem(Entity fromWho, Thing what);
}
