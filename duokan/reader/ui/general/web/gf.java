package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.reading.sh;

class gf implements as {
    final /* synthetic */ ge a;

    gf(ge geVar) {
        this.a = geVar;
    }

    public void a() {
        sh shVar = (sh) this.a.a.pageController.getContext().queryFeature(sh.class);
        if (shVar != null) {
            shVar.j(true);
        }
    }
}
