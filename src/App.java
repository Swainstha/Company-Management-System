import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DataCRUD dataCRUD = new DataCRUD();
        boolean loop = true;
        while(loop) {
            System.out.println("What would you like to do");
            System.out.println("1. Add Employee \t2. Read Employee Info\n3. Read All Employee Info" +
                    "\t4. Update Employee Info\n5. Delete Employee Info\t0. Exit \n");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); //to read the \n left by scanner.nextInt()
            Employee employee = new Employee();
            switch (choice) {
                case 1:
                    System.out.println("Name: ");
                    employee.setName(scanner.nextLine());
                    System.out.println("EmployeeID: ");
                    employee.setEmployeeId(scanner.nextInt());
                    System.out.println("Age: ");
                    employee.setAge(scanner.nextInt());
                    scanner.nextLine(); //to read the \n left by scanner.nextInt()
                    System.out.println("Gender: ");
                    employee.setGender(scanner.nextLine());
                    System.out.println("Department: ");
                    employee.setDepartment(scanner.nextLine());
                    System.out.println("Position: ");
                    employee.setPosition(scanner.nextLine());
                    System.out.println("Salary: ");
                    employee.setSalary(scanner.nextInt());
                    scanner.nextLine(); //to read the \n left by scanner.nextInt()
                    dataCRUD.saveEmployeeToFile(employee);
                    //System.out.println("Enter Date of Joining dd-mm-yy");
                    break;
                case 2:
                    System.out.println("Enter the name of the employee whose info is to be displayed");
                    System.out.println(dataCRUD.readFromFile(scanner.nextLine()) + "\n");
                    break;
                case 3:
                    System.out.println("The Employees with their info are: \n");
                    List<Employee> empList = new ArrayList<>(dataCRUD.readFromFile());
                    for (Employee e : empList) {
                        System.out.println(e);
                    }
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("Enter the name of the employee whose info you want to update\n");
                    String name = scanner.nextLine();
                    System.out.println("What would you like to update");
                    dataCRUD.updateInFile(name, updateInfo(name, dataCRUD));
                    break;
                case 5:
                    System.out.println("Enter the name of the employee to be deleted with his/her ID");
                    dataCRUD.deleteEmployee(scanner.nextLine(),scanner.nextInt());
                    scanner.nextLine(); //to read the \n left by scanner.nextInt()
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice");

            }
        }
    }

    public static Employee updateInfo(String name, DataCRUD dataCRUD) {

        Employee employee = dataCRUD.readFromFile(name);
        boolean loop = true;
        while(loop) {
            System.out.println("1. Name\t2.Age\t3.Gender\t4.EmployeeID\n5.Department\t6.Position\t7.Salary");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name: ");
                    employee.setName(scan.nextLine());
                    break;
                case 2:
                    System.out.println("Enter Age: ");
                    employee.setAge(scan.nextInt());
                    scan.nextLine();
                    break;
                case 3:
                    System.out.println("Enter Gender: ");
                    employee.setGender(scan.nextLine());
                    break;
                case 4:
                    System.out.println("Enter EmployeeID: ");
                    employee.setEmployeeId(scan.nextInt());
                    scan.nextLine();
                    break;
                case 5:
                    System.out.println("Enter Department: ");
                    employee.setDepartment(scan.nextLine());
                    break;
                case 6:
                    System.out.println("Enter Position: ");
                    employee.setPosition(scan.nextLine());
                    break;
                case 7:
                    System.out.println("Enter Salary: ");
                    employee.setSalary(scan.nextInt());
                    scan.nextLine();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
        }
        return employee;
    }

}
