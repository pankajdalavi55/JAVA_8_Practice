package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SreamTesting {

    public static void main(String[] args) {
        System.out.println("Hello");

        List<StreamUser> list = getStreamObjectTestData();
        //System.out.println(list);

        System.out.println("---------------------------------Filter-------------------------------");
        // Filter
        System.out.println("1.Find all the female and collect into List ");
        List<StreamUser> females = list
                .stream()
                .filter((user)-> user.getGender().equals("Female"))
                .collect(Collectors.toList());
        System.out.println(females);

        System.out.println("---------------------------------Filter-------------------------------");
        System.out.println("2. Find all the users having department as art");
        List<StreamUser> artStudent = list
                .stream()
                .filter((obj)->obj.getDepartment().equalsIgnoreCase("art"))
                .collect(Collectors.toList());
        System.out.println(artStudent);

        System.out.println("---------------------------------Filter-------------------------------");
        System.out.println("3. Find all the users who study acting subject");
        List<StreamUser> actingLearner = list
                .stream()
                .filter((obj)->obj.getSubjects().contains("Acting"))
                .collect(Collectors.toList());
        System.out.println(actingLearner);

        System.out.println("---------------------------------Filter-------------------------------");
        //3. find all the unique subject of science department
        List<List<String>> scienceSub = list
                .stream()
                .filter((obj)->obj.getDepartment().equalsIgnoreCase("Science"))
                .map((obj)->obj.getSubjects().stream().collect(Collectors.toList()))
                .map()
                .collect(Collectors.toList());
        System.out.println(scienceSub);

        System.out.println("---------------------------------Filter-------------------------------");
        System.out.println("4. Find all the users having salary more than 10000 INR");

        List<StreamUser> users = list
                .stream()
                .filter(obj->obj.getStifund()>10000)
                .collect(Collectors.toList());
        System.out.println(users);

        System.out.println("---------------------------------Map-------------------------------");
        System.out.println("1. Find all the usernames and collect into set in uppercase");

        Set<String> studentName = list
                .stream()
                .map(obj->obj.getName().toUpperCase())
                .collect(Collectors.toSet());
        System.out.println(studentName);

        System.out.println("---------------------------------Map-------------------------------");
        System.out.println("2. Find all the distinct departments");

        List<String> departmnets = list
                .stream()
                .map(obj->obj.getDepartment())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(departmnets);

        System.out.println("---------------------------------Map-------------------------------");
        System.out.println("2. Find all the distinct departments");









    }

    private static List<StreamUser> getStreamObjectTestData() {

        List<StreamUser> users = new ArrayList<StreamUser>();

        users.add(new StreamUser(1l, "Raj", "Science",
                Arrays.asList("Math", "Physics"), 12000.40, "Male"));
        users.add(new StreamUser(12l, "John", "Science",
                Arrays.asList("Chemistry", "Physics"), 5000, "Male"));
        users.add(new StreamUser(13l, "Daniel", "Science",
                Arrays.asList("Chemistry", "Physics", "Math"), 8000.50, "Male"));
        users.add(new StreamUser(16l, "Smith", "Commerce",
                Arrays.asList("Account", "GST"), 11000, "Male"));
        users.add(new StreamUser(18l, "Kalpesh", "Art",
                Arrays.asList("Music"), 5000, "Male"));
        users.add(new StreamUser(19l, "Jeneliya", "Art",
                Arrays.asList("Acting"), 15000, "Female"));
        users.add(new StreamUser(17l, "Kapil", "Art",
                Arrays.asList("Comedy", "Singing"), 9000, "Male"));
        users.add(new StreamUser(21l, "sara", "Science",
                Arrays.asList("Biology", "Atomic science"), 50000, "Female"));
        users.add(new StreamUser(23l, "Kyila", "HR",
                Arrays.asList("Psychology", "Management"), 5000, "Male"));
        users.add(new StreamUser(14l, "Ranveer", "Art",
                Arrays.asList("Acting", "Singing"), 5000, "Male"));

        return users;
    }
}
