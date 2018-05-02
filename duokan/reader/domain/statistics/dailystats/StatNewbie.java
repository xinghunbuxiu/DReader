package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatNewbie extends StatEventBase {
    private static final long serialVersionUID = 1;
    public String actionType;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("s", this.actionType);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
