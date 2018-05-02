package com.duokan.core.ui;

import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;

/* synthetic */ class bz {
    static final /* synthetic */ int[] a = new int[RefreshState.values().length];

    static {
        try {
            a[RefreshState.NO_REFRESH.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[RefreshState.DOWN_TO_REFRESH.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[RefreshState.REFRESHING.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[RefreshState.REFRESH_DONE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
