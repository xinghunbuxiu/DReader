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

public class DkUserPurchasedBooksManager implements ai {
    /* renamed from: a */
    private static final aj<DkUserPurchasedBooksManager> f3601a = new aj();
    /* renamed from: b */
    private final Context f3602b;
    /* renamed from: c */
    private final C0709k f3603c;
    /* renamed from: d */
    private final C0586j f3604d;
    /* renamed from: e */
    private final CopyOnWriteArrayList<cf> f3605e = new CopyOnWriteArrayList();
    /* renamed from: f */
    private final C0518b<Void> f3606f = new C0518b();
    /* renamed from: g */
    private final C0518b<Void> f3607g = new C0518b();
    /* renamed from: h */
    private ch f3608h = new ch();

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

    private DkUserPurchasedBooksManager(Context context, C0709k c0709k) {
        this.f3602b = context;
        this.f3603c = c0709k;
        this.f3604d = new bd(this);
        DkApp.get().runWhenAppReady(new bk(this));
    }

    /* renamed from: a */
    public static void m5033a(Context context, C0709k c0709k) {
        f3601a.m709a(new DkUserPurchasedBooksManager(context, c0709k));
    }

    /* renamed from: a */
    public static DkUserPurchasedBooksManager m5029a() {
        return (DkUserPurchasedBooksManager) f3601a.m707a();
    }

    /* renamed from: a */
    public void m5056a(cf cfVar) {
        if (cfVar != null && !this.f3605e.contains(cfVar)) {
            this.f3605e.add(cfVar);
        }
    }

    /* renamed from: b */
    public void m5065b(cf cfVar) {
        if (cfVar != null) {
            this.f3605e.remove(cfVar);
        }
    }

    /* renamed from: b */
    public List<DkCloudPurchasedBook> m5063b() {
        return this.f3608h.m5396a();
    }

    /* renamed from: c */
    public List<DkCloudPurchasedBook> m5068c() {
        return this.f3608h.m5400b();
    }

    /* renamed from: d */
    public boolean m5070d() {
        return this.f3608h.m5403d();
    }

    /* renamed from: a */
    public DkCloudPurchasedBook m5052a(String str) {
        return this.f3608h.m5395a(str);
    }

    /* renamed from: b */
    public DkCloudPurchasedBook m5062b(String str) {
        return this.f3608h.m5399b(str);
    }

    /* renamed from: a */
    public void m5055a(DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.f3603c.m3497a(PersonalAccount.class, new bl(this, dkCloudPurchasedBook));
    }

    /* renamed from: c */
    public DkCloudRedeemBenefit m5067c(String str) {
        DkCloudPurchasedBook a = m5052a(str);
        if (a != null) {
            return a.getRedeemMessage();
        }
        return null;
    }

    /* renamed from: d */
    public void m5069d(String str) {
        m5053a(new bo(this, str));
    }

    /* renamed from: a */
    public void m5053a(C0517a<Void> c0517a) {
        UThread.post(new bq(this, c0517a));
    }

    /* renamed from: b */
    public void m5064b(C0517a<Void> c0517a) {
        UThread.post(new bs(this, c0517a));
    }

    /* renamed from: a */
    public void m5059a(boolean z, C0517a<Void> c0517a) {
        if (z) {
            m5053a((C0517a) c0517a);
        } else {
            m5064b((C0517a) c0517a);
        }
    }

    /* renamed from: a */
    public void m5057a(String str, C0517a<Void> c0517a) {
        if (!this.f3603c.m3500a(PersonalAccount.class)) {
            c0517a.mo729a(-1, "");
        }
        this.f3603c.m3497a(PersonalAccount.class, new bv(this, str, c0517a));
    }

    /* renamed from: a */
    public void m5061a(boolean z, boolean z2, C0517a<Void> c0517a) {
        if (z || this.f3603c.m3500a(PersonalAccount.class)) {
            this.f3603c.m3497a(PersonalAccount.class, new by(this, z, z2, c0517a));
        } else {
            c0517a.mo729a(-1, "");
        }
    }

    /* renamed from: a */
    public void m5058a(boolean z) {
        m5060a(z, true);
    }

    /* renamed from: a */
    public void m5060a(boolean z, boolean z2) {
        m5066b(z, z2, C0519c.f1752a);
    }

    /* renamed from: b */
    public void m5066b(boolean z, boolean z2, C0517a c0517a) {
        if (z || this.f3603c.m3500a(PersonalAccount.class)) {
            this.f3603c.m3497a(PersonalAccount.class, new ca(this, z2, c0517a, z));
        } else {
            c0517a.mo729a(-1, "");
        }
    }

    /* renamed from: a */
    public void m5054a(C0517a<Void> c0517a, String... strArr) {
        this.f3603c.m3497a(PersonalAccount.class, new be(this, strArr, c0517a));
    }

    /* renamed from: e */
    public void m5071e(String str) {
        if (this.f3603c.m3500a(PersonalAccount.class) && this.f3608h.m5402c(str)) {
            m5042b(str, C0519c.f1752a);
        }
    }

    /* renamed from: b */
    private void m5042b(String str, C0517a<Void> c0517a) {
        this.f3603c.m3497a(PersonalAccount.class, new bh(this, str, c0517a));
    }

    /* renamed from: a */
    private List<DkCloudPurchasedBook> m5032a(cj cjVar) {
        List<DkCloudPurchasedBook> arrayList = new ArrayList(cjVar.queryItems());
        Collections.sort(arrayList, new cd());
        return arrayList;
    }

    /* renamed from: b */
    private List<DkCloudPurchasedBook> m5041b(cj cjVar) {
        List<DkCloudPurchasedBook> arrayList = new ArrayList(cjVar.queryCorePropertiesOfItems());
        Collections.sort(arrayList, new cd());
        return arrayList;
    }

    /* renamed from: f */
    private void m5048f() {
        for (int i = 0; i < this.f3605e.size(); i++) {
            ((cf) this.f3605e.get(i)).mo962b();
        }
    }

    /* renamed from: a */
    private void m5037a(List<DkCloudStoreBook> list) {
        for (int i = 0; i < this.f3605e.size(); i++) {
            ((cf) this.f3605e.get(i)).mo960a((List) list);
        }
    }

    /* renamed from: g */
    private void m5050g() {
        for (int i = 0; i < this.f3605e.size(); i++) {
            ((cf) this.f3605e.get(i)).mo965d();
        }
    }

    /* renamed from: a */
    private void m5038a(String[] strArr) {
        for (int i = 0; i < this.f3605e.size(); i++) {
            ((cf) this.f3605e.get(i)).mo961a(strArr);
        }
    }

    /* renamed from: h */
    private static al m5051h() {
        return new al(C0709k.m3476a().m3502b(PersonalAccount.class));
    }
}
