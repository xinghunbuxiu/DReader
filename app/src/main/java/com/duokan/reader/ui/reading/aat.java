package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;

import com.duokan.core.sys.TaskHandler;

class aat implements PageProvider {
    final /* synthetic */ aar a;

    aat(aar com_duokan_reader_ui_reading_aar) {
        this.a = com_duokan_reader_ui_reading_aar;
    }

    public CurlAnchor nextPageAnchor(CurlAnchor curlAnchor) {
        return (CurlAnchor) TaskHandler.postTask(new aau(this, curlAnchor));
    }

    public CurlAnchor prevPageAnchor(CurlAnchor curlAnchor) {
        return (CurlAnchor) TaskHandler.postTask(new aav(this));
    }

    public Bitmap getPageBitmap(CurlAnchor curlAnchor) {
        return this.a.e.a(curlAnchor.mPageDrawable);
    }

    public Bitmap getBackgroundBitmap() {
        return this.a.e.a().a;
    }

    public void flipPage(CurlDirection curlDirection) {
        TaskHandler.postTask(new aaw(this, curlDirection));
    }

    public void afterFlip(boolean z) {
        TaskHandler.postTask(new aax(this));
    }

    public void afterDrawFrame() {
        TaskHandler.postTask(new aay(this));
    }

    public void afterSurfaceChanged() {
        TaskHandler.PostTask(new aaz(this));
    }

    public void onPageSizeChanged(int i, int i2) {
    }
}
