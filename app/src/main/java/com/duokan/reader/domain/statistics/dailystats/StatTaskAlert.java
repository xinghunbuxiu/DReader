package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatTaskAlert extends StatEventBase {
    private static final long serialVersionUID = 1;
    public int result;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("r", this.result);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
