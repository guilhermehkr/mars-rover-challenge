package mars.command;

import mars.compass.Compass;
import mars.model.Rover;

public class Left implements Command {

    @Override
    public void execute(Rover rover) {

        switch(rover.getCurrentDirection()) {
            case North: rover.setCurrentDirection(Compass.West); break;
            case South: rover.setCurrentDirection(Compass.East); break;
            case West: rover.setCurrentDirection(Compass.South); break;
            case East: rover.setCurrentDirection(Compass.North); break;
        }
    }
}