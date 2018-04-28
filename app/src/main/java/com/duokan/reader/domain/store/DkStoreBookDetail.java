package com.duokan.reader.domain.store;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.DkStoreAbsBookInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreBookDetailInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreBookTocInfo;
import org.json.JSONObject;

public class DkStoreBookDetail extends DkStoreItemDetail {
    private static final String WEB_URL = "http://www.duokan.com/book/%s";
    private final DkStoreBook mBook;
    private final DkStoreBookCategory[] mCategories;
    private final DkStoreBookDetailInfo mDetailInfo;

    public DkStoreBookDetail(JSONObject jSONObject) {
        this(C0647u.m3009a(jSONObject));
    }

    public DkStoreBookDetail(DkStoreBookDetailInfo dkStoreBookDetailInfo) {
        this(new DkStoreBook(dkStoreBookDetailInfo.mBookInfo), dkStoreBookDetailInfo);
    }

    public DkStoreBookDetail(DkStoreBook dkStoreBook, DkStoreBookDetailInfo dkStoreBookDetailInfo) {
        int i = 0;
        this.mBook = dkStoreBook;
        this.mDetailInfo = dkStoreBookDetailInfo;
        if (this.mDetailInfo.mToc != null) {
            for (int i2 = 0; i2 < this.mDetailInfo.mToc.length; i2++) {
                if (!TextUtils.isEmpty(this.mDetailInfo.mToc[i2].mPreview)) {
                    this.mDetailInfo.mToc[i2].mPreview = this.mDetailInfo.mToc[i2].mPreview.replace("\r\r", "\r\n");
                }
            }
        }
        if (dkStoreBookDetailInfo.mCategories != null) {
            this.mCategories = new DkStoreBookCategory[dkStoreBookDetailInfo.mCategories.length];
            while (i < dkStoreBookDetailInfo.mCategories.length) {
                this.mCategories[i] = new DkStoreBookCategory(dkStoreBookDetailInfo.mCategories[i]);
                i++;
            }
            return;
        }
        this.mCategories = new DkStoreBookCategory[0];
    }

    public DkStoreBook getBook() {
        return this.mBook;
    }

    public String getSummary() {
        return this.mDetailInfo.mSummary;
    }

    public String getCopyright() {
        return this.mDetailInfo.mCopyright;
    }

    public String getCopyrightId() {
        return this.mDetailInfo.mCopyrightId;
    }

    public String getRevision() {
        return this.mDetailInfo.mRevision;
    }

    public String getUpdatedDate() {
        return this.mDetailInfo.mUpdatedDate;
    }

    public String getEpubUri() {
        return this.mDetailInfo.mEpubUri;
    }

    public long getEpubSize() {
        return this.mDetailInfo.mEpubSize;
    }

    public String getEpubMd5() {
        return this.mDetailInfo.mEpubMd5;
    }

    public String getTrialUri() {
        return this.mDetailInfo.mTrialUri;
    }

    public String getTrialMd5() {
        return this.mDetailInfo.mTrialMd5;
    }

    public String getOpfUri() {
        return this.mDetailInfo.mOpfUri;
    }

    public String[] getTranslators() {
        return this.mDetailInfo.mTranslators;
    }

    public String[] getIllustrators() {
        return this.mDetailInfo.mIllustrators;
    }

    public DkStoreBookTocInfo[] getToc() {
        return this.mDetailInfo.mToc;
    }

    public String getIdentifier() {
        return this.mDetailInfo.mIdentifier;
    }

    public String getIssued() {
        return this.mDetailInfo.mIssued;
    }

    public String getWebUrl() {
        return String.format(WEB_URL, new Object[]{this.mDetailInfo.mSid});
    }

    public long getWordCount() {
        return this.mDetailInfo.mWordCount;
    }

    public String getMinKernelVersion() {
        return this.mDetailInfo.mMinKernelVersion;
    }

    public boolean getHasAds() {
        return this.mDetailInfo.mHasAds;
    }

    public int getAdDuration() {
        return this.mDetailInfo.mAdDuration;
    }

    public int getAdTime() {
        return this.mDetailInfo.mAdTime;
    }

    public String[] getBookTags() {
        return this.mDetailInfo.mTags;
    }

    public boolean isHighQuality() {
        return this.mDetailInfo.mQuality >= 60;
    }

    public String[] getDistricts() {
        return this.mDetailInfo.mDistricts;
    }

    public String getPublisherId() {
        return this.mDetailInfo.mCopyrightId;
    }

    public DkStoreBookCategory[] getCategories() {
        return this.mCategories;
    }

    public boolean allowFreeRead() {
        return this.mDetailInfo.mAllowFreeRead;
    }

    public long getHighSize() {
        return this.mDetailInfo.mSize;
    }

    public long getLowSize() {
        return this.mDetailInfo.mSizeLowQuality;
    }

    public int[] getFeatures() {
        return this.mDetailInfo.mFeatures;
    }

    public boolean hasAnyFeatures(int... iArr) {
        if (iArr.length < 1) {
            return true;
        }
        for (int i : iArr) {
            for (int i2 : this.mDetailInfo.mFeatures) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public DkStoreAbsBookInfo[] getUserRelatedBooks() {
        return this.mDetailInfo.mRelatedBookInfoes;
    }

    public String[] getAuthorIds() {
        return this.mBook.getAuthorIds();
    }
}
