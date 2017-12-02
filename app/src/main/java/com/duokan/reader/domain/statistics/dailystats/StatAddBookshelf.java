package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatAddBookshelf extends StatEventBase {
    private static final long serialVersionUID = 1;
    public String bookUuid;
    public String traceId;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("bn", this.bookUuid);
            jSONObject.put("ti", this.traceId);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
