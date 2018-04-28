package com.duokan.reader.common.webservices.duokan;

import java.io.Serializable;
import org.json.JSONObject;

public class DkStoreCouponInfo implements Serializable {
    public int mConsumeType = 0;
    public String mCouponId = "";
    public String mDescription = "";
    public long mExpireTime = 0;
    public String mName = "";
    public long mStartTime = 0;
    public int mStatus = 0;
    public int mValue = 0;

    public DkStoreCouponInfo(JSONObject jSONObject) {
        this.mCouponId = jSONObject.getString("coupon_id");
        this.mConsumeType = jSONObject.getInt("consume_type");
        this.mStatus = jSONObject.getInt("status");
        this.mValue = jSONObject.getInt("value");
        this.mName = jSONObject.getString("name");
        this.mDescription = jSONObject.getString("description");
        this.mStartTime = jSONObject.getLong("start_time") * 1000;
        this.mExpireTime = jSONObject.getLong("expire_time") * 1000;
    }
}
