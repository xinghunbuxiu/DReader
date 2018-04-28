package com.duokan.reader.ui.general;

import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;

public class fs extends ActivatedController {
    /* renamed from: a */
    private final ActivatedController f7255a;
    /* renamed from: c */
    final /* synthetic */ PagesController f7256c;

    public fs(PagesController pagesController, IFeature mFeature, ActivatedController c0303e) {
        this.f7256c = pagesController;
        super(mFeature);
        this.f7255a = c0303e;
        setContentView(this.f7255a.getContentView());
        addSubController(this.f7255a);
    }

    /* renamed from: b */
    public final ActivatedController m10670b() {
        return this.f7255a;
    }

    /* renamed from: c */
    public final View m10671c() {
        return this.f7255a.getContentView();
    }

    protected void onActive(boolean z) {
        if (z) {
            activate(this.f7255a);
        }
    }
}
