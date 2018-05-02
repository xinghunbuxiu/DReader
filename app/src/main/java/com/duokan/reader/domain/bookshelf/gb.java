package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class gb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ga f3218a;

    gb(ga gaVar) {
        this.f3218a = gaVar;
    }

    public void run() {
        try {
            Iterator it = this.f3218a.f3217b.f3212a.f3146a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String u = this.f3218a.f3217b.f3213b.mo1040u(str);
                ex exVar = (ex) this.f3218a.f3216a.get(str);
                if (exVar.f3142a != -1) {
                    this.f3218a.f3217b.f3212a.f3147b.put(str, Integer.valueOf(exVar.f3142a));
                    if (exVar.f3142a != ICallback.LOGIN_OAUTH_AIDL) {
                        WebLog.init().a(LogLevel.ERROR, "epub-s", "fail to pull the chapter(%s)(error=%d, msg=%s, book=%s, name=%s)", str, Integer.valueOf(exVar.f3142a), exVar.f3143b, this.f3218a.f3217b.f3213b.m4156I(), this.f3218a.f3217b.f3213b.ay());
                    }
                } else {
                    WebLog.init().w(!TextUtils.isEmpty(exVar.f3144c));
                    this.f3218a.f3217b.f3212a.f3147b.put(str, Integer.valueOf(-1));
                    Map hashMap = new HashMap();
                    hashMap.put("sha1", exVar.f3145d);
                    this.f3218a.f3217b.f3212a.f3147b.put(str, Integer.valueOf(((Integer) this.f3218a.f3217b.f3213b.m4399a(u, null, -1, exVar.f3144c, hashMap, null).get()).intValue()));
                }
            }
            ee.f3084E.release();
            for (Entry entry : this.f3218a.f3217b.f3212a.f3147b.entrySet()) {
                if ((((Integer) entry.getValue()).intValue() == 0 || ((Integer) entry.getValue()).intValue() == 1) && !this.f3218a.f3217b.f3213b.mo1041v((String) entry.getKey())) {
                    this.f3218a.f3217b.f3213b.bs();
                    break;
                }
            }
            UThread.runOnThread(new gc(this));
        } catch (Throwable th) {
            Throwable th2 = th;
            ee.f3084E.release();
            for (Entry entry2 : this.f3218a.f3217b.f3212a.f3147b.entrySet()) {
                if ((((Integer) entry2.getValue()).intValue() == 0 || ((Integer) entry2.getValue()).intValue() == 1) && !this.f3218a.f3217b.f3213b.mo1041v((String) entry2.getKey())) {
                    this.f3218a.f3217b.f3213b.bs();
                    break;
                }
            }
            UThread.runOnThread(new gc(this));
        }
    }
}
