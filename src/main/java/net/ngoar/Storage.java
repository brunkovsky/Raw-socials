package net.ngoar;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Date, SocialEntity> storage = new HashMap<Date, SocialEntity>();

    public Map<Date, SocialEntity> getStorage() {
        return storage;
    }

    public void setStorage(Map<Date, SocialEntity> storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storage=" + storage +
                '}';
    }
}
