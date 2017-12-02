package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import android.util.Pair;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;

import java.util.Map;

import miuipub.date.Calendar;

class ex extends c {
    final /* synthetic */ ew a;
    private final a b = i.f().b(PersonalAccount.class);

    ex(ew ewVar) {
        this.a = ewVar;
    }

    protected void onSessionTry() {
        aa aaVar = new aa((WebSession) this, this.b);
        if (this.a.a) {
            b a = aaVar.a(this.a.b, (String[]) this.a.c.toArray(new String[0]));
            for (String str : this.a.c) {
                fd fdVar = new fd();
                if (a.b != 0) {
                    switch (a.b) {
                        case 1002:
                            fdVar.a = 1001;
                            break;
                        case 90001:
                            fdVar.a = 1002;
                            break;
                        default:
                            fdVar.a = a.b + 2000;
                            break;
                    }
                    fdVar.b = TextUtils.isEmpty(a.c) ? "" : a.c;
                } else {
                    fdVar.c = (String) ((Pair) ((Map) a.a).get(str)).first;
                    fdVar.d = (String) ((Pair) ((Map) a.a).get(str)).second;
                }
                this.a.d.put(str, fdVar);
            }
            return;
        }
        for (String str2 : this.a.c) {
            b a2 = aaVar.a(this.a.b, str2);
            fd fdVar2 = new fd();
            if (a2.b != 0) {
                switch (a2.b) {
                    case 1002:
                        fdVar2.a = 1001;
                        break;
                    case 90001:
                        fdVar2.a = 1002;
                        break;
                    default:
                        fdVar2.a = a2.b + 2000;
                        break;
                }
                fdVar2.b = TextUtils.isEmpty(a2.c) ? "" : a2.c;
            } else {
                fdVar2.c = (String) ((Pair) a2.a).first;
                fdVar2.d = (String) ((Pair) a2.a).second;
            }
            this.a.d.put(str2, fdVar2);
        }
    }

    protected void onSessionSucceeded() {
        Object obj;
        for (fd fdVar : this.a.d.values()) {
            int i = fdVar.a - 2000;
            if (i != 1001 && i != 1002) {
                if (i == 1003) {
                    obj = 1;
                    break;
                }
            }
            obj = 1;
            break;
        }
        obj = null;
        if (obj != null) {
            i.f().a(this.b.b(), new ey(this));
        } else if (this.a.e != null) {
            this.a.e.a(this.a.d);
        }
    }

    protected boolean onSessionException(Exception exception, int i) {
        for (String str : this.a.c) {
            fd fdVar = new fd();
            fdVar.a = 1005;
            fdVar.b = TextUtils.isEmpty(exception.getMessage()) ? "" : exception.getMessage();
            this.a.d.put(str, fdVar);
        }
        com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "dkbook", String.format("fail to get chapter links(book=%s, name=%s)", new Object[]{this.a.b, this.a.f.aw()}), (Throwable) exception);
        return super.onSessionException(exception, i);
    }

    protected void onSessionFailed() {
        com.duokan.core.diagnostic.a.c().b(this.a.d.size() == this.a.c.size());
        if (this.a.d.size() != this.a.c.size()) {
            for (String str : this.a.c) {
                if (!this.a.d.containsKey(str)) {
                    fd fdVar = new fd();
                    fdVar.a = Calendar.MILLISECOND_OF_SECOND;
                    fdVar.b = "";
                    this.a.d.put(str, fdVar);
                }
            }
        }
        if (this.a.e != null) {
            this.a.e.a(this.a.d);
        }
    }
}
