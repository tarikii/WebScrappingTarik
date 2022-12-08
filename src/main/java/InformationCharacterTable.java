import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CHARACTER")
public class InformationCharacterTable {
    String name;
    String image;
    String health;
    String variants;
    String primaryWeapon;
    String primaryWeaponDamage;
    String abilities;
    String fpsCLass;
    public InformationCharacterTable(String name, String image, String health, String variants, String primaryWeapon, String primaryWeaponDamage, String abilities, String fpsCLass) {
        this.name = name;
        this.image = image;
        this.health = health;
        this.variants = variants;
        this.primaryWeapon = primaryWeapon;
        this.primaryWeaponDamage = primaryWeaponDamage;
        this.abilities = abilities;
        this.fpsCLass = fpsCLass;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name="CHARACTER_NAME")
    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getVariants() {
        return variants;
    }

    public void setVariants(String variants) {
        this.variants = variants;
    }

    public String getPrimaryWeapon() {
        return primaryWeapon;
    }

    public void setPrimaryWeapon(String primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }

    public String getPrimaryWeaponDamage() {
        return primaryWeaponDamage;
    }

    public void setPrimaryWeaponDamage(String primaryWeaponDamage) {
        this.primaryWeaponDamage = primaryWeaponDamage;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getFpsCLass() {
        return fpsCLass;
    }

    public void setFpsCLass(String fpsCLass) {
        this.fpsCLass = fpsCLass;
    }
}
