package mars.command;


import java.util.EnumMap;
import static mars.command.CommandOption.*;
import java.util.Map;

public final class CommandFactory {

    final static private Map<CommandOption, Command> mappedCommands =
            new EnumMap<CommandOption, Command>(CommandOption.class) {{
                    put(Left, new Left());
                    put(Right, new Right());
                    put(Movement, new Movement());
                    put(Unknown, new Unknown());
            }};

    private CommandFactory() {}

    public static synchronized Command fabricate(String command) {
        return mappedCommands.get( CommandOption.from(command) );
    }
}
