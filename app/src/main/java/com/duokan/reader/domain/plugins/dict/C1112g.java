package com.duokan.reader.domain.plugins.dict;

/* renamed from: com.duokan.reader.domain.plugins.dict.g */
/* synthetic */ class C1112g {
    /* renamed from: a */
    static final /* synthetic */ int[] f5397a = new int[DictDownloadState.values().length];

    static {
        try {
            f5397a[DictDownloadState.RUNNING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5397a[DictDownloadState.PAUSED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5397a[DictDownloadState.DOWNLOADED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5397a[DictDownloadState.FRESH.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
