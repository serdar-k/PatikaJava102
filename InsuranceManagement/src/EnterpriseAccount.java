public class EnterpriseAccount extends Account {
    public EnterpriseAccount(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        double finalPrice = insurance.getPrice() + insurance.getPrice() * 0.20;
        insurance.setPrice(finalPrice);
        super.getInsuranceList().add(insurance);
    }
}
