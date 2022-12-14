package story.actions;

import entities.Entity;
import story.Story;

import java.util.concurrent.ThreadLocalRandom;

public class RockPaperScissors extends Action {

    Entity actor1;
    Entity actor2;


    protected RockPaperScissors(Entity actor1, Entity actor2) {
        super("предложил игру в камень-ножницы-бумага " + actor2.getName(), actor1);
        this.actor1 = actor1;
        this.actor2 = actor2;
    }

    enum RPSItems
    {
        ROCK,
        PAPER,
        SCISSORS;
    }

    @Override
    public void invokeAction() {
        System.out.println((getEvent().getEventDescribe()));
        System.out.println(actor2.getName() + " принял предложение.");
        Story.FreezeStory(100);
        System.out.print("Камень... Ножницы... Бумага... ");
        Story.FreezeStory(1000);
        System.out.print("1... ");
        Story.FreezeStory(1000);
        System.out.print("2... ");
        Story.FreezeStory(1000);
        System.out.println("3... ");
        RPSItems item1 =  RPSItems.values()[ThreadLocalRandom.current().nextInt(0, 3)];
        RPSItems item2 =  RPSItems.values()[ThreadLocalRandom.current().nextInt(0, 3)];
        System.out.println(actor1.getClass().getName() + " " + actor1.getName() + " показал " + item1);
        System.out.println(actor2.getClass().getName() + " " + actor2.getName() + " показал " + item2);
        if((item1.equals(RPSItems.ROCK) && item2.equals(RPSItems.SCISSORS))
                || (item1.equals(RPSItems.SCISSORS) && item2.equals(RPSItems.PAPER))
                || (item1.equals(RPSItems.PAPER) && item2.equals(RPSItems.ROCK)))
        {
            System.out.println(actor1.getName() + " ПОБЕДИЛ!!!1!!1");
        }
        else if (item1.equals(item2))
        {
            System.out.println("НИЧЬЯ");
        }
        else
        {
            System.out.println(actor2.getName() + " ПОБЕДИЛ!!!1!!1");
        }
    }
}
