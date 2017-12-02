package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatUpload extends StatEventBase {
    private static final long serialVersionUID = 1;
    public String bookName;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("bn", this.bookName);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
