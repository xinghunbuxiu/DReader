package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatSplash extends StatEventBase {
    private static final long serialVersionUID = 1;
    public int id;
    public String splashTap;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("type", this.splashTap);
            jSONObject.put("si", this.id);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
