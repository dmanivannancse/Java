package handson;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamSample {
    public static void main(String[] args) {
        //Stream of Integer Numbers
        //Print
        IntStream.rangeClosed(0, 100).forEach(System.out::println);
        // Filter Even Numbers and Print
        IntStream.rangeClosed(0, 100).filter(e -> e %2 == 0).forEach(System.out::println);
        // Filter even numbers, square it and print
        IntStream.rangeClosed(0, 100).filter(e -> e %2 == 0).map(e -> e*e).forEach(System.out::println);

        //Boxed - Wrap primitive int with Integer class.  Using Collectors to get the output in a list
        List<Integer> list = IntStream.rangeClosed(0, 100).filter(e -> e %2 == 0).map(e -> e/2).boxed().collect(Collectors.toList());
        list.add(101);

        //Boxed - Wrap primitive int with Integer class.  Using Collectors to get the output in a list
        List<Integer> unModifiableList = IntStream.rangeClosed(0, 100).filter(e -> e %2 == 0).map(e -> e/2).boxed().collect(Collectors.toUnmodifiableList());
        try {
         unModifiableList.add(101); // throws runtime java.lang.UnsupportedOperationException.    
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        
        IntStream.rangeClosed(0, 100).parallel().forEach(System.out::println);

        //Reduce is used to collect all the elements and apply collective action on them like avg, sum, min, max, join all. 
        int sum = IntStream.rangeClosed(0, 100).reduce(0, Integer::sum);
        System.out.println(sum);
    }

}
