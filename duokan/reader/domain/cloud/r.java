package com.duokan.reader.domain.cloud;

import com.duokan.b.i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.DkStoreBookDetailInfo;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.common.webservices.duokan.z;
import com.duokan.reader.domain.account.a;

class r extends b {
    final /* synthetic */ a a;
    final /* synthetic */ q b;
    private com.duokan.reader.common.webservices.b c = null;
    private com.duokan.reader.common.webservices.b d = null;

    r(q qVar, a aVar) {
        this.b = qVar;
        this.a = aVar;
    }

    protected void onSessionTry() {
        v vVar = new v(this, this.a);
        aa aaVar = new aa((WebSession) this, this.a);
        this.c = vVar.a(this.b.a, false);
        this.d = aaVar.g(this.b.a, ((DkStoreBookDetailInfo) this.c.a).mRevision);
    }

    protected void onSessionSucceeded() {
        if (this.c.b == 0 && this.d.b == 0) {
            this.b.b.a(this.b.a, new DkCloudBookManifest(this.b.a, ((DkStoreBookDetailInfo) this.c.a).mRevision, ((DkStoreBookDetailInfo) this.c.a).mEpubUri, ((DkStoreBookDetailInfo) this.c.a).mEpubMd5, ((DkStoreBookDetailInfo) this.c.a).mOpfUri, "", (z) this.d.a));
            return;
        }
        this.b.b.a(this.b.a, this.b.c.c.getString(i.general__shared__network_error));
    }

    protected void onSessionFailed() {
        this.b.b.a(this.b.a, this.b.c.c.getString(i.general__shared__network_error));
    }
}
