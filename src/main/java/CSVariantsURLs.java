import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVariantsURLs {

    File linksVariants = new File("src/CSVs/variantsURLs.csv");


    /**
     * Este constructor recibe el head, y los arryas de la clase Variant
     */
    public CSVariantsURLs(List<Variant> variants) {
        CSVWriter csvWriter;
        String[] head = {"Name","Description","Strategy"};
        List<String[]> linkVariants = new ArrayList<>();
        for (Variant var : variants){
            linkVariants.add(new String[] {var.names,var.descriptions,var.strategies});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(linksVariants));
            csvWriter.writeNext(head);
            csvWriter.writeAll(linkVariants);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
