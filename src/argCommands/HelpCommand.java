package argCommands;

import java.util.ArrayList;
import java.util.Arrays;

public class HelpCommand extends Command {


    public static final String COMMAND_NAME = "help";

    public static final String COMMAND_DESCRIPTION = "Displays information about all supported commands. Use \"help <command> [command...]\" for detailed command information";

    public static final String COMMAND_USAGE = "help [command...]";

    public static final ArrayList<String> COMMAND_PARAMS = new ArrayList<>() {{
        add("command...     Name of command(s), that will be displayed detailed information");
    }};

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
    public String getUsage() {
        return COMMAND_USAGE;
    }

    @Override
    public ArrayList<String> getParams() {
        return COMMAND_PARAMS;
    }

    @Override
    public void invokeCommand()
    {
        String[] args = getArguments();
        if (args.length == 0)
        {
            System.out.println("Information about all supported commands:");
            for (Command cmd : Arrays.stream(Commands.values()).map(Commands::getCommand).toList())
            {
                System.out.println(cmd.getName() + "    " + cmd.getDescription());
            }
        }
        else
        {
            System.out.println("Information about specific commands:");
            for (String command : args)
            {
                try {
                    Command cmdToHelp = Commands.Parser.parse(command);
                    System.out.println("Command:    " + cmdToHelp.getName());
                    System.out.println("Usage:");
                    System.out.println(cmdToHelp.getUsage());
                    System.out.println();
                    System.out.println("Params:");
                    for (String a : cmdToHelp.getParams())
                    {
                        System.out.println(a);
                    }
                }
                catch (IllegalArgumentException ex)
                {
                    System.out.println(getName() + ": No command " + command + " found.");
                }
                finally {
                    System.out.println("---------------------------------------------------");
                }
            }
        }
    }
}
