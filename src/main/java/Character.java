import java.util.ArrayList;
import java.util.List;

public class Character {
    String name;
    String variantsName;
    String image;
    String health;
    String primaryWeapon;
    String primaryWeaponDamage;
    String abilitiesName;
    String fpsClass;

    public Character(String name, String variantsName, String image, String health, String primaryWeapon, String primaryWeaponDamage, String abilitiesName, String fpsClass) {
        this.name = name;
        this.variantsName = variantsName;
        this.image = image;
        this.health = health;
        this.primaryWeapon = primaryWeapon;
        this.primaryWeaponDamage = primaryWeaponDamage;
        this.abilitiesName = abilitiesName;
        this.fpsClass = fpsClass;
    }

    public Character(String name, String health, String primaryWeapon, String primaryWeaponDamage) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariantsName() {
        return variantsName;
    }

    public void setVariantsName(String variantsName) {
        this.variantsName = variantsName;
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

    public String getAbilitiesName() {
        return abilitiesName;
    }

    public void setAbilitiesName(String abilitiesName) {
        this.abilitiesName = abilitiesName;
    }

    public String getFpsClass() {
        return fpsClass;
    }

    public void setFpsClass(String fpsClass) {
        this.fpsClass = fpsClass;
    }
}
