package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utility {
    public static String generateId(String FILENAME, String start) {
        String prevId = null;
        String currentId;
        int id;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            br.readLine();
            while ((row = br.readLine()) != null) {
                    String[] data = row.split("\\|\\|");
                    prevId = data[0];
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ((prevId != null)&&!(prevId.equals(""))) {
            prevId = prevId.replaceFirst(start, "");
            prevId = prevId.replaceFirst("0+(?!$)", "");
            id = Integer.parseInt(prevId);
            id += 1;
            currentId = start + String.format("%03d", id);
            return currentId;
        }else {
            return start + "001";
        }
    }
}
