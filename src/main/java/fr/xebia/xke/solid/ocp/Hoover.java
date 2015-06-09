package fr.xebia.xke.solid.ocp;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;
import java.util.List;

public class Hoover {

    private final List<Command> program;
    private Position currentPosition = new Position();

    public Hoover(String program) {
        this.program = program.
                        chars().
                        mapToObj(cmd -> valueOf((char) cmd)).
                        map(Command::valueOf).
                        collect(toList());
    }

    public void clean() {
        program.stream().
                forEach(cmd -> currentPosition = cmd.apply(currentPosition));
    }

    public Position getPosition() {
        return currentPosition;
    }
}
