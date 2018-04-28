package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatExitApp extends StatEventBase {
    private static final long serialVersionUID = 1;
    public String exitType;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("t", this.exitType);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
