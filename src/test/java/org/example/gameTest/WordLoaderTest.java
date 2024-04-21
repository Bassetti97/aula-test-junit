package org.example.gameTest;

import org.example.game.WordLoader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordLoaderTest {

    @Test
    void testLoad() {
        WordLoader loader = new WordLoader(5);
        String word = loader.load();
        assertNotNull(word);
        assertFalse(word.isEmpty());
    }
}

