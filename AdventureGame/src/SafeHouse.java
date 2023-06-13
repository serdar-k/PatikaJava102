public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player, int id){
        super(player, id, "Safe House", true);
    }

    @Override
    public boolean onLocation(){
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        if(this.getPlayer().getInventory().getFood() == 1 && this.getPlayer().getInventory().getFirewood() == 1 && this.getPlayer().getInventory().getWater() == 1){
            return true;
        }
        System.out.printf("--------------------------------%n");
        System.out.println("| +++ You are in Safehouse +++ |");
        System.out.printf("--------------------------------%n");

        return false;
    }
}
