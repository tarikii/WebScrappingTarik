import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVariantsTable {
    File tablesVariants = new File("src/CSVs/variantsTable.csv");

    public CSVariantsTable(List<Variant> variants) {
        CSVWriter csvWriter;
        String[] head = {"Name","Image","Health","Primary Weapon","Weapon Damage","Variant Perk","Rarity"};
        List<String[]> table = new ArrayList<>();
        for (Variant var : variants){
            table.add(new String[] {var.name,var.image,var.health,var.primaryWeapon,var.primaryWeaponDamage,var.variantPerk,var.rarity});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(tablesVariants));
            csvWriter.writeNext(head);
            csvWriter.writeAll(table);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
