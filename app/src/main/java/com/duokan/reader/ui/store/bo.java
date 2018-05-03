package com.duokan.reader.ui.store;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.IdleHandlerListener;
import com.duokan.core.ui.AnimUtils;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.p037c.C0559f;

class bo implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ bn f11378a;

    bo(bn bnVar) {
        this.f11378a = bnVar;
    }

    public boolean idleRun() {
        if (this.f11378a.f11377a.isActive() && this.f11378a.f11377a.getPopupCount() == 0 && this.f11378a.f11377a.m9241h() == 0 && C0559f.m2476b().m2486e()) {
            ReaderEnv.get().setShowAppStoreGuide(false);
            ReaderEnv.get().setLastCommentTime(System.currentTimeMillis());
            ActivatedController c1475a = new C1475a(this.f11378a.f11377a.getContext());
            ((ReaderFeature) this.f11378a.f11377a.getContext().queryFeature(ReaderFeature.class)).showPopup(c1475a);
            AnimUtils.showAnimation(c1475a.getContentView(), null);
        }
        return false;
    }
}
