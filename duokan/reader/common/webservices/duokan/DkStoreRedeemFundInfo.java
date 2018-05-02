package com.duokan.reader.common.webservices.duokan;

import java.io.Serializable;
import java.util.Date;

public class DkStoreRedeemFundInfo implements Serializable {
    public String mAuthor;
    public String mBookCover;
    public String mBookTitle;
    public String mBookUuid;
    public String mEditor;
    public String mIconUrl;
    public String mLinkUrl;
    public String mNickName;
    public String mReceiverId;
    public int mStatus = 1;
    public Date mStatusUpdatedTime;
    public Date mWordUpdatedTime;
    public String mWords;
}
