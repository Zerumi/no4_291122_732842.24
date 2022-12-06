package things;

import entities.Entity;
import places.Place;
import places.superPlaces.openPlaces.UnknownLocation;

import java.util.Objects;

public abstract class Thing {
    private String name;
    private Place location;

    {
        name = "безымянная вещь";
        location = new UnknownLocation("вне времени и пространства");
    }

    protected Thing()
    {

    }
    protected Thing(String name) {
        this.setName(name);
    }
    protected Thing(String name, Place location) {
        this(name);
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Place getLocation()
    {
        return location;
    }

    public void setLocation(Entity actor, Place location)
    {
        this.location = location;
        System.out.println(actor.getName() + " установил локацию для предмета " + this.name + " на " + location.getName() + ".");
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Thing other = (Thing) otherObject;

        return this.name.equals(other.name) &&
                this.location.equals(other.location);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, location);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name
                + "location=" + location
                + "]";
    }
}
