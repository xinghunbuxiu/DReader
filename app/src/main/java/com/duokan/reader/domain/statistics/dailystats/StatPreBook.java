package com.duokan.reader.domain.statistics.dailystats;

import java.util.List;
import org.json.JSONObject;

public class StatPreBook extends StatEventBase {
    private static final long serialVersionUID = 1;
    public List<String> bookIds;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.bookIds.size(); i++) {
            stringBuffer.append("," + ((String) this.bookIds.get(i)));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("bi", this.bookIds);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
