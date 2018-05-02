package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkStoreBookInfo;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.store.DkStoreBook;

import java.util.HashSet;

class ba extends r {
    final /* synthetic */ ab a;
    final /* synthetic */ az b;
    private b c = null;
    private DkStoreBook[] d = new DkStoreBook[0];
    private HashSet e = new HashSet();

    ba(az azVar, ab abVar) {
        this.b = azVar;
        this.a = abVar;
    }

    protected void onSessionTry() {
        int i = 0;
        this.c = new o(this, this.a).a(this.b.a, this.b.b);
        if (this.c.b == 0) {
            int i2;
            DkStoreBook[] dkStoreBookArr = new DkStoreBook[((DkStoreBookInfo[]) this.c.a).length];
            for (i2 = 0; i2 < dkStoreBookArr.length; i2++) {
                dkStoreBookArr[i2] = new DkStoreBook(((DkStoreBookInfo[]) this.c.a)[i2]);
            }
            this.d = new DkStoreBook[dkStoreBookArr.length];
            for (int i3 = 0; i3 < dkStoreBookArr.length; i3++) {
                this.d[i3] = dkStoreBookArr[i3];
            }
            DkStoreBook[] dkStoreBookArr2 = this.d;
            i2 = dkStoreBookArr2.length;
            while (i < i2) {
                this.e.add(dkStoreBookArr2[i].getBookUuid());
                i++;
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(this.b.d.f)) {
            return;
        }
        if (this.c.b == 1001 || this.c.b == 1002 || this.c.b == 1003) {
            if (this.b.c) {
                i.f().a(this.a.a, new bb(this));
            }
        } else if (this.c.b == 0) {
            this.b.d.g = Integer.parseInt(this.c.c);
            PersonalPrefs.a().b(this.b.d.g);
            this.b.d.c();
        }
    }

    protected void onSessionFailed() {
        if (!this.a.a(this.b.d.f)) {
        }
    }
}
