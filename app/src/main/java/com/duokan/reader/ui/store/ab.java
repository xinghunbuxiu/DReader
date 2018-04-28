package com.duokan.reader.ui.store;

class ab implements al {
    /* renamed from: a */
    final /* synthetic */ aa f11303a;

    ab(aa aaVar) {
        this.f11303a = aaVar;
    }

    public void onDownloadCloudBookStarted() {
        this.f11303a.f11298a.dismiss();
        this.f11303a.f11302e.f11462g.remove(this.f11303a.f11299b);
        this.f11303a.f11300c.onDownloadCloudBookStarted();
    }

    public void onDownloadCloudBookCanceled() {
        this.f11303a.f11298a.dismiss();
        this.f11303a.f11302e.f11462g.remove(this.f11303a.f11299b);
        this.f11303a.f11300c.onDownloadCloudBookCanceled();
    }

    public void onDownloadCloudBookError(String str) {
        this.f11303a.f11298a.dismiss();
        C1502o.m15426d(str);
        this.f11303a.f11302e.f11462g.remove(this.f11303a.f11299b);
        this.f11303a.f11300c.onDownloadCloudBookError(str);
    }
}
