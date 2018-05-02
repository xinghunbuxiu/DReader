package com.duokan.reader.ui.store;

import com.duokan.core.app.IFeature;
import com.duokan.core.ui.PullDownRefreshView.RefreshStyle;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.LoadingCircleView.LoadingStyle;

/* renamed from: com.duokan.reader.ui.store.n */
public class C1501n extends bl {
    public C1501n(IFeature mFeature, bq bqVar) {
        super(mFeature, bqVar);
    }

    /* renamed from: a */
    protected void mo1641a() {
        m15298a(LoadingStyle.COMIC);
        this.a.loadUrl(C0641o.m2934i().m2961b());
        C1163a.m8627k().m8642a("comic_store", 3);
    }

    /* renamed from: b */
    protected void mo2539b() {
        if (this.a != null) {
            this.a.setRefreshStyle(RefreshStyle.COMIC);
        }
    }
}
