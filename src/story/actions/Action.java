package story.actions;

import entities.Entity;
import story.Event;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(actionDescribe, action.actionDescribe) && Objects.equals(getActor(), action.getActor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionDescribe, getActor());
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" +
                "actionDescribe=" + actionDescribe +
                ",actor=" + actor +
                ']';
    }
}
