package com.duokan.reader.ui.store;

import com.duokan.core.app.e;
import com.duokan.core.sys.s;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.c.f;

class bo implements s {
    final /* synthetic */ bn a;

    bo(bn bnVar) {
        this.a = bnVar;
    }

    public boolean idleRun() {
        if (this.a.a.isActive() && this.a.a.getPopupCount() == 0 && this.a.a.i() == 0 && f.b().e()) {
            ReaderEnv.get().setShowAppStoreGuide(false);
            ReaderEnv.get().setLastCommentTime(System.currentTimeMillis());
            e aVar = new a(this.a.a.getContext());
            ((ReaderFeature) this.a.a.getContext().queryFeature(ReaderFeature.class)).showPopup(aVar);
            dv.b(aVar.getContentView(), null);
        }
        return false;
    }
}
