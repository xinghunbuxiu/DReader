package com.duokan.reader.ui.reading;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

import com.duokan.common.i;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.az;
import com.duokan.reader.ui.general.DkTextView;

public class afe implements bb {
    private final sh a;
    private afc b = null;
    private Activity c = null;
    private a d;
    private acv e;
    private afg f;

    public afe(Activity activity, sh shVar, Runnable runnable) {
        this.c = activity;
        this.a = shVar;
        this.f = new afg();
        this.b = new afc(this.c, this.f, shVar);
        this.b.setCancelOnTouchOutside(true);
        this.b.a(runnable);
    }

    public void a(a aVar, Rect rect, acv com_duokan_reader_ui_reading_acv) {
        this.d = aVar;
        this.e = com_duokan_reader_ui_reading_acv;
        a(rect, ((ef) aVar).m(), true);
    }

    public void a(Rect rect, ab abVar) {
        if (!a()) {
            if (abVar.b() == null) {
                a(rect, abVar.a(), false);
            } else {
                a(rect, abVar.b());
            }
        }
    }

    public void a(Rect rect, az azVar) {
        View xkVar = new xk(this.c, azVar);
        xkVar.setTextSize(this.a.C());
        xkVar.setTextColor(this.c.getResources().getColor(d.reading__shared__note_background));
        xkVar.setOnClickListener(this.f);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.c.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int min = Math.min(displayMetrics.widthPixels - i.a(this.c, 60.0f), i.a(this.c, 320.0f));
        xkVar.setMaxWidth(min);
        xkVar.measure(MeasureSpec.makeMeasureSpec(min, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.b.a(xkVar, xkVar.getMeasuredWidth(), xkVar.getMeasuredHeight(), true);
        this.b.a(rect);
    }

    public void a(Rect rect, String str, boolean z) {
        View dkTextView = new DkTextView(this.c);
        if (!z) {
            dkTextView.setChsToChtChars(this.a.ae().P());
        }
        dkTextView.setTextPixelSize(this.a.C());
        dkTextView.setText(str);
        dkTextView.setGravity(119);
        dkTextView.setTextColor(this.c.getResources().getColor(d.reading__shared__note_background));
        dkTextView.setOnClickListener(this.f);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.c.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        dkTextView.measure(MeasureSpec.makeMeasureSpec(Math.min(displayMetrics.widthPixels - i.a(this.c, 60.0f), i.a(this.c, 320.0f)), 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.b.a(dkTextView, dkTextView.getMeasuredWidth(), dkTextView.getMeasuredHeight(), true);
        this.b.a(rect);
    }

    public boolean a() {
        return this.b.isShowing();
    }
}
