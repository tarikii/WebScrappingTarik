import jakarta.xml.bind.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JAXB {
    File fileCharactersXML = new File("src/characters.xml");
    File fileVariantsXML = new File("src/variants.xml");
    Characters charactersInfo = new Characters();
    Character character;
    Variants variantsInfo = new Variants();
    Variant variant;
    JAXBContext jaxbContext;
    Marshaller jaxbMarshaller;


    JAXB(List<Character> characters, List<Variant> variants) {
        fileCharactersXML.delete();
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

        fileVariantsXML.delete();

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
