package entities;

import entities.entityBuff.Buff;
import entities.interfacesAnimateActions.IAttachable;
import entities.interfacesAnimateActions.IWorriable;
import things.unitions.ICanUniteable;
import places.Place;
import things.unitions.Unition;

import java.util.Arrays;

public class They extends Entity implements IAttachable, IWorriable {

    public They(String name) {
        super(name);
    }

    public They(String name, Place location)
    {
        super(name, location);
    }

    public They(String name, Place location, Buff... buffs)
    {
        super(name, location);
        for (var buff: buffs)
        {
            addBuff(buff);
        }
    }

    public void worry()
    {
        System.out.println(this.getName() + " пришли в сильное волнение. ");
    }
    public void huddle()
    {
        System.out.println(this.getName() + " сгрудились на месте: " + getLocation().getName() + ". ");
    }

    public void talk()
    {
        System.out.println(this.getName() + " разговаривали. ");
    }

    public void wave()
    {
        // идея для 4-й лабы: внутренний класс лапы
        System.out.println(this.getName() + " размахивали лапами. ");
    }

    @Override
    public void removeBuff(Buff buff) {
        System.out.println(this.getName() + " забыли " + buff.getStat() + " (Источник: " + buff.getSource() + ").");
        super.removeBuff(buff);
    }

    @Override
    public Unition attach(ICanUniteable... things) {

        Unition unition = new Unition(things);

        System.out.println(this.getName() + " привязали между собой: " + Arrays.toString(Arrays.stream(things).map(ICanUniteable::getName).toArray()));

        return unition;
    }
}
