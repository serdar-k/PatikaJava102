import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, int id, Obstacle obstacle, String award, int maxObstacle, boolean isClean) {
        super(player, name, id, isClean);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int numberOfObstacle = this.randomObstacleNumber();
        System.out.printf("----------------------------------------------------%n");
        System.out.println("| You are Here Now: " + this.getName() + "                           ");
        System.out.println("| Be Careful! There are" + " " + numberOfObstacle + " " + this.getObstacle().getName() + " Live Around!");
        System.out.println("| <F>ight or <R>un?:                               ");
        System.out.printf("----------------------------------------------------%n");

        String selectAction = input.nextLine();
        selectAction = selectAction.toUpperCase();
        if (selectAction.equals("F")) {
            if (combat(numberOfObstacle)) {
                System.out.printf("|***********************************************|%n");
                System.out.println("| You Are Defeated All Enemies in The " + this.getName() + "!     |");
                System.out.printf("|***********************************************|%n");
                if (this.getName() == "Cave") {
                    this.getPlayer().getInventory().setFood(1);
                    this.setClean(true);
                } else if (this.getName() == "Forest") {
                    this.getPlayer().getInventory().setFirewood(1);
                    this.setClean(true);
                } else if (this.getName() == "River") {
                    this.getPlayer().getInventory().setWater(1);
                    this.setClean(true);
                } else if (this.getName() == "Mine") {
                    Random random = new Random();
                    int randomNumber = random.nextInt(101);
                    if (randomNumber > 0 && randomNumber <= 15) {
                        int randomWeapon = random.nextInt(101);
                        if (randomWeapon > 0 && randomWeapon <= 20) {
                            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(3));
                            System.out.printf("++++++++++++++++++++++%n");
                            System.out.println("+ You Got The Rifle! +");
                            System.out.printf("++++++++++++++++++++++%n");

                        }
                        if (randomWeapon > 20 && randomWeapon <= 50) {
                            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(2));
                            System.out.printf("++++++++++++++++++++++%n");
                            System.out.println("+ You Got The Sword! +");
                            System.out.printf("++++++++++++++++++++++%n");
                        }
                        if (randomWeapon > 50 && randomWeapon <= 100) {
                            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(1));
                            System.out.printf("+++++++++++++++++++++++%n");
                            System.out.println("+ You Got The Pistol! +");
                            System.out.printf("+++++++++++++++++++++++%n");

                        }
                    }
                    if (randomNumber > 15 && randomNumber <= 30) {
                        int randomArmor = random.nextInt(101);
                        if (randomArmor > 0 && randomArmor <= 20) {
                            this.getPlayer().getInventory().setArmor(Armor.getArmorById(3));
                            System.out.printf("++++++++++++++++++++++++++++%n");
                            System.out.println("+ You Got The Heavy Armor! +");
                            System.out.printf("++++++++++++++++++++++++++++%n");
                        }
                        if (randomArmor > 20 && randomArmor <= 50) {
                            this.getPlayer().getInventory().setArmor(Armor.getArmorById(2));
                            System.out.printf("+++++++++++++++++++++++++++++%n");
                            System.out.println("+ You Got The Medium Armor! +");
                            System.out.printf("+++++++++++++++++++++++++++++%n");
                        }
                        if (randomArmor > 50 && randomArmor <= 100) {
                            this.getPlayer().getInventory().setArmor(Armor.getArmorById(1));
                            System.out.printf("++++++++++++++++++++++++++++%n");
                            System.out.println("+ You Got The Light Armor! +");
                            System.out.printf("++++++++++++++++++++++++++++%n");

                        }
                    }
                    if (randomNumber > 30 && randomNumber <= 55) {
                        int randomMoney = random.nextInt(101);
                        if (randomMoney > 0 && randomMoney <= 20) {
                            this.getPlayer().setMoney(10);
                            System.out.printf("++++++++++++++++%n");
                            System.out.println("+ You Got $10! +");
                            System.out.printf("++++++++++++++++%n");
                        }
                        if (randomMoney > 20 && randomMoney <= 50) {
                            this.getPlayer().setMoney(5);
                            System.out.printf("+++++++++++++++%n");
                            System.out.println("+ You Got $5! +");
                            System.out.printf("+++++++++++++++%n");

                        }
                        if (randomMoney > 50 && randomMoney <= 100) {
                            this.getPlayer().setMoney(1);
                            System.out.printf("+++++++++++++++%n");
                            System.out.println("+ You Got $1! +");
                            System.out.printf("+++++++++++++++%n");

                        }
                    }
                }
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.printf("|------------------------------|%n");
            System.out.println("|   !!! You are Defeated !!!   |");
            System.out.printf("|------------------------------|%n");
            return false;
        }
        return true;
    }

    public void afterHit() {
        if (this.getPlayer().getHealth() >= 0) {
            System.out.println();
            System.out.printf("<<<<<<<<<<<<<<<<->>>>>>>>>>>>>>>>%n");
            System.out.println("|Your Health: " + this.getPlayer().getHealth());
        } else {
            System.out.printf("<<<<<<<<<<<<<<<<->>>>>>>>>>>>>>>>%n");
            System.out.println("|You are Killed!");
        }

        if (this.getObstacle().getHealth() >= 0) {
            System.out.println("|Obstacle Health: " + this.getObstacle().getHealth());
            System.out.printf("<<<<<<<<<<<<<<<<->>>>>>>>>>>>>>>>%n");
        } else {
            System.out.println("|Enemy is Killed!");
            System.out.printf("<<<<<<<<<<<<<<<<->>>>>>>>>>>>>>>>%n");
        }

    }

    public boolean combat(int numberOfObstacle) {
        for (int i = 0; i < numberOfObstacle; i++) {
            Random randomDamage = new Random();
            int randomObstacleDamage = randomDamage.nextInt(3, 7);
            if (this.getObstacle().getName() == "Snake") {
                this.getObstacle().setDamage(randomObstacleDamage);
            }
            this.getObstacle().setHealth(this.getObstacle().getDefaultHealth());
            playerStats();
            obstacleStats(i + 1);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.printf("---------------------------------%n");
                System.out.println("|        <F>ight or <R>un       |");
                System.out.printf("---------------------------------%n");
                String selectAction = input.nextLine().toUpperCase();
                if (selectAction.equals("F")) {
                    if (this.getPlayer().getHealth() > 0 || this.getObstacle().getHealth() > 0) {
                        Random random = new Random();
                        double randomNumber = random.nextDouble(1);

                        if (randomNumber >= 0 && randomNumber < 0.5) {
                            System.out.printf("|-------------------------------|%n");
                            System.out.println("| *** Player Hit The Enemy! *** |");
                            System.out.printf("|-------------------------------|%n");
                            System.out.println();
                            obstacle.setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        } else {
                            System.out.printf("--------------------------------%n");
                            System.out.println("| !!! Enemy Hit The Player !!! |");
                            System.out.printf("--------------------------------%n");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) obstacleDamage = 0;
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    }
                } else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.printf("--------------------------------%n");
                System.out.println("|You Defeat The Enemy!          ");
                System.out.println("|$" + this.getObstacle().getAward() + " is Your Reward!           ");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("|Your Current Money: " + this.getPlayer().getMoney() + "        ");
                System.out.printf("--------------------------------%n");

            } else {
                return false;
            }
        }
        return true;
    }

    public void playerStats() {
        System.out.printf("--------------%n");
        System.out.println("|Player Stats|");
        System.out.printf("|--------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-10s | %-10s |%n", "HEALTH", "WEAPON", "ARMOR", "BLOCK", "DAMAGE", "MONEY");
        System.out.printf("|--------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-10d | %-15s | %-15s | %-15s | %-10d | %-10d |%n", this.getPlayer().getHealth(), this.getPlayer().getInventory().getWeapon().getName(), this.getPlayer().getInventory().getArmor().getName(), this.getPlayer().getInventory().getArmor().getName(), this.getPlayer().getTotalDamage(), this.getPlayer().getMoney());
        System.out.printf("----------------------------------------------------------------------------------------------%n");
        System.out.println();
    }

    public void obstacleStats(int obstacleNumber) {
        System.out.printf("-----------------%n");
        System.out.println("|" + obstacleNumber + ". " + this.getObstacle().getName() + " Stats|");
        System.out.printf("|-------------------------------------------%n");
        System.out.printf("| %-10s | %-10s | %-15s |%n", "HEALTH", "DAMAGE", "AWARD");
        System.out.printf("|-------------------------------------------%n");
        System.out.printf("| %-10d | %-10d | %-15s |%n", this.getObstacle().getHealth(), this.getObstacle().getDamage(), "$" + this.getObstacle().getAward());
        System.out.printf("---------------------------------------------%n");
    }

    public int randomObstacleNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }
}
