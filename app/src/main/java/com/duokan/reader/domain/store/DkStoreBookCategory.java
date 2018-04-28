package com.duokan.reader.domain.store;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.DkStoreBookCategoryInfo;
import java.util.ArrayList;
import java.util.List;

public class DkStoreBookCategory extends DkStoreCategory {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkStoreBookCategory.class.desiredAssertionStatus());
    private final DkStoreBookCategoryInfo mCategoryInfo;

    protected DkStoreBookCategory(DkStoreBookCategoryInfo dkStoreBookCategoryInfo) {
        if ($assertionsDisabled || dkStoreBookCategoryInfo != null) {
            this.mCategoryInfo = dkStoreBookCategoryInfo;
            return;
        }
        throw new AssertionError();
    }

    public String getCategoryId() {
        return this.mCategoryInfo.mCategoryId;
    }

    public String getLabel() {
        return this.mCategoryInfo.mLabel;
    }

    public String getDescription() {
        return this.mCategoryInfo.mDescription;
    }

    public String getCoverUri() {
        return this.mCategoryInfo.mCoverUri;
    }

    public String getBookTitles() {
        return this.mCategoryInfo.mBookTitles;
    }

    public int getBookCount() {
        return this.mCategoryInfo.mBookCount;
    }

    public String getTitles() {
        return this.mCategoryInfo.mBookTitles;
    }

    public DkStoreCategory[] getChildBookCategories() {
        if (this.mCategoryInfo.mChildCategoryInfos == null) {
            return new DkStoreBookCategory[0];
        }
        List arrayList = new ArrayList();
        for (DkStoreBookCategoryInfo dkStoreBookCategory : this.mCategoryInfo.mChildCategoryInfos) {
            arrayList.add(new DkStoreBookCategory(dkStoreBookCategory));
        }
        return (DkStoreCategory[]) arrayList.toArray(new DkStoreBookCategory[0]);
    }

    public String getChildCategoriesLabel() {
        if (this.mCategoryInfo.mChildCategoryInfos == null || this.mCategoryInfo.mChildCategoryInfos.length == 0) {
            return "";
        }
        List arrayList = new ArrayList();
        for (DkStoreBookCategoryInfo dkStoreBookCategoryInfo : this.mCategoryInfo.mChildCategoryInfos) {
            arrayList.add(dkStoreBookCategoryInfo.mLabel);
        }
        return TextUtils.join(" / ", arrayList.toArray(new String[0]));
    }

    public String getImageUri() {
        return this.mCategoryInfo.mImage;
    }
}
