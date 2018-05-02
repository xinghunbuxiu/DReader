package com.duokan.reader.domain.store;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.duokan.DkStoreFictionCategoryInfo;

import java.util.ArrayList;
import java.util.List;

public class DkStoreFictionCategory extends DkStoreCategory {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkStoreFictionCategory.class.desiredAssertionStatus());
    private final DkStoreFictionCategoryInfo mCategoryInfo;

    protected DkStoreFictionCategory(DkStoreFictionCategoryInfo dkStoreFictionCategoryInfo) {
        if ($assertionsDisabled || dkStoreFictionCategoryInfo != null) {
            this.mCategoryInfo = dkStoreFictionCategoryInfo;
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

    public int getBookCount() {
        return this.mCategoryInfo.mFictionCount;
    }

    public String getCoverUri() {
        return this.mCategoryInfo.mCoverUri;
    }

    public String getTitles() {
        return this.mCategoryInfo.mDescription;
    }

    public DkStoreCategory[] getChildBookCategories() {
        if (this.mCategoryInfo.mChildCategoryInfos == null) {
            return new DkStoreFictionCategory[0];
        }
        List arrayList = new ArrayList();
        for (DkStoreFictionCategoryInfo dkStoreFictionCategory : this.mCategoryInfo.mChildCategoryInfos) {
            arrayList.add(new DkStoreFictionCategory(dkStoreFictionCategory));
        }
        return (DkStoreCategory[]) arrayList.toArray(new DkStoreFictionCategory[0]);
    }

    public String getChildCategoriesLabel() {
        if (this.mCategoryInfo.mChildCategoryInfos == null || this.mCategoryInfo.mChildCategoryInfos.length == 0) {
            return "";
        }
        List arrayList = new ArrayList();
        for (DkStoreFictionCategoryInfo dkStoreFictionCategoryInfo : this.mCategoryInfo.mChildCategoryInfos) {
            arrayList.add(dkStoreFictionCategoryInfo.mLabel);
        }
        return TextUtils.join(" / ", arrayList.toArray(new String[0]));
    }

    public String getImageUri() {
        return this.mCategoryInfo.mImage;
    }
}
