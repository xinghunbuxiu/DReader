package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatRegResult extends StatEventBase {
    private static final long serialVersionUID = 1;
    public String resultType;
    public long time;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("st", this.resultType);
            jSONObject.put("TaskHandler", this.time);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
