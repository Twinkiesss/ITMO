package org.example.models;

/**
 * Класс, представляющий координаты.
 * <p>
 * Содержит информацию о координатах, такие как значение по оси X и значение по оси Y.
 * </p>
 *
 * @author Twinkiesss (Кудряшова Татьяна)
 */
public class Coordinates {
    private long x; // Значение координаты по оси X
    private int y;  // Значение координаты по оси Y

    /**
     * Конструктор для создания объекта {@link Coordinates}.
     *
     * @param x значение координаты по оси X
     * @param y значение координаты по оси Y
     */
    public Coordinates(long x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает значение координаты по оси X.
     *
     * @return значение координаты по оси X
     */
    public long getX() {
        return x;
    }

    /**
     * Возвращает значение координаты по оси Y.
     *
     * @return значение координаты по оси Y
     */
    public int getY() {
        return y;
    }

    /**
     * Возвращает строковое представление объекта {@link Coordinates}.
     *
     * @return строковое представление в формате: "Coordinates{x=..., y=...}"
     */
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                "}";
    }
}