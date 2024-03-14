import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4 {

    //11.
    @Test
    public void flattenArrays() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> namesNested = Arrays.asList(
                list1, list2, list3);

        List<Integer> numbersFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .toList();
        numbersFlatStream.forEach(System.out::println);
        assertThat(numbersFlatStream).hasSize(9);
    }

    //12.
    @Test
    public void distinctList() {
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
        List<Integer> distinctNumberList = numbersList.stream()
                .distinct()
                .peek(System.out::println)
                .toList();
        assertThat(distinctNumberList).hasSize(7);
    }

    //13.
    @Test
    public void elementAsKeyAndValueAsOccurrence() {
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
        Map<Integer, Long> mapOfOccurrences = numbersList.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        for (Integer name : mapOfOccurrences.keySet()) {
            String key = name.toString();
            String value = mapOfOccurrences.get(name).toString();
            System.out.println(key + " " + value);
        }
        assertThat(mapOfOccurrences.get(1)).isEqualTo(2);
        assertThat(mapOfOccurrences.get(6)).isEqualTo(3);
    }
}