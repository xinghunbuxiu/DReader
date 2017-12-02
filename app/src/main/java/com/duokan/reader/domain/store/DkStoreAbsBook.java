package com.duokan.reader.domain.store;

import com.duokan.reader.common.webservices.duokan.DkStoreAbsBookInfo;

public class DkStoreAbsBook extends DkStoreItem {
    protected final DkStoreAbsBookInfo mAbsBookInfo;

    public DkStoreAbsBook(DkStoreAbsBookInfo dkStoreAbsBookInfo) {
        this.mAbsBookInfo = dkStoreAbsBookInfo;
    }

    public String getBookUuid() {
        return this.mAbsBookInfo.mBookUuid;
    }

    public String getTitle() {
        return this.mAbsBookInfo.mTitle;
    }

    public String getNameLine() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.mAbsBookInfo.mAuthors) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public String getCoverUri() {
        return this.mAbsBookInfo.mCoverUri;
    }

    public String getDescription() {
        return this.mAbsBookInfo.mSummary;
    }

    public boolean supportTip() {
        return this.mAbsBookInfo.mSupportTip;
    }
}
