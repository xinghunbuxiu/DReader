package com.duokan.reader.ui.reading;

import com.duokan.core.app.AppContext;
import com.duokan.core.app.ag;
import com.duokan.core.app.ah;

class hj implements ah {
    /* renamed from: a */
    final /* synthetic */ hg f10327a;

    hj(hg hgVar) {
        this.f10327a = hgVar;
    }

    /* renamed from: a */
    public void mo1562a(ag agVar) {
        this.f10327a.f10319b.setCurrentSpeaker(this.f10327a.f10321d);
    }

    /* renamed from: b */
    public void mo1567b(ag agVar) {
        this.f10327a.f10319b.setCurrentSpeaker(this.f10327a.f10321d);
        ((su) AppContext.getAppContext(this.f10327a.getContext()).queryFeature(su.class)).aY();
        ((su) AppContext.getAppContext(this.f10327a.getContext()).queryFeature(su.class)).bf();
    }

    /* renamed from: c */
    public void mo1565c(ag agVar) {
        this.f10327a.f10319b.setCurrentSpeaker(this.f10327a.f10321d);
    }
}
