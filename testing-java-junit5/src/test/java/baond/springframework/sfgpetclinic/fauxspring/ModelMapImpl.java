package baond.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BaoND on 2025-03-20
 */
public class ModelMapImpl implements Model {

    Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {

    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
