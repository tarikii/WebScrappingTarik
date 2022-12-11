import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.List;

public class JAXB {
    File fileCharactersXML = new File("src/XMLs/characters.xml");
    File fileVariantsXML = new File("src/XMLs/variants.xml");
    Characters charactersInfo = new Characters();
    Character character;
    Variants variantsInfo = new Variants();
    Variant variant;
    JAXBContext jaxbContext;
    Marshaller jaxbMarshaller;


    JAXB(List<Character> characters, List<Variant> variants) {
        try {
            jaxbContext = JAXBContext.newInstance(Characters.class);

            for (Character ch : characters) {
                character = new Character(ch.name,ch.image,ch.health,ch.variantsName,ch.primaryWeapon,ch.primaryWeaponDamage
                ,ch.abilitiesName,ch.fpsClass);
                charactersInfo.addCharacters(character);
            }

            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(charactersInfo, fileCharactersXML);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try{
            jaxbContext = JAXBContext.newInstance(Variants.class);

            for (Variant var : variants) {
                variant = new Variant(var.name,var.image,var.health,var.primaryWeapon,var.primaryWeaponDamage
                        ,var.variantPerk,var.rarity);
                variantsInfo.addVariants(variant);
            }

            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(variantsInfo, fileVariantsXML);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        }
}
