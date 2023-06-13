public class IndividualAccount extends Account {
    public IndividualAccount(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        double finalPrice = insurance.getPrice() + insurance.getPrice() * 0.18;
        insurance.setPrice(finalPrice);
        super.getInsuranceList().add(insurance);
    }
}
