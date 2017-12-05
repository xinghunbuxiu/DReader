package com.duokan.reader.ui.reading;

import com.duokan.core.sys.AIdleOperation;

class sj implements yh {
    final /* synthetic */ si a;

    sj(si siVar) {
        this.a = siVar;
    }

    public void a(int i) {
        this.a.f.requestDetach();
        this.a.l = i;
        AIdleOperation.addIdleStatus(new sk(this));
    }
}
