package com.star.Utils;

import java.util.HashMap;
import java.util.Map;

public class Record extends HashMap {
    public Map set(Object key, Object value){
            this.put(key,value);
            return this;
    }
}
