package com.duokan.reader.ui.general;

import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;

abstract class gy extends ActivatedController {
    /* renamed from: a */
    private final ActivatedController f7303a;
    /* renamed from: b */
    final /* synthetic */ gs f7304b;

    public gy(gs gsVar, IFeature mFeature, ActivatedController c0303e) {
        this.f7304b = gsVar;
        super(mFeature);
        this.f7303a = c0303e;
    }

    /* renamed from: a */
    public final ActivatedController m10732a() {
        return this.f7303a;
    }

    /* renamed from: b */
    public final View m10733b() {
        return this.f7303a.getContentView();
    }
}
