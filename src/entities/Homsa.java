package entities;

import entities.emotionMeanings.Meaning;
import entities.entityBuff.Buff;
import entities.entityBuff.Stat;
import places.Place;
import story.Size;

import java.awt.*;
import java.util.Objects;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HomsaEyes homsaEyes = (HomsaEyes) o;
            return Objects.equals(color, homsaEyes.color) && size == homsaEyes.size;
        }

        @Override
        public int hashCode() {
            return Objects.hash(color, size);
        }

        @Override
        public String toString() {
            return getClass().getName() + "[" +
                    "color=" + color +
                    ",size=" + size +
                    ']';
        }
    }

    @Override
    public void setLocation(Place location) {
        System.out.println(getName() + " умчался в локацию: " + location.getName() + ".");
        super.setLocation(location);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Homsa homsa = (Homsa) o;
        return Objects.equals(eyes, homsa.eyes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eyes);
    }

    @Override
    public String toString() {
        return  getClass().getName() + "["
                + "eyes=" + eyes
                + ']';
    }
}
