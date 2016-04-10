package mars.model;


import com.google.common.collect.Iterables;
import mars.command.Command;
import mars.command.CommandFactory;
import mars.compass.Compass;
import mars.model.validation.Validator;
import mars.model.validation.rover.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rover {

    private Coordinate currentCoordinate;
    private Compass currentDirection;
    private List<Command> commands;
    private Status status;
    private String output;
    private Plateau plateau;

    private List<Validator<Rover>> validationList = new LinkedList<Validator<Rover>>() {{
        add(new UnknownCompassValidator());
        add(new NokValidator());
        add(new UnknownCommandValidator());
        add(new UpperRightValidator());
        add(new BottomLeftValidator());
    }};

    public void validateMe() {
        final Rover rover = this;
        validationList.stream()
                .filter(validator -> validator.validate(rover))
                .findFirst()
                .ifPresent(validator -> validator.apply(rover));
    }

    public Rover() {
    }

    public Rover(Compass direction) {
        this.currentDirection = direction;
    }

    public Rover(Compass direction, Coordinate coordinate, Plateau plateau, Status status, List<Command> commands) {
        this.currentDirection = direction;
        this.currentCoordinate = coordinate;
        this.plateau = plateau;
        this.status = status;
        this.commands = commands;
    }

    static private final Rover nokRover =
            new Rover(Compass.Unknown, new Coordinate(-1, -1), new Plateau(-1, -1), Status.Nok, Collections.emptyList());

    public static List<Rover> createRovers(List<List<String>> entries, Plateau plateau) {

        return entries.stream()
                .map(combinedEntry -> {
                    final Rover rover =
                            Optional.ofNullable(Iterables.getFirst(combinedEntry, null))
                                    .map(firstLine -> {
                                        String[] directions = firstLine.split("\\s+");
                                        Rover innerRover;
                                        try {
                                            innerRover =
                                                    new Rover(Compass.from(directions[2]),
                                                            new Coordinate(Integer.valueOf(directions[0]), Integer.valueOf(directions[1])),
                                                            plateau, Status.Ok, Collections.emptyList());
                                        } catch (Exception any) {
                                            innerRover = nokRover;
                                        }
                                        return innerRover;
                                    }).orElse(nokRover);

                    List<Command> commands =
                            Optional.ofNullable(Iterables.getLast(combinedEntry, null))
                                    .map(secondLine -> {
                                        Stream<Character> letters = secondLine.chars().mapToObj(value -> (char)value);
                                        return letters.map(letter -> CommandFactory.fabricate(letter.toString()))
                                                      .collect(Collectors.toList());

                                    }).orElse(Collections.emptyList());

                    rover.setCommands(commands);
                    return rover;

                }).collect(Collectors.toList());
    }

    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    public void setCurrentCoordinate(Coordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }

    public Compass getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Compass currentDirection) {
        this.currentDirection = currentDirection;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }
}