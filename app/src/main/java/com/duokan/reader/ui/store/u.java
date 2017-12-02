package com.duokan.reader.ui.store;

class u implements al {
    final /* synthetic */ r a;

    u(r rVar) {
        this.a = rVar;
    }

    public void onDownloadCloudBookStarted() {
        this.a.a.onDownloadCloudBookStarted();
    }

    public void onDownloadCloudBookCanceled() {
        this.a.a.onDownloadCloudBookCanceled();
    }

    public void onDownloadCloudBookError(String str) {
        this.a.a.onDownloadCloudBookError(str);
    }
}
