public class Product {
    private int id;
    private String name;
    private Brand brand;
    private double price;
    private int discount;
    private int stockAmount;
    private int storageMemory;
    private double screenSize;
    private int randomAccessMemory;
    private int batteryCapacity;
    private String color;

    private String category;

    public Product(int id, String name, Brand brand, double price, int discount, int stockAmount, int storageMemory, double screenSize, int randomAccessMemory, int batteryCapacity, String color, String category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.discount = discount;
        this.stockAmount = stockAmount;
        this.storageMemory = storageMemory;
        this.screenSize = screenSize;
        this.randomAccessMemory = randomAccessMemory;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public int getStorageMemory() {
        return storageMemory;
    }

    public void setStorageMemory(int storageMemory) {
        this.storageMemory = storageMemory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public void setRandomAccessMemory(int randomAccessMemory) {
        this.randomAccessMemory = randomAccessMemory;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
