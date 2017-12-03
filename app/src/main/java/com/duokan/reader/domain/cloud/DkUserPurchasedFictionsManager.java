package com.duokan.reader.domain.cloud;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.common.async.a.b;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DkUserPurchasedFictionsManager implements ah {
    private static final ai a = new ai();
    private final Context b;
    private final i c;
    private final h d;
    private final CopyOnWriteArrayList e = new CopyOnWriteArrayList();
    private final b f = new b();
    private final b g = new b();
    private eg h = new eg();

    class DkUserPurchasedFictionsInfo implements Serializable {
        public String mAccountName;
        public String mAccountUuid;
        public long mLatestFullRefreshTime;
        public long mLatestPurchaseTime;

        private DkUserPurchasedFictionsInfo() {
            this.mAccountUuid = null;
            this.mAccountName = null;
            this.mLatestPurchaseTime = 0;
        }
    }

    private DkUserPurchasedFictionsManager(Context context, i iVar) {
        this.b = context;
        this.c = iVar;
        this.d = new cx(this);
        DkApp.get().runPreReady(new di(this));
    }

    public static void a(Context context, i iVar) {
        a.a(new DkUserPurchasedFictionsManager(context, iVar));
    }

    public static DkUserPurchasedFictionsManager a() {
        return (DkUserPurchasedFictionsManager) a.a();
    }

    public void a(ec ecVar) {
        if (ecVar != null && !this.e.contains(ecVar)) {
            this.e.add(ecVar);
        }
    }

    public void b(ec ecVar) {
        if (ecVar != null) {
            this.e.remove(ecVar);
        }
    }

    public List b() {
        return this.h.a();
    }

    public List c() {
        return this.h.b();
    }

    public boolean d() {
        return this.h.d();
    }

    public DkCloudPurchasedFiction a(String str) {
        return this.h.a(str);
    }

    public DkCloudPurchasedFiction b(String str) {
        return this.h.b(str);
    }

    public boolean c(String str) {
        return this.h.c(str);
    }

    public void a(a aVar) {
        TaskHandler.PostTask(new dj(this, aVar));
    }

    public void b(a aVar) {
        TaskHandler.PostTask(new dl(this, aVar));
    }

    public void a(boolean z, a aVar) {
        if (z) {
            a(aVar);
        } else {
            b(aVar);
        }
    }

    public void b(boolean z, a aVar) {
        a(z, true, aVar);
    }

    public void a(boolean z, boolean z2, a aVar) {
        if (z || this.c.a(PersonalAccount.class)) {
            this.c.a(PersonalAccount.class, new dp(this, z2, aVar, z));
        } else {
            TaskHandler.b(new do (this, aVar));
        }
    }

    public void b(boolean z, boolean z2, a aVar) {
        if (z || this.c.a(PersonalAccount.class)) {
            this.c.a(PersonalAccount.class, new du(this, z, z2, aVar));
        } else {
            TaskHandler.PostTask(new dt(this, aVar));
        }
    }

    public void a(a aVar, String... strArr) {
        this.c.a(PersonalAccount.class, new dw(this, strArr, aVar));
    }

    public void d(String str) {
        if (this.c.a(PersonalAccount.class) && c(str)) {
            b(str, c.a);
        }
    }

    public void a(String str, a aVar) {
        this.c.a(PersonalAccount.class, new cy(this, str, aVar));
    }

    public void a(String str, List list, a aVar) {
        this.c.a(PersonalAccount.class, new db(this, str, list, aVar));
    }

    private void b(String str, a aVar) {
        this.c.a(PersonalAccount.class, new de(this, str, aVar));
    }

    private List a(ei eiVar) {
        List arrayList = new ArrayList(eiVar.queryItems());
        Collections.sort(arrayList, new eb());
        return arrayList;
    }

    private List b(ei eiVar) {
        List arrayList = new ArrayList(eiVar.queryCorePropertiesOfItems());
        Collections.sort(arrayList, new eb());
        return arrayList;
    }

    private void f() {
        for (int i = 0; i < this.e.size(); i++) {
            ((ec) this.e.get(i)).e();
        }
    }

    private void a(String[] strArr) {
        for (int i = 0; i < this.e.size(); i++) {
            ((ec) this.e.get(i)).b(strArr);
        }
    }

    private void a(List list) {
        for (int i = 0; i < this.e.size(); i++) {
            ((ec) this.e.get(i)).b(list);
        }
    }

    private static ab g() {
        return new ab(i.f().b(PersonalAccount.class));
    }
}
