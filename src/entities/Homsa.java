package entities;

import entities.emotionMeanings.Meaning;
import entities.entityBuff.Buff;
import entities.entityBuff.Stat;
import places.Place;
import story.Size;

import java.awt.*;

public class Homsa extends Entity {
    private HomsaEyes eyes;

    {
        eyes = new HomsaEyes(Color.DARK_GRAY, Size.SMALL);
    }
    public Homsa(String name, Place location) {
        super(name, location);
    }

    public void setEyesParams(Color color, Size size)
    {
        eyes.color = color;
        eyes.size = size;
    }

    public HomsaEyes getHomsaEyes()
    {
        return eyes;
    }

    public class HomsaEyes
    {
        private Color color;

        private Size size;

        public HomsaEyes(Color color, Size size)
        {
            this.color = color;
            this.size = size;
        }

        public void shine()
        {
            System.out.println("Глаза " + Homsa.this.getName() + " засветились.");
            Buff buff = new Buff(Stat.SHINING, Homsa.this);
            Homsa.this.addBuff(buff);
        }

        public void examine(Entity who, Meaning meaning)
        {
            System.out.println("Глаза " +  Homsa.this.getName() + " " + meaning.getName() + " разглядывали " + who.getName() + ".");
        }

        public void darker()
        {
            this.color = this.color.darker();
            System.out.println("Глаза " +  Homsa.this.getName() + " потемнели (Новый цвет: " + color + ").");
        }
    }

    @Override
    public void setLocation(Place location) {
        System.out.println(getName() + " умчался в локацию: " + location.getName() + ".");
        super.setLocation(location);
    }
}
