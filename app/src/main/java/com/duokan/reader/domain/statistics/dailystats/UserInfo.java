package com.duokan.reader.domain.statistics.dailystats;

import java.io.Serializable;
import org.json.JSONObject;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String deviceId;
    public String deviceType;
    public String imeiMd5;
    public String userId;
    public String version;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ui", this.userId);
            jSONObject.put("imei", this.imeiMd5);
            jSONObject.put("di", this.deviceId);
            jSONObject.put("ver", this.version);
            jSONObject.put("dt", this.deviceType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
