package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.C0352r;
import com.duokan.core.sys.UThread;
import com.duokan.reader.common.p037c.C0559f;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ko implements Runnable {
    /* renamed from: a */
    final /* synthetic */ kn f3472a;

    ko(kn knVar) {
        this.f3472a = knVar;
    }

    public void run() {
        C0352r a = this.f3472a.f3471c.br();
        try {
            Iterator it = this.f3472a.f3469a.f3503a.iterator();
            while (it.hasNext()) {
                int i;
                String str = (String) it.next();
                ky z = this.f3472a.f3471c.m4842z(str);
                if (this.f3472a.f3470b && C0559f.m2476b().m2484c()) {
                    i = ICallback.THIRD_PART_LOGIN;
                } else {
                    Map hashMap = new HashMap();
                    hashMap.put("md5", z.f3499d);
                    i = ((Integer) this.f3472a.f3471c.m4399a(z.f3497b, a, z.f3500e, z.f3498c, hashMap, null).get()).intValue();
                }
                this.f3472a.f3469a.f3504b.put(str, Integer.valueOf(i));
            }
        } catch (Throwable th) {
        } finally {
            this.f3472a.f3471c.bs();
            ee.f3084E.release();
            UThread.post(new kp(this));
        }
    }
}
