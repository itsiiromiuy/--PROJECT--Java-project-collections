package domain;

import Service.TeamStatus;

public class Architect extends Designer {
    private int stock;

    public Architect() {
        super();
    }

    public Architect(int id,
                     String name,
                     int age,
                     double salary,
                     int memberId,
                     TeamStatus.Status status,
                     Equipment equipment,
                     double bonus,
                     int stock) {
        super(id, name, age, salary, memberId, status, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return super.getDetails() + "\tArchtiect\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment();
    }


    public String toString2() {
        return getMemberId() + "/" + getDetails() + "\tArchtiect\t" + getBonus() + "\t" + stock;
    }

}