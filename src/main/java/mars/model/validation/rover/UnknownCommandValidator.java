package mars.model.validation.rover;

import mars.command.Unknown;
import mars.model.Rover;
import mars.model.Status;
import mars.model.validation.Validator;

public class UnknownCommandValidator extends Validator<Rover> {

    @Override
    public boolean validate(Rover rover) {
        return rover.getCommands().stream().anyMatch(command -> command instanceof Unknown);
    }

    @Override
    public void apply(Rover rover) {
        rover.setStatus(Status.Nok);
        rover.setOutput("There is one invalid command at least, impossible to proceed");
    }
}
