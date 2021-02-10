package chapter2;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Chapter2Utils {
    // This regular expression identify all characters not belonging to "letter" category.
    private static final String WORD_REGEX = "[\\P{L}]+";


    public List<String> generateRandomStrings(int numberOfWords) {
        Random random = new Random();
        List<String> words = random.ints(0, 15)
                .limit(numberOfWords)
                .mapToObj(RandomStringUtils::randomAlphabetic)
                .collect(Collectors.toList());
        return words;
    }

    public List<String> getWordsAsList() {
        String content = null;
        try {
            content = new String(Files.readAllBytes
                    (Paths.get(this.getClass().getResource("/frankenstein.txt").toURI())),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Arrays.asList(content.split(WORD_REGEX));
    }


}
