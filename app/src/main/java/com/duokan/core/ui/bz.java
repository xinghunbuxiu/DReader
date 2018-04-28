package com.duokan.core.ui;

import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;

/* synthetic */ class bz {
    /* renamed from: a */
    static final /* synthetic */ int[] f1062a = new int[RefreshState.values().length];

    static {
        try {
            f1062a[RefreshState.NO_REFRESH.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1062a[RefreshState.DOWN_TO_REFRESH.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1062a[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1062a[RefreshState.REFRESHING.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1062a[RefreshState.REFRESH_DONE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
