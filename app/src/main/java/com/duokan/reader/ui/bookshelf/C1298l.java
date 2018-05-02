package com.duokan.reader.ui.bookshelf;

/* renamed from: com.duokan.reader.ui.bookshelf.l */
class C1298l implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1297k f6724a;

    C1298l(C1297k c1297k) {
        this.f6724a = c1297k;
    }

    public void run() {
        if (this.f6724a.f6698a.f6647a < this.f6724a.f6698a.f6648b.f6489i.getHeight() / 2) {
            this.f6724a.f6698a.f6648b.f6486f.mo434a(0, 0, 0, null, null);
        } else if (this.f6724a.f6698a.f6647a < this.f6724a.f6698a.f6648b.f6489i.getHeight()) {
            this.f6724a.f6698a.f6648b.f6486f.mo434a(0, this.f6724a.f6698a.f6648b.f6489i.getHeight(), 0, null, null);
        } else {
            this.f6724a.f6698a.f6648b.f6486f.mo434a(0, this.f6724a.f6698a.f6647a, 0, null, null);
        }
    }
}
