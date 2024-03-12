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
                Map<Integer, Long> mapOfOccurences = numbersList.stream()
                        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
                for (Integer name : mapOfOccurences.keySet()) {
                    String key = name.toString();
                    String value = mapOfOccurences.get(name).toString();
                    System.out.println(key + " " + value);
                }
                assertThat(mapOfOccurences.get(1)).isEqualTo(2);
                assertThat(mapOfOccurences.get(6)).isEqualTo(3);
            }
    //14.
    @Test
    public  void onlyStringValues(){
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123","s", "555-3389", "a"));
        people.put("Mary", Arrays.asList("555-2243","z", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));
        List<String> stringValues = people.values().stream().flatMap(Collection::stream)
                .filter(s -> s.matches("[a-zA-Z]"))
                .peek(System.out::println)
                .toList();
        assertThat(stringValues.getFirst()).isEqualTo("d");
        assertThat(stringValues.get(1)).isEqualTo("s");
        assertThat(stringValues.get(2)).isEqualTo("a");
        assertThat(stringValues.get(3)).isEqualTo("z");
        assertThat(stringValues).hasSize(4);
        }
}