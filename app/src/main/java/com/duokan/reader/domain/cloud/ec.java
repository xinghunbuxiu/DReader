package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBookInfo;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;

class ec extends ReloginSession {
    /* renamed from: a */
    final /* synthetic */ al f3918a;
    /* renamed from: b */
    final /* synthetic */ eb f3919b;
    /* renamed from: c */
    private C0621a<ReadBookInfo[]> f3920c = null;
    /* renamed from: d */
    private ReadBook[] f3921d = new ReadBook[0];

    ec(eb ebVar, String str, C0657i c0657i, al alVar) {
        this.f3919b = ebVar;
        this.f3918a = alVar;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        int i = 0;
        this.f3920c = new C0640n(this, this.f3918a).m2914a(this.f3919b.f3913a, this.f3919b.f3914b);
        if (this.f3920c.b == 0) {
            ReadBook[] readBookArr = new ReadBook[((ReadBookInfo[]) this.f3920c.f2058a).length];
            for (int i2 = 0; i2 < readBookArr.length; i2++) {
                readBookArr[i2] = new ReadBook(((ReadBookInfo[]) this.f3920c.f2058a)[i2]);
            }
            this.f3921d = new ReadBook[readBookArr.length];
            while (i < readBookArr.length) {
                this.f3921d[i] = readBookArr[i];
                i++;
            }
        }
    }

    /* renamed from: b */
    public void mo827b() {
        if (!this.f3918a.m3365a(this.f3919b.f3917e.f3622f)) {
            this.f3919b.f3915c.mo1156a("");
        } else if (this.f3920c.b != 0) {
            this.f3919b.f3915c.mo1156a("");
        } else {
            if (this.f3919b.f3913a == 0) {
                this.f3919b.f3917e.m5118a(this.f3921d);
            } else {
                this.f3919b.f3917e.m5123b(this.f3921d);
            }
            this.f3919b.f3915c.mo1157a(this.f3921d, Boolean.parseBoolean(this.f3920c.c), false);
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        if (this.f3918a.m3365a(this.f3919b.f3917e.f3622f)) {
            this.f3919b.f3915c.mo1156a(str);
        } else {
            this.f3919b.f3915c.mo1156a("");
        }
    }

    /* renamed from: c */
    public boolean mo828c() {
        return (this.f3920c.b == 1001 || this.f3920c.b == ICallback.LOGIN_OAUTH_AIDL || this.f3920c.b == ICallback.CLEAR_ACCOUNT_AIDL) && this.f3919b.f3916d;
    }
}
