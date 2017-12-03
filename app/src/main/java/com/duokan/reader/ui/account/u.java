package com.duokan.reader.ui.account;

import com.duokan.c.j;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ui.general.SpirtMenuController;

class u extends SpirtMenuController {
    final /* synthetic */ t a;

    public u(t tVar, IFeature featrue) {
        this.a = tVar;
        super(featrue);
        a(j.personal__output_entrance_view__yingxiang, new v(this, tVar));
        a(j.personal__output_entrance_view__email, new IFeature(this, tVar));
    }
}
