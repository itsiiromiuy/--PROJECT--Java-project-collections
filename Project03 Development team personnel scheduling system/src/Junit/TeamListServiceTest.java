package Junit;

import Service.TeamException;
import Service.TeamListService;
import Domain.Employee;
import org.junit.Test;

public class TeamListServiceTest {
    @Test
    public void testGetAllEmployees() {
        TeamListService listService = new TeamListService();
        Employee[] employees = listService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee() {
        TeamListService listService = new TeamListService();
        int id = 1;
        try {
            Employee employee = listService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }


}
}
