package argCommands.CommandFlags;

public interface ICommandFlagsEnum {

    static <T1 extends Enum<T1>> argCommands.CommandFlags.ICommandFlags<T1> valueOf(Class<T1> enumType, String name) {
        return (argCommands.CommandFlags.ICommandFlags<T1>) Enum.valueOf(enumType, name);
    }
}
