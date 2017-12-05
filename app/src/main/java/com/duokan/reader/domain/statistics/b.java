package com.duokan.reader.domain.statistics;

import com.duokan.reader.common.classc;

class b implements classc.IConnectChanged {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onConnectivityChanged(classc.ConnectivityReceiver connectivity) {
        this.a.l();
    }
}
