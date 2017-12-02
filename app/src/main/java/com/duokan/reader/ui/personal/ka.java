package com.duokan.reader.ui.personal;

import com.duokan.reader.ui.store.DkCloudBookStatusHelper.StoreBookStatus;

/* synthetic */ class ka {
    static final /* synthetic */ int[] a = new int[StoreBookStatus.values().length];

    static {
        try {
            a[StoreBookStatus.UPDATE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[StoreBookStatus.DOWNLOAD.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[StoreBookStatus.DOWNLOADING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[StoreBookStatus.ORDER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[StoreBookStatus.TRADING.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[StoreBookStatus.NORMAL.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
