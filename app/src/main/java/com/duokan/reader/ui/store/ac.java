package com.duokan.reader.ui.store;

class ac implements al {
    /* renamed from: a */
    final /* synthetic */ String f11304a;
    /* renamed from: b */
    final /* synthetic */ al f11305b;
    /* renamed from: c */
    final /* synthetic */ C1502o f11306c;

    ac(C1502o c1502o, String str, al alVar) {
        this.f11306c = c1502o;
        this.f11304a = str;
        this.f11305b = alVar;
    }

    public void onDownloadCloudBookStarted() {
        this.f11306c.f11462g.remove(this.f11304a);
        this.f11305b.onDownloadCloudBookStarted();
    }

    public void onDownloadCloudBookCanceled() {
        this.f11306c.f11462g.remove(this.f11304a);
        this.f11305b.onDownloadCloudBookCanceled();
    }

    public void onDownloadCloudBookError(String str) {
        this.f11306c.f11462g.remove(this.f11304a);
        this.f11305b.onDownloadCloudBookError(str);
    }
}
