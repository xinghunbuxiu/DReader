package com.duokan.reader.ui.store;

class ab implements al {
    final /* synthetic */ aa a;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    public void onDownloadCloudBookStarted() {
        this.a.a.dismiss();
        this.a.e.g.remove(this.a.b);
        this.a.c.onDownloadCloudBookStarted();
    }

    public void onDownloadCloudBookCanceled() {
        this.a.a.dismiss();
        this.a.e.g.remove(this.a.b);
        this.a.c.onDownloadCloudBookCanceled();
    }

    public void onDownloadCloudBookError(String str) {
        this.a.a.dismiss();
        o.d(str);
        this.a.e.g.remove(this.a.b);
        this.a.c.onDownloadCloudBookError(str);
    }
}
