package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.C0352r;
import com.duokan.core.sys.UThread;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class kl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ kk f3467a;

    kl(kk kkVar) {
        this.f3467a = kkVar;
    }

    public void run() {
        C0352r a = this.f3467a.f3466b.f3464b.br();
        try {
            Iterator it = this.f3467a.f3466b.f3463a.f3146a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String u = this.f3467a.f3466b.f3464b.mo1040u(str);
                ex exVar = (ex) this.f3467a.f3465a.get(str);
                if (exVar.f3142a != -1) {
                    this.f3467a.f3466b.f3463a.f3147b.put(str, Integer.valueOf(exVar.f3142a));
                    if (exVar.f3142a != ICallback.LOGIN_OAUTH_AIDL) {
                        WebLog.init().a(LogLevel.ERROR, "sbk", "fail to pull the chapter(%s)(error=%d, msg=%s, book=%s, name=%s)", str, Integer.valueOf(exVar.f3142a), exVar.f3143b, this.f3467a.f3466b.f3464b.m4156I(), this.f3467a.f3466b.f3464b.ay());
                    }
                } else {
                    WebLog.init().w(!TextUtils.isEmpty(exVar.f3144c));
                    this.f3467a.f3466b.f3463a.f3147b.put(str, Integer.valueOf(-1));
                    Map hashMap = new HashMap();
                    hashMap.put("sha1", exVar.f3145d);
                    this.f3467a.f3466b.f3463a.f3147b.put(str, Integer.valueOf(((Integer) this.f3467a.f3466b.f3464b.m4399a(u, a, -1, exVar.f3144c, hashMap, null).get()).intValue()));
                }
            }
        } catch (Throwable th) {
        } finally {
            this.f3467a.f3466b.f3464b.bs();
            ee.f3084E.release();
            UThread.post(new km(this));
        }
    }
}
