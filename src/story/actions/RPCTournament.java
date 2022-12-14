package story.actions;

import entities.Entity;
import story.Story;

public class RPCTournament extends Action {
    Entity[] entities;

    public RPCTournament(Entity... actors) {
        super("ТУРНИР ПО КАМЕНЬ-НОЖНИЦЫ-БУМАГА", actors[0]);
        entities = actors;
    }

    @Override
    public void invokeAction() {
        for (int i = 0; i < entities.length; i += 2)
        {
            RockPaperScissors game = new RockPaperScissors(entities[i], entities[(i + 1) % entities.length]);
            game.invokeAction();
        }
        System.out.println("ТУРНИР ОКОНЧЕН!");
        Story.FreezeStory(4000);
    }
}
