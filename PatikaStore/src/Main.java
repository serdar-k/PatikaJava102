import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Store store = new Store();
        String[] brands = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        for (int i = 0; i < brands.length; i++) {
            Brand b = new Brand(i + 1, brands[i]);
            store.addBrand(b);
        }


        int choice = -1;
        while (choice != 0) {
            System.out.println("Patika Store Management");
            System.out.println("Select Your Process\nAdd Notebook [1]\nAdd Cellphone [2]\nList Products[3]\nDelete Product[4]\nSee The Brands[5]");
            int userSelect = input.nextInt();
            switch (userSelect) {
                case 1:
                case 2:
                    System.out.print("ID: ");
                    int id = input.nextInt();
                    System.out.print("Name: ");
                    String name = input.next();

                    System.out.println("Samsung[1] Lenovo[2] Apple[3] Huawei[4] Casper[5] Asus[6] HP[7] Xiaomi[8] Monster[9]");
                    int brandSelect = input.nextInt();
                    Brand brand = store.getBrands().get(brandSelect - 1);

                    System.out.print("Price: ");
                    double price = input.nextDouble();
                    System.out.print("Discount: ");
                    int discount = input.nextInt();
                    System.out.print("Stock Amount: ");
                    int stockAmount = input.nextInt();
                    System.out.print("Storage Memory: ");
                    int storageMemory = input.nextInt();
                    System.out.print("Screen Size: ");
                    double screenSize = input.nextDouble();
                    System.out.print("RAM: ");
                    int randomAccessMemory = input.nextInt();
                    System.out.print("Battery Capacity: ");
                    int batteryCapacity = input.nextInt();
                    System.out.print("Color: ");
                    String color = input.next();
                    System.out.print("Category: ");
                    String category = input.next();

                    Notebook notebook = new Notebook(id, name, brand, price, discount, stockAmount, storageMemory, screenSize, randomAccessMemory, batteryCapacity, color, category);
                    store.addProduct(notebook);
                    break;
                case 3:
                    store.filterProducts();
                    break;
                case 4:
                    store.removeProduct();
                case 5:
                    store.listBrands();
            }
        }

    }
}