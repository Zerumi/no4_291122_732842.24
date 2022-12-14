package argCommands.CommandFlags;

import java.util.HashMap;

public interface ICommandFlags<T extends Enum<T>> {
    CommandFlag getCommandFlag();

    Class<T> resolveType();

    HashMap<Character, String> getShortFlags();

    default String resolveFullFlag(char shortFlag)
    {
        char upCaseShortFlag = Character.toUpperCase(shortFlag);
        var hashMap = getShortFlags();
        String result = hashMap.get(upCaseShortFlag);
        if (result == null)
        {
            throw new IllegalArgumentException("Key -" + shortFlag + " doesn't exist.");
        }
        return result;
    }
}
