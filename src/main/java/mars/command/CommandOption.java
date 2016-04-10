package mars.command;

import java.util.Arrays;

public enum CommandOption {

    Right("R"),
    Left("L"),
    Movement("M"),
    Unknown("U");

    private String identifier;

    private CommandOption(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public static CommandOption from(String command) {
        return Arrays.stream(CommandOption.values())
                .filter(option -> option.getIdentifier().equalsIgnoreCase(command))
                .findFirst()
                .orElse(Unknown);
    }
}
