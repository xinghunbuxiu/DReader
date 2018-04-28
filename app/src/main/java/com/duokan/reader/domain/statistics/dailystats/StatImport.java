package com.duokan.reader.domain.statistics.dailystats;

import java.util.List;
import org.json.JSONObject;

public class StatImport extends StatEventBase {
    private static final long serialVersionUID = 1;
    public List<String> bookNames;
    public String importType;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.bookNames.size(); i++) {
            stringBuffer.append("," + ((String) this.bookNames.get(i)));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("bn", stringBuffer.toString().substring(1));
            jSONObject.put("t", this.importType);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
