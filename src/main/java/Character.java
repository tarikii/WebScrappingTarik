import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Esta clase sera la variable que usaremos para añadir a base de constructores los datos scrappeados en un CSV y en un XML.
 */
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

    /**
     * Este constructor que recibira unos datos y los asignara
     * @param name recibe un valor del nombre del personaje
     * @param variantsName recibe un valor de nombre de variantes
     * @param  image recibe un valor de la URL
     * @param health recibe un valor de la vida
     * @param primaryWeapon recibe un valor del arma
     * @param primaryWeaponDamage recibe un valor del daño
     */

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

    /**
     * Este es un constructor que esta vacio
     */
    public Character(){
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


    /**
     * Aqui recogemos el nombre
     * @param name nos devuelve el name
     */
    @XmlElement(name="Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getVariantsName() {
        return variantsName;
    }

    /**
     * Aqui recogemos el nombre de la variante
     * @param variantsName devuelve el nombre de las variantes
     */
    @XmlElement(name="Variant")
    public void setVariantsName(String variantsName) {
        this.variantsName = variantsName;
    }

    public String getImage() {
        return image;
    }

    /**
     * Aqui recogemos la URL de la imagen
     * @param image devuelve una URL
     */
    @XmlElement(name="Image_URL")
    public void setImage(String image) {
        this.image = image;
    }

    public String getHealth() {
        return health;
    }

    /**
     * Aqui recogemos la vida del personaje
     * @param health devuelve la vida del personaje
     */
    @XmlElement(name="Health")
    public void setHealth(String health) {
        this.health = health;
    }

    public String getPrimaryWeapon() {
        return primaryWeapon;
    }

    /**
     * Aqui recogemos el nombre del arma
     * @param primaryWeapon devuelve el nombre del arma
     */
    @XmlElement(name="Primary_Weapon")
    public void setPrimaryWeapon(String primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }

    public String getPrimaryWeaponDamage() {
        return primaryWeaponDamage;
    }

    /**
     * Aqui recogemos el daño del arma
     * @param primaryWeaponDamage devuelve el numero de daño
     */
    @XmlElement(name="Weapon_Damage")
    public void setPrimaryWeaponDamage(String primaryWeaponDamage) {
        this.primaryWeaponDamage = primaryWeaponDamage;
    }

    public String getAbilitiesName() {
        return abilitiesName;
    }

    /**
     * Aqui recogemos el nombre de las habilidades
     * @param abilitiesName devuelve el nombre de las habilidades
     */
    @XmlElement(name="Ability")
    public void setAbilitiesName(String abilitiesName) {
        this.abilitiesName = abilitiesName;
    }

    public String getFpsClass() {
        return fpsClass;
    }

    /**
     * Aqui recogemos la clase de fps
     * @param fpsClass devuelve la clase fps
     */
    @XmlElement(name="Fps_Class")
    public void setFpsClass(String fpsClass) {
        this.fpsClass = fpsClass;
    }



    public String getDescription() {
        return description;
    }

    /**
     * Aqui recogemos la descripcion
     * @param description devuelve la descripcion del personaje
     */
    @XmlElement(name = "Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getStrategy() {
        return strategy;
    }

    /**
     * Aqui recogemos la estrategia
     * @param strategy devuelve un paragrafo de la estrategia
     */
    @XmlElement(name = "Strategy")
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }


    /**
     * Aqui creamos un toString que imprime todos los atributos de la clase
     */
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
