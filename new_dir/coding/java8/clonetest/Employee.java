package coding.java8.clonetest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Employee implements Cloneable {
    int id;
    String name;
    int salary;

    @Override
    public Employee clone() {
        Employee employee = null;
        try {
            employee = (Employee)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return employee;
    }

}
