import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int money;
    private int defaultHealth;
    private Inventory inventory;

    Scanner input = new Scanner(System.in);

    public Player() {
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getTotalDamage(){
        return this.damage  + this.getInventory().getWeapon().getDamage();
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public void selectChar() {
        GameChar[] gameChars = {new Samurai(), new Archer(), new Knight()};

        System.out.println("Choose Your Character!");
        System.out.printf("---------------------------------------------------------------------------------%n");
        System.out.printf("| %-5s | %-15s | %-15s | %-15s | %-15s |%n", "ID", "NAME", "DAMAGE", "HEALTH", "MONEY");
        for (GameChar character : gameChars) {
            System.out.printf("---------------------------------------------------------------------------------%n");
            System.out.printf("| %-5d | %-15s | %-15d | %-15d | %-15d |%n", character.getId(), character.getName(), character.getDamage(), character.getHealth(), character.getMoney());
        }
        System.out.printf("---------------------------------------------------------------------------------%n");
        int userCharSelect = input.nextInt();
        switch (userCharSelect) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
    }

    public void initPlayer(GameChar character) {
        this.id = character.getId();
        this.name = character.getName();
        this.damage = character.getDamage();
        this.health = character.getHealth();
        this.money = character.getMoney();
        this.defaultHealth = character.getDefaultHealth();
        System.out.println("Player Created!");
    }

    public void printPlayerInfo() {
        System.out.println();
        System.out.printf("------------------------------------------------------------------%n");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |%n", "WEAPON", "DAMAGE", "HEALTH", "MONEY", "ARMOR");
        System.out.printf("------------------------------------------------------------------%n");
        System.out.printf("| %-10s | %-10d | %-10d | %-10s | %-10s |%n", this.getInventory().getWeapon().getName(), this.getDamage(), this.getHealth(),"$" + this.getMoney(), this.getInventory().getArmor().getName());
        System.out.printf("------------------------------------------------------------------%n");
        System.out.println();
    }
}
