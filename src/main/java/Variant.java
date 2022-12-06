public class Variant extends Character{
    String variantPerk;
    String rarity;

    public Variant(String name, String health, String primaryWeapon, String primaryWeaponDamage, String variantPerk, String rarity){
        super(name,health,primaryWeapon,primaryWeaponDamage);
        this.variantPerk = variantPerk;
        this.rarity = rarity;
    }
}
