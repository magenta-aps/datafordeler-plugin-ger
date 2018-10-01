package dk.magenta.datafordeler.ger.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class RawData extends HashMap<String, Object> {

    public String getString(String key) {
        Object value = this.get(key);
        if (value instanceof Long) {
            return ((Long) value).toString();
        }
        if (value instanceof Integer) {
            return ((Integer) value).toString();
        }
        if (value instanceof Date) {
            return ((Date) value).toString();
        }
        return (String) value;
    }

    public boolean getBoolean(String key) {
        return "j".equalsIgnoreCase(this.getString(key));
    }

    public Integer getInt(String key) {
        Object value = this.get(key);
        if (value != null) {
            if (value instanceof Long) {
                return ((Long) value).intValue();
            }
            return (Integer) value;
        }
        return null;
    }

    public LocalDate getDate(String key) {
        Object value = this.get(key);
        if (value != null) {
            if (value instanceof Date) {
                Date d = (Date) value;
                return LocalDate.of(d.getYear(), d.getMonth() + 1, d.getDate());
            }
            return LocalDate.parse((String) value, DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return null;
    }

    public UUID getUUID(String key) {
        String value = this.getString(key);
        return value != null ? UUID.fromString(value) : null;
    }

    public Character getCharacter(String key) {
        String value = this.getString(key);
        if (value != null) {
            char[] chars = value.toCharArray();
            if (chars.length > 0) {
                return chars[0];
            }
        }
        return null;
    }
}
