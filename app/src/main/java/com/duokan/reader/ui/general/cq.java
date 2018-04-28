package com.duokan.reader.ui.general;

import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import com.duokan.reader.ui.general.PagesView.PageLayout;

/* synthetic */ class cq {
    /* renamed from: a */
    static final /* synthetic */ int[] f7042a = new int[PageScaleType.values().length];
    /* renamed from: b */
    static final /* synthetic */ int[] f7043b = new int[PageLayout.values().length];

    static {
        try {
            f7043b[PageLayout.TOP_TO_BOTTOM.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f7043b[PageLayout.LEFT_TO_RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f7042a[PageScaleType.MATCH_WIDTH.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f7042a[PageScaleType.MATCH_INSIDE.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
    }
}
