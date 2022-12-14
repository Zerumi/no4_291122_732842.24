package argCommands.CommandFlags.storyFlags.charactersFlags.getCharacterListFlags;

import argCommands.CommandFlags.CommandFlag;
import argCommands.CommandFlags.ICommandFlags;
import argCommands.CommandFlags.storyFlags.charactersFlags.StoryCharacterFlag;

import java.util.ArrayList;

public class GetCharactersCommand extends CommandFlag {

    private static GetCharactersCommand singleToneMoment;

    private GetCharactersCommand()
    {

    }

    public static CommandFlag getObject()
    {
        if (singleToneMoment == null)
        {
            singleToneMoment = new GetCharactersCommand();
        }
        return singleToneMoment;
    }

    @Override
    public ICommandFlags[] getFlags() {
        return new ICommandFlags[] {};
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public ArrayList<String> getParams() {
        return null;
    }

    @Override
    public void invokeCommand(String[] args) {
        var currentCharacters = StoryCharacterFlag.getCurrentCharacters();
        for (var entity: currentCharacters)
        {
            System.out.println(entity.toString());
        }
        if ((long) currentCharacters.size() == 0)
        {
            System.out.println("There are currently no entities. Create them by using \"story -c -a <Name> | <Type> <Name> | <Type> <Name> <Place>\"");
        }
    }
}
