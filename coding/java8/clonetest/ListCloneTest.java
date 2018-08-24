package coding.java8.clonetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListCloneTest {

    public static void main(String[] args) {
        Integer a[]=new Integer[]{2,5,4,1,7,9};
        ArrayList<Integer> integerArrayList=new ArrayList<>(Arrays.asList(a));
        ArrayList<Integer> integerArrayListCopy= (ArrayList<Integer>) integerArrayList.clone(); // Deep Copy
        integerArrayListCopy.set(0,9);
        System.out.println(integerArrayList);
        System.out.println(integerArrayListCopy);
        ArrayList<Integer> integerArrayList1=new ArrayList<>(integerArrayList); // deep copy in case of wrapper class
        integerArrayList1.set(1,9);
        System.out.println(integerArrayList);
        System.out.println(integerArrayList1);

        String str[]=new String[]{"hi","abc","bh"};
        ArrayList<String> stringArrayList=new ArrayList<>(Arrays.asList(str));
        ArrayList<String> stringArrayList1=new ArrayList<>(stringArrayList);
        stringArrayList1.set(0,"hello");
        System.out.println(stringArrayList);
        System.out.println(stringArrayList1);


        Employee e1= Employee.builder().id(10).name("abc").salary(25000).build();
        Employee e2= Employee.builder().id(15).name("xyz").salary(4000).build();
        Employee e3= Employee.builder().id(30).name("pot").salary(9700).build();

        ArrayList<Employee> employees=new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        System.out.println(employees);

        ArrayList<Employee> employeesClone=new ArrayList<>(employees); // Shallow Copy
        System.out.println(employeesClone);
        employeesClone.get(0).setSalary(35000);

        System.out.println("After modify");
        System.out.println(employeesClone);
        System.out.println(employees);

        ArrayList<Employee> employeesClone2=new ArrayList<>();
        employeesClone2.addAll(employees); // Shallow Copy
        employeesClone2.get(0).setSalary(5000);
        System.out.println("After modify");
        System.out.println(employeesClone2);
        System.out.println(employees);

        /* Deep Copy examples */
        Employee e11= Employee.builder().id(101).name("abc").salary(5000).build();
        Employee e21= Employee.builder().id(151).name("xyz").salary(14000).build();
        Employee e31= Employee.builder().id(301).name("pot").salary(7700).build();
        ArrayList<Employee> employeeList=new ArrayList<>();
        employeeList.add(e11);
        employeeList.add(e21);
        employeeList.add(e31);
        System.out.println(employeeList);

        List<Employee> employeeListCopy=deepCopy1(employeeList);
        System.out.println(employeeListCopy);

        System.out.println("After Modify");
        employeeListCopy.get(0).setSalary(3300);
        System.out.println(employeeList);
        System.out.println(employeeListCopy);
    }

    static List<Employee> deepCopy1(ArrayList<Employee> list){
        return list.stream().map(Employee::clone).collect(Collectors.toList());
        // return list.stream().map(e -> e.clone()).collect(Collectors.toList());
    }
}
