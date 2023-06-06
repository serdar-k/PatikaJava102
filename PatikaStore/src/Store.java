import java.util.*;

public class Store {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Brand> brands = new ArrayList<>();

    Scanner input = new Scanner(System.in);


    public Store() {
        products = new ArrayList<>();
        brands = new ArrayList<>();
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Brand> getBrands() {
        return brands;
    }

    public void setBrands(ArrayList<Brand> brands) {
        this.brands = brands;
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Invalid Product! Try Again!");
        }
        products.add(product);
    }

    public void removeProduct() {
        System.out.print("Select ID For DELETE!:");
        int id = input.nextInt();
        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                System.out.println("Product Deleted!");
            } else {
                System.out.println("There Is No Product With This ID!");
            }
        }
    }

    public void listProducts() {
        System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", "ID", "ÜRÜN ADI", "FİYAT", "MARKA", "DEPOLAMA", "EKRAN", "PİL", "RAM", "RENK", "KATEGORI");
        for (Product p : products) {
            System.out.printf("| %-2d | %-25s | %-15.2f | %-15s | %-15d | %-15.1f | %-15d | %-15d | %-15s | %-15s |%n", p.getId(), p.getName(), p.getPrice(), p.getBrand().getName(), p.getStorageMemory(), p.getScreenSize(), p.getBatteryCapacity(), p.getRandomAccessMemory(), p.getColor(), p.getCategory());
        }
    }

    public void listProducts(int id) {
        System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", "ID", "ÜRÜN ADI", "FİYAT", "MARKA", "DEPOLAMA", "EKRAN", "PİL", "RAM", "RENK", "KATEGORI");
        for (Product p : products) {
            if (p.getId() == id) {
                System.out.printf("| %-2d | %-25s | %-15.2f | %-15s | %-15d | %-15.1f | %-15d | %-15d | %-15s | %-15s |%n", p.getId(), p.getName(), p.getPrice(), p.getBrand().getName(), p.getStorageMemory(), p.getScreenSize(), p.getBatteryCapacity(), p.getRandomAccessMemory(), p.getColor(), p.getCategory());
            }
        }
    }

    public void listProducts(String category) {
        System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", "ID", "ÜRÜN ADI", "FİYAT", "MARKA", "DEPOLAMA", "EKRAN", "PİL", "RAM", "RENK", "KATEGORI");
        for (Product p : products) {
            if (p.getCategory().toLowerCase().equals(category)) {
                System.out.printf("| %-2d | %-25s | %-15.2f | %-15s | %-15d | %-15.1f | %-15d | %-15d | %-15s | %-15s |%n", p.getId(), p.getName(), p.getPrice(), p.getBrand().getName(), p.getStorageMemory(), p.getScreenSize(), p.getBatteryCapacity(), p.getRandomAccessMemory(), p.getColor(), p.getCategory());
            }
        }
    }

    public void filterProducts() {
        System.out.println("Filter According To ID [1] OR Filter According To Category [2]");
        int userSelect = input.nextInt();
        if (userSelect == 1) {
            System.out.println("ID: ");
            int id = input.nextInt();
            for (Product p : products) {
                if (p.getId() == id) {
                    listProducts(id);
                } else {
                    System.out.println("Invalid ID!");
                }
            }
        } else if (userSelect == 2) {
            System.out.println("Category");
            String category = input.next();
            for (Product p : products) {
                if (p.getCategory().toLowerCase().equals(category.toLowerCase())) {
                    listProducts(category);
                }
            }
        }
    }

    public void addBrand(Brand brand) {
        brands.add(brand);
    }

    public void listBrands() {
        Collections.sort(brands, (b1, b2) -> b1.getName().compareTo(b2.getName()));
        System.out.println("---------------------------------");
        System.out.printf("| %-2s | %-25s |%n", "ID", "BRAND");
        System.out.println("---------------------------------");
        for (Brand brand : brands) {
            System.out.printf("| %-2d | %-25s |%n", brand.getId(), brand.getName());
            System.out.println("---------------------------------");
        }
    }
}
