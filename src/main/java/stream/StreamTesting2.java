package stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamTesting2 extends SreamTesting{

    public static void main(String[] args) {
        List<StreamUser> list = getStreamObjectTestData();
        System.out.println(list.stream().map(o->o.getId())
                        .collect(Collectors.toList()).toString());


    }
}
