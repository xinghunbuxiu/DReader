package com.duokan.reader.ui.reading;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0252d;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.az;
import com.duokan.reader.ui.general.deprecatedDkTextView;

public class bg implements bb {
    /* renamed from: a */
    private final su f9830a;
    /* renamed from: b */
    private bd f9831b = null;
    /* renamed from: c */
    private Activity f9832c = null;
    /* renamed from: d */
    private final int f9833d;

    public bg(Activity activity, su suVar, Runnable runnable) {
        this.f9832c = activity;
        this.f9830a = suVar;
        this.f9831b = new bd(this.f9832c);
        this.f9831b.setCancelOnTouchOutside(false);
        this.f9831b.m13772a(runnable);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f9832c.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f9833d = displayMetrics.widthPixels - dv.m1932b(this.f9832c, 115.0f);
    }

    /* renamed from: a */
    public void mo2262a(Rect rect, ab abVar) {
        if (!m13776a()) {
            if (abVar.mo1380b() == null) {
                m13775a(rect, abVar.mo1379a(), false);
            } else {
                m13774a(rect, abVar.mo1380b());
            }
        }
    }

    /* renamed from: a */
    public void m13774a(Rect rect, az azVar) {
        View xxVar = new xx(this.f9832c, azVar);
        xxVar.setTextSize(this.f9830a.mo1988C());
        xxVar.setTextColor(this.f9832c.getResources().getColor(C0252d.reading__shared__note_background));
        xxVar.setMaxWidth(this.f9833d);
        xxVar.measure(MeasureSpec.makeMeasureSpec(this.f9833d, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.f9831b.m13771a(xxVar, xxVar.getMeasuredWidth(), xxVar.getMeasuredHeight(), true);
        this.f9831b.m13770a(rect);
    }

    /* renamed from: a */
    public void m13775a(Rect rect, String str, boolean z) {
        View deprecateddktextview = new deprecatedDkTextView(this.f9832c);
        deprecateddktextview.setUseBitmapCache(true);
        deprecateddktextview.setUsePartialDraw(true);
        if (!z) {
            deprecateddktextview.setChsToChtChars(this.f9830a.ae().m12455P());
        }
        deprecateddktextview.setTextSize(this.f9830a.mo1988C());
        deprecateddktextview.setText(str);
        deprecateddktextview.setGravity(119);
        deprecateddktextview.setTextColor(this.f9832c.getResources().getColor(C0252d.reading__shared__note_background));
        deprecateddktextview.setMaxWidth(this.f9833d);
        deprecateddktextview.measure(MeasureSpec.makeMeasureSpec(this.f9833d, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.f9831b.m13771a(deprecateddktextview, deprecateddktextview.getMeasuredWidth(), deprecateddktextview.getMeasuredHeight(), true);
        this.f9831b.m13770a(rect);
    }

    /* renamed from: a */
    public boolean m13776a() {
        return this.f9831b.isShowing();
    }
}
