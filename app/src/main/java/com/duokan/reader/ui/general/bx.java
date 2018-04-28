package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.C0343f;
import com.duokan.reader.DkApp;

public class bx extends C0343f {
    /* renamed from: a */
    private final dq f7012a;
    /* renamed from: b */
    private hq f7013b;

    public bx(Context context) {
        super(context);
        if (DkApp.get().forHd()) {
            this.f7012a = new fg(this);
        } else {
            this.f7012a = new gh(this);
        }
    }

    public bx(Context context, boolean z) {
        super(context);
        if (z) {
            this.f7012a = new fg(this);
        } else if (DkApp.get().forHd()) {
            this.f7012a = new fg(this);
        } else {
            this.f7012a = new gh(this);
        }
    }

    /* renamed from: a */
    public void m10321a(Rect rect) {
        if (this.f7012a instanceof fg) {
            ((fg) this.f7012a).m10640a(rect);
        } else {
            show();
        }
    }

    /* renamed from: a */
    public void m10322a(View view) {
        if (this.f7012a instanceof fg) {
            ((fg) this.f7012a).m10641a(view);
        } else {
            show();
        }
    }

    /* renamed from: a */
    public final int m10320a(String str) {
        int childCount = this.f7012a.mo1783a().getChildCount();
        View a = m10318a(str, childCount != 0);
        a.setOnClickListener(new by(this, childCount));
        this.f7012a.mo1783a().addView(a, childCount, new LayoutParams(-1, -2));
        return childCount;
    }

    /* renamed from: a */
    public void m10323a(hq hqVar) {
        this.f7013b = hqVar;
    }

    /* renamed from: a */
    private View m10318a(String str, boolean z) {
        return this.f7012a.mo1782a(str, 0, z);
    }
}
