package places.superPlaces.openPlaces;

import java.awt.*;

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
}
