package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.common.webservices.duokan.DkStoreBookInfo;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.store.DkStoreBook;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.HashSet;

class at extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3708a;
    /* renamed from: b */
    final /* synthetic */ as f3709b;
    /* renamed from: c */
    private C0621a<DkStoreBookInfo[]> f3710c = null;
    /* renamed from: d */
    private DkStoreBook[] f3711d = new DkStoreBook[0];
    /* renamed from: e */
    private HashSet<String> f3712e = new HashSet();

    at(as asVar, String str, C0657i c0657i, al alVar) {
        this.f3709b = asVar;
        this.f3708a = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        int i = 0;
        this.f3710c = new C0640n(this, this.f3708a).m2912a(this.f3709b.f3704a, this.f3709b.f3705b);
        if (this.f3710c.b == 0) {
            int i2;
            DkStoreBook[] dkStoreBookArr = new DkStoreBook[((DkStoreBookInfo[]) this.f3710c.f2058a).length];
            for (i2 = 0; i2 < dkStoreBookArr.length; i2++) {
                dkStoreBookArr[i2] = new DkStoreBook(((DkStoreBookInfo[]) this.f3710c.f2058a)[i2]);
            }
            this.f3711d = new DkStoreBook[dkStoreBookArr.length];
            for (int i3 = 0; i3 < dkStoreBookArr.length; i3++) {
                this.f3711d[i3] = dkStoreBookArr[i3];
            }
            DkStoreBook[] dkStoreBookArr2 = this.f3711d;
            i2 = dkStoreBookArr2.length;
            while (i < i2) {
                this.f3712e.add(dkStoreBookArr2[i].getBookUuid());
                i++;
            }
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f3708a.m3365a(this.f3709b.f3707d.f3700f) && this.f3710c.b == 0) {
            this.f3709b.f3707d.f3701g = Integer.parseInt(this.f3710c.c);
            PersonalPrefs.m5175a().m5211b(this.f3709b.f3707d.f3701g);
            this.f3709b.f3707d.m5300c();
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        if (!this.f3708a.m3365a(this.f3709b.f3707d.f3700f)) {
        }
    }

    /* renamed from: c */
    public boolean mo828c() {
        return (this.f3710c.b == 1001 || this.f3710c.b == ICallback.LOGIN_OAUTH_AIDL || this.f3710c.b == ICallback.CLEAR_ACCOUNT_AIDL) && this.f3709b.f3706c;
    }
}
