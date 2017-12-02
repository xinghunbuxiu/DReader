package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;

import java.text.Collator;

public abstract class DkCloudStoreBook extends DkCloudBook {
    protected static final String[][] FALLBACK_LABELS;

    public abstract String getAuthorLine();

    public abstract DkStoreBookSourceType getBookSourceType();

    public abstract String getCoverUri();

    public abstract String getEditorLine();

    public abstract String[][] getLabels();

    public abstract long getPurchaseTimeInSeconds();

    protected abstract long getUpdateTimeInSeconds();

    static {
        String[][] strArr = new String[1][];
        strArr[0] = new String[]{"其他", ""};
        FALLBACK_LABELS = strArr;
    }

    protected DkCloudStoreBook(String str) {
        super(str);
    }

    protected DkCloudStoreBook(DkCloudStoreBook dkCloudStoreBook) {
        super((DkCloudBook) dkCloudStoreBook);
    }

    protected int labelLevels(String[] strArr) {
        int i = 0;
        if (strArr == null) {
            return 0;
        }
        while (i < strArr.length) {
            if (strArr[i] == null) {
                return i;
            }
            i++;
        }
        return strArr.length;
    }

    public int comparePurchaseTimeTo(DkCloudStoreBook dkCloudStoreBook) {
        if (getPurchaseTimeInSeconds() < dkCloudStoreBook.getPurchaseTimeInSeconds()) {
            return -1;
        }
        if (getPurchaseTimeInSeconds() > dkCloudStoreBook.getPurchaseTimeInSeconds()) {
            return 1;
        }
        if (TextUtils.equals(getBookUuid(), dkCloudStoreBook.getBookUuid())) {
            return 0;
        }
        if (getBookUuid().compareTo(dkCloudStoreBook.getBookUuid()) >= 0) {
            return 1;
        }
        return -1;
    }

    public int compareUpdateTimeTo(DkCloudStoreBook dkCloudStoreBook) {
        if (getUpdateTimeInSeconds() < dkCloudStoreBook.getUpdateTimeInSeconds()) {
            return -1;
        }
        if (getUpdateTimeInSeconds() > dkCloudStoreBook.getUpdateTimeInSeconds()) {
            return 1;
        }
        if (TextUtils.equals(getBookUuid(), dkCloudStoreBook.getBookUuid())) {
            return 0;
        }
        if (getBookUuid().compareTo(dkCloudStoreBook.getBookUuid()) >= 0) {
            return 1;
        }
        return -1;
    }

    public int compareNameTo(Collator collator, DkCloudStoreBook dkCloudStoreBook) {
        int compare = collator.compare(getTitle(), dkCloudStoreBook.getTitle());
        if (compare < 0) {
            return -1;
        }
        if (compare > 0) {
            return 1;
        }
        if (TextUtils.equals(getBookUuid(), dkCloudStoreBook.getBookUuid())) {
            return 0;
        }
        if (getBookUuid().compareTo(dkCloudStoreBook.getBookUuid()) >= 0) {
            return 1;
        }
        return -1;
    }
}
