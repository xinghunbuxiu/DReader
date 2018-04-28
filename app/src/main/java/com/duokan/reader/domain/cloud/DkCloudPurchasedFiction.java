package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.core.sys.af;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedFictionInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DkCloudPurchasedFiction extends DkCloudStoreBook {
    private boolean mIsFullData;
    private String[][] mLabels;
    private final DkCloudPurchasedFictionInfo mOrderInfo;

    protected DkCloudPurchasedFiction(DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo, boolean z) {
        super(dkCloudPurchasedFictionInfo.mBookUuid);
        this.mLabels = (String[][]) null;
        this.mOrderInfo = dkCloudPurchasedFictionInfo;
        this.mOrderInfo.mIsHide = z;
        this.mIsFullData = true;
    }

    protected DkCloudPurchasedFiction(C0846f c0846f) {
        super(c0846f.f3967a);
        this.mLabels = (String[][]) null;
        this.mOrderInfo = new DkCloudPurchasedFictionInfo();
        this.mOrderInfo.mBookUuid = c0846f.f3967a;
        this.mOrderInfo.mTitle = c0846f.f3968b;
        this.mOrderInfo.mAuthors = c0846f.f3969c;
        this.mOrderInfo.mEditors = c0846f.f3970d;
        this.mOrderInfo.setPurchaseTimeInSeconds(c0846f.f3971e);
        this.mOrderInfo.mCoverUri = c0846f.f3972f;
        this.mOrderInfo.mIsHide = c0846f.f3973g;
        this.mIsFullData = false;
    }

    protected DkCloudPurchasedFiction(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        super((DkCloudStoreBook) dkCloudPurchasedFiction);
        this.mLabels = (String[][]) null;
        this.mOrderInfo = new DkCloudPurchasedFictionInfo(dkCloudPurchasedFiction.mOrderInfo);
        this.mLabels = dkCloudPurchasedFiction.mLabels;
        this.mIsFullData = dkCloudPurchasedFiction.mIsFullData;
    }

    public List<String> getNotPurchasedChapterIds() {
        return this.mOrderInfo.mNotPurchasedChapterIds;
    }

    public List<String> getPurchasedChapterIds() {
        return this.mOrderInfo.mPurchasedChapterIds;
    }

    public af<Boolean> checkChapterPurchased(String str) {
        if (!this.mIsFullData) {
            return new af();
        }
        if (this.mOrderInfo.mPaidChapterId.length > 0) {
            for (CharSequence equals : this.mOrderInfo.mPaidChapterId) {
                if (TextUtils.equals(str, equals)) {
                    return new af(Boolean.valueOf(true));
                }
            }
            return new af(Boolean.valueOf(false));
        } else if (this.mOrderInfo.mPurchasedChapterIds.contains(str)) {
            return new af(Boolean.valueOf(true));
        } else {
            if (this.mOrderInfo.mNotPurchasedChapterIds.contains(str)) {
                return new af(Boolean.valueOf(false));
            }
            return new af();
        }
    }

    public void setHidden(boolean z) {
        this.mOrderInfo.mIsHide = z;
    }

    public boolean isHidden() {
        return this.mOrderInfo.mIsHide;
    }

    public boolean isFullData() {
        return this.mIsFullData;
    }

    public boolean isVerticalComic() {
        return TextUtils.equals(this.mOrderInfo.mTypeId, "10000006");
    }

    public String getTitle() {
        return this.mOrderInfo.mTitle;
    }

    public String getLatestChapterTitle() {
        return this.mOrderInfo.mLatest;
    }

    public String getLatestChapterId() {
        return this.mOrderInfo.mLatest;
    }

    public boolean isFinish() {
        return this.mOrderInfo.mFinish;
    }

    public int getChapterCount() {
        return this.mOrderInfo.mChapterCount;
    }

    public String[] getPaidChaptersId() {
        return this.mOrderInfo.mPaidChapterId;
    }

    public long getPurchaseTimeInSeconds() {
        return this.mOrderInfo.getPurchaseTimeInSeconds();
    }

    protected long getUpdateTimeInSeconds() {
        return getPurchaseTimeInSeconds();
    }

    public String[] getAuthors() {
        return this.mOrderInfo.mAuthors;
    }

    public void addPurchasedChapterIds(List<String> list) {
        if (!list.isEmpty()) {
            HashSet hashSet = new HashSet(Arrays.asList(this.mOrderInfo.mPaidChapterId));
            if (hashSet.addAll(list)) {
                this.mOrderInfo.mPaidChapterId = (String[]) hashSet.toArray(new String[0]);
            }
        }
    }

    public String[] getEditors() {
        return this.mOrderInfo.mEditors;
    }

    public String getAuthorLine() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.mOrderInfo.mAuthors) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public boolean isEntirePaid() {
        return this.mOrderInfo.mEntire;
    }

    public String getEditorLine() {
        return null;
    }

    public String getCoverUri() {
        return this.mOrderInfo.mCoverUri;
    }

    public DkStoreBookSourceType getBookSourceType() {
        return DkStoreBookSourceType.NORMAL;
    }

    public String[][] getLabels() {
        if (this.mLabels == null) {
            if (this.mOrderInfo.mLabels == null || this.mOrderInfo.mLabels.length < 1) {
                this.mLabels = FALLBACK_LABELS;
            } else {
                int i;
                int i2 = 0;
                for (String[] labelLevels : this.mOrderInfo.mLabels) {
                    i2 = Math.max(labelLevels(labelLevels), i2);
                }
                if (i2 == 0) {
                    this.mLabels = FALLBACK_LABELS;
                } else {
                    for (i = 0; i < this.mOrderInfo.mLabels.length; i++) {
                        if (labelLevels(this.mOrderInfo.mLabels[i]) == 1) {
                            this.mOrderInfo.mLabels[i] = new String[]{this.mOrderInfo.mLabels[i][0], ""};
                        }
                    }
                }
                this.mLabels = this.mOrderInfo.mLabels;
            }
        }
        return this.mLabels;
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        try {
            DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) dkCloudItem;
            if (!dkCloudPurchasedFiction.isEntirePaid() || this.mOrderInfo.mEntire == dkCloudPurchasedFiction.isEntirePaid()) {
                Collection linkedList = new LinkedList();
                HashSet hashSet = new HashSet(Arrays.asList(this.mOrderInfo.mPaidChapterId));
                for (Object obj : dkCloudPurchasedFiction.getPaidChaptersId()) {
                    if (!hashSet.contains(obj)) {
                        linkedList.add(obj);
                    }
                }
                DkCloudItem dkCloudPurchasedFiction2 = new DkCloudPurchasedFiction(this);
                dkCloudPurchasedFiction2.mOrderInfo.mEntire = dkCloudPurchasedFiction.isEntirePaid();
                dkCloudPurchasedFiction2.mOrderInfo.setPurchaseTimeInSeconds(dkCloudPurchasedFiction.getPurchaseTimeInSeconds());
                dkCloudPurchasedFiction2.mOrderInfo.mIsHide = dkCloudPurchasedFiction.isHidden();
                if (!linkedList.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.mOrderInfo.mPaidChapterId.length + linkedList.size());
                    arrayList.addAll(Arrays.asList(this.mOrderInfo.mPaidChapterId));
                    arrayList.addAll(linkedList);
                    dkCloudPurchasedFiction2.mOrderInfo.mPaidChapterId = (String[]) arrayList.toArray(new String[0]);
                }
                return dkCloudPurchasedFiction2;
            }
            DkCloudItem dkCloudPurchasedFiction3 = new DkCloudPurchasedFiction(this);
            dkCloudPurchasedFiction3.mOrderInfo.mEntire = true;
            dkCloudPurchasedFiction3.mOrderInfo.setPurchaseTimeInSeconds(dkCloudPurchasedFiction.getPurchaseTimeInSeconds());
            return dkCloudPurchasedFiction3;
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }
}
