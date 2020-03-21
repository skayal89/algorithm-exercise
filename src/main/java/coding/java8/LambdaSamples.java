package coding.java8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaSamples {
    public static void main(String[] args) {
        Employee u1=new Employee(1,"abc",19,15000,
                new Address(560103,"135"),new ArrayList<String>(){{add("3657483");}});
        Employee u2=new Employee(2,"xyz",15,25000,
                new Address(560156,"245"),new ArrayList<String>(){{add("3657483");}});
        Employee u3=new Employee(3,"pqrs",25,18500,
                new Address(561123,"106"),new ArrayList<String>(){{add("90878876");}});
        Employee u4=new Employee(4,"nvb",21,39000,
                new Address(560264,"909"),new ArrayList<String>(){{add("180007483"); add("8734486");}});


        List<Employee> employees =new ArrayList<Employee>();
        employees.add(u1);
        employees.add(u2);
        employees.add(u3);
        employees.add(u4);

        Map<Integer, Employee> userMap=new HashMap<>();
        userMap.put(1,u1);
        userMap.put(2,u2);
        userMap.put(3,u3);
        userMap.put(4,u4);

        System.out.println(employees);
        System.out.println(listToList(employees));
        System.out.println(listToMap(employees));
        System.out.println("filterByAge:"+filterByAge(employees));
        System.out.println("getUserByMaxAge:"+getUserByMaxAge(employees));
        System.out.println("getMaxSalary:"+getMaxSalary(employees));
        System.out.println("getAvgSalary:"+getAvgSalary(employees));
        System.out.println("areSalGreaterThan20k:"+areSalGreaterThan20k(employees));
        System.out.println("mapContactsToEmployee:"+mapContactsToEmployee(employees));
        System.out.println("hasSingleContactByEmp:"+hasSingleContactByEmp(employees));
        System.out.println("hasSingleContactById:"+hasSingleContactById(employees));
        System.out.println("inUnserviceablePincode:"+inUnserviceablePincode(employees));
        System.out.println(mapToList(userMap));
    }

    public static List<Integer> listToList(List<Employee> credentials){
        return credentials.stream().map(employee -> employee.getId()).collect(Collectors.toList());
    }

    public static List<String> mapToList(Map<Integer,Employee> map){
        return map.values().stream().map(Employee::getName).collect(Collectors.toList());
    }

    public static Map<Integer, Employee> listToMap(List<Employee> employees){
        return employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
    }

    public static List<Employee> filterByAge(List<Employee> employees){
        return employees.stream().filter(employee -> employee.getAge()>18).collect(Collectors.toList());
    }

    public static Employee getUserByMaxAge(List<Employee> employees){
        return employees.stream().max(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge()-o2.getAge();
            }
        }).get();
    }

    public static int getMaxSalary(List<Employee> employees){
        return employees.stream().mapToInt(Employee::getSalary).max().getAsInt();
    }

    public static double getAvgSalary(List<Employee> employees){
        return employees.stream().mapToInt(Employee::getSalary).average().getAsDouble();
    }

    public static boolean areSalGreaterThan20k(List<Employee> employees){
        return employees.stream().allMatch(employee -> employee.getSalary()>20000);
    }

    public static Map<Integer,List<String>> mapContactsToEmployee(List<Employee> employees){
        return employees.stream().collect(Collectors.toMap(Employee::getId,Employee::getContacts));
    }

    public static List<Employee> hasSingleContactByEmp(List<Employee> employees){
        return employees.stream().filter(employee -> employee.getContacts().size()<2).collect(Collectors.toList());
    }

    public static List<Integer> hasSingleContactById(List<Employee> employees){
        return employees
                .stream()
                .filter(employee -> employee.getContacts().size()<2)
                .map(Employee::getId)
                .collect(Collectors.toList());
    }

    public static List<Employee> inUnserviceablePincode(List<Employee> employees){
        return employees.stream()
                .filter(employee -> employee.getAddress().getPincode()==560264 || employee.getAddress().getPincode()==560103)
                .collect(Collectors.toList());
    }

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    static class Employee
    {
        private Integer id;
        private String name;
        private int age;
        private int salary;
        private Address address;
        List<String> contacts;
    }

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    static class Address{
        int pincode;
        String flatNumber;
    }
}
