package com.duokan.reader.ui.general.web;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.common.p037c.C0559f;
import java.lang.ref.WeakReference;

class kr implements Runnable {
    /* renamed from: a */
    private final WeakReference<StorePageController> f8112a;
    /* renamed from: b */
    private boolean f8113b = false;

    kr(StorePageController storePageController) {
        this.f8112a = new WeakReference(storePageController);
    }

    public void run() {
        WebLog.init().w();
        if (!this.f8113b) {
            this.f8113b = true;
            StorePageController storePageController = (StorePageController) this.f8112a.get();
            if (storePageController != null) {
                if (C0559f.m2476b().m2486e()) {
                    storePageController.updateStoreMirror(false);
                }
                storePageController.clearUpdateMirrorRunnable();
            }
        }
    }
}
