import java.time.LocalDate;

public class ResidenceInsurance extends Insurance {

    private int squareMetersOfTheHouse;

    public ResidenceInsurance(String name, int squareMetersOfTheHouse, LocalDate startingDate, LocalDate endingDate) {
        super(name, 750, startingDate, endingDate);
        this.squareMetersOfTheHouse = squareMetersOfTheHouse;
    }

    public int getSquareMetersOfTheHouse() {
        return squareMetersOfTheHouse;
    }

    public void setSquareMetersOfTheHouse(int squareMetersOfTheHouse) {
        this.squareMetersOfTheHouse = squareMetersOfTheHouse;
    }

    @Override
    public void calculate() {
        double startingPrice = this.getPrice();
        if (this.getSquareMetersOfTheHouse() > 0 && this.getSquareMetersOfTheHouse() <= 70) {
            this.setPrice(startingPrice + this.getSquareMetersOfTheHouse() * 0.15);
        } else if (this.getSquareMetersOfTheHouse() > 70 && this.getSquareMetersOfTheHouse() <= 100) {
            this.setPrice(startingPrice + this.getSquareMetersOfTheHouse() * 0.20);
        } else if (this.getSquareMetersOfTheHouse() > 100 && this.getSquareMetersOfTheHouse() <= 150) {
            this.setPrice(startingPrice + this.getSquareMetersOfTheHouse() * 0.25);
        }
        if (this.getSquareMetersOfTheHouse() > 150) {
            this.setPrice(startingPrice + this.getSquareMetersOfTheHouse() * 0.30);
        }

    }
}
