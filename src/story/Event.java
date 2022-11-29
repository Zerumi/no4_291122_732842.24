package story;

import places.Place;
import story.actions.Action;
import story.actions.BasicActions;
import story.actions.IActionable;
import story.actions.ICanActionable;

import java.util.Objects;

public class Event {
    private String event;
    @Deprecated
    public Event(String event)
    {
        this.setEventStr(event);
    }

    public Event(BasicActions action, ICanActionable what, Place where)
    {
        event = "В локации " + where.getName() + ": " + what.getName() + " " + action.getAction();
    }

    public Event(IActionable action, ICanActionable what, Place where)
    {
        event = "В локации " + where.getName() + ": " + what.getName() + " " + action.getAction();
    }

    public Event(Action action)
    {
        event = action.getActor().getName() + " " + action.getAction();
    }

    public Event (Action action, Place where)
    {
        event = "В локации " + where.getName() + ": " + action.getActor().getName() + " " + action.getAction();
    }

    public String getEventDescribe() {
        return event;
    }

    @Deprecated
    public void setEventStr(String event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Event other = (Event) otherObject;

        return Objects.equals(this.event, other.event);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(event);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "["
                + "event=" + event + "]";
    }
}
