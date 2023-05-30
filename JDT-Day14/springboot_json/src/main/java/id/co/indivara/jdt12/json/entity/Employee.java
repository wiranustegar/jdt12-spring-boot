package id.co.indivara.jdt12.json.entity;

public class Employee {
    private int employeeId;
    private String firstName;
    private double salary;

    public Employee() {
    }

    public String toString(){
        return "NIP: " + employeeId + ", NAMA: " + firstName + ", Salary: " + salary;
    }

    public Employee(int employeeId, String firstName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
