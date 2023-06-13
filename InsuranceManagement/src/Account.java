import java.util.ArrayList;

public abstract class Account implements Comparable<Account> {
    private User user;
    private ArrayList<Insurance> insuranceList = new ArrayList<Insurance>();
    private AuthenticationStatus authenticationStatus = AuthenticationStatus.FAIL;


    public Account(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(ArrayList<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    final void showUserInfo() {
        System.out.println();
        System.out.println("##### KULLANICI BİLGİLERİ #####");
        System.out.println("Ad: " + this.getUser().getName());
        System.out.println("Soyad: " + this.getUser().getLastName());
        System.out.println("Yaş: " + this.getUser().getAge());
        System.out.println("Email: " + this.getUser().getEmail());
        System.out.println("Meslek: " + this.getUser().getJob());
        System.out.println("Hesap Tipi: " + this.getUser().getAccountType());
        System.out.println("###############################");
        System.out.println("Sigortalar: ");
        if (getInsuranceList().size() != 0) {
            System.out.printf("----------------------------------------------------------------------------------------------------------%n");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-20s |%n", "SİGORTA NO", "SİGORTA TİPİ", "SİGORTA ÜCRETİ", "BAŞLANGIÇ TARİHİ", "BİTİŞ TARİHİ");
            System.out.printf("----------------------------------------------------------------------------------------------------------%n");
            for (int i = 0; i < insuranceList.size(); i++) {
                System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-20s |%n", i + 1, insuranceList.get(i).getName(), insuranceList.get(i).getPrice(), insuranceList.get(i).getStartingDate(), insuranceList.get(i).getEndingDate());
                System.out.printf("----------------------------------------------------------------------------------------------------------%n");
            }
        } else {
            System.out.println("Kullanıcıya Ait Kayıtlı Sigorta Bilgisi Bulunamadı!");
        }
        System.out.println("###############################");
        System.out.println("Adresler: ");
        if (this.getUser().getAddressList().size() != 0) {
            System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------%n");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "ADRES NO", "ADRES BAŞLIĞI", "SOKAK", "MAHALLE", "İLÇE", "İL", "POSTA KODU");
            System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------%n");
            for (int i = 0; i < this.getUser().getAddressList().size(); i++) {
                System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", i + 1, this.getUser().getAddressList().get(i).getAddressName(), this.getUser().getAddressList().get(i).getStreet(), this.getUser().getAddressList().get(i).getDistrict(), this.getUser().getAddressList().get(i).getProvince(), this.getUser().getAddressList().get(i).getCity(), this.getUser().getAddressList().get(i).getPostalCode());
                System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------%n");
            }
        } else {
            System.out.println("Kullanıcıya Ait Kayıtlı Adres Bilgisi Bulunamadı!");
        }

        System.out.println("###############################");
        System.out.println("Sisteme Son Başarılı Giriş: " + this.getUser().getLastLogin());
        System.out.println("###############################");
        System.out.println();

    }

    public abstract void addInsurance(Insurance insurance);

    public void deleteInsurance(int index) {
        index--;
        if (index >= 0 && index < insuranceList.size()) {
            insuranceList.remove(index);
        } else {
            System.out.println("Girdiğiniz Sigorta Numarası Hatalı! Lütfen Tekrar Deneyin!");
        }
    }

    @Override
    public int compareTo(Account account) {
        return this.getUser().getEmail().compareTo(account.getUser().getEmail());
    }

    @Override
    public int hashCode() {
        return user.getEmail().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof Account)) {
            return false;
        } else {
            Account account = (Account) object;
            return this.getUser().getEmail().equals(account.getUser().getEmail());
        }
    }

}
