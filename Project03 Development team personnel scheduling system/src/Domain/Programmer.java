package Domain;

import Service.TeamStatus;

public class Programmer extends Employee{

        private int memberId;
        private TeamStatus.Status status = TeamStatus.Status.FREE;
        private Equipment equipment;

        public Programmer() {super();
        }
    public Programmer(int id,
                      String name,
                      int age,
                      double salary,
                      int memberId,
                      TeamStatus.Status status,
                      Equipment equipment) {
        super(id, name, age, salary);
        this.memberId = memberId;
        this.status = status;
    }
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public TeamStatus.Status getStatus() {
        return status;
    }

    public void setStatus(TeamStatus.Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\tProgrammer\t" + status + "\t\t\t" + equipment;
    }



}


