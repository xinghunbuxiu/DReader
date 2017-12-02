package com.duokan.reader.ui.store;

import android.view.LayoutInflater;
import android.view.View;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.app.e;
import com.duokan.core.app.y;

public class a extends e {
    public a(y yVar) {
        super(yVar);
        View inflate = LayoutInflater.from(getContext()).inflate(h.general__app_store_guide_view, null, false);
        setContentView(inflate);
        inflate.findViewById(g.general__app_store_guide_view__positive).setOnClickListener(new b(this));
        inflate.findViewById(g.general__app_store_guide_view__negative).setOnClickListener(new c(this));
        inflate.findViewById(g.general__app_store_guide_view__cancel).setOnClickListener(new e(this));
    }
}
