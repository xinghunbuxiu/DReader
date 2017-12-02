package com.duokan.reader.domain.store;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.common.webservices.duokan.y;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cmread.CmBookManager;

public class a implements ah {
    static final /* synthetic */ boolean c = (!a.class.desiredAssertionStatus());
    private static final ai d = new ai();
    protected final Context a;
    protected final i b;
    private l e = null;
    private WebSession f = null;
    private c g = null;

    protected a(Context context, i iVar) {
        this.a = context;
        this.b = iVar;
    }

    public void a(String str, boolean z, h hVar) {
        a(str, z, 0, null, hVar);
    }

    private void a(String str, boolean z, int i, String str2, h hVar) {
        if (!c && str == null) {
            throw new AssertionError();
        } else if (c || hVar != null) {
            c bVar = new b(this, hVar, str, z, str2);
            if (i > 0) {
                int max = Math.max(5000, i);
                bVar.setConnectTimeout(max);
                bVar.setReadTimeout(max);
            }
            bVar.open();
        } else {
            throw new AssertionError();
        }
    }

    public void b(String str, boolean z, h hVar) {
        a(str, z, false, -1, -1, 0, hVar);
    }

    public void a(String str, boolean z, boolean z2, int i, int i2, int i3, h hVar) {
        if (!c && str == null) {
            throw new AssertionError();
        } else if (!c && hVar == null) {
            throw new AssertionError();
        } else if (new y(str).b() == 1) {
            CmBookManager.get().fetchFictionDetail(str, z, z2, i, i2, i3, hVar);
        } else {
            new c(this, hVar, str, z, z2, i, i2, i3).open();
        }
    }

    public void a(String str, int i, int i2, i iVar) {
        if (this.g != null) {
            this.g.close();
            this.g = null;
        }
        this.g = new d(this, str, i, i2, iVar);
        this.g.open();
    }

    public void a(String str, k kVar) {
        if (this.f != null) {
            this.f.close();
            this.f = null;
        }
        this.f = new e(this, str, kVar);
        this.f.open();
    }

    public void a(String str, int i, int i2, g gVar) {
        if (c || gVar != null) {
            new f(this, str, i, i2, gVar).open();
            return;
        }
        throw new AssertionError();
    }

    public void a(l lVar) {
        this.e = lVar;
    }

    public static void a(Context context, i iVar) {
        d.a(new a(context, iVar));
    }

    public static a a() {
        return (a) d.a();
    }
}
