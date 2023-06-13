public class HomeAddress implements IAddress {
    private String addressName;
    private String street;
    private String district;
    private String province;
    private String city;
    private int postalCode;

    public HomeAddress(String addressName, String street, String district, String province, String city, int postalCode) {
        this.addressName = addressName;
        this.street = street;
        this.district = district;
        this.province = province;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String country) {
        this.province = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }


    @Override
    public String getAddressInfo() {
        return ("Adres Basligi: " + this.getAddressName() + " - " + "Sokak: " + this.getStreet() + "Mahalle: " + this.getDistrict() + " - " + "Ilce: " + this.getProvince() + " - " + "Il: " + this.getCity() + " - " + "Posta Kodu: " + this.getPostalCode());
    }

}
