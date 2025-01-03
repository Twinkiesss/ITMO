package Other;

import java.util.ArrayList;
import Exception.*;

public class Sentence {
    public StringBuilder content;
    public ArrayList<String> story;

    public Sentence() {
        content = new StringBuilder();
        story = new ArrayList<>();
    }

    public void makeStory() throws EmptyException {
        if (story.isEmpty()) {
            throw new EmptyException();
        }
        for (String sentence : story) {
            System.out.println(sentence);
        }
    }

    public void dot() {
        story.add(content.toString() + "."); // Добавляем строку
        content.setLength(0); // Очищаем content
    }


    public void and(String words) {
        content.append("и " + words + " ");
    }

    public void no(String words) {
        content.append("не " + words + " ");
    }

    public void differentNo(String words) {
        content.append("ни " + words + " ");
    }

    public void how(String words) {
        content.append("как " + words + " ");
    }

    public void still(String words) {
        content.append("все же " + words + " ");
    }

    public void with(String words) {
        content.append("с " + words + " ");
    }

    public void that(String words) {
        content.append("что " + words + " ");
    }

    public void at(String words) {
        content.append("на " + words + " ");
    }

    public void about(String words) {
        content.append("об " + words + " ");
    }

    public void next(String words) {
        content.append(words + " ");
    }

    public void but(String words) {
        content.append("но " + words + " ");
    }

    public void oneDay(String words) {
        content.append("однажды " + words + " ");
    }

    public void in(String words) {
        content.append("в " + words + " ");
    }

    public void comma(String words) {
        content.append(", " + words + " ");
    }

    public void differentBut(String words) { content.append("да " + words + " ");}


}