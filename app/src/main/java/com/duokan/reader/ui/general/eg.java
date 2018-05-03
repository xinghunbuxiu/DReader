package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0241c;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.C0435s;

public class eg {
    /* renamed from: a */
    public static void m10556a(DkWebListView dkWebListView) {
        Context context = dkWebListView.getContext();
        dkWebListView.setRowDivider(m10557b(context));
        dkWebListView.setColumnDivider(m10553a(context));
        dkWebListView.setRowBackground(m10558c(context));
        C0435s c0435s = (C0435s) AppContext.getAppContext(context).queryFeature(C0435s.class);
        if (c0435s != null) {
            dkWebListView.m9955a(dkWebListView.getListPaddingLeft(), dkWebListView.getListPaddingTop(), dkWebListView.getListPaddingRight(), c0435s.getTheme().getPagePaddingBottom());
        }
    }

    /* renamed from: a */
    public static void m10555a(HatGridView hatGridView) {
        Context context = hatGridView.getContext();
        hatGridView.setRowDivider(m10557b(context));
        hatGridView.setColumnDivider(m10553a(context));
        hatGridView.setRowBackground(m10558c(context));
        C0435s c0435s = (C0435s) AppContext.getAppContext(context).queryFeature(C0435s.class);
        if (c0435s != null) {
            hatGridView.m1250b(0, 0, 0, c0435s.getTheme().getPagePaddingBottom());
        }
    }

    /* renamed from: a */
    public static int m10551a(Context context, int i) {
        return m10552a(context, i, AnimUtils.m1932b(context, 380.0f));
    }

    /* renamed from: a */
    public static int m10552a(Context context, int i, int i2) {
        return ReaderEnv.get().forHd() ? Math.max(i / i2, 1) : 1;
    }

    /* renamed from: a */
    public static Drawable m10553a(Context context) {
        Drawable iwVar = new iw(context.getResources().getColor(C0241c.general__shared__bcbcbc));
        iwVar.m10815a(1);
        return iwVar;
    }

    /* renamed from: b */
    public static Drawable m10557b(Context context) {
        Drawable dkVar = new dk(context.getResources().getColor(C0241c.general__shared__bcbcbc));
        dkVar.m10476a(1);
        return dkVar;
    }

    /* renamed from: c */
    public static Drawable m10558c(Context context) {
        if (ReaderEnv.get().forHd()) {
            return new eh(context);
        }
        return new ColorDrawable(context.getResources().getColor(C0241c.general__shared__ffffff));
    }

    /* renamed from: a */
    public static Drawable m10554a(Context context, HatGridView hatGridView, int i) {
        if (ReaderEnv.get().forHd()) {
            return new ei(context, hatGridView, i);
        }
        return new ColorDrawable(context.getResources().getColor(C0241c.general__shared__f7f7f7));
    }
}
