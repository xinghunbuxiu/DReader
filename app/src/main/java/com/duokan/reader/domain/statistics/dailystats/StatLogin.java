package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatLogin extends StatEventBase {
    private static final long serialVersionUID = 1;
    public String loginType;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("type", this.loginType);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
