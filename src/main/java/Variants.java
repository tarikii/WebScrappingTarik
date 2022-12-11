import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Variants")
public class Variants {
    List<Variant> variants = new ArrayList<>();

    public List<Variant> getVariants() {
        return variants;
    }

    @XmlElement(name="Variant")
    public void setDatos(List<Variant> variants) {
        this.variants = variants;
    }

    public void addVariants(Variant variant){
        this.variants.add(variant);
    }
}
