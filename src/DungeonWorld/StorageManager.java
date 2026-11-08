package DungeonWorld;

import java.io.*;
import java.util.ArrayList;

public class StorageManager {
    private static final String DATA_DIR = "data";
    private static final String ITEM_FILE = DATA_DIR + "/items.ser";
    private static final String CHARACTER_FILE = DATA_DIR + "/characters.ser";

    public static void saveItems(ArrayList<Item> items) {
        save(items, ITEM_FILE);
    }

    public static ArrayList<Item> loadItems() {
        return load(ITEM_FILE);
    }

    public static void saveCharacters(ArrayList<Character> characters) {
        save(characters, CHARACTER_FILE);
    }

    public static ArrayList<Character> loadCharacters() {
        return load(CHARACTER_FILE);
    }

    private static void save(Object data, String file) {
        new File(DATA_DIR).mkdirs();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T load(String file) {
        File f = new File(file);
        if (!f.exists()) return null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}