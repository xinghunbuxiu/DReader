package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.DkStoreRedeemBenefitInfo;
import com.duokan.reader.domain.account.User;
import java.util.Date;

public class DkCloudRedeemBenefit extends DkCloudJsonItem {
    private final DkStoreRedeemBenefitInfo mInfo;
    private final User mUser = new User();

    public DkCloudRedeemBenefit(DkStoreRedeemBenefitInfo dkStoreRedeemBenefitInfo) {
        super(0);
        this.mInfo = dkStoreRedeemBenefitInfo;
        this.mUser.mUserId = this.mInfo.mFromUuid;
    }

    public String getCloudId() {
        return null;
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        return null;
    }

    public User getGiver() {
        if (TextUtils.isEmpty(this.mUser.mUserId)) {
            this.mUser.mUserId = this.mInfo.mFromUuid;
        }
        return this.mUser;
    }

    public String getMessage() {
        return this.mInfo.mMessage;
    }

    public Date getWordUpdatedTime() {
        return this.mInfo.mTime;
    }
}
