package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.C0343f;

public class hp extends C0343f {
    /* renamed from: a */
    private dq f6537a = ho.m10751a(this);
    /* renamed from: b */
    private hq f6538b;

    public hp(Context context) {
        super(context);
        this.f6537a.mo1785a(true);
    }

    /* renamed from: a */
    public void m9768a(String str) {
        this.f6537a.mo1784a(str);
    }

    /* renamed from: a */
    public void m9765a(int i) {
        m9768a(getContext().getResources().getString(i));
    }

    /* renamed from: b */
    public void m9769b(int i) {
        m9770b(getContext().getString(i));
    }

    /* renamed from: b */
    public void m9770b(String str) {
        m9766a(m9763a(str, this.f6537a.mo1783a().getChildCount() != 0));
    }

    /* renamed from: a */
    public void m9766a(View view) {
        view.setOnClickListener(new hr(this, this.f6537a.mo1787c()));
        this.f6537a.mo1786b().setVisibility(8);
        this.f6537a.mo1783a().addView(view, new LayoutParams(-1, -2));
    }

    /* renamed from: a */
    public void m9767a(hq hqVar) {
        this.f6538b = hqVar;
    }

    /* renamed from: a */
    private View m9763a(String str, boolean z) {
        return this.f6537a.mo1782a(str, 0, z);
    }
}
