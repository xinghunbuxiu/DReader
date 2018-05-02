package com.duokan.reader.ui.surfing;

import android.widget.FrameLayout;
import com.duokan.core.sys.UThread;

/* renamed from: com.duokan.reader.ui.surfing.n */
class C1527n implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FrameLayout f11575a;
    /* renamed from: b */
    final /* synthetic */ Runnable f11576b;
    /* renamed from: c */
    final /* synthetic */ C1522i f11577c;

    C1527n(C1522i c1522i, FrameLayout frameLayout, Runnable runnable) {
        this.f11577c = c1522i;
        this.f11575a = frameLayout;
        this.f11576b = runnable;
    }

    public void run() {
        this.f11577c.f11543k.removeView(this.f11575a);
        this.f11575a.removeAllViews();
        UThread.runOnThread(this.f11576b);
    }
}
