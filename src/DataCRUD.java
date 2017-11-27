import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataCRUD {
    Employee employee = new Employee();

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    /***********************************************************************************/

    /** Read the json file and map it into a list of Employee class objects */
    public List<Employee> readFromFile() {
        List<Employee> empArray = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("hello.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Gson gson = new Gson();
                Employee employee = gson.fromJson(line, Employee.class);
                empArray.add(employee);
            }
            reader.close();
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException a) {
            a.printStackTrace();
        }
        return empArray;
    }

    /**********************************************************************************************/
    /** Read the info of a specific person from the file*/

    public Employee readFromFile(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("hello.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Gson gson = new Gson();
                Employee employee = gson.fromJson(line, Employee.class);
                if(employee.getName().equals(name)) {
                    return employee;
                }
            }
            System.out.println("Could find the name " + name + " in the file");
            reader.close();
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException a) {
            a.printStackTrace();
        }
        return null;
    }

    /***********************************************************************************************/

    /** Save an employee information to a file */
    public void saveEmployeeToFile(Employee employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("hello.txt"), true))) {

            this.writeToFile(writer,employee);

        } catch(FileNotFoundException f) {
            System.out.println("THe required file was not found");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /*********************************************************************************************/

    /** matching the name of the employee to delete its content from the file
    first the info of all employees except the employee to be deleted are copied to a new file new.txt then
    later the whole content of file is copied to hello.txt(original file) */

    public void deleteEmployee(String name, int ID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("hello.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("new.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Gson gson = new Gson();
                Employee employee = gson.fromJson(line, Employee.class);
                if(!(employee.getName().equals(name) && employee.getEmployeeId() == ID)) {
                    this.writeToFile(writer, employee);
                }
            }
            writer.close();
            reader.close();
            this.copyFileToFile("new.txt", "hello.txt");
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException a) {
            a.printStackTrace();
        }
    }

    /**********************************************************************************************/

    /** When the required match for the employee name is found all the new info of the required employee is copied to the new file
     * instead of the info of the  info of the required employee from the read file
     * otherwise other employee's info are copied from the read file to the new file
     * later the new file is recopied to the hello.txt
     */
    public void updateInFile(String name, Employee employee) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("hello.txt")));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File("new.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Gson gson = new Gson();
                Employee emp = gson.fromJson(line, Employee.class);
                if((emp.getName().equals(name))) {
                    this.writeToFile(writer, employee);
                } else {
                    this.writeToFile(writer, emp);
                }
            }
            writer.close();
            reader.close();
            this.copyFileToFile("new.txt", "hello.txt");

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException a) {
            a.printStackTrace();
        }
    }

    /*********************************************************************************************/

    /** the employee object is converted to json format using gson library */
    public void writeToFile(BufferedWriter writer, Employee employee) throws IOException{
        Gson gson = new Gson();
        String data = gson.toJson(employee);
        writer.append(data);
        writer.append("\n");
    }

    /**********************************************************************************************/

    /** The contents of one file is copied to another*/
    public void copyFileToFile(String source, String destination) throws IOException{
        File file = new File(source);
        InputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream(new File(destination));
        byte[] buf = new byte[(int)file.length()];
        int len;

        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
}
