public class Armor {
    private int id;
    private String name;
    private int block;
    private int cost;

    public Armor(int id, String name, int block, int cost){
        this.id = id;
        this.name = name;
        this.block = block;
        this.cost = cost;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static Armor[] armors(){
        Armor[] armors = {new Armor(1, "Light", 1, 15), new Armor(2, "Medium", 3, 25), new Armor(3, "Heavy", 5, 40)};
        return armors;
    }

    public static Armor getArmorById(int id){
        for (Armor armor : Armor.armors()){
            if(armor.getId() == id){
                return armor;
            }
        }
        return null;
    }
}
