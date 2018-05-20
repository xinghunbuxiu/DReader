package com.duokan.reader.ui.reading;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.duokan.common.CommonUtils;
import com.duokan.p024c.C0252d;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.az;
import com.duokan.reader.ui.general.DkTextView;

public class age implements bb {
    /* renamed from: a */
    private final su f9718a;
    /* renamed from: b */
    private agc f9719b = null;
    /* renamed from: c */
    private Activity f9720c = null;
    /* renamed from: d */
    private C0798a f9721d;
    /* renamed from: e */
    private adi f9722e;
    /* renamed from: f */
    private agg f9723f;

    public age(Activity activity, su suVar, Runnable runnable) {
        this.f9720c = activity;
        this.f9718a = suVar;
        this.f9723f = new agg();
        this.f9719b = new agc(this.f9720c, this.f9723f, suVar);
        this.f9719b.setCancelOnTouchOutside(true);
        this.f9719b.m13665a(runnable);
    }

    /* renamed from: a */
    public void m13673a(C0798a c0798a, Rect rect, adi adi) {
        this.f9721d = c0798a;
        this.f9722e = adi;
        m13672a(rect, ((ea) c0798a).m4384m(), true);
    }

    /* renamed from: a */
    public void mo2262a(Rect rect, ab abVar) {
        if (!m13674a()) {
            if (abVar.mo1380b() == null) {
                m13672a(rect, abVar.mo1379a(), false);
            } else {
                m13671a(rect, abVar.mo1380b());
            }
        }
    }

    /* renamed from: a */
    public void m13671a(Rect rect, az azVar) {
        View xxVar = new xx(this.f9720c, azVar);
        xxVar.setTextSize(this.f9718a.mo1988C());
        xxVar.setTextColor(this.f9720c.getResources().getColor(C0252d.reading__shared__note_background));
        xxVar.setOnClickListener(this.f9723f);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f9720c.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int min = Math.min(displayMetrics.widthPixels - CommonUtils.dip2px(this.f9720c, 60.0f), CommonUtils.dip2px(this.f9720c, 320.0f));
        xxVar.setMaxWidth(min);
        xxVar.measure(MeasureSpec.makeMeasureSpec(min, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.f9719b.m13664a(xxVar, xxVar.getMeasuredWidth(), xxVar.getMeasuredHeight(), true);
        this.f9719b.m13663a(rect);
    }

    /* renamed from: a */
    public void m13672a(Rect rect, String str, boolean z) {
        View dkTextView = new DkTextView(this.f9720c);
        if (!z) {
            dkTextView.setChsToChtChars(this.f9718a.ae().m12455P());
        }
        dkTextView.setTextPixelSize(this.f9718a.mo1988C());
        dkTextView.setText(str);
        dkTextView.setGravity(119);
        dkTextView.setTextColor(this.f9720c.getResources().getColor(C0252d.reading__shared__note_background));
        dkTextView.setOnClickListener(this.f9723f);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f9720c.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        dkTextView.measure(MeasureSpec.makeMeasureSpec(Math.min(displayMetrics.widthPixels - CommonUtils.dip2px(this.f9720c, 60.0f), CommonUtils.dip2px(this.f9720c, 320.0f)), 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.f9719b.m13664a(dkTextView, dkTextView.getMeasuredWidth(), dkTextView.getMeasuredHeight(), true);
        this.f9719b.m13663a(rect);
    }

    /* renamed from: a */
    public boolean m13674a() {
        return this.f9719b.isShowing();
    }
}
