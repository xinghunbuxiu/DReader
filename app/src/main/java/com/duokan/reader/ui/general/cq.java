package com.duokan.reader.ui.general;

import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import com.duokan.reader.ui.general.PagesView.PageLayout;

/* synthetic */ class cq {
    static final /* synthetic */ int[] a = new int[PageScaleType.values().length];
    static final /* synthetic */ int[] b = new int[PageLayout.values().length];

    static {
        try {
            b[PageLayout.TOP_TO_BOTTOM.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[PageLayout.LEFT_TO_RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[PageScaleType.MATCH_WIDTH.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[PageScaleType.MATCH_INSIDE.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
    }
}
