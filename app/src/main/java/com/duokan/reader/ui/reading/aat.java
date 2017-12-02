package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;

import com.duokan.core.sys.t;

class aat implements PageProvider {
    final /* synthetic */ aar a;

    aat(aar com_duokan_reader_ui_reading_aar) {
        this.a = com_duokan_reader_ui_reading_aar;
    }

    public CurlAnchor nextPageAnchor(CurlAnchor curlAnchor) {
        return (CurlAnchor) t.a(new aau(this, curlAnchor));
    }

    public CurlAnchor prevPageAnchor(CurlAnchor curlAnchor) {
        return (CurlAnchor) t.a(new aav(this));
    }

    public Bitmap getPageBitmap(CurlAnchor curlAnchor) {
        return this.a.e.a(curlAnchor.mPageDrawable);
    }

    public Bitmap getBackgroundBitmap() {
        return this.a.e.a().a;
    }

    public void flipPage(CurlDirection curlDirection) {
        t.a(new aaw(this, curlDirection));
    }

    public void afterFlip(boolean z) {
        t.a(new aax(this));
    }

    public void afterDrawFrame() {
        t.a(new aay(this));
    }

    public void afterSurfaceChanged() {
        t.b(new aaz(this));
    }

    public void onPageSizeChanged(int i, int i2) {
    }
}
