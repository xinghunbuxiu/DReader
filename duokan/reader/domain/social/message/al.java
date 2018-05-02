package com.duokan.reader.domain.social.message;

class al implements Runnable {
    final /* synthetic */ ak a;

    al(ak akVar) {
        this.a = akVar;
    }

    public void run() {
        if (this.a.b.e.k.a(this.a.a)) {
            this.a.b.e.a(this.a.f.mUnreadMessageIds);
        }
    }
}
