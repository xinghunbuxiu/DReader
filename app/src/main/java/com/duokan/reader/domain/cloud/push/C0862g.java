package com.duokan.reader.domain.cloud.push;

/* renamed from: com.duokan.reader.domain.cloud.push.g */
class C0862g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0857b f4122a;

    C0862g(C0857b c0857b) {
        this.f4122a = c0857b;
    }

    public void run() {
        C0880y.m5742a().m5750a(new C0863h(this));
        if (!this.f4122a.f4106g.getUpdatePushStatus()) {
            if (this.f4122a.f4106g.getReceivePushes()) {
                this.f4122a.m5692d("black_list");
            } else {
                this.f4122a.m5690c("black_list");
            }
            this.f4122a.f4106g.setUpdatePushStatus(true);
        }
    }
}
