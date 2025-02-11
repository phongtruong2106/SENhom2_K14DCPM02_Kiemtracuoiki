import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StoreFilesAccount {
    private String nameFile;
    private JsonArray memory;// data on RAM

    /**
     * @param storedFile
     */
    public StoreFilesAccount(String storedFile) {
        this.nameFile = storedFile;
        // tu dong doc du lieu tu file len memory
        this.memory = read();
    }

    // un mr teo
    /**
     * 
     * @param key
     * @param value
     * @return: index of elements *** -1: not found
     */
    // un //mrteo
    public int search(String key, String value) {
        // duyet
        int index = -1;

        
        // ...
        String username = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            username = jsonObject.get(key).getAsString();
            if (value.equals(username)) {
                index = i;//
                break;
            }
        }
        return index;
    }

    public JsonArray read() {
        JsonArray jsonArray = null;
        
        
        try (FileReader reader = new FileReader(nameFile)) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    // add to memory
    public void update(String username, Integer password, String email, Integer phone) {
        JsonObject jsonObject = new JsonObject();


        //JsonArray jsonArray = new JsonArray();
        //jsonArray.ad

        jsonObject.addProperty("un", username);
        jsonObject.addProperty("ps", password);
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("phone", phone);
        memory.add(jsonObject);
        // memory.ad
    }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(nameFile)) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public JsonArray getAll(){
        return this.memory;
    }
}
