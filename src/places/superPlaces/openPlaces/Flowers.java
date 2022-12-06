package places.superPlaces.openPlaces;

import java.awt.*;
import java.util.Objects;

public class Flowers extends OpenPlace {
    private Color color;

    public Flowers(String name, Color color) {
        super(color.toString() + " " + name);
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }

    public void changeColor(Color color)
    {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Flowers flowers = (Flowers) o;
        return Objects.equals(color, flowers.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" +
                "color=" + color +
                ']';
    }
}
