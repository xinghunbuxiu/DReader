package com.duokan.reader.ui.general.web;

import android.net.Uri;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.C0437t;
import com.duokan.reader.ui.C1367p;

public class lp extends C1367p {
    /* renamed from: a */
    private final Uri f8164a;
    /* renamed from: b */
    private final StorePageController f8165b = new WebSceneController$1(this, getContext());

    public lp(IFeature mFeature, Uri uri) {
        super(mFeature);
        this.f8164a = uri;
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
            C1163a.m8627k().m8642a("single_page", 3);
            ((C0437t) getContext().queryFeature(C0437t.class)).pushPage(this.f8165b);
            this.f8165b.loadUrl(this.f8164a.toString());
        }
    }
}
