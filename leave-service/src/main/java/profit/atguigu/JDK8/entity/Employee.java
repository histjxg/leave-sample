package profit.atguigu.JDK8.entity;

import java.util.Objects;

public class Employee {
    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
    private String name;
    private double salary;
    private Status status;

    public Employee(int age) {
        this.age = age;
    }

    public Employee() {

    }

    public Employee(int age, String name, double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public Employee(Integer age, String name, double salary, Status status) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.status = status;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" + "age=" + age + ", name='" + name + '\'' + ", salary=" + salary + ", status=" + status
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(age, employee.age) && Objects
                .equals(name, employee.name);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(age, name, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public enum Status{
        FREE,BUSY,VOCATION
    }

}
