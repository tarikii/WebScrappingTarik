import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVCharactersURLs {
    File linksCharacters = new File("src/CSVs/charactersURLs.csv");


    public CSVCharactersURLs(List<Character> characters) {
        CSVWriter csvWriter;
        String[] head = {"Name","Description","Strategy"};
        List<String[]> linkCharacters = new ArrayList<>();
        for (Character ch : characters){
            linkCharacters.add(new String[] {ch.name,ch.description,ch.strategy});
        }
        try {
            csvWriter = new CSVWriter(new FileWriter(linksCharacters));
            csvWriter.writeNext(head);
            csvWriter.writeAll(linkCharacters);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
