package com.duokan.reader.domain.cloud.push;

class g implements Runnable {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public void run() {
        z.a().a(new h(this));
        if (!this.a.g.getUpdatePushStatus()) {
            if (this.a.g.getReceivePushes()) {
                this.a.d("black_list");
            } else {
                this.a.c("black_list");
            }
            this.a.g.setUpdatePushStatus(true);
        }
    }
}
