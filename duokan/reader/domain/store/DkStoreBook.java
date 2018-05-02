package com.duokan.reader.domain.store;

import com.duokan.reader.common.webservices.duokan.DkStoreBookInfo;

import java.util.Date;

public class DkStoreBook extends DkStoreAbsBook {
    protected final DkStoreBookInfo mBookInfo;

    public DkStoreBook(DkStoreBookInfo dkStoreBookInfo) {
        super(dkStoreBookInfo);
        this.mBookInfo = dkStoreBookInfo;
    }

    public int getSource() {
        return this.mBookInfo.mSource;
    }

    public String getSourceId() {
        return this.mBookInfo.mSourceId;
    }

    public String[] getAuthors() {
        return this.mBookInfo.mAuthors;
    }

    public String[] getAuthorIds() {
        return this.mBookInfo.mAuthorIds;
    }

    public String getAuthorLine() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.mBookInfo.mAuthors) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public String[] getEditors() {
        return this.mBookInfo.mEditors;
    }

    public String getEditorLine() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.mBookInfo.mEditors) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public int getPrice() {
        return this.mBookInfo.mPrice;
    }

    public int getNewPrice() {
        return this.mBookInfo.mNewPrice;
    }

    public Date getExpirationDate() {
        return this.mBookInfo.mExpirationDate;
    }

    public int getWeight() {
        return this.mBookInfo.mWeight;
    }

    public boolean isFree() {
        return getNewPrice() == 0;
    }

    public boolean hasChangeLog() {
        return this.mBookInfo.mHasChangeLog;
    }

    public float getAverageScore() {
        return this.mBookInfo.mAverageScore;
    }

    public int getScoreCount() {
        return this.mBookInfo.mScoreCount;
    }

    public int getCommentCount() {
        return this.mBookInfo.mCommentCount;
    }

    public long getLimitedTime() {
        return this.mBookInfo.mLimitedTime;
    }

    public boolean isAndroidPlatformValid() {
        return this.mBookInfo.mAndroidPlatformValid;
    }

    public String getExpandInfo() {
        return this.mBookInfo.mExpandInfo;
    }

    public String getNameLine() {
        if (this.mBookInfo.mAuthors == null || this.mBookInfo.mAuthors.length <= 0) {
            return getEditorLine();
        }
        return getAuthorLine();
    }

    public long getTime() {
        return this.mBookInfo.mTime;
    }
}
