package argCommands;

import java.util.*;
import java.util.regex.Pattern;

public enum Commands {
    HELP(HelpCommand.getObject()),
    EXIT(ExitCommand.getObject()),
    STORY(StoryCommand.getObject());

    private final Command cmd;

    Commands(Command cmd)
    {
        this.cmd = cmd;
    }

    public Command getCommand() {
        return cmd;
    }

    public static class Parser
    {
        public static Command parse(String cmd) throws IllegalArgumentException, NullPointerException
        {
            return Commands.valueOf(Commands.class, cmd.toUpperCase()).cmd;
        }

        public static Command parseWithArguments(String [] args)
        {
            String sCommand = args[0];
            Command command = Commands.Parser.parse(sCommand);
            command.setArguments(Arrays.copyOfRange(args, 1, args.length));
            return command;
        }

        public static String parseShortFlagsFromArguments(String[] args)
        {
            Pattern shortFlagsPattern = Pattern.compile("(?<!--)-[a-z|A-Z]+");
            StringBuilder shortFlagsStringBuilder = new StringBuilder();
            for (var argsStr: args) {
                var shortFlagsMatcher = shortFlagsPattern.matcher(argsStr);
                if (shortFlagsMatcher.matches()) {
                    shortFlagsStringBuilder.append(shortFlagsMatcher.group().substring(1));
                }
            }

            String shortFlags = shortFlagsStringBuilder.toString();
            char[] chars = shortFlags.toCharArray();
            Set<Character> charSet = new LinkedHashSet<>();
            for (char c : chars) {
                charSet.add(c);
            }

            StringBuilder uniqueShortFlagsBuilder = new StringBuilder();
            for (Character character : charSet) {
                uniqueShortFlagsBuilder.append(character);
            }

            String uniqueShortFlags = uniqueShortFlagsBuilder.toString();

            return uniqueShortFlags;
        }

        public static String[] removeAllFlags(String[] args) {
            ArrayList<String> result = new ArrayList<>(List.of(args));

            Pattern flagsPattern = Pattern.compile("-+[a-z|A-Z]+");
            for (var argsStr: args)
            {
                var shortFlagsMatcher = flagsPattern.matcher(argsStr);
                if (shortFlagsMatcher.matches()) {
                    result.remove(argsStr);
                }
            }

            return result.toArray(new String[]{});
        }
    }
}
