package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkSyncService;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;
import com.mipay.sdk.Mipay;

import org.w3c.dom.Node;

class am extends b {
    static final /* synthetic */ boolean a = (!DkCloudStorage.class.desiredAssertionStatus());
    final /* synthetic */ a b;
    final /* synthetic */ DkCloudReadingInfo c;
    final /* synthetic */ String d;
    final /* synthetic */ DkCloudReadingInfo e;
    final /* synthetic */ ConflictStrategy f;
    final /* synthetic */ String g;
    final /* synthetic */ ar h;
    final /* synthetic */ DkCloudStorage i;
    private com.duokan.reader.common.webservices.b j = null;

    am(DkCloudStorage dkCloudStorage, a aVar, DkCloudReadingInfo dkCloudReadingInfo, String str, DkCloudReadingInfo dkCloudReadingInfo2, ConflictStrategy conflictStrategy, String str2, ar arVar) {
        this.i = dkCloudStorage;
        this.b = aVar;
        this.c = dkCloudReadingInfo;
        this.d = str;
        this.e = dkCloudReadingInfo2;
        this.f = conflictStrategy;
        this.g = str2;
        this.h = arVar;
    }

    protected void onSessionTry() {
        this.j = new DkSyncService((WebSession) this, this.b).a(this.c.getCloudId(), this.c.getIsDuokanBook(), this.c.getCloudVersion());
    }

    protected void onSessionSucceeded() {
        if (this.j.b == 3) {
            i.f().a(this.d, new an(this));
        } else if (this.j.b == 7) {
            try {
                DkCloudReadingInfo dkCloudReadingInfo = new DkCloudReadingInfo(this.c.getIsDuokanBook(), this.c.getBookName(), (Node) this.j.a, com.duokan.reader.common.e.a.a(com.duokan.reader.common.e.a.f((Node) this.j.a, Mipay.KEY_RESULT), "latestversion"));
                if (dkCloudReadingInfo.getBookRevision() == null || this.c.getBookRevision() == null || dkCloudReadingInfo.getBookRevision().compareTo(this.c.getBookRevision()) <= 0) {
                    switch (x.a[this.f.ordinal()]) {
                        case 1:
                            break;
                        case 2:
                            dkCloudReadingInfo = this.c;
                            break;
                        default:
                            dkCloudReadingInfo = (DkCloudReadingInfo) this.c.merge(dkCloudReadingInfo);
                            break;
                    }
                    this.e.setAnnotations(dkCloudReadingInfo.getAnnotations());
                    this.e.setCloudVersion(dkCloudReadingInfo.getCloudVersion());
                    this.i.a(this.e);
                    this.h.b(this.c, this.e, this.g);
                    return;
                }
                this.h.b(this.c, "", this.g);
            } catch (Exception e) {
                e.printStackTrace();
                this.h.b(this.c, "", this.g);
            }
        } else if (this.j.b == 8) {
            this.e.setAnnotations(this.c.getAnnotations());
            this.h.b(this.c, this.e, this.g);
        } else if (this.j.b != 0) {
            this.h.b(this.c, this.j.c, this.g);
        } else if (!a) {
            throw new AssertionError();
        }
    }

    protected void onSessionFailed() {
        this.h.b(this.c, this.i.c.getString(com.duokan.b.i.general__shared__network_error), this.g);
    }
}
