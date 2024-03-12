import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2 {

    //4.
    @Test
    public void arrayContainsOnlyEvenElements() {
        List<Integer> listTask2_1 = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            listTask2_1.add(i);
        }
        Integer[] evenArray = listTask2_1.stream()
                .filter(i -> i % 2 == 0)
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(evenArray));

        assertThat(evenArray).contains(2, 4, 6, 8);
        assertThat(evenArray).hasSize(4);
    }

    //5.
    @Test
    public void arrayContainsOnlyValuesStartingWithUppercaseC_AndIsSortedDesc() {
        List<String> listTask2_2 = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        List<String> upperCList = listTask2_2.stream()
                .filter(ch -> ch.charAt(0) == 'c')
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toList();
        upperCList.forEach(System.out::println);
        assertThat(upperCList.getFirst()).isEqualTo("C2");
        assertThat(upperCList.get(1)).isEqualTo("C1");
        assertThat(upperCList).hasSize(2);
    }
}
