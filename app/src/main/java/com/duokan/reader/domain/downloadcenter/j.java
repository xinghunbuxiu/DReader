package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.classc;

class j implements classc.IConnectChanged {
    final /* synthetic */ b a;

    j(b bVar) {
        this.a = bVar;
    }

    public void onConnectivityChanged(classc.ConnectivityReceiver connectivity) {
        this.a.a(connectivity);
    }
}
