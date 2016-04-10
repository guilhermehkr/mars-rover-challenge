package mars.model;

import java.util.List;

public class Plateau {

    private Integer boundX;
    private Integer boundY;

    public Plateau(Integer x, Integer y) {
        this.boundX = x;
        this.boundY = y;
    }

    public Plateau(List<String> entries) {

        final String[] firstLine = entries.stream().findFirst().map(first -> first.split("\\s+")).orElse(new String[]{});
        if(firstLine.length != 2) throw new IllegalArgumentException("There is no correspondent line for plateau creation");

        try {
            this.boundX = Integer.valueOf(firstLine[0]);
            this.boundY = Integer.valueOf(firstLine[1]);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Plateau creation is impossible, incorrect values", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plateau)) return false;

        Plateau plateau = (Plateau) o;

        if (boundX != null ? !boundX.equals(plateau.boundX) : plateau.boundX != null) return false;
        if (boundY != null ? !boundY.equals(plateau.boundY) : plateau.boundY != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = boundX != null ? boundX.hashCode() : 0;
        result = 31 * result + (boundY != null ? boundY.hashCode() : 0);
        return result;
    }

    public Integer getBoundX() {
        return boundX;
    }

    public void setBoundX(Integer boundX) {
        this.boundX = boundX;
    }

    public Integer getBoundY() {
        return boundY;
    }

    public void setBoundY(Integer boundY) {
        this.boundY = boundY;
    }
}
