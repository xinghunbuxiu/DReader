package com.duokan.reader.domain.statistics.dailystats;

import org.json.JSONObject;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String deviceId;
    public String deviceType;
    public String imei;
    public String userId;
    public String version;

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ui", this.userId);
            jSONObject.put("imei", this.imei);
            jSONObject.put("di", this.deviceId);
            jSONObject.put("ver", this.version);
            jSONObject.put("dt", this.deviceType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
