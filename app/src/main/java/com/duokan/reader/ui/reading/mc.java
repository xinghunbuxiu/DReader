package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.ui.general.a.a;

public class mc extends FrameLayout {
    public mc(Context context) {
        super(context);
    }

    public void setMultiCallout(aj ajVar) {
        for (int i = 0; i < ajVar.a(); i++) {
            View xkVar = new xk(getContext(), ajVar.a(i).f());
            int b = UTools.closeAnimation(getContext(), 10.0f);
            xkVar.setPadding(b, b, b, b);
            xkVar.setTextSize(UTools.closeAnimation(getContext(), 18.0f));
            xkVar.setVisibility(4);
            addView(xkVar, new LayoutParams(-1, -2, 80));
        }
    }

    public void a(int i) {
        int i2;
        if (i == -1) {
            for (i2 = 0; i2 < getChildCount(); i2++) {
                if (getChildAt(i2).getVisibility() == 0) {
                    View childAt = getChildAt(i2);
                    a.a(childAt, 0.0f, 0.0f, 0.0f, (float) childAt.getHeight(), 300, Boolean.valueOf(false), new md(this, childAt));
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
            a.a(childAt, 0.0f, 0.0f, (float) childAt.getHeight(), 0.0f, 300, Boolean.valueOf(false), null);
        }
    }
}
