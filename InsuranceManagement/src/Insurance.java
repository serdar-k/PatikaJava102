import java.time.LocalDate;

public abstract class Insurance {
    private String name;
    private double price;
    private LocalDate startingDate;
    private LocalDate endingDate;

    public Insurance(String name, double price, LocalDate startingDate, LocalDate endingDate) {
        this.name = name;
        this.price = price;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public abstract void calculate();

}
