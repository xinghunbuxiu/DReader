package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.DkAnnotationBookInfo;
import com.duokan.reader.common.webservices.duokan.DkAnnotationsInfo;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class DkCloudNotesInfo extends DkCloudJsonItem {
    private static Comparator<DkCloudNoteBookInfo> mComp = new C0843d();
    private final String mAccountLoginName;
    private final LinkedList<DkCloudNoteBookInfo> mNoteBookInfos;
    private int mNoteCount = 0;

    public DkCloudNotesInfo(String str, DkAnnotationsInfo dkAnnotationsInfo, DkCloudStoreBook[] dkCloudStoreBookArr, boolean z) {
        int i = 0;
        super(0);
        this.mAccountLoginName = str;
        this.mNoteBookInfos = new LinkedList();
        DkAnnotationBookInfo[] dkAnnotationBookInfoArr = dkAnnotationsInfo.mBookInfos;
        int length = dkAnnotationBookInfoArr.length;
        while (i < length) {
            DkAnnotationBookInfo dkAnnotationBookInfo = dkAnnotationBookInfoArr[i];
            if (dkAnnotationBookInfo.mCommentCount != 0 && (isPurchased(dkCloudStoreBookArr, dkAnnotationBookInfo.mBookUuid) ^ z) == 0) {
                this.mNoteBookInfos.add(new DkCloudNoteBookInfo(dkAnnotationBookInfo, z));
                this.mNoteCount = dkAnnotationBookInfo.mCommentCount + this.mNoteCount;
            }
            i++;
        }
        Collections.sort(this.mNoteBookInfos, mComp);
    }

    public int getNoteCount() {
        return this.mNoteCount;
    }

    public void setNoteCount(int i) {
        this.mNoteCount = i;
    }

    public LinkedList<DkCloudNoteBookInfo> getCloudNoteBookInfo() {
        return this.mNoteBookInfos;
    }

    public void append(DkCloudNotesInfo dkCloudNotesInfo) {
        this.mNoteCount += dkCloudNotesInfo.getNoteCount();
        this.mNoteBookInfos.addAll(dkCloudNotesInfo.getCloudNoteBookInfo());
        Collections.sort(this.mNoteBookInfos, mComp);
    }

    private boolean isPurchased(DkCloudStoreBook[] dkCloudStoreBookArr, String str) {
        if (dkCloudStoreBookArr == null) {
            return false;
        }
        for (DkCloudStoreBook bookUuid : dkCloudStoreBookArr) {
            if (TextUtils.equals(bookUuid.getBookUuid(), str)) {
                return true;
            }
        }
        return false;
    }

    public String getCloudId() {
        return this.mAccountLoginName;
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        return null;
    }
}
