package argCommands.CommandFlags.storyFlags.charactersFlags.createCharacterFlags;

import argCommands.CommandFlags.CommandFlag;
import argCommands.CommandFlags.ICommandFlags;
import argCommands.CommandFlags.storyFlags.charactersFlags.StoryCharacterFlag;
import entities.Entity;
import entities.Viewer;
import places.Place;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class AddCharacterCommand extends CommandFlag {
    private static AddCharacterCommand singleToneMoment;

    private AddCharacterCommand()
    {

    }

    public static CommandFlag getObject()
    {
        if (singleToneMoment == null)
        {
            singleToneMoment = new AddCharacterCommand();
        }
        return singleToneMoment;
    }

    @Override
    public ICommandFlags[] getFlags() {
        return new ICommandFlags[]{};
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
        return "story -c -a <Name> | <Type> <Name> | <Type> <Name> <Place>";
    }

    @Override
    public ArrayList<String> getParams() {
        return null;
    }

    @Override
    public void invokeCommand(String[] args) {
        // create character
        try {

            Entity createdEntity = null;

            switch (args.length) {
                case 1:
                {
                    Constructor<Viewer> cons = Viewer.class.getDeclaredConstructor(String.class);
                    createdEntity = cons.newInstance(args[0]);
                    System.out.println("Viewer created: " + createdEntity.getName());
                    break;
                }
                case 2:
                {
                    var classEntity = Class.forName("entities." + args[0]);
                    Constructor<?> consEntity = classEntity.getDeclaredConstructor(String.class);
                    createdEntity = (Entity)consEntity.newInstance(args[1]);
                    System.out.println("Entity created: " + createdEntity.getName() + ". Type: " + classEntity.getName());
                    break;
                }
                case 3:
                {
                    var classPlace = Class.forName("places." + args[2]);
                    Constructor<?> constructor = classPlace.getDeclaredConstructor(String.class);
                    var createdPlace = (Place)constructor.newInstance(args[2]);

                    var classEntity = Class.forName("entities." + args[0]);
                    Constructor<?> consEntity = classEntity.getDeclaredConstructor(String.class, Place.class);
                    createdEntity = (Entity)consEntity.newInstance(args[1], createdPlace);
                    System.out.println("Entity created: " + createdEntity.getName() + ". Type: " + classEntity.getName() + " / At location: " + createdPlace.getName());
                    break;
                }
                default:
                {
                    System.out.println("Usage: " + getUsage());
                    return;
                }
            }

            StoryCharacterFlag.addEntity(createdEntity);
        }
        catch (Exception ex)
        {
            System.out.println("story -c -c: Exception: " + ex.getMessage());
        }
    }
}
