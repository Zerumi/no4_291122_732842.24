package argCommands;

import argCommands.CommandFlags.CommandFlag;
import argCommands.CommandFlags.ICommandFlags;
import argCommands.CommandFlags.ICommandFlagsEnum;
import argCommands.CommandFlags.storyFlags.charactersFlags.StoryCharacterFlag;
import argCommands.CommandFlags.storyFlags.objectsFlags.StoryObjectsFlag;

import java.util.ArrayList;
import java.util.HashMap;

public class StoryCommand extends Command {
    // story
    public static final String COMMAND_NAME = "story";

    public static final String COMMAND_DESCRIPTION = "Basic command for setup story. Use \"help story\" or \"story\" for get additional information.";

    public static final String COMMAND_USAGE = "story <[-o|--objects]|[-c|--characters]|[-l|--logger]> [arguments]";

    public static final ArrayList<String> COMMAND_PARAMS = new ArrayList<>() {{
        add("-o|--objects    Flag for objects manipulation. Flags:");
        add("    -g|--get    Get object('s) info.");
        add("    -i|--info <Type> [Type...]    Get type information");
        add("-c|-characters    Flag for characters setup. FLags:");
        add("    -c|--create <Name>    Add new character to the story");
    }};

    public enum StoryCommandsFlags implements ICommandFlags<StoryCommandsFlags> {
        OBJECTS(StoryObjectsFlag.getObject()),
        CHARACTERS(StoryCharacterFlag.getObject());
        //LOGGER();

        public static class Holder
        {
            private static final HashMap<Character, String> shortFlags = new HashMap<>();
        }

        private final CommandFlag flag;
        StoryCommandsFlags(CommandFlag flag)
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
        public Class<StoryCommandsFlags> resolveType() {
            return StoryCommandsFlags.class;
        }

        @Override
        public HashMap<Character, String> getShortFlags() {
            return Holder.shortFlags;
        }
    }
    private static StoryCommand singleToneMoment;

    private StoryCommand()
    {

    }

    public static Command getObject()
    {
        if (singleToneMoment == null)
        {
            singleToneMoment = new StoryCommand();
        }
        return singleToneMoment;
    }

    @Override
    public String getName() {
        return COMMAND_NAME;
    }

    @Override
    public String getDescription() {
        return COMMAND_DESCRIPTION;
    }

    @Override
    public String getUsage() {
        return COMMAND_USAGE;
    }

    @Override
    public ArrayList<String> getParams() {
        return COMMAND_PARAMS;
    }

    @Override
    public ICommandFlags[] getFlags()
    {
        return StoryCommandsFlags.values();
    }

    @Override
    public void invokeCommand() {
        String[] args = getArguments();
        if (args.length == 0)
        {
            System.out.println("Usage: usage -<flag('s)> [arguments]. See \"help story\".");
        }
        else
        {
            char[] shortFlags = Commands.Parser.parseShortFlagsFromArguments(args).toCharArray();

            String[] arguments = Commands.Parser.removeAllFlags(args);

            ICommandFlags[] currentFlags = getFlags();
            ICommandFlags accessFlag;
            CommandFlag flag = null;

            for (int i = 0; currentFlags.length > 0 && i < shortFlags.length; i++)
            {
                accessFlag = currentFlags[0];
                flag = ICommandFlagsEnum.valueOf(accessFlag.resolveType(), accessFlag.resolveFullFlag(shortFlags[i])).getCommandFlag();
                currentFlags = flag.getFlags();
            }

            assert flag != null;
            flag.invokeCommand(arguments);
        }
    }
}
