package stream;

import com.sun.security.jgss.GSSUtil;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasicTest {

    public static void main(String[] args) {

        // to generate Stream
        Stream<Integer> numbStream = Stream.of(1, 2,3,4,55,66,777);

        Stream<Integer> arrStream = Stream.of(new Integer[]{1, 33,44,23,432});

        //to generate random number we can use Stream generator

        List<Integer> randomNumber = Stream
                .generate(()->(new Random()).nextInt(100))
                .limit(30)
                .collect(Collectors.toList());

        System.out.println(randomNumber);

        // generate stream using iterator

        List<Double> douNumbList = Stream
                .iterate(1.2, n->n+2)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(douNumbList);

        // Stream using Builder

        List<String> strBuilder = Stream.<String>builder()
                .add("asd")
                .add("ll")
                .add("iop")
                .build()
                .collect(Collectors.toList());
        System.out.println(strBuilder);


    }
}
