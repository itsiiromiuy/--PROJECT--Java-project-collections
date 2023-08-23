package Service;

import Domain.*;

import static Service.TeamData.*;

/**
 * @Description: Encapsulates data from the Data class into the Employee[] array and provides methods for manipulating the Employee[] array.
 */
public class TeamListService {
    private Employee[] employees;
    private Equipment[] equipments;

    public TeamListService() {

        equipments = new Equipment[EQUIPMENTS.length];
        for (int i = 0; i < equipments.length; i++) {
            String[] eqs = EQUIPMENTS[i];
            if (eqs.length == 0) {
                continue;
            }
            int eqsType = Integer.parseInt(eqs[0]);
            switch (eqsType) {
                case PC:
                    equipments[i] = new PC(eqs[1], eqs[2]);
                    break;
                case MAC:
                    equipments[i] = new MAC(eqs[1], Integer.parseInt(eqs[2]));
                    break;
                case PRINTER:
                    equipments[i] = new Printer(eqs[1], eqs[2]);
                    break;
            }
        }

        // 1. Initialize the employees[] & array elements: Construct the employees array of appropriate size based on the Data class provided by the project.
        employees = new Employee[EMPLOYEES.length];
        // 2. Create different objects based on the data in the Data class, including Employee, Programmer, Designer, and Architect objects, along with associated Equipment objects.
        for (int i = 0; i < employees.length; i++) {
            // Get the type of Employee
            int employeeType = Integer.parseInt(EMPLOYEES[i][0]);

            // Get the four basic information of Employee
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Integer.parseInt(EMPLOYEES[i][4]);

            TeamStatus.Status status = TeamStatus.Status.FREE;
            double bonus;
            int memberId = 0;
            status = TeamStatus.Status.VACATION;
            Equipment equipment = equipments[i];

            switch (employeeType) {
                case STAFF:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    this.employees[i] = new Programmer(id, name, age, salary, memberId, status, equipment);
                    break;
                case DESIGNER:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    this.employees[i] = new Designer(id, name, age, salary, memberId, status, equipment, bonus);
                    break;
                case ARCHITECT:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, memberId, status, equipment, bonus, stock);
                    break;
            }
        }
    }

    /**
     * Get the employee object with the specified ID.
     *
     * @param id The ID of the specified employee
     * @return The specified employee object
     * @throws TeamException If the specified employee cannot be found
     */
    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new TeamException("Employee with specified ID [" + id + "] not found");
    }

    /**
     * Get all current employees and return the employee array.
     *
     * @return The array of all employees
     */
    public Employee[] getAllEmployees() {
        return employees;
    }
}
