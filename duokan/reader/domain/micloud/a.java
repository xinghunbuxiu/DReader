package com.duokan.reader.domain.micloud;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import com.duokan.reader.common.async.work.e;

public class a {
    private CheckErrorResult a = CheckErrorResult.Ignored;
    private boolean b = false;

    public CheckErrorResult a(e eVar) {
        Object obj = new Object();
        TaskHandler.PostTask(new b(this, eVar, obj));
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            synchronized (obj) {
                if (!this.b) {
                    try {
                        obj.wait(120000);
                    } catch (InterruptedException e) {
                    }
                    if (!this.b) {
                        if (System.currentTimeMillis() - currentTimeMillis > 600000) {
                            break;
                        }
                    }
                    break;
                }
                break;
                return this.a;
            }
        }
        return this.a;
    }
}
