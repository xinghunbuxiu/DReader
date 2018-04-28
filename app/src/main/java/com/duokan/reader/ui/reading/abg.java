package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import com.duokan.core.sys.UThread;
import fi.harism.curl.CurlAnchor;
import fi.harism.curl.CurlDirection;
import fi.harism.curl.PageProvider;

class abg implements PageProvider {
    /* renamed from: a */
    final /* synthetic */ abe f9391a;

    abg(abe abe) {
        this.f9391a = abe;
    }

    public CurlAnchor nextPageAnchor(CurlAnchor curlAnchor) {
        return (CurlAnchor) UThread.m1035a(new abh(this, curlAnchor));
    }

    public CurlAnchor prevPageAnchor(CurlAnchor curlAnchor) {
        return (CurlAnchor) UThread.m1035a(new abi(this));
    }

    public Bitmap getPageBitmap(CurlAnchor curlAnchor) {
        return this.f9391a.f9383e.m13254a(curlAnchor.mPageDrawable);
    }

    public Bitmap getBackgroundBitmap() {
        return this.f9391a.f9383e.m13255a().f9421a;
    }

    public void flipPage(CurlDirection curlDirection) {
        UThread.runOnThread(new abj(this, curlDirection));
    }

    public void afterFlip(boolean z) {
        UThread.runOnThread(new abk(this));
    }

    public void afterDrawFrame() {
        UThread.runOnThread(new abl(this));
    }

    public void afterSurfaceChanged() {
        UThread.post(new abm(this));
    }

    public void onPageSizeChanged(int i, int i2) {
    }
}
