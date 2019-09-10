package com.star.Utils;

import com.star.Utils.Record;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyResultHandler implements ResultHandler {
    //private final Record record = new Record();
    private final List<Record> results = new ArrayList<>();

    @Override
    public void handleResult(ResultContext resultContext) {
        Record record = new Record();
        Map resultObject = (Map) resultContext.getResultObject();
        for (Object key : resultObject.keySet()) {
            record.set(key, resultObject.get(key));
        }
        results.add( record);

    }

    public List<Record> getResultMap() {
        List<Record> temp = new ArrayList<>();
        temp.addAll(results);
        results.clear();
        return temp;
    }
}
