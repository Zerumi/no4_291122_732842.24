package argCommands;

import java.util.ArrayList;

public class ExitCommand extends Command {

    private static Command singleToneMoment;

    public static final String COMMAND_NAME = "exit";

    public static final String COMMAND_DESCRIPTION = "Exits from command manager & runs the story";

    public static final String COMMAND_USAGE = "exit";

    public static final ArrayList<String> COMMAND_PARAMS = new ArrayList<>()
    {{
        add("No params attached with this command.");
    }};

    private ExitCommand() {

    }

    public static Command getObject() {
        if (singleToneMoment == null)
        {
            singleToneMoment = new ExitCommand();
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
    public void invokeCommand() {
        System.out.println("Stopping Command Manager...");
        Command.setCommandManagerRunning(false);
    }
}
