package com.duokan.reader.ui.reading;

class lv implements mb {
    final /* synthetic */ lw a;
    final /* synthetic */ ls b;

    lv(ls lsVar, lw lwVar) {
        this.b = lsVar;
        this.a = lwVar;
    }

    public void a() {
        this.b.b.removeView(this.b.c.b());
        this.b.c = null;
        this.b.d.a(false);
        this.a.a();
        this.b.b.getShowingPagesView().setEnabled(true);
        this.b.a.a(0, 12);
    }

    public void b() {
        this.a.b();
    }

    public void c() {
        this.a.c();
    }

    public void a(boolean z) {
        this.b.b.getShowingPagesView().setEnabled(!z);
    }
}
