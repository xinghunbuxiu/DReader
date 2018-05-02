package com.duokan.reader.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.duokan.reader.ui.general.fs;

/* renamed from: com.duokan.reader.ui.n */
class C1389n implements OnTouchListener {
    /* renamed from: a */
    final /* synthetic */ C1384i f8196a;
    /* renamed from: b */
    final /* synthetic */ C1387l f8197b;

    C1389n(C1387l c1387l, C1384i c1384i) {
        this.f8197b = c1387l;
        this.f8196a = c1384i;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            for (int h = this.f8197b.f8191a.m9241h() - 1; h >= 0; h--) {
                fs a = this.f8197b.f8191a.m9238f(h);
                if (Float.compare(((C1387l) a).m11333a(), this.f8197b.f8193d) != 0) {
                    this.f8197b.f8191a.mo1863d(a.m10670b(), null);
                    break;
                }
            }
            this.f8197b.f8191a.m9225b(null);
        }
        return true;
    }
}
