package com.duokan.reader.ui.store;

class t implements al {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public void onDownloadCloudBookStarted() {
        this.a.b.a.onDownloadCloudBookStarted();
    }

    public void onDownloadCloudBookCanceled() {
        this.a.b.a.onDownloadCloudBookCanceled();
    }

    public void onDownloadCloudBookError(String str) {
        this.a.b.a.onDownloadCloudBookError(str);
    }
}
