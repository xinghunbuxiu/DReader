package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import android.util.Pair;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.Map;

class es extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f3125a;
    /* renamed from: b */
    final /* synthetic */ er f3126b;

    es(er erVar, String str, C0657i c0657i, C0672a c0672a) {
        this.f3126b = erVar;
        this.f3125a = c0672a;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        C0652z c0652z = new C0652z((WebSession) this, this.f3125a);
        if (this.f3126b.f3119a) {
            C0621a a = c0652z.m3061a(this.f3126b.f3120b, (String[]) this.f3126b.f3121c.toArray(new String[0]));
            for (String str : this.f3126b.f3121c) {
                ex exVar = new ex();
                if (a.b != 0) {
                    switch (a.b) {
                        case ICallback.LOGIN_OAUTH_AIDL /*1002*/:
                            exVar.f3142a = 1001;
                            break;
                        case 90001:
                            exVar.f3142a = ICallback.LOGIN_OAUTH_AIDL;
                            break;
                        default:
                            exVar.f3142a = a.b + 2000;
                            break;
                    }
                    exVar.f3143b = TextUtils.isEmpty(a.c) ? "" : a.c;
                } else {
                    exVar.f3144c = (String) ((Pair) ((Map) a.f2058a).get(str)).first;
                    exVar.f3145d = (String) ((Pair) ((Map) a.f2058a).get(str)).second;
                }
                this.f3126b.f3122d.put(str, exVar);
            }
            return;
        }
        for (String str2 : this.f3126b.f3121c) {
            C0621a a2 = c0652z.m3058a(this.f3126b.f3120b, str2);
            ex exVar2 = new ex();
            if (a2.b != 0) {
                switch (a2.b) {
                    case ICallback.LOGIN_OAUTH_AIDL /*1002*/:
                        exVar2.f3142a = 1001;
                        break;
                    case 90001:
                        exVar2.f3142a = ICallback.LOGIN_OAUTH_AIDL;
                        break;
                    default:
                        exVar2.f3142a = a2.b + 2000;
                        break;
                }
                exVar2.f3143b = TextUtils.isEmpty(a2.c) ? "" : a2.c;
            } else {
                exVar2.f3144c = (String) ((Pair) a2.f2058a).first;
                exVar2.f3145d = (String) ((Pair) a2.f2058a).second;
            }
            this.f3126b.f3122d.put(str2, exVar2);
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f3126b.f3123e != null) {
            this.f3126b.f3123e.run(this.f3126b.f3122d);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        C0328a.m757c().m764b(this.f3126b.f3122d.size() == this.f3126b.f3121c.size());
        if (this.f3126b.f3122d.size() != this.f3126b.f3121c.size()) {
            for (String str2 : this.f3126b.f3121c) {
                if (!this.f3126b.f3122d.containsKey(str2)) {
                    ex exVar = new ex();
                    exVar.f3142a = 1000;
                    exVar.f3143b = "";
                    this.f3126b.f3122d.put(str2, exVar);
                }
            }
        }
        if (this.f3126b.f3123e != null) {
            this.f3126b.f3123e.run(this.f3126b.f3122d);
        }
    }

    /* renamed from: a */
    public void mo1024a(Exception exception) {
        for (String str : this.f3126b.f3121c) {
            ex exVar = new ex();
            exVar.f3142a = 1005;
            exVar.f3143b = TextUtils.isEmpty(exception.getMessage()) ? "" : exception.getMessage();
            this.f3126b.f3122d.put(str, exVar);
        }
        C0328a.m757c().m748a(LogLevel.ERROR, "dkbook", String.format("fail to get chapter links(book=%s, name=%s)", new Object[]{this.f3126b.f3120b, this.f3126b.f3124f.ay()}), (Throwable) exception);
    }

    /* renamed from: c */
    public boolean mo828c() {
        for (ex exVar : this.f3126b.f3122d.values()) {
            int i = exVar.f3142a - 2000;
            if (i == 1001 || i == ICallback.LOGIN_OAUTH_AIDL) {
                return true;
            }
            if (i == ICallback.CLEAR_ACCOUNT_AIDL) {
                return true;
            }
        }
        return false;
    }
}
