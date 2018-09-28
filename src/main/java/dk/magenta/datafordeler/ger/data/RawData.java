package dk.magenta.datafordeler.ger.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

public class RawData extends HashMap<String, Object> {

    public String getString(String key) {
        return (String) this.get(key);
    }
    public boolean getBoolean(String key) {
        return "j".equalsIgnoreCase(this.getString(key));
    }
    public Integer getInt(String key) {
        return (Integer) this.get(key);
    }
    public LocalDate getDate(String key) {
        return LocalDate.parse(this.getString(key), DateTimeFormatter.ISO_LOCAL_DATE);
    }
    public UUID getUUID(String key) {
        return UUID.fromString(this.getString(key));
    }
    public Character getCharacter(String key) {
        char[] chars = this.getString(key).toCharArray();
        if (chars.length > 0) {
            return chars[0];
        }
        return null;
    }
}
