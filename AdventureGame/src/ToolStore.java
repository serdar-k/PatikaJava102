public class ToolStore extends NormalLocation {
    public ToolStore(Player player, int id) {
        super(player, id, "Tool Store", true);
    }

    public boolean onLocation() {
        System.out.printf("-------------------------------------%n");
        System.out.println("|       You Are In Tool Store!      |");
        System.out.println("|Weapons.........................[1]|");
        System.out.println("|Armors..........................[2]|");
        System.out.println("|Exit............................[3]|");
        System.out.printf("-------------------------------------%n");
        System.out.print("Your Select: ");
        int userToolSelect = Location.input.nextInt();
        while (userToolSelect < 1 || userToolSelect > 3) {
            System.out.print("Try Again: ");
            userToolSelect = input.nextInt();
        }
        switch (userToolSelect) {
            case 1:
                printWeapons();
                buyWeapon();
                break;
            case 2:
                printArmors();
                buyArmor();
                break;
            case 3:

                break;
        }
        return true;
    }

    public void printWeapons() {
        System.out.printf("---------------------------------%n");
        System.out.println("|            Weapons            |");
        System.out.printf("---------------------------------%n");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |%n", "ID", "NAME", "COST", "DAMAGE");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.printf("-----------------------------------------------------%n");
            System.out.printf("| %-10d | %-10s | %-10s | %-10d |%n", weapon.getId(), weapon.getName(), "$" + weapon.getPrice(), weapon.getDamage());
        }
        System.out.printf("-----------------------------------------------------%n");
    }

    public void buyWeapon() {
        System.out.println("Choose Your Weapon");
        int userWeaponSelect = input.nextInt();
        while (userWeaponSelect < 1 || userWeaponSelect > Weapon.weapons().length) {
            System.out.print("Try Again: ");
            userWeaponSelect = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponById(userWeaponSelect);
        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.printf("-----------------------------------------------------%n");
                System.out.println("Not Enough Money!");
                System.out.printf("-----------------------------------------------------%n");
            } else {
                System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++++%n");
                System.out.println("+" + selectedWeapon.getName() + " Has Been Purchased!+");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("+Your New Balance: " + this.getPlayer().getMoney() + "+");
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++++%n");
            }
        }
    }


    public void printArmors() {
        System.out.printf("---------------------------------%n");
        System.out.println("|             Armors            |");
        System.out.printf("---------------------------------%n");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |%n", "ID", "NAME", "COST", "BLOCK");
        for (Armor armor : Armor.armors()) {
            System.out.printf("-----------------------------------------------------%n");
            System.out.printf("| %-10d | %-10s | %-10s | %-10d |%n", armor.getId(), armor.getName(), "$" + armor.getCost(), armor.getBlock());
        }
        System.out.printf("-----------------------------------------------------%n");
    }

    public void buyArmor() {
        System.out.println("Choose Your Armor");
        int userArmorSelect = input.nextInt();
        while (userArmorSelect < 0 || userArmorSelect > Armor.armors().length) {
            System.out.print("Try Again: ");
            userArmorSelect = input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorById(userArmorSelect);
        if (selectedArmor != null) {
            if (selectedArmor.getCost() > this.getPlayer().getMoney()) {
                System.out.printf("-----------------------------------------------------%n");
                System.out.println("Not Enough Money!");
                System.out.printf("-----------------------------------------------------%n");
            } else {
                System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++++%n");
                System.out.println("+" + selectedArmor.getName() + " Has Been Purchased!+");
                int balance = this.getPlayer().getMoney() - selectedArmor.getCost();
                this.getPlayer().setMoney(balance);
                System.out.println("+Your New Balance: " + this.getPlayer().getMoney() + "+");
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++++%n");

            }
        }
    }
}
