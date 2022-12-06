package entities;

import entities.emotionMeanings.Meaning;
import entities.interfacesAnimateActions.*;
import places.Place;
import story.Time;
import things.Broom;
import things.IKnockable;
import things.Thing;

public class Emma extends Entity implements IStealable, IShuffable, INoisable, ISweepable, IHeadShakeable, IShrugable, ISnortable, IRunnable, IMutterable, ICanKnock {

    public static final double STEAL_PROBABILITY = 0.3; // test it with anonymous class

    public Emma(String name) {
        super(name);
    }


    @Override
    public double getStealProbability() {
        return STEAL_PROBABILITY;
    }
    @Override
    public boolean tryStealItem(Entity entity, Thing thing) {
        boolean isStoled = false;
        System.out.println(getName() + " приготовилась совершать страшные вещи...");
        double a = Math.random();
        if (a > 1 - getStealProbability())
        {
            if (entity.removeItemFromInventory(thing))
            {
                isStoled = true;
                System.out.println(getName() + " УКРАЛА ПРЕДМЕТ \"" + thing.getName() + "\" У " + entity.getName() + "!! (Вероятность: " + getStealProbability() + " / " + a + ").");
                this.addItemToInventory(thing);
            }
        }
        else
        {
            System.out.println(getName() + " не смогла украсть важную для " + entity.getName() + " вещь. Воровать -- плохо! (Вероятность: " + getStealProbability() + " / " + a + ").");
        }
        return isStoled;
    }

    @Override
    public void shuffle() {
        System.out.println(getName() + " прошаркалась по локации " + getLocation().getName());
    }

    @Override
    public void noise(Meaning meaning) {
        System.out.println(getName() + " издавала шум в локации " + this.getLocation().getName() + ", означающий " + meaning.getDescription());
    }

    public void sweep(Broom broom) {
        System.out.println(getName() + " принялась мести с помощью " + broom.getName());
    }

    @Override
    public void shakeHead() {
        System.out.println(getName() + " покачала головой.");
    }

    @Override
    public void shrug() {
        System.out.println(getName() + " пожала плечами");
    }

    @Override
    public void snort(Meaning meaning) {
        System.out.println(getName() + " " + meaning.getName() + " фыркнула.");
    }

    public void runTo(Time when, Place location) {
        System.out.println(when.getName() + " " + getName() + " прибежала на локацию: " + location.getName());
    }

    @Override
    public void mutter() {
        System.out.println(getName() + " бормотала.");
    }

    @Override
    public void knock(IKnockable thing) {
        System.out.println(getName() + " стучала " + thing.getName());
    }
}
