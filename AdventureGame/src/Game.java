import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;
    Scanner input = new Scanner(System.in);

    public void start() {
        Player player = new Player();
        player.selectChar();
        boolean isGameOn = true;
        Location loc = null; // ÇÜNKÜ LOCATION ABSTRACT BİR SINIF
        while (isGameOn) {
            player.printPlayerInfo();
            Location[] locations = {new SafeHouse(player, 1), new ToolStore(player, 2), new Cave(player), new Forest(player), new River(player), new Mine(player)};
            System.out.println("Select Location:");
            System.out.printf("---------------------------%n");
            System.out.printf("| %-5s | %-15s |%n", "ID", "NAME");
            for (Location location : locations) {
                System.out.printf("---------------------------%n");
                System.out.printf("| %-5d | %-15s |%n", location.getId(), location.getName());
            }
            System.out.printf("---------------------------%n");
            System.out.println("| 0     | Quit Game       |");
            System.out.printf("---------------------------%n");

            int userLocSelect = input.nextInt();
            switch (userLocSelect) {
                case 0:
                    loc = null;
                    isGameOn = false;
                    break;
                case 1:
                    loc = new SafeHouse(player, userLocSelect);
//                    isGameOn = isPlayerWin(loc);
                    break;
                case 2:
                    loc = new ToolStore(player, userLocSelect);
                    break;
                case 3:
                    if (player.getInventory().getFood() == 1) {
                        System.out.printf("----------------------------------------------------------%n");
                        System.out.println("| This Location Cleaned Before! Choose Another Location! |");
                        System.out.printf("----------------------------------------------------------%n");
                        loc = new SafeHouse(player, userLocSelect);
                        break;
                    } else {
                        loc = new Cave(player);
                        break;
                    }
                case 4:
                    if (player.getInventory().getFirewood() == 1) {
                        System.out.printf("----------------------------------------------------------%n");
                        System.out.println("| This Location Cleaned Before! Choose Another Location! |");
                        System.out.printf("----------------------------------------------------------%n");
                        loc = new SafeHouse(player, userLocSelect);
                        break;
                    } else {
                        loc = new Forest(player);
                        break;
                    }
                case 5:
                    if (player.getInventory().getWater() == 1) {
                        System.out.printf("----------------------------------------------------------%n");
                        System.out.println("| This Location Cleaned Before! Choose Another Location! |");
                        System.out.printf("----------------------------------------------------------%n");
                        loc = new SafeHouse(player, userLocSelect);
                        break;
                    } else {
                        loc = new River(player);
                        break;
                    }
                case 6:
                    loc = new Mine(player);
                    break;
                default:
                    loc = new SafeHouse(player, userLocSelect);
                    break;
            }

            if (loc.onLocation()) {
                if (loc.getName().equals("Safe House")) {
                    System.out.printf("|===========================|%n");
                    System.out.println("| *** You Win The Game! *** |");
                    System.out.printf("|===========================|%n");
                    break;
                }
            } else {
                if (loc.getName().equals("Safe House")) {
                    continue;
                } else {
                    isGameOn = false;
                }
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
