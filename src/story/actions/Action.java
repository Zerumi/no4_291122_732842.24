package story.actions;

import entities.Entity;
import story.Event;

public abstract class Action implements IActionable {
    private String actionDescribe;

    private Entity actor;

    protected Action(String actionDescribe, Entity actor)
    {
        this.actionDescribe = actionDescribe;
        this.actor = actor;
    }

    public abstract void invokeAction();

    public Entity getActor()
    {
        return actor;
    }

    @Override
    public String getAction() {
        return actionDescribe;
    }

    public Event getEvent() {
        return new Event(this);
    }
}
