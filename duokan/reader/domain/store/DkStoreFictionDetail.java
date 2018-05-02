package com.duokan.reader.domain.store;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.duokan.DkStoreAbsBookInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreFictionDetailInfo;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;

import org.json.JSONObject;

public class DkStoreFictionDetail extends DkStoreItemDetail {
    private final DkStoreFiction mBook;
    private final DkStoreFictionCategory[] mCategories;
    private DkCloudFictionChapter[] mChapters;
    private final DkStoreFictionDetailInfo mDetailInfo;

    public DkStoreFictionDetail(JSONObject jSONObject) {
        this(v.b(jSONObject));
    }

    public DkStoreFictionDetail(DkStoreFictionDetailInfo dkStoreFictionDetailInfo) {
        this(new DkStoreFiction(dkStoreFictionDetailInfo.mFictionInfo), dkStoreFictionDetailInfo);
    }

    public DkStoreFictionDetail(DkStoreFiction dkStoreFiction, DkStoreFictionDetailInfo dkStoreFictionDetailInfo) {
        int i = 0;
        this.mChapters = new DkCloudFictionChapter[0];
        this.mBook = dkStoreFiction;
        this.mDetailInfo = dkStoreFictionDetailInfo;
        if (this.mDetailInfo.mChapterInfo != null) {
            this.mChapters = new DkCloudFictionChapter[this.mDetailInfo.mChapterInfo.length];
            boolean isFree = this.mBook.isFree();
            for (int i2 = 0; i2 < this.mDetailInfo.mChapterInfo.length; i2++) {
                this.mChapters[i2] = new DkCloudFictionChapter(this.mDetailInfo.mChapterInfo[i2], isFree);
            }
        }
        if (dkStoreFictionDetailInfo.mCategories != null) {
            this.mCategories = new DkStoreFictionCategory[dkStoreFictionDetailInfo.mCategories.length];
            while (i < dkStoreFictionDetailInfo.mCategories.length) {
                this.mCategories[i] = new DkStoreFictionCategory(dkStoreFictionDetailInfo.mCategories[i]);
                i++;
            }
            return;
        }
        this.mCategories = new DkStoreFictionCategory[0];
    }

    public DkStoreFiction getFiction() {
        return this.mBook;
    }

    public String getFeeDescription() {
        return this.mDetailInfo.mFeeDesc;
    }

    public int getFeeMode() {
        return this.mDetailInfo.mFeeMode;
    }

    public String getSummary() {
        return this.mDetailInfo.mSummary;
    }

    public DkCloudFictionChapter[] getToc() {
        return this.mChapters;
    }

    public void setToc(DkCloudFictionChapter[] dkCloudFictionChapterArr) {
        this.mChapters = dkCloudFictionChapterArr;
    }

    public DkCloudFictionChapter findChapter(String str) {
        int i = 1;
        if (this.mChapters.length < 1) {
            return null;
        }
        DkCloudFictionChapter dkCloudFictionChapter;
        int max;
        try {
            Integer valueOf = Integer.valueOf(str);
            if (valueOf != null && valueOf.intValue() >= 0 && valueOf.intValue() < this.mChapters.length) {
                dkCloudFictionChapter = this.mChapters[valueOf.intValue()];
                if (TextUtils.equals(dkCloudFictionChapter.getCloudId(), str)) {
                    return dkCloudFictionChapter;
                }
                max = Math.max(valueOf.intValue(), (this.mChapters.length - 1) - valueOf.intValue());
                while (i <= max) {
                    if (valueOf.intValue() - i >= 0) {
                        dkCloudFictionChapter = this.mChapters[valueOf.intValue() - i];
                        if (TextUtils.equals(dkCloudFictionChapter.getCloudId(), str)) {
                            return dkCloudFictionChapter;
                        }
                    }
                    if (valueOf.intValue() + i < this.mChapters.length) {
                        dkCloudFictionChapter = this.mChapters[valueOf.intValue() + i];
                        if (TextUtils.equals(dkCloudFictionChapter.getCloudId(), str)) {
                            return dkCloudFictionChapter;
                        }
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
        }
        for (DkCloudFictionChapter dkCloudFictionChapter2 : this.mChapters) {
            if (TextUtils.equals(dkCloudFictionChapter2.getCloudId(), str)) {
                return dkCloudFictionChapter2;
            }
        }
        return null;
    }

    public boolean hasToc() {
        return this.mChapters.length > 0;
    }

    public String getCopyright() {
        return this.mDetailInfo.mRights;
    }

    public String getCopyrightId() {
        return this.mDetailInfo.mRightId;
    }

    public DkStoreFictionCategory[] getCategories() {
        return this.mCategories;
    }

    public boolean allowFreeRead() {
        return this.mDetailInfo.mAllowFreeRead;
    }

    public DkStoreAbsBookInfo[] getUserRelatedBooks() {
        return this.mDetailInfo.mRelatedInfo;
    }

    public String[] getAuthorIds() {
        return this.mBook.getAuthorIds();
    }
}
