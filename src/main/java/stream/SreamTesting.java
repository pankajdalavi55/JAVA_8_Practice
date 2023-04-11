package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        System.out.println("4. find all the unique subject of science department");
        //3. find all the unique subject of science department
        Set<String> scienceSub = list
                .stream()
                .filter((obj) -> obj.getDepartment().equalsIgnoreCase("Science"))
                .map(StreamUser::getSubjects)
                .flatMap(Collection::stream)//flatMap(str-str.stream())
                .collect(Collectors.toSet());
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
                .map(StreamUser::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(departmnets);

        System.out.println("---------------------------------Map-------------------------------");
        System.out.println("2. Find all the distinct departments");

        List<String> departments = list
                .stream()
                .map(StreamUser::getDepartment)
                .distinct().collect(Collectors.toList());

        System.out.println(departments);

        System.out.println("---------------------------------Summing-------------------------------");
        System.out.println("2. Find total salary");

        Double totalSalary = list
                .stream().mapToDouble(StreamUser::getStifund).sum();
        //list.stream().collect(Collectors.summingDouble(StreamUser::getStifund))
        System.out.println("Total sti fund require :"+ totalSalary);

        OptionalDouble maxSalary = list
                .stream().mapToDouble(StreamUser::getStifund).max();
        System.out.println("Max sti fund :"+maxSalary);

        OptionalDouble minSalary = list
                .stream().mapToDouble(StreamUser::getStifund).min();
        System.out.println("Min sti fund :"+minSalary);

        OptionalDouble avgSalary = list
                .stream().mapToDouble(StreamUser::getStifund).average();
        System.out.println("AVG sti fund :"+avgSalary);


        System.out.println("---------------------------------Sorting-------------------------------");
        System.out.println("2. sort users by salary");

        List<StreamUser> sortBySalary = list
                .stream()
                .sorted(Comparator.comparingDouble(StreamUser::getStifund).reversed())
                .collect(Collectors.toList());
        System.out.println(sortBySalary);

        System.out.println("---------------------------------Sorting-------------------------------");
        System.out.println("2. find streamuser having 2 highest salary");

        Optional<StreamUser> secondHighestSalaryUser = list
                .stream()
                .sorted(Comparator.comparingDouble(StreamUser::getStifund).reversed())
                .skip(1)
                .findFirst();
        System.out.println(secondHighestSalaryUser.get());


        System.out.println("2. find streamuser having 3rd highest salary");

        Optional<StreamUser> thirdHighestSalaryUser = list
                .stream()
                .sorted(Comparator.comparingDouble(StreamUser::getStifund).reversed())
                .skip(2)
                .findFirst();
        System.out.println(thirdHighestSalaryUser.get());

        System.out.println("---------------------------------Map-------------------------------");
        System.out.println("2. find StreamUser having 2 highest salary");

//        Map<String, List<String>> passingFailing =
//                list.stream()
//                        .collect(Collectors.partitioningBy(s->s.getGender().equalsIgnoreCase("Male"),
//                               Collectors.toMap("Male", new ArrayList<>().add()) );



        System.out.println("---------------------------------Comparator-------------------------------");
        System.out.println("Sort by user name..!");

        List<StreamUser> usersByName = list.stream()
                .sorted(Comparator.comparing(StreamUser::getName))
                .collect(Collectors.toList());
        System.out.println(usersByName);

        System.out.println("---------------------------------Map-------------------------------");
        System.out.println("Store user name with salary in map..!");

        Map<String, Double> userWithSalary = list.stream()
                .collect(Collectors.toMap(StreamUser::getName, StreamUser::getStifund));
        userWithSalary.entrySet().
                stream().forEach((t)-> System.out.println("Name :"+t.getKey()+" Salary :"+ t.getValue()));

    }

    private static List<StreamUser> getStreamObjectTestData() {

        List<StreamUser> users = new ArrayList<>();

        users.add(new StreamUser(1L, "Raj", "Science",
                Arrays.asList("Math", "Physics"), 12000.40, "Male"));
        users.add(new StreamUser(12L, "John", "Science",
                Arrays.asList("Chemistry", "Physics"), 5000, "Male"));
        users.add(new StreamUser(13L, "Daniel", "Science",
                Arrays.asList("Chemistry", "Physics", "Math"), 8000.50, "Male"));
        users.add(new StreamUser(16L, "Smith", "Commerce",
                Arrays.asList("Account", "GST"), 11000, "Male"));
        users.add(new StreamUser(18L, "Kamlesh", "Art",
                List.of("Music"), 5000, "Male"));
        users.add(new StreamUser(19L, "Jenelle", "Art",
                Arrays.asList("Acting"), 15000, "Female"));
        users.add(new StreamUser(17L, "Kapil", "Art",
                Arrays.asList("Comedy", "Singing"), 9000, "Male"));
        users.add(new StreamUser(21L, "sara", "Science",
                Arrays.asList("Biology", "Atomic science"), 50000, "Female"));
        users.add(new StreamUser(23L, "Kyla", "HR",
                Arrays.asList("Psychology", "Management"), 5000, "Male"));
        users.add(new StreamUser(14L, "Ran veer", "Art",
                Arrays.asList("Acting", "Singing"), 5000, "Male"));

        return users;
    }
}
