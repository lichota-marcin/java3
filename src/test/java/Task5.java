import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Task5 {

    //14.
    @Test
    public void onlyStringValues() {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "s", "555-3389", "a"));
        people.put("Mary", Arrays.asList("555-2243", "z", "555-5264"));
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
