import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CSVCharactersTable {

    File tablesCharacters = new File("src/CSVs/charactersTable.csv");


    /**
     * Este constructor recibe el head, y los arryas de la clase Character
     */
    public CSVCharactersTable(List<Character> characters) {
        CSVWriter csvWriter;
        String[] head = {"Name","Image","Health","Variants","Primary Weapon","Weapon Damage","Abilities","FPSClass"};
        List<String[]> tableCharacters = new ArrayList<>();
        for (Character ch : characters){
            tableCharacters.add(new String[] {ch.name,ch.image,ch.health,ch.variantsName,ch.primaryWeapon,ch.primaryWeaponDamage,
            ch.abilitiesName,ch.fpsClass});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(tablesCharacters));
            csvWriter.writeNext(head);
            csvWriter.writeAll(tableCharacters);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
