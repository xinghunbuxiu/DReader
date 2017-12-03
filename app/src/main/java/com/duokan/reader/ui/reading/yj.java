package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;

public class yj extends yr {
    public yj(IFeature featrue, zj zjVar) {
        super(featrue, zjVar);
    }

    public void a(int i) {
        this.C = i;
    }

    public void a(String str, boolean z, adl com_duokan_reader_ui_reading_adl) {
        super.a(str, z, com_duokan_reader_ui_reading_adl);
        this.d.setVisibility(0);
        this.z.a(this.s);
        this.z.a(this.q);
        this.z.a(this.i);
        this.z.a(this.t);
        this.z.a(this.j);
        this.z.a(this.r);
        if (g()) {
            this.z.a(this.h);
        }
        for (int i = 0; i < this.z.getToolCount(); i++) {
            this.z.a(i).setPadding(0, 0, UTools.closeAnimation(getContext(), 20.0f), 0);
        }
        this.z.a(UTools.closeAnimation(getContext(), 10.0f), 0, UTools.closeAnimation(getContext(), 10.0f), 0);
        this.d.addView(this.z);
    }
}
