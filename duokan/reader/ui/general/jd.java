package com.duokan.reader.ui.general;

import com.duokan.core.app.ActivatedController;

class jd implements iq {
    final /* synthetic */ ja a;

    jd(ja jaVar) {
        this.a = jaVar;
    }

    public void a(int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            ActivatedController controller = (ActivatedController) this.a.b.get(i2);
            this.a.deactivate((ActivatedController) this.a.b.get(i));
            this.a.activate(controller);
        }
    }
}
