package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;

/* synthetic */ class x {
    static final /* synthetic */ int[] a = new int[ConflictStrategy.values().length];

    static {
        try {
            a[ConflictStrategy.TAKE_SERVER_VERSION.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[ConflictStrategy.TAKE_LOCAL_VERSION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
