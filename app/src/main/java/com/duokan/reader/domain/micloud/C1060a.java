package com.duokan.reader.domain.micloud;

import com.duokan.core.sys.UThread;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;

/* renamed from: com.duokan.reader.domain.micloud.a */
public class C1060a {
    /* renamed from: a */
    private CheckErrorResult f5183a = CheckErrorResult.Ignored;
    /* renamed from: b */
    private boolean f5184b = false;

    /* renamed from: a */
    public CheckErrorResult m8040a(C0525e c0525e) {
        Object obj = new Object();
        UThread.post(new C1061b(this, c0525e, obj));
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            synchronized (obj) {
                if (!this.f5184b) {
                    try {
                        obj.wait(120000);
                    } catch (InterruptedException e) {
                    }
                    if (!this.f5184b) {
                        if (System.currentTimeMillis() - currentTimeMillis > 600000) {
                            break;
                        }
                    }
                    break;
                }
                break;
                return this.f5183a;
            }
        }
        return this.f5183a;
    }
}
