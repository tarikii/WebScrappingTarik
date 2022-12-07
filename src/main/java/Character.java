public class Character {
    String name;
    String variantsName;
    String image;
    String health;
    String primaryWeapon;
    String primaryWeaponDamage;
    String abilitiesName;
    String fpsClass;

    String rarities;

    String description;

    String ammo;

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

    public Character(String name, String description, String health, String weapon, String ammo, String rarity ) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.primaryWeapon = weapon;
        this.ammo = ammo;
        this.rarities = rarity;
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

    public String getRarities() {
        return rarities;
    }

    public void setRarities(String rarities) {
        this.rarities = rarities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmmo() {
        return ammo;
    }

    public void setAmmo(String ammo) {
        this.ammo = ammo;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", variantsName='" + variantsName + '\'' +
                ", image='" + image + '\'' +
                ", health='" + health + '\'' +
                ", primaryWeapon='" + primaryWeapon + '\'' +
                ", primaryWeaponDamage='" + primaryWeaponDamage + '\'' +
                ", abilitiesName='" + abilitiesName + '\'' +
                ", fpsClass='" + fpsClass + '\'' +
                ", strategies='" + rarities + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
