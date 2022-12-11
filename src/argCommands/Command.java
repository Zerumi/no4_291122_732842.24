package argCommands;

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

    public void setArguments(String[] args) {
        this.args = args;
    }

    public String[] getArguments()
    {
        return args;
    }
}
