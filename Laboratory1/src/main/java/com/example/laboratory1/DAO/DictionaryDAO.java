package com.example.laboratory1.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryDAO {
    private List<String> dictionary;

    public DictionaryDAO() {
        dictionary = new ArrayList<>();
        getData();
    }

    public List<String> getDictionary() {
        return dictionary;
    }

    private void getData() {
        try {
            URL resource = getClass().getClassLoader().getResource("dictionary.txt");
            File file = new File(resource.toURI());
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                dictionary.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error at opening the file !");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
