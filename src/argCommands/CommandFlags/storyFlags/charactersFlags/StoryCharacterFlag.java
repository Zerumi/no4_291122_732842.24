package argCommands.CommandFlags.storyFlags.charactersFlags;

import argCommands.CommandFlags.CommandFlag;
import argCommands.CommandFlags.ICommandFlags;
import argCommands.CommandFlags.storyFlags.charactersFlags.createCharacterFlags.AddCharacterCommand;
import argCommands.CommandFlags.storyFlags.charactersFlags.getCharacterListFlags.GetCharactersCommand;
import entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class StoryCharacterFlag extends CommandFlag {

    private static ArrayList<Entity> characters = new ArrayList<>();

    public static void addEntity(Entity entity)
    {
        if (entity != null)
        {
            characters.add(entity);
        }
    }

    public static ArrayList<Entity> getCurrentCharacters()
    {
        return characters;
    }

    private static StoryCharacterFlag singleToneMoment;

    private StoryCharacterFlag() {}

    public static CommandFlag getObject()
    {
        if (singleToneMoment == null)
        {
            singleToneMoment = new StoryCharacterFlag();
        }
        return singleToneMoment;
    }

    public enum StoryCharacterFlags implements ICommandFlags<StoryCharacterFlags> {
        ADD(AddCharacterCommand.getObject()),
        GET(GetCharactersCommand.getObject());

        public static class Holder
        {
            private static final HashMap<Character, String> shortFlags = new HashMap<>();
        }
        private final CommandFlag flag;

        StoryCharacterFlags(CommandFlag flag)
        {
            this.flag = flag;
            addToCollection(this.toString());
        }

        private void addToCollection(String value)
        {
            Holder.shortFlags.put(value.toCharArray()[0], value);
        }

        @Override
        public CommandFlag getCommandFlag() {
            return flag;
        }

        @Override
        public Class<StoryCharacterFlags> resolveType() {
            return StoryCharacterFlags.class;
        }

        @Override
        public HashMap<Character, String> getShortFlags() {
            return Holder.shortFlags;
        }
    }

    @Override
    public ICommandFlags[] getFlags() {
        return StoryCharacterFlags.values();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public ArrayList<String> getParams() {
        return null;
    }

    @Override
    public void invokeCommand(String[] args) {
        System.out.println("story -c");
    }
}
