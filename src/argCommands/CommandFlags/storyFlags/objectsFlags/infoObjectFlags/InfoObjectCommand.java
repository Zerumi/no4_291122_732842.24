package argCommands.CommandFlags.storyFlags.objectsFlags.infoObjectFlags;

import argCommands.CommandFlags.CommandFlag;
import argCommands.CommandFlags.ICommandFlags;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class InfoObjectCommand extends CommandFlag {
    private static InfoObjectCommand singleToneMoment;

    private InfoObjectCommand() {

    }

    public static CommandFlag getObject() {
        if (singleToneMoment == null) {
            singleToneMoment = new InfoObjectCommand();
        }
        return singleToneMoment;
    }

    @Override
    public String getName() {
        return "story -o -i";
    }

    @Override
    public String getDescription() {
        return "Returns info about Type";
    }

    @Override
    public String getUsage() {
        return "story -o -i <Type> [Type...]";
    }

    @Override
    public ArrayList<String> getParams() {
        return new ArrayList<>() {{
            add("This command doesn't operating parameters");
        }};
    }

    @Override
    public ICommandFlags[] getFlags() {

        return new ICommandFlags[]{};
    }

    @Override
    public void invokeCommand(String[] args) {
        if (args.length == 0)
        {
            System.out.println("Usage: " + getUsage());
        }
        for (String className : args)
        {
            // print class name and superclass name (if != Object)
            try {
                ReflectionWorker.printClassInfo(className);
            }
            catch (ClassNotFoundException ex)
            {
                System.out.println("story -o -i: Class " + className + " not found.");
            }
        }

    }

    static class ReflectionWorker
    {
        public static void printClassInfo(String className) throws ClassNotFoundException
        {
            Class cl = Class.forName(className);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + className);
            if (supercl != null && supercl != Object.class) System.out.print(" extends "
                    + supercl.getName());

            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        }

        public static void printConstructors(Class cl)
        {
            Constructor[] constructors = cl.getDeclaredConstructors();

            for (Constructor c : constructors)
            {
                String name = c.getName();
                System.out.print("   ");
                String modifiers = Modifier.toString(c.getModifiers());
                if (modifiers.length() > 0) System.out.print(modifiers + " ");
                System.out.print(name + "(");

                // print parameter types
                Class[] paramTypes = c.getParameterTypes();
                for (int j = 0; j < paramTypes.length; j++)
                {
                    if (j > 0) System.out.print(", ");
                    System.out.print(paramTypes[j].getName());
                }
                System.out.println(");");
            }
        }

        public static void printMethods(Class cl)
        {
            Method[] methods = cl.getDeclaredMethods();

            for (Method m : methods)
            {
                Class retType = m.getReturnType();
                String name = m.getName();

                System.out.print("   ");
                // print modifiers, return type and method name
                String modifiers = Modifier.toString(m.getModifiers());
                if (modifiers.length() > 0) System.out.print(modifiers + " ");
                System.out.print(retType.getName() + " " + name + "(");

                // print parameter types
                Class[] paramTypes = m.getParameterTypes();
                for (int j = 0; j < paramTypes.length; j++)
                {
                    if (j > 0) System.out.print(", ");
                    System.out.print(paramTypes[j].getName());
                }
                System.out.println(");");
            }
        }

        public static void printFields(Class cl)
        {
            Field[] fields = cl.getDeclaredFields();

            for (Field f : fields)
            {
                Class type = f.getType();
                String name = f.getName();
                System.out.print("   ");
                String modifiers = Modifier.toString(f.getModifiers());
                if (modifiers.length() > 0) System.out.print(modifiers + " ");
                System.out.println(type.getName() + " " + name + ";");
            }
        }
    }
}
