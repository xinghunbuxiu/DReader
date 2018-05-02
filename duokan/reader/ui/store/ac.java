package com.duokan.reader.ui.store;

class ac implements al {
    final /* synthetic */ String a;
    final /* synthetic */ al b;
    final /* synthetic */ o c;

    ac(o oVar, String str, al alVar) {
        this.c = oVar;
        this.a = str;
        this.b = alVar;
    }

    public void onDownloadCloudBookStarted() {
        this.c.g.remove(this.a);
        this.b.onDownloadCloudBookStarted();
    }

    public void onDownloadCloudBookCanceled() {
        this.c.g.remove(this.a);
        this.b.onDownloadCloudBookCanceled();
    }

    public void onDownloadCloudBookError(String str) {
        this.c.g.remove(this.a);
        this.b.onDownloadCloudBookError(str);
    }
}
