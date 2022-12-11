package argCommands;

import java.util.Arrays;

public class HelpCommand extends Command {


    public static final String COMMAND_NAME = "help";

    public static final String COMMAND_DESCRIPTION = "Displays information about all supported commands. Use \"help <command> [command...]\" for detailed command information";

    private HelpCommand() {

    }

    private static HelpCommand singleToneMoment;

    public static Command getObject() {
        if (singleToneMoment == null)
        {
            singleToneMoment = new HelpCommand();
        }
        return singleToneMoment;
    }


    @Override
    public String getName()
    {
        return COMMAND_NAME;
    }

    @Override
    public String getDescription() {
        return COMMAND_DESCRIPTION;
    }

    @Override
    public void invokeCommand()
    {
        String[] args = getArguments();
        if (args.length == 0)
        {
            System.out.println("Information about all commands:");
            for (Command cmd : Arrays.stream(Commands.values()).map(Commands::getCommand).toList())
            {
                System.out.println(cmd.getName() + "    " + cmd.getDescription());
            }
        }
        else
        {
            for (String command : args)
            {
                try {
                    Command cmdToHelp = Commands.Parser.parse(command);
                    System.out.println(cmdToHelp.getName() + "    " + cmdToHelp.getDescription());
                }
                catch (IllegalArgumentException ex)
                {
                    System.out.println(getName() + ": No command " + command + " found.");
                }
            }
        }
    }
}
