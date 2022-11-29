package story;

public class Story {
    public static void FreezeStory()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException ignored) { }
    }

    public static void FreezeStory(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException ignored) { }
    }
}
