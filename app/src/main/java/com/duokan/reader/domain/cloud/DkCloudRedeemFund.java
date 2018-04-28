package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.DkStoreRedeemFundInfo;
import com.duokan.reader.domain.account.User;
import java.util.Date;

public class DkCloudRedeemFund extends DkCloudJsonItem {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkCloudRedeemFund.class.desiredAssertionStatus());
    private final DkStoreRedeemFundInfo mInfo;
    private final User mUser = new User();

    public DkCloudRedeemFund(DkStoreRedeemFundInfo dkStoreRedeemFundInfo) {
        super(0);
        this.mInfo = dkStoreRedeemFundInfo;
        this.mUser.mUserId = this.mInfo.mReceiverId;
        this.mUser.mNickName = this.mInfo.mNickName;
        this.mUser.mIconUrl = this.mInfo.mIconUrl;
    }

    public String getCloudId() {
        return null;
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        if ($assertionsDisabled) {
            return null;
        }
        throw new AssertionError();
    }

    public String getBookCoverUrl() {
        return this.mInfo.mBookCover;
    }

    public String getTitle() {
        return this.mInfo.mBookTitle;
    }

    public String getBookAuthor() {
        return this.mInfo.mAuthor;
    }

    public String getBookEditor() {
        return this.mInfo.mEditor;
    }

    public String getNameLine() {
        if (TextUtils.isEmpty(getBookAuthor())) {
            return getBookEditor();
        }
        return getBookAuthor();
    }

    public String getBookUuid() {
        return this.mInfo.mBookUuid;
    }

    public String getMessage() {
        return this.mInfo.mWords;
    }

    public void setMessage(String str) {
        this.mInfo.mWords = str;
    }

    public boolean isUsed() {
        return this.mInfo.mStatus == 2;
    }

    public User getReceivedUser() {
        return this.mUser;
    }

    public String getLinkUrl() {
        return this.mInfo.mLinkUrl;
    }

    public Date getReceivedTime() {
        return this.mInfo.mStatusUpdatedTime;
    }

    public Date getWordUpdatedTime() {
        return this.mInfo.mWordUpdatedTime;
    }

    public int getStatus() {
        return this.mInfo.mStatus;
    }
}
