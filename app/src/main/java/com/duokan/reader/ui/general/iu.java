package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.duokan.core.ui.cg;

public class iu extends cw {
    private ix a;
    private cg b;
    private cx c;

    public iu(Context context) {
        this(context, null);
    }

    public iu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        super.setOnScrollListener(new iv(this));
        super.setOnFlipListener(new iw(this));
    }

    public void setTabListener(ix ixVar) {
        this.a = ixVar;
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            super.addView(new iy(this, getContext(), view), layoutParams);
        } else {
            super.addView(view, layoutParams);
        }
    }

    public void setOnFlipListener(cx cxVar) {
        this.c = cxVar;
    }

    public void setOnScrollListener(cg cgVar) {
        this.b = cgVar;
    }
}
