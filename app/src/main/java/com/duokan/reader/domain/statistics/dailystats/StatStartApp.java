package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatStartApp extends StatEventBase {
    private static final long serialVersionUID = 1;
    public boolean isStartedFromCold;
    public long startTime;

    public String toString() {
        long j = 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("cold", this.isStartedFromCold);
            String str = "t";
            if (this.startTime >= 0) {
                j = this.startTime;
            }
            jSONObject.put(str, j);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
