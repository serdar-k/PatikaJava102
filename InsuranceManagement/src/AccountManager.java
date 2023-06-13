import java.time.LocalDate;
import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {
    private Account account;
    private TreeSet<Account> accountList = new TreeSet<Account>();
    Scanner input = new Scanner(System.in);

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TreeSet<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(TreeSet<Account> accountList) {
        this.accountList = accountList;
    }

    public void run() {
        int selection = -1;
        while (selection != 0) {
            showMenu();
            int userSelect = input.nextInt();
            switch (userSelect) {
                case 1:
                    System.out.println("Bireysel Hesap....................[1]");
                    System.out.println("Kurumsal Hesap....................[2]");
                    int userAccountSelect = input.nextInt();
                    input.nextLine();
                    System.out.print("Ad: ");
                    String name = input.nextLine();
                    System.out.print("Soyad: ");
                    String lastName = input.nextLine();
                    System.out.print("Email: ");
                    String email = input.nextLine();
                    System.out.print("Şifre: ");
                    String password = input.nextLine();
                    System.out.print("Meslek: ");
                    String job = input.nextLine();
                    System.out.print("Yaş: ");
                    int age = input.nextInt();

                    switch (userAccountSelect) {
                        case 1:
                            String individualAccountType = "Bireysel";
                            User userIndividual = new User(name, lastName, email, password, job, age, individualAccountType, null);
                            Account individualAccount = new IndividualAccount(userIndividual);
                            accountList.add(individualAccount);
                            System.out.println("Bireysel Hesap Oluşturuldu!");
                            break;
                        case 2:
                            String enterpriseAccountType = "Kurumsal";
                            input.nextLine();
                            System.out.print("Şirket Adı: ");
                            String companyName = input.nextLine();
                            User userEnterprise = new User(name, lastName, email, password, job, age, enterpriseAccountType, companyName);
                            Account enterpriseAccount = new EnterpriseAccount(userEnterprise);
                            accountList.add(enterpriseAccount);
                            System.out.println("Kurumsal Hesap Oluşturuldu!");
                            break;

                    }
                    break;
                case 2:
                    System.out.println("Giriş Bilgileriniz");
                    input.nextLine();
                    System.out.print("Email: ");
                    String loginEmail = input.nextLine();
                    System.out.print("Şifre: ");
                    String loginPassword = input.nextLine();
                    User user = null;
                    Account account = null;
                    for (Account a : accountList) {
                        if (a.getUser().getEmail().equals(loginEmail)) {
                            user = a.getUser();
                            account = a;
                            user.setLastLogin(LocalDate.now());
                        }
                    }
                    try {
                        if (login(loginEmail, loginPassword)) {
                            int userLoginSelect = -1;
                            while (userLoginSelect != 0) {
                                showUserMenu();
                                userLoginSelect = input.nextInt();
                                switch (userLoginSelect) {
                                    case 1:
                                        input.nextLine();
                                        System.out.print("Adres İsmi: ");
                                        String addressName = input.nextLine();
                                        System.out.print("Sokak: ");
                                        String street = input.nextLine();
                                        System.out.print("Mahalle: ");
                                        String district = input.nextLine();
                                        System.out.print("İlçe: ");
                                        String province = input.nextLine();
                                        System.out.print("Şehir: ");
                                        String city = input.nextLine();
                                        System.out.print("Posta Kodu: ");
                                        int postalCode = input.nextInt();
                                        if (user.getAccountType().equalsIgnoreCase("Kurumsal")) {
                                            String companyName = user.getCompanyName();
                                            EnterpriseAddress enterpriseAddress = new EnterpriseAddress(addressName, street, district, province, city, postalCode, companyName);
                                            AddressManager.addUserAddress(user, enterpriseAddress);
                                            System.out.println("Kurumsal Adres Eklendi!");
                                            break;
                                        }
                                        HomeAddress address = new HomeAddress(addressName, street, district, province, city, postalCode);
                                        AddressManager.addUserAddress(user, address);
                                        System.out.println("Bireysel Adres Eklendi!");
                                        break;
                                    case 2:
                                        input.nextLine();
                                        System.out.println("Güncellemek İstediğiniz Adres Numarasını Giriniz: ");
                                        int indexNew = input.nextInt();
                                        System.out.println("Adres İsmi: ");
                                        String addressNameNew = input.nextLine();
                                        System.out.print("Sokak: ");
                                        String streetNew = input.nextLine();
                                        System.out.print("Mahalle: ");
                                        String districtNew = input.nextLine();
                                        System.out.print("İlçe: ");
                                        String provinceNew = input.nextLine();
                                        System.out.print("Şehir: ");
                                        String cityNew = input.nextLine();
                                        System.out.print("Posta Kodu: ");
                                        int postalCodeNew = input.nextInt();
                                        AddressManager.editAddress(user, indexNew, addressNameNew, streetNew, districtNew, provinceNew, cityNew, postalCodeNew);
                                        break;

                                    case 3:
                                        input.nextLine();
                                        System.out.print("Silmek İstediğiniz Adres Numarasını Girin: ");
                                        int removeAddressIndex = input.nextInt();
                                        AddressManager.deleteUserAddress(user, removeAddressIndex);
                                        break;
                                    case 4:
                                        showInsuranceMenu();
                                        int userInsuranceSelect = input.nextInt();
                                        if (userInsuranceSelect == 0) {
                                            break;
                                        }
                                        System.out.print("Başlangıç Ayı(1-12): ");
                                        int startingMonth = input.nextInt();
                                        if (startingMonth > 12 || startingMonth < 1) {
                                            System.out.println("Ay Bilgisi 1-12 Arasında Olmalıdır! Lütfen Tekrar Deneyin!");
                                            break;
                                        }
                                        System.out.print("Başlangıç Günü(1-31): ");
                                        int startingDay = input.nextInt();
                                        if (startingDay > 31 || startingDay < 1) {
                                            System.out.println("Gün Bilgisi 1-12 Arasında Olmalıdır! Lütfen Tekrar Deneyin!");
                                            break;
                                        }
                                        System.out.print("Başlangıç Yılı: ");
                                        int startingYear = input.nextInt();
                                        System.out.print("Bitiş Ayı(1-12): ");
                                        int endingMonth = input.nextInt();
                                        System.out.print("Bitiş Günü(1-31): ");
                                        int endingDay = input.nextInt();
                                        System.out.print("Bitiş Yılı: ");
                                        int endingYear = input.nextInt();
                                        LocalDate localDateStart = null;
                                        LocalDate localDateEnd = null;
                                        try {
                                            localDateStart = LocalDate.of(startingYear, startingMonth, startingDay);
                                            localDateEnd = LocalDate.of(endingYear, endingMonth, endingDay);
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                            break;
                                        }
                                        switch (userInsuranceSelect) {
                                            case 1:
                                                int insuranceAge = user.getAge();
                                                input.nextLine();
                                                System.out.print("Cinsiyet: ");
                                                String gender = input.nextLine();
                                                Insurance healthInsurance = new HealthInsurance("Sağlık Sigortasi", insuranceAge, gender, localDateStart, localDateEnd);
                                                account.addInsurance(healthInsurance);
                                                System.out.println("Yeni Sağlık Sigortası Eklendi!");
                                                break;
                                            case 2:
                                                input.nextLine();
                                                System.out.print("Aracın Model Yılı: ");
                                                int carModelYear = input.nextInt();
                                                System.out.print("Aracın Motor Hacmi: ");
                                                int carHorsePower = input.nextInt();

                                                Insurance carInsurance = new CarInsurance("Araç Sigortası", carModelYear, carHorsePower, localDateStart, localDateEnd);
                                                account.addInsurance(carInsurance);
                                                System.out.println("Yeni Araç Sigortası Eklendi!");
                                                break;
                                            case 3:
                                                input.nextLine();
                                                System.out.print("Gidilecek Ülke: ");
                                                String travelTo = input.nextLine();
                                                if (travelTo.equalsIgnoreCase("Amerika") || travelTo.equalsIgnoreCase("Almanya") || travelTo.equalsIgnoreCase("Fransa")) {
                                                    travelTo = "A";
                                                } else if (travelTo.equalsIgnoreCase("Ukrayna") || travelTo.equalsIgnoreCase("Rusya") || travelTo.equalsIgnoreCase("Meksika")) {
                                                    travelTo = "B";
                                                } else if (travelTo.equalsIgnoreCase("İsrail") || travelTo.equalsIgnoreCase("Japonya") || travelTo.equalsIgnoreCase("Avustralya")) {
                                                    travelTo = "C";
                                                } else {
                                                    System.out.println("Listede Olmayan Bir Ülke Girdiniz! Lütfen Sigorta Kapsamında Bulunan Bir Ülke Adı Girin!");
                                                }
                                                System.out.print("Seyahat Süresi(Gün Sayısı): ");
                                                int timeOfJourney = input.nextInt();
                                                Insurance travelInsurance = new TravelInsurance("Seyahat Sigortası", timeOfJourney, travelTo, localDateStart, localDateEnd);
                                                account.addInsurance(travelInsurance);
                                                System.out.println("Yeni Seyahat Sigortası Eklendi!");
                                                break;
                                            case 4:
                                                input.nextLine();
                                                System.out.print("Evinizin Oturum Alanı(m^2): ");
                                                int squareMetersOfTheHouse = input.nextInt();
                                                Insurance residenceInsurance = new ResidenceInsurance("Konut Sigortası", squareMetersOfTheHouse, localDateStart, localDateEnd);
                                                account.addInsurance(residenceInsurance);
                                                System.out.println("Yeni Konut Sigortası Eklendi!");
                                                break;
                                        }
                                        break;
                                    case 5:
                                        input.nextLine();
                                        System.out.print("Silmek İstediğiniz Sigorta Numarasını Girin: ");
                                        int removeInsuranceIndex = input.nextInt();
                                        AddressManager.deleteUserAddress(user, removeInsuranceIndex);
                                        account.deleteInsurance(removeInsuranceIndex);
                                        break;
                                    case 6:
                                        account.showUserInfo();
                                        System.out.println("Bir Önceki Menü...................[0]");
                                        input.nextLine();
                                        userSelect = input.nextInt();
                                        switch (userSelect) {
                                            case 0:
                                                break;
                                        }
                                        break;
                                    case 0:
                                        userLoginSelect = 0;
                                        break;
                                }
                            }
                        }
                    } catch (InvalidAuthenticationException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    listUsers();
                    System.out.println("Bir Önceki Menü...................[0]");
                    input.nextLine();
                    int goBack = input.nextInt();
                    if (goBack == 0) {
                        break;
                    }
                    break;
                case 0:
                    selection = 0;
                    break;
            }
        }
    }

    public void showMenu() {
        System.out.println();
        System.out.println("###### SİGORTA YÖNETİM SİSTEMİ ######");
        System.out.println("----------- İşlem Seçiniz -----------");
        System.out.println("Kullanıcı Oluştur.................[1]");
        System.out.println("Giriş Yap.........................[2]");
        System.out.println("Kullanıcıları Listele.............[3]");
        System.out.println("Çıkış.............................[0]");
        System.out.println("#####################################");
        System.out.println();
    }

    public void showUserMenu() {
        System.out.println();
        System.out.println("############ HOŞGELDİNİZ ############");
        System.out.println("Adres Ekle........................[1]");
        System.out.println("Adres Güncelle....................[2]");
        System.out.println("Adres Sil.........................[3]");
        System.out.println("Sigorta Ekle......................[4]");
        System.out.println("Sigorta İptali....................[5]");
        System.out.println("Kullanıcı Bilgilerini Getir.......[6]");
        System.out.println("Çıkış.............................[0]");
        System.out.println("#####################################");
        System.out.println();
    }

    public void showInsuranceMenu() {
        System.out.println();
        System.out.println("########## SİGORTA MENÜSÜ ##########");
        System.out.println("Sağlık Sigortası.................[1]");
        System.out.println("Araç Sigortası...................[2]");
        System.out.println("Seyahat Sigortası................[3]");
        System.out.println("Konut Sigortası..................[4]");
        System.out.println("Çıkış............................[0]");
        System.out.println("####################################");
        System.out.println();
    }

    public void listUsers() {
        if (accountList.size() > 0) {
            System.out.printf("| %-15s | %-15s | %-20s | %-10s | %-15s |%n", "AD", "SOYAD", "EMAIL", "YAŞ", "MESLEK");
            for (Account account : accountList) {
                System.out.printf("| %-15s | %-15s | %-20s | %-10d | %-15s |%n", account.getUser().getName(), account.getUser().getLastName(), account.getUser().getEmail(), account.getUser().getAge(), account.getUser().getJob());
            }
        } else {
            System.out.println("Kayıtlı Kullanıcı Bulunamadı!");
        }
    }

    public boolean login(String email, String password) throws InvalidAuthenticationException {
        if (accountList.isEmpty()) {
            throw new InvalidAuthenticationException("Kullanıcı Bulunamadı! Lütfen Yeni Kullanıcı Kaydı Oluşturun!");
        }
        for (Account account : accountList) {
            if (account.getUser().getEmail().equals(email) && account.getUser().getPassword().equals(password)) {
                System.out.println("Giriş İşlemi Başarılı!");
                account.setAuthenticationStatus(AuthenticationStatus.SUCCESS);
                return true;
            } else if (!(account.getUser().getEmail().equals(email)) || !(account.getUser().getPassword().equals(password))) {
                account.setAuthenticationStatus(AuthenticationStatus.FAIL);
                throw new InvalidAuthenticationException("Kullanıcı Adı ya da Şifre Hatalı!");
            }
        }
        return false;
    }

}
