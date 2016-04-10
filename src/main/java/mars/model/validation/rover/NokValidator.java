package mars.model.validation.rover;

import mars.model.Rover;
import mars.model.Status;
import mars.model.validation.Validator;

public class NokValidator extends Validator<Rover> {

    @Override
    public boolean validate(Rover rover) {
        return Status.Nok.equals(rover.getStatus());
    }

    @Override
    public void apply(Rover rover) {
        rover.setOutput("The rover entry was malformed");
    }
}
