import jakarta.xml.bind.*;

import java.io.File;
import java.util.List;

public class JAXBCharacter {
    File fileCharactersXML = new File("src/XMLs/characters.xml");
    Characters charactersInfo = new Characters();
    Character character;

    JAXBContext jaxbContext;
    Marshaller jaxbMarshaller;


    public JAXBCharacter(List<Character> characters) {
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
        }
}
