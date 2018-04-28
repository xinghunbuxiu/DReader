package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.ui.general.p052a.C1317a;

public class mm extends FrameLayout {
    public mm(Context context) {
        super(context);
    }

    public void setMultiCallout(aj ajVar) {
        for (int i = 0; i < ajVar.mo1415a(); i++) {
            View xxVar = new xx(getContext(), ajVar.mo1416a(i).m6434f());
            int b = dv.m1932b(getContext(), 10.0f);
            xxVar.setPadding(b, b, b, b);
            xxVar.setTextSize(dv.m1932b(getContext(), 18.0f));
            xxVar.setVisibility(4);
            addView(xxVar, new LayoutParams(-1, -2, 80));
        }
    }

    /* renamed from: a */
    public void m14661a(int i) {
        int i2;
        if (i == -1) {
            for (i2 = 0; i2 < getChildCount(); i2++) {
                if (getChildAt(i2).getVisibility() == 0) {
                    View childAt = getChildAt(i2);
                    C1317a.m10194a(childAt, 0.0f, 0.0f, 0.0f, (float) childAt.getHeight(), 300, Boolean.valueOf(false), new mn(this, childAt));
                }
            }
            return;
        }
        for (i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2).getVisibility() == 0) {
                getChildAt(i2).setVisibility(4);
            }
        }
        if (i >= 0 && i < getChildCount()) {
            childAt = getChildAt(i);
            childAt.setVisibility(0);
            C1317a.m10194a(childAt, 0.0f, 0.0f, (float) childAt.getHeight(), 0.0f, 300, Boolean.valueOf(false), null);
        }
    }
}
