package mars.model.validation.rover;

import mars.model.Rover;
import mars.model.Status;
import mars.model.validation.Validator;

public class BottomLeftValidator extends Validator<Rover> {

    @Override
    public boolean validate(Rover rover) {
        return rover.getCurrentCoordinate().getX() < 0
                || rover.getCurrentCoordinate().getY() < 0;
    }

    @Override
    public void apply(Rover rover) {
        rover.setStatus(Status.Nok);
        rover.setOutput("The rover is outside of plateau bottom-left");
    }
}
