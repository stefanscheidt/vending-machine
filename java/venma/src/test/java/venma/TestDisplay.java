package venma;

import vendomagic.ports.Display;

import java.util.*;

public class TestDisplay implements Display {

    private final List<String> displayedText = new ArrayList<>();

    @Override
    public void show(String text) {
        displayedText.add(text);
    }

    public List<String> displayedText() {
        return Collections.unmodifiableList(displayedText);
    }

    public void clear() {
        displayedText.clear();
    }
}
