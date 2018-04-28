package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;

class jh implements Runnable {
    /* renamed from: a */
    final /* synthetic */ jo f3387a;
    /* renamed from: b */
    final /* synthetic */ it f3388b;

    jh(it itVar, jo joVar) {
        this.f3388b = itVar;
        this.f3387a = joVar;
    }

    public void run() {
        jp b = this.f3388b.f3365i;
        if (b != null) {
            b.m4742a(null, null);
            if (this.f3387a != null) {
                UThread.runOnThread(new ji(this));
            }
        }
    }
}
