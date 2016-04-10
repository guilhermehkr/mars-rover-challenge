package mars.command;

import mars.compass.Compass;
import mars.model.Rover;

public class Right implements Command {

    @Override
    public void execute(Rover rover) {

        switch(rover.getCurrentDirection()) {
            case North: rover.setCurrentDirection(Compass.East); break;
            case South: rover.setCurrentDirection(Compass.West); break;
            case West: rover.setCurrentDirection(Compass.North); break;
            case East: rover.setCurrentDirection(Compass.South); break;
        }
    }
}