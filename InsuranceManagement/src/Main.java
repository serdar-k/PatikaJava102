
public class Main {
    public static void main(String[] args) {
        try {
            AccountManager accountManager = new AccountManager();
            accountManager.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}