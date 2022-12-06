package entities;

import entities.emotionMeanings.Meaning;
import entities.entityBuff.Buff;
import entities.entityBuff.ISourceable;
import entities.interfacesAnimateActions.IWorriable;
import places.Place;
import places.singlePlaces.SinglePlace;
import places.superPlaces.openPlaces.UnknownLocation;
import story.Event;
import story.Time;
import story.actions.ICanActionable;
import things.Thing;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Entity implements ICanActionable, ISourceable {
    private String name;
    private Place location;
    private ArrayList<Buff> bufflist;
    private int angleRotate;

    private ArrayList<Thing> inventory;

    {
        name = "безымянный";
        location = new UnknownLocation("вне времени и пространства");
        bufflist = new ArrayList<>();
        inventory = new ArrayList<>();
        angleRotate = ThreadLocalRandom.current().nextInt(0,360);
    }

    protected Entity(String name) {
        this.setName(name);
    }

    protected Entity(String name, Place location) {
        this(name);
        this.location = location;
    }

    protected Entity(String name, Place location, ArrayList<Buff> bufflist)
    {
        this(name, location);
        this.bufflist = bufflist;
    }

    protected Entity(String name, Place location, ArrayList<Buff> bufflist, ArrayList<Thing> inventory)
    {
        this(name,location,bufflist);
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public Place getLocation()
    {
        return location;
    }

    public int getRotateAngle()
    {
        return angleRotate;
    }

    public void rotate(int angleRotate)
    {
        this.angleRotate += angleRotate;
    }

    protected void setName(String name) {
        this.name = name;
    }

    // we can set location to the every entity
    public void setLocation(Place location)
    {
        this.location = location;
    }

    public void lockAttention(Time when, Event onWhat)
    {
        System.out.println(when.getName() + " " + this.getName() + " обратил внимание: " + onWhat.getEventDescribe() + ". ");
    }

    public void lookFor(Event event)
    {
        System.out.println(this.getName() + " наблюдал за событием: " + event.getEventDescribe() + ".");
    }

    public void lookOn(SinglePlace what)
    {
        System.out.println(this.getName() + " посмотрел на: " + what.getName() + ".");
    }

    public void lookOn(Entity who, Meaning meaning)
    {
        System.out.println(this.getName() + " " + meaning.getDescription() + " посмотрел на: " + who.getName() + ".");
    }

    public void lookOn(Thing something)
    {
        System.out.println(this.getName() + " посмотрел на: " + something.getName() + ", находящийся в локации: " + something.getLocation().getName() + ".");
    }

    public static void getWorried(IWorriable entity)
    {
        entity.worry();
    }

    public void addBuff(Buff buff)
    {
        System.out.println("Присвоена характеристика: " + buff.getStat() + " персонажу " + this.getName() + " (Источник: " + buff.getSource() + ")");
        bufflist.add(buff);
    }

    public void removeBuff(Buff buff)
    {
        bufflist.remove(buff);
    }

    public void addItemToInventory(Thing thing)
    {
        System.out.println("В инвентарь персонажа " + getName() + " добавлен предмет " + thing.getName());
        inventory.add(thing);
    }

    public boolean removeItemFromInventory(Thing thing)
    {
        boolean result = inventory.remove(thing);
        if (result)
        {
            System.out.println("Из инвентаря персонажа " + getName() + " пропал предмет " + thing.getName());
        }
        return result;
    }

    @Override
    public String getSource() {
        return getName();
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!otherObject.getClass().equals(this.getClass())) return false;

        Entity other = (Entity) otherObject;

        return name.equals(other.name)
                && location.equals(other.location);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "["
                + "name=" + this.name
                + ",location=" + this.location
                + ",bufflist=" + this.bufflist + "]";
    }
}
