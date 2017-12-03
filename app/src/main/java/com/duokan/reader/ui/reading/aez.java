package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.core.app.IFeature;

class aez extends po {
    public aez(IFeature featrue) {
        super(featrue);
        findViewById(g.reading__reading_menu_bottom_view__read_mode).setOnClickListener(new afa(this));
    }

    protected View a() {
        return inflate(h.reading__reading_menu_view_txt, null);
    }
}
