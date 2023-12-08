package wordplay;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import wordplay.io.DictionaryReader;
import wordplay.io.NamesReader;

public class NamesInDictionary {

    private static List<String> finnishNames = NamesReader.readFirstNames();
    private static List<String> finnishWords = DictionaryReader.readFinnishWords();

    public static void main(String[] args) {
        /*
         * Implement a program that prints all Finnish names that are also
         * found in the Finnish dictionary.
         *
         * You can use the finnishNames and finnishWords variables defined above
         * as the data set you need to process. Notice that the words are in lower case
         * but the names are not. The names can contain duplicates, as there are several
         * unisex names in the data set.
         *
         * Try to make your program as efficient as possible. A good goal is to have
         * the program run in tenths of a second.
         *
         * Good luck!
         */
           // Convert all names to lower case
    List<String> lowerCaseNames = finnishNames.stream()
        .map(String::toLowerCase)
        .collect(Collectors.toList());

    // Remove duplicates
    List<String> uniqueNames = lowerCaseNames.stream()
        .distinct()
        .collect(Collectors.toList());

    // Use a HashSet for the dictionary words for efficient lookup
    Set<String> wordsSet = new HashSet<>(finnishWords);

    // Iterate over the names and check if they are in the dictionary
    for (String name : uniqueNames) {
        if (wordsSet.contains(name)) {
            System.out.println(name);
        }
    }
}
}
