package com.duokan.reader.domain.plugins.dict;

/* synthetic */ class g {
    static final /* synthetic */ int[] a = new int[DictDownloadState.values().length];

    static {
        try {
            a[DictDownloadState.RUNNING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[DictDownloadState.PAUSED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[DictDownloadState.DOWNLOADED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[DictDownloadState.FRESH.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
