package com.duokan.reader.ui.general;

import com.duokan.reader.ui.general.DkWebListView.ListState;

/* synthetic */ class bn {
    /* renamed from: a */
    static final /* synthetic */ int[] f7003a = new int[ListState.values().length];

    static {
        try {
            f7003a[ListState.UNKNOWN.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f7003a[ListState.FIRST_LOADING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f7003a[ListState.EMPTY.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f7003a[ListState.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
