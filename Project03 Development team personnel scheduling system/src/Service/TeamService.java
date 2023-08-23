package Service;

import Domain.Architect;
import Domain.Designer;
import Domain.Employee;
import Domain.Programmer;

/**
 * @Description Manages development team members: add, delete, etc.
 */

public class TeamService {
    // counter is a static variable used to automatically generate unique IDs for team members when adding them to the team
    // (Hint: should use an increment approach) programmer.setMemberId(counter++);
    private static int counter = 1;
    // MAX_MEMBER: represents the maximum number of members in the development team
    private final int MAX_MEMBER = 5;
    // team array: used to store current team members' objects
    private Programmer[] team = new Programmer[MAX_MEMBER];
    // realCount: records the actual number of team members
    private int realCount;

    public TeamService() {
        super();
    }

    /**
     * @return An array containing all member objects, with the array size matching the number of members
     * @description Get all members in the development team
     */
    public Programmer[] getTeamList() {
        // 1) Create a new array with the size of the counter
        Programmer[] newTeamArr = new Programmer[realCount];
        // 2) Save all valid objects from the internal array into the new array one by one
        for (int i = 0; i < newTeamArr.length; i++) {
            newTeamArr[i] = this.team[i];
        }
        // 3) Return the new array
        return newTeamArr;
    }

    /**
     * @Description Add the specified employee to the team
     * @Param The object of the member to be added
     * @Exception If adding fails, TeamException will contain the reason for the failure
     */
    public void addMember(Employee employee) throws TeamException {
        //"Team is full, can't add"
        if (realCount >= MAX_MEMBER) {
            throw new TeamException("Team is full, can't add");
        }
        //"The member cannot be added because it is not part of the development team."
        if (!(employee instanceof Programmer)) {
            throw new TeamException("The member cannot be added because it is not part of the development team.");
        }
        //"The person is already a team member"
        if (isExist(employee)) {
            throw new TeamException("The person is already a team member");
        }
        //"The person is already a team member"
        Programmer programmer = (Programmer) employee;
        if (programmer.getStatus().equals(TeamStatus.Status.BUSY)) {
            throw new TeamException("The person is already a team member");
        } else if (programmer.getStatus().equals(TeamStatus.Status.VACATION)) {
            throw new TeamException("The person is on vacation");
        }

        int architect = 0;
        int designer = 0;
        int programmers = 0;
        // At most one architect, two designers, and three programmers in the team
        // Get the number of architects, programmers, and designers in the current team members
        for (int i = 0; i < realCount; i++) {
            if (team[i] instanceof Architect) {
                architect++;
            } else if (team[i] instanceof Designer) {
                designer++;
            } else {
                programmers++;
            }
        }
        if (programmer instanceof Architect) {
            if (architect == 1) {
                throw new TeamException("There can be at most one Architect on the team");
            }
        } else if (programmer instanceof Designer) {
            if (designer == 2) {
                throw new TeamException("There can be at most two Designers on the team");
            }
        } else {
            if (programmers == 3) {
                throw new TeamException("There can be at most Three Programmers on the team");
            }
        }
        // Assign a new TID to the new member and change the status
        programmer.setMemberId(counter++);
        programmer.setStatus(TeamStatus.Status.BUSY);
        // Save the object from the parameter into the array, adjust the counter
        this.team[realCount++] = programmer; // Passed by reference
    }

    private boolean isExist(Employee employee) {
        for (int i = 0; i < realCount; i++) {
            if (team[i].getId() == employee.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method: Remove a member from the team
     * Parameter: memberId of the member to be removed
     * Exception: If removal fails, TeamException will contain the reason for the failure
     */
    public void removeMember(int memberId) throws TeamException {
        // Find the index based on memberId
        int index = -1; // Set an invalid index first
        for (int i = 0; i < realCount; i++) {
            if (team[i].getMemberId() == memberId) {
                index = i;
                break;
            }
        }
        if (index == -1) { // If index hasn't been updated, it means the target hasn't been found
            throw new TeamException("There is no member with the specified TID[" + memberId + "]");
        }

        // Before removing, modify the TID and status of the target object to be removed
        team[index].setMemberId(0);
        team[index].setStatus(TeamStatus.Status.FREE);

        // 1) Make the slot of the to-be-deleted index empty
        team[index] = null;
        // 2) Starting from the index to be deleted, copy the right adjacent element to the left one by one
        for (int i = index; i < realCount - 1; i++) {
            team[i] = team[i + 1];
        }
        // 3) Make the previous last valid element slot empty, 4) Adjust the counter
        team[--realCount] = null; // Decrease first, then use
    }
}
