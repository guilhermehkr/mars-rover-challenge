package mars.model.validation.rover;

import mars.model.Rover;
import mars.model.Status;
import mars.model.validation.Validator;

public class UpperRightValidator extends Validator<Rover> {

    @Override
    public boolean validate(Rover rover) {
        return rover.getCurrentCoordinate().getX() > rover.getPlateau().getBoundX()
                ||  rover.getCurrentCoordinate().getY() > rover.getPlateau().getBoundY();
    }

    @Override
    public void apply(Rover rover) {
        rover.setStatus(Status.Nok);
        rover.setOutput("The rover is outside of plateau upper-right");
    }
}
