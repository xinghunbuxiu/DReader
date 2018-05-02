package com.duokan.reader.ui.general.web;

import android.net.Uri;

import com.duokan.core.app.IFeature;
import com.duokan.reader.ui.p;
import com.duokan.reader.ui.PushHalfPage;

public class kk extends p {
    private final Uri a;
    private final StorePageController b = new WebSceneController$1(this, getContext());

    public kk(IFeature featrue, Uri uri) {
        super(featrue);
        this.a = uri;
    }

    public boolean navigateSmoothly(String str) {
        return false;
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        return false;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            a.k().a("single_page", 3);
            ((PushHalfPage) getContext().queryFeature(PushHalfPage.class)).pushPage(this.b);
            this.b.loadUrl(this.a.toString());
        }
    }
}
