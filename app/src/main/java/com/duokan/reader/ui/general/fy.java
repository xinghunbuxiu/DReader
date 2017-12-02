package com.duokan.reader.ui.general;

import android.view.View;

import com.duokan.core.app.e;
import com.duokan.core.app.y;

public class fy extends e {
    private final e a;
    final /* synthetic */ PagesController c;

    public fy(PagesController pagesController, y yVar, e eVar) {
        this.c = pagesController;
        super(yVar);
        this.a = eVar;
        setContentView(this.a.getContentView());
        addSubController(this.a);
    }

    public final e b() {
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
