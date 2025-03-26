package org.example.models;

/**
 * Класс, представляющий человека.
 * <p>
 * Содержит информацию о имени, весе и национальности человека.
 * </p>
 *
 * @author Twinkiesss (Кудряшова Татьяна)
 */
public class Person {
    private String name;        // Имя человека
    private int weight;         // Вес человека
    private Country nationality; // Национальность человека

    /**
     * Конструктор для создания объекта {@link Person}.
     *
     * @param name        имя человека
     * @param weight      вес человека
     * @param nationality национальность человека
     */
    public Person(String name, int weight, Country nationality) {
        this.name = name;
        this.weight = weight;
        this.nationality = nationality;
    }

    /**
     * Возвращает строковое представление объекта {@link Person}.
     *
     * @return строковое представление в формате:
     *         "Person{name='имя', weight=вес, nationality=национальность}"
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", nationality=" + nationality +
                '}';
    }

    /**
     * Возвращает имя человека.
     *
     * @return имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя человека.
     *
     * @param name новое имя человека
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает вес человека.
     *
     * @return вес человека
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Устанавливает вес человека.
     *
     * @param weight новый вес человека
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Возвращает национальность человека.
     *
     * @return национальность человека
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Устанавливает национальность человека.
     *
     * @param nationality новая национальность человека
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }
}