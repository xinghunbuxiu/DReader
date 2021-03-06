package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatPay extends StatEventBase {
    private static final long serialVersionUID = 1;
    public String bookId;
    public String bookType;
    public String result;
    public String resultFromMipay;
    public String track;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("tr", this.track);
            jSONObject.put("onActivityResult", this.result);
            jSONObject.put("rs", this.resultFromMipay);
            jSONObject.put("bt", this.bookType);
            jSONObject.put("bi", this.bookId);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
