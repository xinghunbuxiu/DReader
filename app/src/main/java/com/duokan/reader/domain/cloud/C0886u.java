package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;

/* renamed from: com.duokan.reader.domain.cloud.u */
/* synthetic */ class C0886u {
    /* renamed from: a */
    static final /* synthetic */ int[] f4195a = new int[ConflictStrategy.values().length];

    static {
        try {
            f4195a[ConflictStrategy.TAKE_SERVER_VERSION.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4195a[ConflictStrategy.TAKE_LOCAL_VERSION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
