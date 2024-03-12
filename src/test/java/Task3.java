import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3 {

    List<String> memberNames = Arrays.asList("Amitabh","Shekhar","Aman","Rahul","Shahrukh","Abibaba","Salman","Yana","Lokesh");
    //6.
    @Test
    public void namesStartingWithLowerCaseASorted() {
        List<String> lowerList = memberNames.stream()
                .filter(ch -> ch.charAt(0) == 'A' && ch.length() > 5)
                .map(String::toLowerCase)
                .sorted(Comparator.naturalOrder())
                .toList();
        lowerList.forEach(System.out::println);
        assertThat(lowerList.getFirst()).isEqualTo("abibaba");
        assertThat(lowerList.get(1)).isEqualTo("amitabh");
        assertThat(lowerList).hasSize(2);
    }
    //7.1
    @Test
    public void allElementsContainLetterS() {
        boolean allElementsContainLetterS = memberNames.stream()
                .allMatch(ch -> ch.contains("S"));
        assertThat(allElementsContainLetterS).isEqualTo(false);

    }
    //7.2
    @Test
    public void anyElementContainsLetterS() {
        boolean anyElementContainsLetterS = memberNames.stream()
                .anyMatch(ch -> ch.contains("S"));
        assertThat(anyElementContainsLetterS).isEqualTo(true);
    }
    //7.3
    @Test
    public void noElementsContainLetterH(){
        boolean noElementsContainH = memberNames.stream()
                .noneMatch(ch -> ch.contains("H"));
        assertThat(noElementsContainH).isEqualTo(true);
    }
    //9.
    @Test
    public void elementsStartingWithLetterA (){
        long elementsStartingWithLetterA = memberNames.stream()
                .filter(ch -> ch.startsWith("A"))
                .count();
        System.out.println(elementsStartingWithLetterA);
        assertThat(elementsStartingWithLetterA).isEqualTo(3);
    }
    //10.
    @Test
    public void findFirstElementStartingWithLetterL (){
        String firstL = memberNames.stream()
                .filter(ch -> ch.startsWith("L"))
                .findFirst()
                .orElse(null);
        System.out.println(firstL);
        assertThat(firstL).isEqualTo("Lokesh");
    }
}
