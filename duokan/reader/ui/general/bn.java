package com.duokan.reader.ui.general;

import com.duokan.reader.ui.general.DkWebListView.ListState;

/* synthetic */ class bn {
    static final /* synthetic */ int[] a = new int[ListState.values().length];

    static {
        try {
            a[ListState.UNKNOWN.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[ListState.FIRST_LOADING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[ListState.EMPTY.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[ListState.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
