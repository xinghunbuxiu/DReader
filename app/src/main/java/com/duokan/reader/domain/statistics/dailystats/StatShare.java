package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatShare extends StatEventBase {
    private static final long serialVersionUID = 1;
    public String bookUuid;
    public String channelCode;
    public String traceId;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("bn", this.bookUuid);
            jSONObject.put("ti", this.traceId);
            jSONObject.put("ch", this.channelCode);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
