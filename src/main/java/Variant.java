public class Variant extends Character{
    String variantPerk;
    String rarity;

    public Variant(String name, String image, String health, String primaryWeapon, String primaryWeaponDamage, String variantPerk, String rarity){
        super(name,image,health,primaryWeapon,primaryWeaponDamage);
        this.variantPerk = variantPerk;
        this.rarity = rarity;
    }

    public Variant(String names, String descriptions, String strategies) {
        super(names,descriptions,strategies);
    }
}
