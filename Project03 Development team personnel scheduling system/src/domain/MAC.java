package domain;


public class MAC implements Equipment {
    private String model;
    private double price;

    public MAC(String model, double price) {
        super();
        this.model = model;
        this.price = price;
    }

    public MAC() {
        super();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
