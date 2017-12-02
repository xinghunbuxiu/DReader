package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

public class StatOpenBook extends StatEventBase {
    private static final long serialVersionUID = 1;
    public int autoBuyCount;
    public int autoBuyPrice;
    public String bookId;
    public long bookOpenTime;
    public String bookStatus;
    public String bookType;
    public long closeTime;
    public int exit;
    public boolean isPreBook;
    public long openTime;
    public String traceId;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ev", this.event);
            jSONObject.put("t", (this.closeTime - this.openTime) / 1000);
            jSONObject.put("bn", this.bookId);
            jSONObject.put("ty", this.bookType);
            jSONObject.put("bc", this.autoBuyCount);
            jSONObject.put("br", this.autoBuyPrice);
            jSONObject.put("to", this.bookOpenTime);
            jSONObject.put("r", this.bookStatus);
            jSONObject.put("exit", this.exit);
            jSONObject.put("ti", this.traceId);
            jSONObject.put("pre", this.isPreBook);
            jSONObject.put("ts", this.timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
