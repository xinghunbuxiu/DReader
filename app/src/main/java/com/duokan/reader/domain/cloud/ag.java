package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.p039e.C0606a;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.ReloginSession;
import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;
import com.mipay.sdk.Mipay;
import org.w3c.dom.Node;

class ag extends ReloginSession {
    /* renamed from: a */
    static final /* synthetic */ boolean f3679a = (!DkCloudStorage.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0672a f3680b;
    /* renamed from: c */
    final /* synthetic */ DkCloudReadingInfo f3681c;
    /* renamed from: d */
    final /* synthetic */ ak f3682d;
    /* renamed from: e */
    final /* synthetic */ String f3683e;
    /* renamed from: f */
    final /* synthetic */ ConflictStrategy f3684f;
    /* renamed from: g */
    final /* synthetic */ DkCloudReadingInfo f3685g;
    /* renamed from: h */
    final /* synthetic */ DkCloudStorage f3686h;
    /* renamed from: i */
    private C0621a<Node> f3687i = null;

    ag(DkCloudStorage dkCloudStorage, String str, C0657i c0657i, C0672a c0672a, DkCloudReadingInfo dkCloudReadingInfo, ak akVar, String str2, ConflictStrategy conflictStrategy, DkCloudReadingInfo dkCloudReadingInfo2) {
        this.f3686h = dkCloudStorage;
        this.f3680b = c0672a;
        this.f3681c = dkCloudReadingInfo;
        this.f3682d = akVar;
        this.f3683e = str2;
        this.f3684f = conflictStrategy;
        this.f3685g = dkCloudReadingInfo2;
        super(str, c0657i);
    }

    /* renamed from: a */
    public void mo825a() {
        this.f3687i = new DkSyncService((WebSession) this, this.f3680b).m2826a(this.f3681c.getCloudId(), this.f3681c.getIsDuokanBook(), this.f3681c.getCloudVersion());
    }

    /* renamed from: b */
    public void mo827b() {
        if (this.f3687i.b == 7) {
            try {
                DkCloudReadingInfo dkCloudReadingInfo = new DkCloudReadingInfo(this.f3681c.getIsDuokanBook(), this.f3681c.getBookName(), (Node) this.f3687i.f2058a, C0606a.m2773a(C0606a.m2783f((Node) this.f3687i.f2058a, Mipay.KEY_RESULT), "latestversion"));
                if (dkCloudReadingInfo.getBookRevision() == null || this.f3681c.getBookRevision() == null || dkCloudReadingInfo.getBookRevision().compareTo(this.f3681c.getBookRevision()) <= 0) {
                    switch (C0886u.f4195a[this.f3684f.ordinal()]) {
                        case 1:
                            break;
                        case 2:
                            dkCloudReadingInfo = this.f3681c;
                            break;
                        default:
                            dkCloudReadingInfo = (DkCloudReadingInfo) this.f3681c.merge(dkCloudReadingInfo);
                            break;
                    }
                    this.f3685g.setAnnotations(dkCloudReadingInfo.getAnnotations());
                    this.f3685g.setCloudVersion(dkCloudReadingInfo.getCloudVersion());
                    this.f3686h.m4997a(this.f3685g);
                    this.f3682d.mo1086b(this.f3681c, this.f3685g, this.f3683e);
                    return;
                }
                this.f3682d.mo1087b(this.f3681c, "", this.f3683e);
            } catch (Exception e) {
                e.printStackTrace();
                this.f3682d.mo1087b(this.f3681c, "", this.f3683e);
            }
        } else if (this.f3687i.b == 8) {
            this.f3685g.setAnnotations(this.f3681c.getAnnotations());
            this.f3682d.mo1086b(this.f3681c, this.f3685g, this.f3683e);
        } else if (this.f3687i.b != 0) {
            this.f3682d.mo1087b(this.f3681c, this.f3687i.c, this.f3683e);
        } else if (!f3679a) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo826a(String str) {
        this.f3682d.mo1087b(this.f3681c, str, this.f3683e);
    }

    /* renamed from: c */
    public boolean mo828c() {
        return this.f3687i.b == 3;
    }
}
