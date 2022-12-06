package entities;

import entities.emotionMeanings.Meaning;
import entities.interfacesAnimateActions.INoisable;
import entities.interfacesAnimateActions.ISighable;
import entities.interfacesAnimateActions.IThinkable;

public class Misa extends Entity implements INoisable, ISighable, IThinkable {
    public Misa(String name) {
        super(name);
    }

    @Override
    public void noise(Meaning meaning) {
        System.out.println(getName() + " издала звук, означающий " + meaning.getDescription());
    }

    public void sigh()
    {
        System.out.println(getName() + " вздохнула.");
    }

    @Override
    public void think(String thought) {
        System.out.println("\"" + thought + "\" -- думала " + getName());
    }
}
