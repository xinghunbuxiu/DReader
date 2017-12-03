package com.duokan.reader.ui.store;

import com.duokan.core.app.IFeature;
import com.duokan.core.ui.PullDownRefreshView.RefreshStyle;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.LoadingCircleView.LoadingStyle;

public class n extends bl {
    public n(IFeature featrue, bq bqVar) {
        super(featrue, bqVar);
    }

    protected void a() {
        a(LoadingStyle.COMIC);
        this.a.loadUrl(p.i().b());
        a.k().a("comic_store", 3);
    }

    protected void b() {
        if (this.a != null) {
            this.a.setRefreshStyle(RefreshStyle.COMIC);
        }
    }
}
