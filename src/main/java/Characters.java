import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="Characters")

public class Characters {
    List<Character> characters = new ArrayList<>();



    public List<Character> getCharacters() {
        return characters;
    }



    @XmlElement(name="Character")
    public void setDatos(List<Character> characters) {
        this.characters = characters;
    }

    public void addCharacters(Character character){
        this.characters.add(character);
    }
}
