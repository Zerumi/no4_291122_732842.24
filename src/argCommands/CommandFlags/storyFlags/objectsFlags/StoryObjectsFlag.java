package argCommands.CommandFlags.storyFlags.objectsFlags;

import argCommands.CommandFlags.CommandFlag;
import argCommands.CommandFlags.ICommandFlags;
import argCommands.CommandFlags.storyFlags.objectsFlags.getObjectFlags.GetObjectsCommand;
import argCommands.CommandFlags.storyFlags.objectsFlags.infoObjectFlags.InfoObjectCommand;
import argCommands.CommandFlags.storyFlags.objectsFlags.treeObjectFlags.TreeObjectsCommand;

import java.util.ArrayList;
import java.util.HashMap;

public class StoryObjectsFlag extends CommandFlag {
    private static StoryObjectsFlag singleToneMoment;

    public static CommandFlag getObject()
    {
        if (singleToneMoment == null)
        {
            singleToneMoment = new StoryObjectsFlag();
        }
        return singleToneMoment;
    }

    private StoryObjectsFlag()
    {

    }

    public enum StoryObjectsFlags implements ICommandFlags<StoryObjectsFlags> {
        GET(GetObjectsCommand.getObject()),
        INFO(InfoObjectCommand.getObject()),
        TREE(TreeObjectsCommand.getObject());

        public static class Holder
        {
            private static final HashMap<Character, String> shortFlags = new HashMap<>();
        }
        private final CommandFlag flag;

        StoryObjectsFlags(CommandFlag flag)
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
        public Class<StoryObjectsFlags> resolveType() {
            return StoryObjectsFlags.class;
        }

        @Override
        public HashMap<Character, String> getShortFlags() {
            return Holder.shortFlags;
        }
    }

    @Override
    public ICommandFlags[] getFlags() {
        return StoryObjectsFlags.values();
    }

    @Override
    public String getName() {
        return "story -o";
    }

    @Override
    public String getDescription() {
        return "Basic command for story reflection setup.";
    }

    @Override
    public String getUsage() {
        return "story -o <flag's> [arguments]";
    }

    @Override
    public ArrayList<String> getParams() {
        return null;
    }

    @Override
    public void invokeCommand(String[] args) {
        System.out.println("Usage: " + getUsage());
    }
}
