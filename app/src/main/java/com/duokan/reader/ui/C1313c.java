package com.duokan.reader.ui;

/* renamed from: com.duokan.reader.ui.c */
class C1313c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f6751a;
    /* renamed from: b */
    final /* synthetic */ C1235a f6752b;

    C1313c(C1235a c1235a, int i) {
        this.f6752b = c1235a;
        this.f6751a = i;
    }

    public void run() {
        if (this.f6752b.f5746h == this.f6751a && this.f6752b.f5744f.getVisibility() == 0) {
            this.f6752b.f5744f.setBackgroundColor(this.f6752b.f5746h);
        }
    }
}
