package entities;

import places.Place;

public class FreakenSnork extends Entity{
    public FreakenSnork(String name)
    {
        super(name);
    }
    public FreakenSnork(String name, Place location) {
        super(name, location);
    }
}
