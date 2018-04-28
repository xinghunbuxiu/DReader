package com.duokan.reader.domain.cloud;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.UThread;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.common.async.p035a.C0518b;
import com.duokan.reader.common.async.p035a.C0519c;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DkUserPurchasedFictionsManager implements ai {
    /* renamed from: a */
    private static final aj<DkUserPurchasedFictionsManager> f3609a = new aj();
    /* renamed from: b */
    private final Context f3610b;
    /* renamed from: c */
    private final C0709k f3611c;
    /* renamed from: d */
    private final C0586j f3612d;
    /* renamed from: e */
    private final CopyOnWriteArrayList<dn> f3613e = new CopyOnWriteArrayList();
    /* renamed from: f */
    private final C0518b<Void> f3614f = new C0518b();
    /* renamed from: g */
    private final C0518b<Void> f3615g = new C0518b();
    /* renamed from: h */
    private dr f3616h = new dr();

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

    private DkUserPurchasedFictionsManager(Context context, C0709k c0709k) {
        this.f3610b = context;
        this.f3611c = c0709k;
        this.f3612d = new cl(this);
        DkApp.get().runPreReady(new cv(this));
    }

    /* renamed from: a */
    public static void m5076a(Context context, C0709k c0709k) {
        f3609a.m709a(new DkUserPurchasedFictionsManager(context, c0709k));
    }

    /* renamed from: a */
    public static DkUserPurchasedFictionsManager m5072a() {
        return (DkUserPurchasedFictionsManager) f3609a.m707a();
    }

    /* renamed from: a */
    public void m5096a(dn dnVar) {
        if (dnVar != null && !this.f3613e.contains(dnVar)) {
            this.f3613e.add(dnVar);
        }
    }

    /* renamed from: b */
    public void m5104b(dn dnVar) {
        if (dnVar != null) {
            this.f3613e.remove(dnVar);
        }
    }

    /* renamed from: b */
    public List<DkCloudPurchasedFiction> m5102b() {
        return this.f3616h.m5459a();
    }

    /* renamed from: c */
    public List<DkCloudPurchasedFiction> m5107c() {
        return this.f3616h.m5463b();
    }

    /* renamed from: d */
    public boolean m5110d() {
        return this.f3616h.m5466d();
    }

    /* renamed from: a */
    public DkCloudPurchasedFiction m5093a(String str) {
        return this.f3616h.m5458a(str);
    }

    /* renamed from: b */
    public DkCloudPurchasedFiction m5101b(String str) {
        return this.f3616h.m5462b(str);
    }

    /* renamed from: c */
    public boolean m5108c(String str) {
        return this.f3616h.m5465c(str);
    }

    /* renamed from: a */
    public void m5094a(C0517a<Void> c0517a) {
        UThread.post(new cw(this, c0517a));
    }

    /* renamed from: b */
    public void m5103b(C0517a<Void> c0517a) {
        UThread.post(new cy(this, c0517a));
    }

    /* renamed from: a */
    public void m5099a(boolean z, C0517a<Void> c0517a) {
        if (z) {
            m5094a((C0517a) c0517a);
        } else {
            m5103b((C0517a) c0517a);
        }
    }

    /* renamed from: b */
    public void m5105b(boolean z, C0517a<Void> c0517a) {
        m5100a(z, true, (C0517a) c0517a);
    }

    /* renamed from: a */
    public void m5100a(boolean z, boolean z2, C0517a<Void> c0517a) {
        if (z || this.f3611c.m3500a(PersonalAccount.class)) {
            this.f3611c.m3497a(PersonalAccount.class, new dc(this, z2, c0517a, z));
        } else {
            UThread.post(new db(this, c0517a));
        }
    }

    /* renamed from: b */
    public void m5106b(boolean z, boolean z2, C0517a<Void> c0517a) {
        if (z || this.f3611c.m3500a(PersonalAccount.class)) {
            this.f3611c.m3497a(PersonalAccount.class, new dg(this, z, z2, c0517a));
        } else {
            UThread.post(new df(this, c0517a));
        }
    }

    /* renamed from: a */
    public void m5095a(C0517a<Void> c0517a, String... strArr) {
        this.f3611c.m3497a(PersonalAccount.class, new di(this, strArr, c0517a));
    }

    /* renamed from: d */
    public void m5109d(String str) {
        if (this.f3611c.m3500a(PersonalAccount.class) && m5108c(str)) {
            m5085b(str, C0519c.f1752a);
        }
    }

    /* renamed from: a */
    public void m5097a(String str, C0517a<DkCloudPurchasedFiction> c0517a) {
        this.f3611c.m3497a(PersonalAccount.class, new cm(this, str, c0517a));
    }

    /* renamed from: a */
    public void m5098a(String str, List<String> list, C0517a<DkCloudPurchasedFiction> c0517a) {
        this.f3611c.m3497a(PersonalAccount.class, new cp(this, str, list, c0517a));
    }

    /* renamed from: b */
    private void m5085b(String str, C0517a<Void> c0517a) {
        this.f3611c.m3497a(PersonalAccount.class, new cs(this, str, c0517a));
    }

    /* renamed from: a */
    private List<DkCloudPurchasedFiction> m5075a(dt dtVar) {
        List<DkCloudPurchasedFiction> arrayList = new ArrayList(dtVar.queryItems());
        Collections.sort(arrayList, new dm());
        return arrayList;
    }

    /* renamed from: b */
    private List<DkCloudPurchasedFiction> m5084b(dt dtVar) {
        List<DkCloudPurchasedFiction> arrayList = new ArrayList(dtVar.queryCorePropertiesOfItems());
        Collections.sort(arrayList, new dm());
        return arrayList;
    }

    /* renamed from: f */
    private void m5091f() {
        for (int i = 0; i < this.f3613e.size(); i++) {
            ((dn) this.f3613e.get(i)).mo966e();
        }
    }

    /* renamed from: a */
    private void m5081a(String[] strArr) {
        for (int i = 0; i < this.f3613e.size(); i++) {
            ((dn) this.f3613e.get(i)).mo964b(strArr);
        }
    }

    /* renamed from: a */
    private void m5080a(List<DkCloudStoreBook> list) {
        for (int i = 0; i < this.f3613e.size(); i++) {
            ((dn) this.f3613e.get(i)).mo963b((List) list);
        }
    }

    /* renamed from: g */
    private static al m5092g() {
        return new al(C0709k.m3476a().m3502b(PersonalAccount.class));
    }
}
