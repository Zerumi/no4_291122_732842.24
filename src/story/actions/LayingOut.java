package story.actions;

import entities.Entity;
import entities.interfacesAnimateActions.ICanLayOut;
import things.ICanBeLayOutPlace;
import things.food.ICanBeLayedOut;

public class LayingOut<T extends Entity & ICanLayOut> extends Action {
    private T actor;
    private ICanBeLayedOut layOutThing;
    private ICanBeLayOutPlace layOutPlace;

    public LayingOut(T actor, ICanBeLayedOut layOutThing, ICanBeLayOutPlace layOutPlace) {
        super("раскладывание " + layOutThing.getName() + " на " + layOutPlace.getName(), actor);
        this.actor = actor;
        this.layOutThing = layOutThing;
        this.layOutPlace = layOutPlace;
    }

    @Override
    public void invokeAction() {
        actor.layOut(layOutThing, layOutPlace);
    }
}
