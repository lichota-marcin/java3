import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1 {
    //1.
    @Test
    public void streamContainsNumbersFrom1To9() {
        Stream<Integer> streamTask1_1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        streamTask1_1.forEach(System.out::println);
        assertThat(streamTask1_1).contains(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(streamTask1_1).hasSize(4);
    }

    //2.
    @Test
    public void streamContains20Numbers() {
        Stream<Integer> streamTask1_2 = Stream
                .generate(new Random()::nextInt)
                .limit(20);
        streamTask1_2.forEach(System.out::println);
        assertThat(streamTask1_2).hasSize(20);
    }

    //3.
    @Test
    public void listContainsOnlyEvenElements() {
        List<Integer> listTask1_3 = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            listTask1_3.add(i);
        }
        List<Integer> evenList = listTask1_3
                .stream()
                .filter(i -> i % 2 == 0)
                .toList();
        evenList.forEach(System.out::println);
        assertThat(evenList).contains(2, 4, 6, 8);
        assertThat(evenList).hasSize(4);
    }
}
