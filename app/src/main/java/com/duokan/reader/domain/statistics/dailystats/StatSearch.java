package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatSearch extends StatEventBase {
    private static final long serialVersionUID = 1;
    public int clickResult;
    public int field;
    public String keyword;
    public int resultCount;
    public String searchType;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("ctx", this.searchType);
            jSONObject.put("key", this.keyword);
            jSONObject.put("showAnimation", this.resultCount);
            jSONObject.put("r", this.field);
            jSONObject.put("cc", this.clickResult);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
