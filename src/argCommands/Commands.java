package argCommands;

import java.util.Arrays;

public enum Commands {
    HELP(HelpCommand.getObject()),
    EXIT(ExitCommand.getObject());

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

        public static Command parseWithArguments(String[] args)
        {
            String sCommand = args[0];
            Command command = Commands.Parser.parse(sCommand);
            command.setArguments(Arrays.copyOfRange(args, 1, args.length));
            return command;
        }
    }
}
