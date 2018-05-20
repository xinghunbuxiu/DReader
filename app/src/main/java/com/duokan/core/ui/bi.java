package com.duokan.core.ui;

class bi implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f1012a;
    /* renamed from: b */
    final /* synthetic */ bh f1013b;

    bi(bh bhVar, int i) {
        this.f1013b = bhVar;
        this.f1012a = i;
    }

    public void run() {
        if (this.f1013b.f960b.f763E != null) {
            this.f1013b.f960b.f763E.onItemClick(this.f1013b.f960b, this.f1013b.f960b.m1141g(this.f1012a), this.f1012a);
        }
    }
}
