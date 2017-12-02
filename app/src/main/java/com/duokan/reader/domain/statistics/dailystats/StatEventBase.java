package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

import java.io.Serializable;

public class StatEventBase implements Serializable {
    private static final long serialVersionUID = 1;
    public String event;
    public long timeStamp;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
