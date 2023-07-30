package Service;


import Domain.*;

import static Service.TeamData.*;

/**
 * @Description: Responsible for encapsulating the data in Data into the Employee[] array, as well as providing the relevant methods to manipulate Employee[].
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

        //1.Initialize the employees[] & array elements: Build the corresponding size employees array according to the Data class provided by the project
        employees = new Employee[EMPLOYEES.length];
        //2. Then build different objects based on the data in the Data class, including Employee, Programmer, Designer and Architect objects, as well as the objects of the associated Equipment
        // subclass
        for (int i = 0; i < employees.length; i++) {
            // Get the type of Employee

            int EmployeeType = Integer.parseInt(EMPLOYEES[i][0]);

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

            switch (EmployeeType) {
                case STAFF:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    //  equipment = getEquipment(i);
                    this.employees[i] = new Programmer(id, name, age, salary, memberId, status, equipment);
                    break;
                case DESIGNER:
                    // equipment = getEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    this.employees[i] = new Designer(id, name, age, salary, memberId, status, equipment, bonus);
                    break;
                case ARCHITECT:
                    //  equipment = getEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, memberId, status, equipment, bonus, stock);
                    break;
            }
        }
    }


   /* //getEquipment Method 2
    private Equipment getEquipment(int index) {
        int EquipmentCode = Integer.parseInt(EQUIPMENTS[index][0]);
        String model = EQUIPMENTS[index][1];
        String info = EQUIPMENTS[index][2];
        switch (EquipmentCode) {
            case TeamData.PC:
                return new PC(model, info);
            case TeamData.MAC:
                double price = Double.parseDouble(info);
                return new MAC(model, price);
            case TeamData.PRINTER:
                return new Printer(model, info);
        }
        return null;
    }*/

    /**
     * @Description Get the employee object with the specified ID.
     * @param: ID of the specified employee
     * @Return the specified employee object
     * @Exception: the specified employee could not be found
     */
    public Employee getEmployee(int id) throws TeamException {
        // 遍历员工数组
        for (Employee employee : employees) {
            // 如果某员工的id和参数id相等
            if (employee.getId() == id) {
                // 返回某员工
                return employee;
            }
        }
        // 循环结束后 直接抛出异常
        throw new TeamException("未找到指定ID[" + id + "]的员工");
    }

    /**
     * @Description Get the current employee and return the current employee array
     * @param：
     * @Return employees
     */
    public Employee[] getAllEmployees() {
        return employees;
    }
}
