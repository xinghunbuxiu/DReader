package com.duokan.reader.domain.bookshelf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.duokan.reader.common.async.work.c;
import com.duokan.reader.domain.micloud.i;

import java.util.Collection;

class jf extends Handler {
    final /* synthetic */ iz a;

    jf(iz izVar, Looper looper) {
        this.a = izVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        Collection collection;
        i iVar;
        if (message.what == 0) {
            collection = (Collection) message.obj;
            if (collection.size() > 0) {
                iVar = (i) collection.iterator().next();
                collection.remove(iVar);
                if (iVar.k()) {
                    this.a.j.a().c((c) iVar);
                }
                if (collection.size() > 0) {
                    sendMessageDelayed(this.a.n.obtainMessage(0, collection), 0);
                }
            }
        } else if (message.what == 1) {
            collection = (Collection) message.obj;
            if (collection.size() > 0) {
                iVar = (i) collection.iterator().next();
                collection.remove(iVar);
                if (iVar.o()) {
                    this.a.j.a().a((c) iVar, false);
                }
                if (collection.size() > 0) {
                    sendMessageDelayed(this.a.n.obtainMessage(1, collection), 0);
                }
            }
        }
    }
}
