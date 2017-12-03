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

public class DkUserPurchasedBooksManager implements ah {
    private static final ai a = new ai();
    private final Context b;
    private final i c;
    private final h d;
    private final CopyOnWriteArrayList e = new CopyOnWriteArrayList();
    private final b f = new b();
    private final b g = new b();
    private ct h = new ct();

    class DkUserPurchasedBooksInfo implements Serializable {
        public String mAccountName;
        public String mAccountUuid;
        public long mLatestFullRefreshTime;
        public long mLatestPurchaseTime;

        private DkUserPurchasedBooksInfo() {
            this.mAccountUuid = null;
            this.mAccountName = null;
            this.mLatestFullRefreshTime = 0;
            this.mLatestPurchaseTime = 0;
        }
    }

    private DkUserPurchasedBooksManager(Context context, i iVar) {
        this.b = context;
        this.c = iVar;
        this.d = new bm(this);
        DkApp.get().runWhenAppReady(new bv(this));
    }

    public static void a(Context context, i iVar) {
        a.a(new DkUserPurchasedBooksManager(context, iVar));
    }

    public static DkUserPurchasedBooksManager a() {
        return (DkUserPurchasedBooksManager) a.a();
    }

    public void a(cr crVar) {
        if (crVar != null && !this.e.contains(crVar)) {
            this.e.add(crVar);
        }
    }

    public void b(cr crVar) {
        if (crVar != null) {
            this.e.remove(crVar);
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

    public DkCloudPurchasedBook a(String str) {
        return this.h.a(str);
    }

    public DkCloudPurchasedBook b(String str) {
        return this.h.b(str);
    }

    public void a(DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.c.a(PersonalAccount.class, new bw(this, dkCloudPurchasedBook));
    }

    public DkCloudRedeemBenefit c(String str) {
        DkCloudPurchasedBook a = a(str);
        if (a != null) {
            return a.getRedeemMessage();
        }
        return null;
    }

    public void d(String str) {
        a(new bz(this, str));
    }

    public void a(a aVar) {
        TaskHandler.PostTask(new cb(this, aVar));
    }

    public void b(a aVar) {
        TaskHandler.PostTask(new cd(this, aVar));
    }

    public void a(boolean z, a aVar) {
        if (z) {
            a(aVar);
        } else {
            b(aVar);
        }
    }

    public void a(String str, a aVar) {
        if (!this.c.a(PersonalAccount.class)) {
            aVar.a(-1, "");
        }
        this.c.a(PersonalAccount.class, new cg(this, str, aVar));
    }

    public void a(boolean z, boolean z2, a aVar) {
        if (z || this.c.a(PersonalAccount.class)) {
            this.c.a(PersonalAccount.class, new cj(this, z, z2, aVar));
        } else {
            aVar.a(-1, "");
        }
    }

    public void a(boolean z) {
        a(z, true);
    }

    public void a(boolean z, boolean z2) {
        b(z, z2, c.a);
    }

    public void b(boolean z, boolean z2, a aVar) {
        if (z || this.c.a(PersonalAccount.class)) {
            this.c.a(PersonalAccount.class, new cl(this, z2, aVar, z));
        } else {
            aVar.a(-1, "");
        }
    }

    public void a(a aVar, String... strArr) {
        this.c.a(PersonalAccount.class, new bn(this, strArr, aVar));
    }

    public void e(String str) {
        if (this.c.a(PersonalAccount.class) && this.h.c(str)) {
            b(str, c.a);
        }
    }

    private void b(String str, a aVar) {
        this.c.a(PersonalAccount.class, new br(this, str, aVar));
    }

    private List a(cv cvVar) {
        List arrayList = new ArrayList(cvVar.queryItems());
        Collections.sort(arrayList, new cp());
        return arrayList;
    }

    private List b(cv cvVar) {
        List arrayList = new ArrayList(cvVar.queryCorePropertiesOfItems());
        Collections.sort(arrayList, new cp());
        return arrayList;
    }

    private void f() {
        for (int i = 0; i < this.e.size(); i++) {
            ((cr) this.e.get(i)).b();
        }
    }

    private void a(List list) {
        for (int i = 0; i < this.e.size(); i++) {
            ((cr) this.e.get(i)).a(list);
        }
    }

    private void g() {
        for (int i = 0; i < this.e.size(); i++) {
            ((cr) this.e.get(i)).d();
        }
    }

    private void a(String[] strArr) {
        for (int i = 0; i < this.e.size(); i++) {
            ((cr) this.e.get(i)).a(strArr);
        }
    }

    private static ab h() {
        return new ab(i.f().b(PersonalAccount.class));
    }
}
