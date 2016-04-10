package mars.model.validation.rover;

import mars.compass.Compass;
import mars.model.Rover;
import mars.model.validation.Validator;

import static mars.model.Status.Nok;

public class UnknownCompassValidator extends Validator<Rover> {

    @Override
    public boolean validate(Rover rover) {
        return Compass.Unknown.equals(rover.getCurrentDirection());
    }

    @Override
    public void apply(Rover rover) {
        rover.setStatus(Nok);
        rover.setOutput("The initial direction could not be read, impossible to proceed");
    }
}
