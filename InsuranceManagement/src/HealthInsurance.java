import java.time.LocalDate;

public class HealthInsurance extends Insurance {

    private int age;
    private String gender;

    public HealthInsurance(String name, int age, String gender, LocalDate startingDate, LocalDate endingDate) {
        super(name, 500, startingDate, endingDate);
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void calculate() {
        double startingPrice = this.getPrice();
        if (this.getAge() <= 18) {
            this.setPrice(startingPrice);
        } else if (this.getAge() > 18 && this.getAge() <= 35) {
            if (this.gender.equalsIgnoreCase("erkek")) {
                this.setPrice(startingPrice + this.getAge() * 15);
            } else if (this.gender.equalsIgnoreCase("kadin")) {
                this.setPrice(startingPrice + this.getAge() * 12);
            }
        } else if (this.getAge() > 35 && this.getAge() <= 55) {
            if (this.gender.equalsIgnoreCase("erkek")) {
                this.setPrice(startingPrice + this.getAge() * 20);
            } else if (this.gender.equalsIgnoreCase("kadin")) {
                this.setPrice(startingPrice + this.getAge() * 15);
            }
        } else if (this.getAge() > 55) {
            if (this.gender.equalsIgnoreCase("erkek")) {
                this.setPrice(startingPrice + this.getAge() * 30);
            } else if (this.gender.equalsIgnoreCase("kadin")) {
                this.setPrice(startingPrice + this.getAge() * 25);
            }
        }
    }
}
