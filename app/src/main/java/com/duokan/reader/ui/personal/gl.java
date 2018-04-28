package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import java.util.concurrent.Callable;

class gl implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ gj f8613a;

    gl(gj gjVar) {
        this.f8613a = gjVar;
    }

    public /* synthetic */ Object call() {
        return m11934a();
    }

    /* renamed from: a */
    public ActivatedController m11934a() {
        return new ij(this.f8613a.f8611a.getContext());
    }
}
