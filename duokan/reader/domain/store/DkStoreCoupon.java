package com.duokan.reader.domain.store;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.duokan.DkStoreCouponInfo;

import java.io.Serializable;

public class DkStoreCoupon implements Serializable {
    private final DkStoreCouponInfo mCouponInfo;

    public enum COUPON_TYPE {
        BAMBOO,
        SILVER,
        GOLD,
        DIAMOND,
        ERROR
    }

    public DkStoreCoupon(DkStoreCouponInfo dkStoreCouponInfo) {
        this.mCouponInfo = dkStoreCouponInfo;
    }

    public String getUniqueId() {
        return this.mCouponInfo.mCouponId;
    }

    public int getValue() {
        return this.mCouponInfo.mValue;
    }

    public long getValidDuration() {
        return Math.max(this.mCouponInfo.mExpireTime - System.currentTimeMillis(), 0);
    }

    public String getDescription() {
        return TextUtils.isEmpty(this.mCouponInfo.mDescription) ? this.mCouponInfo.mName : this.mCouponInfo.mDescription;
    }

    public long getStartTime() {
        return this.mCouponInfo.mStartTime;
    }

    public long getExpireTime() {
        return this.mCouponInfo.mExpireTime;
    }

    public boolean hasUsed() {
        return this.mCouponInfo.mStatus != 0;
    }

    public COUPON_TYPE getCouponType() {
        if (this.mCouponInfo.mValue > 0 && this.mCouponInfo.mValue <= 3) {
            return COUPON_TYPE.BAMBOO;
        }
        if (3 < this.mCouponInfo.mValue && this.mCouponInfo.mValue <= 6) {
            return COUPON_TYPE.SILVER;
        }
        if (6 < this.mCouponInfo.mValue && this.mCouponInfo.mValue <= 12) {
            return COUPON_TYPE.GOLD;
        }
        if (12 < this.mCouponInfo.mValue) {
            return COUPON_TYPE.DIAMOND;
        }
        return COUPON_TYPE.ERROR;
    }
}
