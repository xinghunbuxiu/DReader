package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;

class yo extends yr {
    private final zj E;

    public yo(IFeature featrue, zj zjVar) {
        super(featrue, zjVar);
        this.E = zjVar;
        this.o.setOnLongClickListener(new yp(this));
        this.o.setOnClickListener(new yq(this));
    }

    public void a(int i) {
        this.C = i;
    }

    public void a(String str, boolean z, adl com_duokan_reader_ui_reading_adl) {
        super.a(str, z, com_duokan_reader_ui_reading_adl);
        if (g()) {
            this.d.setVisibility(0);
            this.d.addView(this.o);
            this.d.addView(this.j);
            this.d.addView(this.r);
            this.d.addView(this.h);
            this.d.addView(this.i);
            return;
        }
        this.d.setVisibility(0);
        this.d.addView(this.o);
        this.d.addView(this.j);
        this.d.addView(this.r);
        this.d.addView(this.i);
    }
}
