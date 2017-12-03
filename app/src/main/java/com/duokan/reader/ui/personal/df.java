package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.a.c;
import com.duokan.reader.domain.account.i;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;

import java.io.File;

class df extends r {
    final /* synthetic */ File a;
    final /* synthetic */ String b;
    final /* synthetic */ da c;
    private b d = null;
    private boolean e = false;

    df(da daVar, File file, String str) {
        this.c = daVar;
        this.a = file;
        this.b = str;
    }

    protected void onSessionTry() {
        File parentFile = this.a.getParentFile();
        String name = this.a.getName();
        String[] list = parentFile.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(name)) {
                    new File(parentFile.getAbsolutePath() + "/" + str).delete();
                }
            }
        }
        c cVar = new c(this);
        ExtendedAuthToken.parse(this.b);
        try {
            this.d = cVar.e(this.c.g);
        } catch (AuthenticationFailureException e) {
            this.e = true;
            throw e;
        }
    }

    protected void onSessionSucceeded() {
        if (this.d.b == 0) {
            MiAccount miAccount = (MiAccount) i.f().b(MiAccount.class);
            miAccount.e(this.c.g);
            this.c.f.b();
            miAccount.a(null, new dg(this));
            return;
        }
        this.c.f.a(this.d.c);
    }

    protected void onSessionFailed() {
        if (this.e) {
            e.a(DkApp.get().getApplicationContext()).a("com.xiaomi", this.b);
            this.c.b(this.c.f);
            return;
        }
        this.c.f.a(this.c.a.getString(j.general__shared__network_error));
    }
}
