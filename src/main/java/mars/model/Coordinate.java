package mars.model;


public class Coordinate {

    private Integer x;

    private Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate) o;

        if (!x.equals(that.x)) return false;
        if (!y.equals(that.y)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x.hashCode();
        result = 31 * result + y.hashCode();
        return result;
    }
}
