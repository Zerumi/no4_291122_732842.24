package entities.emotionMeanings;

import entities.entityBuff.ISourceable;

import java.util.Objects;

public class Meaning implements ISourceable {
    private String name;
    private String description;

    public Meaning(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }
    @Override
    public String getSource()
    {
        return getDescription();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Meaning other = (Meaning)otherObject;
        return Objects.equals(name, other.name) && Objects.equals(description, other.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return  getClass().getName() + "[" +
                "name=" + name +
                ",description=" + description +
                ']';
    }
}
