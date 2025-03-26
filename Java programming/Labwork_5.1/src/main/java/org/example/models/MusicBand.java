package org.example.models;

import java.util.Date;

/**
 * Класс, представляющий музыкальную группу.
 * <p>
 * Содержит информацию о музыкальной группе, такую как идентификатор, название, координаты,
 * дата создания, количество участников, музыкальный жанр и фронтмен.
 * </p>
 *
 * @author Twinkiesss (Кудряшова Татьяна)
 */
public class MusicBand implements Comparable<MusicBand> {
    private static long nextId = 1; // Статическая переменная для генерации уникального ID
    private final Long id; // Уникальный идентификатор группы
    private String name; // Название группы
    private Coordinates coordinates; // Координаты группы
    private final Date creationDate; // Дата создания группы
    private long numberOfParticipants; // Количество участников группы
    private MusicGenre genre; // Музыкальный жанр группы
    private Person frontMan; // Фронтмен группы

    /**
     * Конструктор для создания объекта {@link MusicBand}.
     *
     * @param name                название группы
     * @param coordinates         координаты группы
     * @param numberOfParticipants количество участников группы
     * @param genre               музыкальный жанр группы
     * @param frontMan            фронтмен группы
     */
    public MusicBand(String name, Coordinates coordinates,
                     long numberOfParticipants, MusicGenre genre, Person frontMan) {
        this.id = nextId++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.frontMan = frontMan;
    }

    /**
     * Возвращает уникальный идентификатор группы.
     *
     * @return идентификатор группы
     */
    public Long getId() {
        return id;
    }

    /**
     * Возвращает название группы.
     *
     * @return название группы
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает координаты группы.
     *
     * @return координаты группы
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Возвращает дату создания группы.
     *
     * @return дата создания группы
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Возвращает количество участников группы.
     *
     * @return количество участников группы
     */
    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    /**
     * Возвращает музыкальный жанр группы.
     *
     * @return музыкальный жанр группы
     */
    public MusicGenre getGenre() {
        return genre;
    }

    /**
     * Возвращает фронтмена группы.
     *
     * @return фронтмен группы
     */
    public Person getFrontMan() {
        return frontMan;
    }

    /**
     * Сравнивает текущую музыкальную группу с другой группой по количеству участников.
     *
     * @param other другая музыкальная группа
     * @return результат сравнения (отрицательное число, если текущая группа меньше,
     *         положительное число, если больше, и 0, если группы равны)
     */
    @Override
    public int compareTo(MusicBand other) {
        return Long.compare(this.numberOfParticipants, other.numberOfParticipants);
    }

    /**
     * Возвращает строковое представление объекта {@link MusicBand}.
     *
     * @return строковое представление в формате:
     *         "MusicBand{id=..., name='...', coordinates=..., creationDate=...,
     *         numberOfParticipants=..., genre=..., frontMan=...}"
     */
    @Override
    public String toString() {
        return "MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", numberOfParticipants=" + numberOfParticipants +
                ", genre=" + genre +
                ", frontMan=" + (frontMan != null ? frontMan.toString() : "null") +
                '}';
    }

    /**
     * Устанавливает новое название группы.
     *
     * @param newName новое название группы
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Устанавливает новые координаты группы.
     *
     * @param coordinates новые координаты группы
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Устанавливает новое количество участников группы.
     *
     * @param participants новое количество участников группы
     */
    public void setNumberOfParticipants(long participants) {
        this.numberOfParticipants = participants;
    }

    /**
     * Устанавливает новый музыкальный жанр группы.
     *
     * @param genre новый музыкальный жанр группы
     */
    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    /**
     * Устанавливает нового фронтмена группы.
     *
     * @param frontMan новый фронтмен группы
     */
    public void setFrontMan(Person frontMan) {
        this.frontMan = frontMan;
    }
}