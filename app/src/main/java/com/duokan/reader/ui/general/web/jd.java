package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.bookshelf.ie;

class jd implements as {
    /* renamed from: a */
    final /* synthetic */ jc f8038a;

    jd(jc jcVar) {
        this.f8038a = jcVar;
    }

    /* renamed from: a */
    public void mo1831a() {
        ((ReaderFeature) this.f8038a.f8037b.f7581b.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(new ie(this.f8038a.f8037b.f7581b.getContext()), null);
    }
}
