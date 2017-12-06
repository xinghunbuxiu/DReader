package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.duokan.b.c;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.ITheme;

public class eh {
    public static void a(DkWebListView dkWebListView) {
        Context context = dkWebListView.getContext();
        dkWebListView.setRowDivider(b(context));
        dkWebListView.setColumnDivider(a(context));
        dkWebListView.setRowBackground(c(context));
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(context).queryFeature(ITheme.class);
        if (sVar != null) {
            dkWebListView.a(dkWebListView.getListPaddingLeft(), dkWebListView.getListPaddingTop(), dkWebListView.getListPaddingRight(), sVar.getTheme().getPagePaddingBottom());
        }
    }

    public static void a(HatGridView hatGridView) {
        Context context = hatGridView.getContext();
        hatGridView.setRowDivider(b(context));
        hatGridView.setColumnDivider(a(context));
        hatGridView.setRowBackground(c(context));
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(context).queryFeature(ITheme.class);
        if (sVar != null) {
            hatGridView.b(0, 0, 0, sVar.getTheme().getPagePaddingBottom());
        }
    }

    public static int a(Context context, int i) {
        return a(context, i, UTools.getMinimumHeight(context, 380.0f));
    }

    public static int a(Context context, int i, int i2) {
        return ReaderEnv.get().forHd() ? Math.max(i / i2, 1) : 1;
    }

    public static Drawable a(Context context) {
        Drawable jmVar = new jm(context.getResources().getColor(c.general__shared__bcbcbc));
        jmVar.a(1);
        return jmVar;
    }

    public static Drawable b(Context context) {
        Drawable dkVar = new dk(context.getResources().getColor(c.general__shared__bcbcbc));
        dkVar.a(1);
        return dkVar;
    }

    public static Drawable c(Context context) {
        if (ReaderEnv.get().forHd()) {
            return new ei(context);
        }
        return new ColorDrawable(context.getResources().getColor(c.general__shared__ffffff));
    }

    public static Drawable a(Context context, DkListView dkListView, int i) {
        if (ReaderEnv.get().forHd()) {
            return new ej(context, dkListView, i);
        }
        return new ColorDrawable(context.getResources().getColor(c.general__shared__f7f7f7));
    }

    public static Drawable a(Context context, HatGridView hatGridView, int i) {
        if (ReaderEnv.get().forHd()) {
            return new ek(context, hatGridView, i);
        }
        return new ColorDrawable(context.getResources().getColor(c.general__shared__f7f7f7));
    }
}
