package com.duokan.reader.ui.store;

import android.content.Context;

import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.ds;

class bs extends ds {
    final /* synthetic */ br c;

    bs(br brVar, Context context) {
        this.c = brVar;
        super(context);
    }

    protected boolean b() {
        return this.c.b();
    }

    protected float c() {
        float f = 0.0f;
        for (Integer intValue : getVisibleViewIndexMap().keySet()) {
            int intValue2 = intValue.intValue();
            f = (((Float) getVisibleViewIndexMap().get(Integer.valueOf(intValue2))).floatValue() * UTools.addAnimation(((float) ((bl) this.c.b.get(intValue2)).e()) / ((float) (this.c.d - getTabView().getHeight())))) + f;
        }
        return f;
    }
}
