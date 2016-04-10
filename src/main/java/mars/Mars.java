package mars;

import com.google.common.collect.Lists;
import mars.model.Status;
import mars.model.Plateau;
import mars.model.Rover;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Mars {

    private Mars() {
    }

    private static Mars mars = new Mars();

    public static Mars getInstance() {
        return mars;
    }

    private final Integer RoverCombinedSize = 2;

    public synchronized List<Rover> startMission(String path) {

        List<String> entries = FileReader.readFrom(path);

        Plateau plateau = new Plateau(entries);
        List<List<String>> roverCombined = Lists.partition(entries.subList(1, entries.size()), RoverCombinedSize);

        final List<Rover> rovers = Rover.createRovers(roverCombined, plateau);
        rovers.stream().forEach(rover -> rover.validateMe());

        Map<Boolean, List<Rover>> mappedRovers =
                rovers.stream()
                        .collect(Collectors.partitioningBy(rover -> Status.Ok.equals(rover.getStatus())));

        List<Rover> results = mappedRovers.get(true);
        results.stream()
                .forEach(rover -> {
                    rover.getCommands().stream()
                            .forEach(command -> {
                                if (Status.Ok.equals(rover.getStatus())) command.execute(rover);
                            });

                    if (Status.Ok.equals(rover.getStatus())) {
                        String output =
                                new StringBuilder().append(rover.getCurrentCoordinate().getX()).append(" ")
                                        .append(rover.getCurrentCoordinate().getY()).append(" ")
                                        .append(rover.getCurrentDirection().getSymbol()).toString();

                        rover.setOutput(output);
                    }
                });

        results.addAll(mappedRovers.get(false));
        return results;
    }
}
