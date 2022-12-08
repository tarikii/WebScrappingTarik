import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CSV {

    File tables = new File("src/CSVs/charactersTable.csv");


    public CSV(List<Character> characters) {
        CSVWriter csvWriter;
        String[] head = {"Name","Image","Health","Variants","Primary Weapon","Weapon Damage","Abilities","FPSClass"};
        List<String[]> data = new ArrayList<>();
        for (Character ch : characters){
            data.add(new String[] {ch.name,ch.image,ch.health,ch.variantsName,ch.primaryWeapon,ch.primaryWeaponDamage,
            ch.abilitiesName,ch.fpsClass});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(tables));
            csvWriter.writeNext(head);
            csvWriter.writeAll(data);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
