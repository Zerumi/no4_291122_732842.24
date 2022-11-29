package entities;

import entities.emotionMeanings.Meaning;

public class Misa extends Entity implements INoisable {
    public Misa(String name) {
        super(name);
    }

    @Override
    public void noise(Meaning meaning) {
        System.out.println(getName() + " издала звук, означающий " + meaning.getDescription());
    }
}
