package com.duokan.reader.domain.store;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.DkStoreFictionInfo;
import java.util.Date;

public class DkStoreFiction extends DkStoreAbsBook {
    private final DkStoreCategory[] mCategories = new DkStoreCategory[this.mFictionInfo.mCategories.length];
    protected final DkStoreFictionInfo mFictionInfo;

    public DkStoreFiction(DkStoreFictionInfo dkStoreFictionInfo) {
        super(dkStoreFictionInfo);
        this.mFictionInfo = dkStoreFictionInfo;
        for (int i = 0; i < this.mCategories.length; i++) {
            this.mCategories[i] = new DkStoreFictionCategory(this.mFictionInfo.mCategories[i]);
        }
    }

    public String getAuthorLine() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.mFictionInfo.mAuthors) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public String[] getAuthorIds() {
        return this.mFictionInfo.mAuthorIds;
    }

    public String[] getAuthors() {
        return this.mFictionInfo.mAuthors;
    }

    public int getChapterCount() {
        return this.mFictionInfo.mChapterCount;
    }

    public boolean getHasAds() {
        return this.mFictionInfo.mHasAds;
    }

    public int getAdTime() {
        return this.mFictionInfo.mAdTime;
    }

    public int getClickCount() {
        return this.mFictionInfo.mClick;
    }

    public String getLatestChapterId() {
        return this.mFictionInfo.mLatestId;
    }

    public String getLatestChapterTitle() {
        return this.mFictionInfo.mLatest;
    }

    public int getPrice() {
        return this.mFictionInfo.mPrice;
    }

    public int getCent() {
        return this.mFictionInfo.mPrice;
    }

    public String getRights() {
        return this.mFictionInfo.mRights;
    }

    public Date getUpdateDate() {
        return this.mFictionInfo.mUpdated;
    }

    public long getWordCount() {
        return this.mFictionInfo.mWordCount;
    }

    public boolean isFinish() {
        return this.mFictionInfo.mFinish;
    }

    public boolean isFree() {
        return this.mFictionInfo.mPrice == 0;
    }

    public boolean isOnSale() {
        return this.mFictionInfo.mOnSale;
    }

    public boolean isVerticalComic() {
        return TextUtils.equals(this.mFictionInfo.mTypeId, "10000006");
    }

    public boolean isSpecialPrice() {
        return this.mFictionInfo.mSpecial > 0.0f;
    }

    public float getSpecialPrice() {
        return this.mFictionInfo.mSpecial;
    }

    public String getNameLine() {
        return getAuthorLine();
    }

    public DkStoreCategory[] getInCategories() {
        return this.mCategories;
    }
}
