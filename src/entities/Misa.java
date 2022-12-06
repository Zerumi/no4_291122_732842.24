package entities;

import entities.emotionMeanings.Meaning;
import entities.interfacesAnimateActions.INoisable;
import entities.interfacesAnimateActions.ISighable;

public class Misa extends Entity implements INoisable, ISighable {
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
}
