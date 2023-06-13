import java.time.LocalDate;

public class TravelInsurance extends Insurance {

    private int timeOfJourney;
    private String countryClass;

    public TravelInsurance(String name, int timeOfJourney, String countryClass, LocalDate startingDate, LocalDate endingDate) {
        super(name, 800, startingDate, endingDate);
        this.timeOfJourney = timeOfJourney;
        this.countryClass = countryClass;
    }

    public double getTimeOfJourney() {
        return timeOfJourney;
    }

    public void setTimeOfJourney(int timeOfJourney) {
        this.timeOfJourney = timeOfJourney;
    }

    public String getCountryClass() {
        return countryClass;
    }

    public void setCountryClass(String countryClass) {
        this.countryClass = countryClass;
    }

    @Override
    public void calculate() {
        double startingPrice = this.getPrice();
        if (this.getCountryClass().equalsIgnoreCase("A")) {
            if (this.getTimeOfJourney() > 0 && this.getTimeOfJourney() <= 500) {
                this.setPrice(startingPrice + this.getTimeOfJourney() * 0.3);
            } else if (this.getTimeOfJourney() > 500 && this.getTimeOfJourney() <= 1000) {
                this.setPrice(startingPrice + this.getTimeOfJourney() * 0.4);
            }
            if (this.getTimeOfJourney() > 1000) {
                this.setPrice(startingPrice + this.getTimeOfJourney() * 0.5);
            }
        } else if (this.getCountryClass().equalsIgnoreCase("B")) {
            if (this.getTimeOfJourney() > 0 && this.getTimeOfJourney() <= 500) {
                this.setPrice(startingPrice + this.getTimeOfJourney() * 0.2);
            } else if (this.getTimeOfJourney() > 500 && this.getTimeOfJourney() <= 1000) {
                this.setPrice(startingPrice + this.getTimeOfJourney() * 0.3);
            }
            if (this.getTimeOfJourney() > 1000) {
                this.setPrice(startingPrice + this.getTimeOfJourney() * 0.4);
            }
        } else if (this.getCountryClass().equalsIgnoreCase("C")) {
            if (this.getTimeOfJourney() > 0 && this.getTimeOfJourney() <= 500) {
                this.setPrice(startingPrice + this.getTimeOfJourney() * 0.1);
            } else if (this.getTimeOfJourney() > 500 && this.getTimeOfJourney() <= 1000) {
                this.setPrice(startingPrice + this.getTimeOfJourney() * 0.2);
            }
            if (this.getTimeOfJourney() > 1000) {
                this.setPrice(startingPrice + this.getTimeOfJourney() * 0.3);
            }
        }
    }
}
