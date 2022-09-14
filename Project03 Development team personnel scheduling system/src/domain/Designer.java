package domain;


import Service.TeamStatus;

public class Designer extends Programmer {

    private double bonus;

    public Designer() {
        super();
    }

    public Designer(int id,
                    String name,
                    int age,
                    double salary,
                    int memberId,
                    TeamStatus.Status status,
                    Equipment equipment,
                    double bonus) {
        super(id, name, age, salary, memberId, status, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\tDesigner\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment();
    }

     public String toString2() {
        return getMemberId() + "/" + getDetails() + "\tDesigner\t" + bonus;
    }

}
