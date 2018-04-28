package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.duokan.core.ui.cg;

public class ie extends cw {
    /* renamed from: a */
    private ih f7373a;
    /* renamed from: b */
    private cg f7374b;
    /* renamed from: c */
    private cx f7375c;

    public ie(Context context) {
        this(context, null);
    }

    public ie(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7374b = null;
        this.f7375c = null;
        super.setOnScrollListener(new C1337if(this));
        super.setOnFlipListener(new ig(this));
    }

    public void setTabListener(ih ihVar) {
        this.f7373a = ihVar;
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            super.addView(new ii(this, getContext(), view), layoutParams);
        } else {
            super.addView(view, layoutParams);
        }
    }

    public void setOnFlipListener(cx cxVar) {
        this.f7375c = cxVar;
    }

    public void setOnScrollListener(cg cgVar) {
        this.f7374b = cgVar;
    }
}
