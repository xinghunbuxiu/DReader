package com.duokan.reader.ui.general;

import android.view.View;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;

public class fy extends ActivatedController {
    private final ActivatedController a;
    final /* synthetic */ PagesController c;

    public fy(PagesController pagesController, IFeature featrue, ActivatedController activatedControllerVar) {
        this.c = pagesController;
        super(featrue);
        this.a = activatedControllerVar;
        setContentView(this.a.getContentView());
        addSubController(this.a);
    }

    public final ActivatedController b() {
        return this.a;
    }

    public final View c() {
        return this.a.getContentView();
    }

    protected void onActive(boolean z) {
        if (z) {
            activate(this.a);
        }
    }
}
