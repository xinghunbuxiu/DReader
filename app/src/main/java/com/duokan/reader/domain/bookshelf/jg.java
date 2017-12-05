package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.classc;

class jg implements classc.IConnectChanged {
    final /* synthetic */ iz a;

    jg(iz izVar) {
        this.a = izVar;
    }

    public void onConnectivityChanged(classc.ConnectivityReceiver connectivity) {
        this.a.a(connectivity);
    }
}
