package argCommands;

import argCommands.CommandFlags.ICommandFlags;

import java.util.ArrayList;

public abstract class Command {

    private static boolean isCommandManagerRunning = true;

    public static boolean getCommangManagerRunning()
    {
        return isCommandManagerRunning;
    }

    public static void setCommandManagerRunning(boolean value)
    {
        isCommandManagerRunning = value;
    }

    private String[] args;

    protected Command()
    {

    }

    public abstract String getName();
    public abstract String getDescription();

    public abstract void invokeCommand();
    public abstract String getUsage();

    public abstract ArrayList<String> getParams();

    public void setArguments(String[] args) {
        this.args = args;
    }

    public String[] getArguments()
    {
        return args;
    }

    public ICommandFlags[] getFlags()
    {
        return null;
    }
}
