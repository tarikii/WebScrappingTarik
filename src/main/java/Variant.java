import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Variant")
public class Variant {
    String name;
    String image;
    String health;
    String primaryWeapon;
    String primaryWeaponDamage;
    String variantPerk;
    String rarity;

    String names;
    String descriptions;
    String strategies;

    public Variant(String name, String image, String health, String primaryWeapon, String primaryWeaponDamage, String variantPerk, String rarity){
        this.name = name;
        this.image = image;
        this.health = health;
        this.primaryWeapon = primaryWeapon;
        this.primaryWeaponDamage = primaryWeaponDamage;
        this.variantPerk = variantPerk;
        this.rarity = rarity;
    }

    public Variant(String names, String descriptions, String strategies) {
        this.names = names;
        this.descriptions = descriptions;
        this.strategies = strategies;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name="Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    @XmlElement(name="ImageURL")
    public void setImage(String image) {
        this.image = image;
    }

    public String getHealth() {
        return health;
    }

    @XmlElement(name="Health")
    public void setHealth(String health) {
        this.health = health;
    }

    public String getPrimaryWeapon() {
        return primaryWeapon;
    }

    @XmlElement(name="PrimaryWeapon")
    public void setPrimaryWeapon(String primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }

    public String getPrimaryWeaponDamage() {
        return primaryWeaponDamage;
    }

    @XmlElement(name="WeaponDamage")
    public void setPrimaryWeaponDamage(String primaryWeaponDamage) {
        this.primaryWeaponDamage = primaryWeaponDamage;
    }

    public String getVariantPerk() {
        return variantPerk;
    }

    @XmlElement(name="Perk")
    public void setVariantPerk(String variantPerk) {
        this.variantPerk = variantPerk;
    }

    public String getRarity() {
        return rarity;
    }

    @XmlElement(name="Rarity")
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getNames() {
        return names;
    }


    public void setNames(String names) {
        this.names = names;
    }

    public String getDescriptions() {
        return descriptions;
    }

    @XmlElement(name="Description")
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getStrategies() {
        return strategies;
    }

    @XmlElement(name="Strategy")
    public void setStrategies(String strategies) {
        this.strategies = strategies;
    }
}
