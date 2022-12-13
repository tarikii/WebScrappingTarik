import jakarta.xml.bind.*;

import java.io.File;
import java.util.List;

public class JAXBVariant {

    File fileVariantsXML = new File("src/XMLs/variants.xml");
    Variants variantsInfo = new Variants();
    Variant variant = new Variant();

    JAXBContext jaxbContext;
    Marshaller jaxbMarshaller;


    public JAXBVariant(List<Variant> variants){
        fileVariantsXML.delete();
        try{
            jaxbContext = JAXBContext.newInstance(Variants.class);

            for (Variant var : variants) {
                variant = new Variant(var.name,var.image,var.health,var.primaryWeapon,var.primaryWeaponDamage,var.variantPerk,var.rarity);
                variantsInfo.addVariants(variant);
            }
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(variantsInfo, fileVariantsXML);

        } catch (
                JAXBException e) {
            e.printStackTrace();
        }
    }
}
