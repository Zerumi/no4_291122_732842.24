package entities.emotionMeanings;

import entities.entityBuff.ISourceable;

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
}
