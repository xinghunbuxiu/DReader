package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatLoginResult extends StatEventBase {
    private static final long serialVersionUID = 1;
    public long costTime;
    public String resultType;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("st", this.resultType);
            jSONObject.put("t", this.costTime);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
