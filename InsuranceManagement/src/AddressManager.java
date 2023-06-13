public class AddressManager {

    private static User user;
    private static IAddress address;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IAddress getAddress() {
        return address;
    }

    public void setAddress(IAddress address) {
        this.address = address;
    }

    public static void addUserAddress(User user, IAddress address) {
        user.getAddressList().add(address);
    }

    public static void editAddress(User user, int index, String addressName, String street, String district, String province, String city, int postalCode) {
        index--;
        IAddress address = user.getAddressList().get(index);
        address.setAddressName(addressName);
        address.setStreet(street);
        address.setDistrict(district);
        address.setProvince(province);
        address.setCity(city);
        address.setPostalCode(postalCode);
        System.out.println("Adres Bilgileriniz Güncellendi!");
    }

    public static void deleteUserAddress(User user, int index) {
        index--;
        if (index >= 0 && index < user.getAddressList().size()) {
            user.getAddressList().remove(index);
        } else {
            System.out.println("Girdiğiniz Adres Numarası Hatalı! Tekrar Deneyin!");
        }
    }
}
