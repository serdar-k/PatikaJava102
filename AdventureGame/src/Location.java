import java.util.Scanner;

public abstract class Location {
    private Player player;
    private int id;
    private String name;
    private boolean isClean;
    public static Scanner input = new Scanner(System.in);
    public Location(Player player, String name, int id, boolean isClean){
        this.player = player;
        this.id = id;
        this.name = name;
        this.isClean = isClean;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public abstract boolean onLocation();

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }
}
