package coding.java8;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<>();
        Employee e1=new Employee(170,"xyz",3000);
        employees.add(e1);
        employees.add(new Employee(101,"abc",1100));
        employees.add(new Employee(220,"pqr",3600));
        employees.add(new Employee(130,"jfh",3880));

        Comparator<Employee> cid=new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.empid-o2.empid;
            }
        };
        Comparator<Employee> csal=new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.salary-o2.salary;
            }
        };

        System.out.println(employees);
        Collections.sort(employees, cid);
        System.out.println(employees);
        int position = Collections.binarySearch(employees, new Employee(170,"xyz",3000), cid);
        System.out.println(position);
        System.out.println(Collections.min(employees,csal));
    }

    @AllArgsConstructor
    @ToString
    static class Employee{
        int empid;
        String name;
        int salary;
    }
}
