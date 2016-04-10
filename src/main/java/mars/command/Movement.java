package mars.command;

import mars.model.Rover;

public class Movement implements Command {

    @Override
    public void execute(Rover rover) {
        rover.setCurrentCoordinate( rover.getCurrentDirection().move( rover.getCurrentCoordinate() ) );
        rover.validateMe();
    }
}
