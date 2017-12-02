package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.app.y;

class aez extends po {
    public aez(y yVar) {
        super(yVar);
        findViewById(g.reading__reading_menu_bottom_view__read_mode).setOnClickListener(new afa(this));
    }

    protected View a() {
        return inflate(h.reading__reading_menu_view_txt, null);
    }
}
