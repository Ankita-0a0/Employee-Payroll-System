import java.lang.reflect.Array;
import java.util.ArrayList;

abstract class Employee{
    private String name;

    private int id;

    public Employee(String name, int id){             //constructor
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public abstract double calculateSalary();       //abstract methods

    @Override
    public String toString(){   //
        return "Employee[name="+name+", id="+id+", Salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){             //constructor
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override

    public double calculateSalary(){    //abstract methods
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){            //constructor
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){             //abstract methods
        return hourlyRate * hoursWorked;
    }
}

// ArrayList<Integer> arr = new ArrayList<>();

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){           //constructor
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("emp1", 1, 70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("emp2", 2, 40,100);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details:  ");
        payrollSystem.displayEmployee();
        System.out.println("Removeing Employee");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employees Details");
        payrollSystem.displayEmployee();
    }
}
