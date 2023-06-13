import java.time.LocalDate;

public class CarInsurance extends Insurance {

    private int modelYear;
    private int horsePower;

    public CarInsurance(String name, int modelYear, int horsePower, LocalDate startingDate, LocalDate endingDate) {
        super(name, 600, startingDate, endingDate);
        this.modelYear = modelYear;
        this.horsePower = horsePower;

    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void calculate() {
        double startingPrice = this.getPrice();
        if (this.getModelYear() >= 1980 && this.getModelYear() <= 2000) {
            if (this.getHorsePower() >= 1300 && this.getHorsePower() < 1600) {
                this.setPrice(startingPrice + this.getModelYear() * 0.15 + this.getHorsePower() * 0.12);
            } else if (this.getHorsePower() >= 1600 && this.getHorsePower() < 2000) {
                this.setPrice(startingPrice + this.getModelYear() * 0.15 + this.getHorsePower() * 0.15);
            } else if (this.getHorsePower() >= 2000) {
                this.setPrice(startingPrice + this.getModelYear() * 0.15 + this.getHorsePower() * 0.20);
            }
        } else if (this.getModelYear() >= 2001) {
            if (this.getHorsePower() >= 1300 && this.getHorsePower() < 1600) {
                this.setPrice(startingPrice + this.getModelYear() * 0.20 + this.getHorsePower() * 0.12);
            } else if (this.getHorsePower() >= 1600 && this.getHorsePower() < 2000) {
                this.setPrice(startingPrice + this.getModelYear() * 0.20 + this.getHorsePower() * 0.15);
            } else if (this.getHorsePower() >= 2000) {
                this.setPrice(startingPrice + this.getModelYear() * 0.20 + this.getHorsePower() * 0.20);
            }
        }
    }
}
