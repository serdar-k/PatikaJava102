public abstract class NormalLocation extends Location{

    public NormalLocation(Player player, int id, String name, boolean isClean) {
        super(player, name, id, isClean);
    }

    @Override
    public boolean onLocation() {
        return false;
    }
}
