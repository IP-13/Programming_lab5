package lab5.storedClasses;

/**
 * Represents coordinates
 */
public class Coordinates {
    private Long x; //Поле не может быть null
    private Integer y; //Значение поля должно быть больше -37, Поле не может быть null

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Coordinates(Long x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x.intValue() + y;
    }

    @Override
    public String toString() {
        return "X: " + x + " " + "Y: " + y + " ";
    }
}
