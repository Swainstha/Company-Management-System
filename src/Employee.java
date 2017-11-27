import java.util.Date;

public class Employee implements Person {

    private String name;
    private String gender;
    private int age;
    private int employeeId;
    private String department;
    private Date dateOfJoining;
    private String position;
    private long salary;

    public Employee() { //default constructor
        this.name = "Someone";
    }

    public Employee(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //Setters
    @Override
    public void setAge(int age) {
            this.age = age;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    //Getters
    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "EmployeeID: " + this.employeeId + " ,Name: " + this.name + " ,Age: " + this.age + " ,Gender: " + this.gender +
                " ,Department: " + this.department + " ,Position: " + this.position + " ,Salary: " + salary +
                " ,Date: " + this.dateOfJoining;
    }
}
