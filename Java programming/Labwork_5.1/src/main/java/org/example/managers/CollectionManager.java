package org.example.managers;

import org.example.models.MusicBand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс, управляющий коллекцией музыкальных групп.
 */
public class CollectionManager {
    private final Map<Integer, MusicBand> collection;

    public CollectionManager() {
        this.collection = new HashMap<>();
    }

    public Map<Integer, MusicBand> getCollection() {
        return collection;
    }

    public void addElement(int key, MusicBand band) {
        collection.put(key, band);
    }

    public void removeElement(int key) {
        collection.remove(key);
    }

    public void updateElement(int key, MusicBand band) {
        if (collection.containsKey(key)) {
            collection.put(key, band);
        }
    }

    public void clearCollection() {
        collection.clear();
    }

    public List<MusicBand> getSortedBands() {
        return collection.values().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public long sumOfParticipants() {
        return collection.values().stream()
                .mapToLong(MusicBand::getNumberOfParticipants)
                .sum();
    }
}