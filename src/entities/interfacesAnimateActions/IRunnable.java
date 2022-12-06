package entities.interfacesAnimateActions;

import places.Place;
import story.Time;

public interface IRunnable {
    void runTo(Time when, Place location);
}
