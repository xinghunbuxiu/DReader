package com.duokan.reader.ui.reading;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.core.sys.t;
import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.bd;
import com.duokan.reader.domain.cloud.bk;
import com.duokan.reader.domain.cloud.ec;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.ui.general.be;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class aaj extends rx implements ec, aaq {
    final /* synthetic */ zo d;

    protected aaj(zo zoVar) {
        this.d = zoVar;
        super(zoVar);
    }

    public boolean b(ak akVar) {
        if (akVar.f()) {
            return false;
        }
        long[] a = a(akVar);
        for (long j : a) {
            if (j < 0 || j >= a()) {
                return false;
            }
            if (!d(a(j)) && j(j).b(Boolean.valueOf(false)) && !this.d.c.ah()) {
                return false;
            }
        }
        return true;
    }

    public void a(boolean z) {
        if (this.d.N.b(Boolean.valueOf(true))) {
            this.d.N.c();
        }
        this.d.C();
        if (!this.d.L.isEmpty()) {
            this.d.L.clear();
            this.d.F();
        }
        if (!this.d.Q.isEmpty()) {
            this.d.Q.clear();
            this.d.I();
        }
        if (z) {
            this.d.e.f();
        }
        this.d.h.a(null);
        super.a(false);
    }

    public void a(ak akVar, boolean z, ag agVar) {
        b(akVar, z, new aak(this, agVar, z));
    }

    public short g(long j) {
        return ((ej) this.d.f).j(j);
    }

    public boolean h(long j) {
        if (e(j)) {
            return false;
        }
        return true;
    }

    public List c(as asVar) {
        if (this.d.f.o() != BookType.SERIAL) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(2);
        long[] a = a(asVar.l());
        for (long a2 : a) {
            CharSequence a3 = a(a2);
            if (!TextUtils.isEmpty(a3)) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    public List d(as asVar) {
        if (this.d.f.o() != BookType.SERIAL) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(2);
        long[] a = a(asVar.l());
        for (long j : a) {
            if (h(j)) {
                arrayList.add(a(j));
            }
        }
        return arrayList;
    }

    public boolean e(ak akVar) {
        if (!this.d.f.ai()) {
            return super.e(akVar);
        }
        this.d.c.getDocument().d((a) akVar);
        akVar.e();
        long a = a() - 1;
        if (akVar instanceof com.duokan.reader.domain.document.txt.a) {
            akVar = ((com.duokan.reader.domain.document.txt.a) akVar).p();
        }
        if (a(akVar)[0] < a || !akVar.f()) {
            return false;
        }
        return true;
    }

    public boolean d(String str) {
        return ((ej) this.d.f).u(str);
    }

    public af i(long j) {
        return (af) this.d.a.get(a(j));
    }

    public af j(long j) {
        af afVar;
        if (!this.d.f.aj()) {
            bk b = bd.a().b();
            long j2 = this.d.f.l() ? b.c : b.b;
            if (this.d.f.K() == 0 || (j2 > System.currentTimeMillis() && this.d.f.v())) {
                afVar = new af(Boolean.valueOf(true));
            } else if (g(j) == (short) 0) {
                afVar = new af(Boolean.valueOf(true));
            } else {
                afVar = new af(Boolean.valueOf(false));
            }
        } else if (g(j) == (short) 0) {
            afVar = new af(Boolean.valueOf(true));
        } else {
            afVar = new af();
        }
        String a = a(j);
        if (!TextUtils.isEmpty(a)) {
            DkCloudPurchasedFiction b2 = DkUserPurchasedFictionsManager.a().b(this.d.f.H());
            if (b2 != null) {
                if (this.d.f.aj()) {
                    af checkChapterPurchased = b2.checkChapterPurchased(a);
                    if (checkChapterPurchased.b()) {
                        afVar.a(checkChapterPurchased.a());
                    }
                } else if (b2.isEntirePaid()) {
                    afVar.a(Boolean.valueOf(true));
                } else if (!this.d.c.bn()) {
                    afVar.a(Boolean.valueOf(true));
                } else if (b2.checkChapterPurchased(a).b(Boolean.valueOf(true))) {
                    afVar.a(Boolean.valueOf(true));
                }
            }
        }
        return afVar;
    }

    public boolean c(long j) {
        if (!this.d.c.ah() || !j(j).b(Boolean.valueOf(false))) {
            return false;
        }
        String a = a(j);
        if (TextUtils.isEmpty(a) || d(a)) {
            return false;
        }
        return true;
    }

    public boolean g_() {
        return (this.d.f.aj() || this.d.c.h()) ? false : true;
    }

    public void c() {
        if (f.b().e()) {
            Runnable com_duokan_reader_ui_reading_aao = new aao(this);
            if (this.d.f.aG()) {
                ((ej) this.d.f).a(new aap(this, com_duokan_reader_ui_reading_aao));
                return;
            } else {
                com_duokan_reader_ui_reading_aao.run();
                return;
            }
        }
        be.a(this.d.getContext(), j.general__shared__network_error, 1).show();
    }

    public boolean b(ba baVar) {
        com.duokan.core.diagnostic.a.c().b(t.a());
        if (this.d.K.contains(a(a(baVar)))) {
            return true;
        }
        List<String> D = ((as) baVar).D();
        if (D.isEmpty()) {
            return false;
        }
        for (String containsKey : D) {
            if (this.d.Q.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public int c(ba baVar) {
        com.duokan.core.diagnostic.a.c().b(t.a());
        if (this.d.L.isEmpty() && this.d.Q.isEmpty()) {
            return -1;
        }
        Integer num = (Integer) this.d.L.get(a(a(baVar)));
        if (num != null) {
            return num.intValue();
        }
        for (String str : ((as) baVar).D()) {
            num = (Integer) this.d.Q.get(str);
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    public void a(n nVar, as asVar) {
        super.a(nVar, asVar);
        if (this.d.f.k()) {
            this.d.F();
        }
    }

    public void b(n nVar, as asVar) {
        super.b(nVar, asVar);
        if (this.d.f.k()) {
            this.d.I();
        }
    }

    public void e() {
        if (this.d.f.k()) {
            j(true);
        }
    }

    public void b(String[] strArr) {
    }

    public void b(List list) {
    }
}
