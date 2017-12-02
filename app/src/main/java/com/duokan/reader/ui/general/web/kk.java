package com.duokan.reader.ui.general.web;

import android.net.Uri;

import com.duokan.core.app.y;
import com.duokan.reader.domain.statistics.a;
import com.duokan.reader.ui.p;
import com.duokan.reader.ui.t;

public class kk extends p {
    private final Uri a;
    private final StorePageController b = new WebSceneController$1(this, getContext());

    public kk(y yVar, Uri uri) {
        super(yVar);
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
            ((t) getContext().queryFeature(t.class)).pushPage(this.b);
            this.b.loadUrl(this.a.toString());
        }
    }
}
