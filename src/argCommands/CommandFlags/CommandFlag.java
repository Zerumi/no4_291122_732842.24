package argCommands.CommandFlags;

import java.util.ArrayList;

public abstract class CommandFlag {
    protected CommandFlag()
    {

    }
    public abstract ICommandFlags[] getFlags();

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getUsage();

    public abstract ArrayList<String> getParams();

    public abstract void invokeCommand(String[] args);
}
