package com.duokan.reader.ui.reading;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.duokan.p023b.C0242d;
import com.duokan.reader.ui.general.DkLabelView;

class mw extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ mr f10649a;
    /* renamed from: b */
    private DkLabelView f10650b;
    /* renamed from: c */
    private ImageView f10651c;

    public mw(mr mrVar, Context context) {
        this.f10649a = mrVar;
        super(context);
    }

    /* renamed from: a */
    public void m14682a(String str) {
        m14680b().setText(str);
    }

    /* renamed from: a */
    public void m14681a(int i) {
        m14680b().setTextColor(i);
    }

    /* renamed from: b */
    public void m14684b(int i) {
        m14679a().setImageResource(i);
    }

    /* renamed from: a */
    public void m14683a(boolean z) {
        m14679a().setAdjustViewBounds(z);
    }

    /* renamed from: a */
    private ImageView m14679a() {
        if (this.f10651c == null) {
            this.f10651c = new ImageView(getContext());
            this.f10651c.setScaleType(ScaleType.FIT_CENTER);
            m14679a().setAdjustViewBounds(true);
            addView(this.f10651c, new LayoutParams(-2, -1, 17));
        }
        return this.f10651c;
    }

    /* renamed from: b */
    private DkLabelView m14680b() {
        if (this.f10650b == null) {
            this.f10650b = new DkLabelView(getContext());
            this.f10650b.setTextSize(0, getResources().getDimension(C0242d.general_font__shared__e));
            this.f10650b.setTextColor(-16777216);
            this.f10650b.setGravity(17);
            addView(this.f10650b, new LayoutParams(-2, -1, 17));
        }
        return this.f10650b;
    }
}
