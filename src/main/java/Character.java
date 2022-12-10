import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Character")
public class Character {
    String name;
    String variantsName;
    String image;
    String health;
    String primaryWeapon;
    String primaryWeaponDamage;
    String abilitiesName;
    String fpsClass;

    String description;

    String strategy;

    public Character(String name, String image, String health, String variantsName, String primaryWeapon, String primaryWeaponDamage, String abilitiesName, String fpsClass) {
        this.name = name;
        this.image = image;
        this.health = health;
        this.variantsName = variantsName;
        this.primaryWeapon = primaryWeapon;
        this.primaryWeaponDamage = primaryWeaponDamage;
        this.abilitiesName = abilitiesName;
        this.fpsClass = fpsClass;
    }

    public Character(String name, String description, String strategy ) {
        this.name = name;
        this.description = description;
        this.strategy = strategy;
    }

    public Character(String name, String health, String image, String primaryWeapon, String primaryWeaponDamage) {
    }

    public String getName() {
        return name;
    }

    @XmlElement(name="Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getVariantsName() {
        return variantsName;
    }

    @XmlElement(name="Variant")
    public void setVariantsName(String variantsName) {
        this.variantsName = variantsName;
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

    public String getAbilitiesName() {
        return abilitiesName;
    }

    @XmlElement(name="Ability")
    public void setAbilitiesName(String abilitiesName) {
        this.abilitiesName = abilitiesName;
    }

    public String getFpsClass() {
        return fpsClass;
    }

    @XmlElement(name="FpsClass")
    public void setFpsClass(String fpsClass) {
        this.fpsClass = fpsClass;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement(name="Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getStrategy() {
        return strategy;
    }

    @XmlElement(name="Strategy")
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", health='" + health + '\'' +
                ", variants='" + variantsName + '\'' +
                ", primaryWeapon='" + primaryWeapon + '\'' +
                ", primaryWeaponDamage='" + primaryWeaponDamage + '\'' +
                ", abilitiesName='" + abilitiesName + '\'' +
                ", fpsClass='" + fpsClass + '\'' +
                ", description='" + description + '\'' +
                ", strategy='" + strategy + '\'' +
                '}';
    }
}
