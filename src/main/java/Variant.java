import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Esta clase devuelve los atributos de las variantes, que se recogera para scrappearlos en un CSV y un XML
 */
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

    /**
     * Este constructor que recibira unos datos y los asignara
     * @param name recibe un valor del nombre del personaje
     * @param  image recibe un valor de la URL
     * @param health recibe un valor de la vida
     * @param primaryWeapon recibe un valor del arma
     * @param primaryWeaponDamage recibe un valor del daño
     * @param variantPerk recibe la categoria de la variante
     * @param rarity recibe la rareza de la variante
     */
    public Variant(String name, String image, String health, String primaryWeapon, String primaryWeaponDamage, String variantPerk, String rarity){
        this.name = name;
        this.image = image;
        this.health = health;
        this.primaryWeapon = primaryWeapon;
        this.primaryWeaponDamage = primaryWeaponDamage;
        this.variantPerk = variantPerk;
        this.rarity = rarity;
    }

    /**
     * Un constructor vacio
     */
    public Variant(){

    }

    /**
     * Este constructor que recibira unos datos y los asignara
     * @param names recibe un valor de los nombres de personaje
     * @param descriptions recibe un valor de las desripciones de las variantes
     * @param  strategies recibe un valor de la estrategia de los personajes
     */
    public Variant(String names, String descriptions, String strategies) {
        this.names = names;
        this.descriptions = descriptions;
        this.strategies = strategies;
    }

    /**
     * Este setter recibe un nombre
     * @param name recibe un valor del nombre del personaje
     */
    @XmlElement(name="Name")
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /**
     * Este setter devuelve la URL de la imagen
     * @param  image recibe un valor de la URL
     */
    @XmlElement(name="Image_URL")
    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    /**
     * Este setter devuelve el numero de la vida
     * @param health recibe un numero que sera la vida
     */
    @XmlElement(name="Health")
    public void setHealth(String health) {
        this.health = health;
    }
    public String getHealth() {
        return health;
    }

    @XmlElement(name="Primary_Weapon")
    public void setPrimaryWeapon(String primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }
    public String getPrimaryWeapon() {
        return primaryWeapon;
    }

    /**
     * Este setter devuelve el daño del arma
     * @param primaryWeaponDamage recibe el daño del arma
     */
    @XmlElement(name="Weapon_Damage")
    public void setPrimaryWeaponDamage(String primaryWeaponDamage) {
        this.primaryWeaponDamage = primaryWeaponDamage;
    }
    public String getPrimaryWeaponDamage() {
        return primaryWeaponDamage;
    }

    /**
     * Este setter devuelve la categoria de la variante
     * @param variantPerk recibe la categoria de la variante
     */
    @XmlElement(name="Perk")
    public void setVariantPerk(String variantPerk) {
        this.variantPerk = variantPerk;
    }
    public String getVariantPerk() {
        return variantPerk;
    }

    /**
     * Este setter devuelve la rareza del personaje
     * @param rarity recibe la rareza del personaje
     */
    @XmlElement(name="Rarity")
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    public String getRarity() {
        return rarity;
    }

    /**
     * Este setter devuelve los nombres de los personajes
     * @param  names recibe un valor de los nombres
     */
    @XmlElement(name="Names")
    public void setNames(String names) {
        this.names = names;
    }
    public String getNames() {
        return names;
    }

    /**
     * Este setter devuelve las descripciones de los personajes
     * @param descriptions recibe un valor de las descripciones
     */
    @XmlElement(name="Descriptions")
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * Este setter devuelve la estrategia de los personajes
     * @param strategies recibe un paragrafo de las estrategias
     */
    @XmlElement(name="Strategies")
    public void setStrategies(String strategies) {
        this.strategies = strategies;
    }
    public String getStrategies() {
        return strategies;
    }
}
