package com.duokan.reader.ui.store;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.IdleStatus;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.classc;

class bo implements IdleStatus {
    final /* synthetic */ bn a;

    bo(bn bnVar) {
        this.a = bnVar;
    }

    public boolean idleRun() {
        if (this.a.a.isActive() && this.a.a.getPopupCount() == 0 && this.a.a.i() == 0 && classc.ConnectivityReceiver.b().e()) {
            ReaderEnv.get().setShowAppStoreGuide(false);
            ReaderEnv.get().setLastCommentTime(System.currentTimeMillis());
            ActivatedController aVar = new a(this.a.a.getContext());
            ((ReaderFeature) this.a.a.getContext().queryFeature(ReaderFeature.class)).showPopup(aVar);
            UTools.closeAnimation(aVar.getContentView(), null);
        }
        return false;
    }
}
