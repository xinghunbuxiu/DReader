package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.sys.ag;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.av;
import com.duokan.reader.domain.cloud.bb;
import com.duokan.reader.domain.cloud.dn;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.txt.C0939a;
import com.duokan.reader.ui.general.be;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class aaw extends si implements dn, abd {
    /* renamed from: d */
    final /* synthetic */ aab f9363d;

    protected aaw(aab aab) {
        this.f9363d = aab;
        super(aab);
    }

    /* renamed from: b */
    public boolean mo2186b(ak akVar) {
        if (akVar.m5817f()) {
            return false;
        }
        long[] a = mo2358a(akVar);
        for (long j : a) {
            if (j < 0 || j >= mo2354a()) {
                return false;
            }
            if (!mo2192c(mo2356a(j)) && mo2197j(j).m862b(Boolean.valueOf(false)) && !this.f9363d.c.ah()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo2185a(boolean z) {
        if (this.f9363d.f9307N.m862b(Boolean.valueOf(true))) {
            this.f9363d.f9307N.m863c();
        }
        this.f9363d.m12862C();
        if (!this.f9363d.f9305L.isEmpty()) {
            this.f9363d.f9305L.clear();
            this.f9363d.m12865F();
        }
        if (!this.f9363d.f9310Q.isEmpty()) {
            this.f9363d.f9310Q.clear();
            this.f9363d.m12868I();
        }
        if (z) {
            this.f9363d.e.m13656f();
        }
        this.f9363d.h.mo1219a(null);
        super.mo2185a(false);
    }

    /* renamed from: a */
    public void mo2022a(ak akVar, boolean z, ag<as> agVar) {
        m13100b(akVar, z, new aax(this, agVar, z));
    }

    /* renamed from: g */
    public short mo2194g(long j) {
        return ((ee) this.f9363d.f).m4421j(j);
    }

    /* renamed from: h */
    public boolean m13192h(long j) {
        if (mo2361e(j)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public List<String> mo2189c(as asVar) {
        if (this.f9363d.f.m4242o() != BookType.SERIAL) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(2);
        long[] a = mo2358a(asVar.mo1332l());
        for (long a2 : a) {
            CharSequence a3 = mo2356a(a2);
            if (!TextUtils.isEmpty(a3)) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public List<String> mo2193d(as asVar) {
        if (this.f9363d.f.m4242o() != BookType.SERIAL) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(2);
        long[] a = mo2358a(asVar.mo1332l());
        for (long j : a) {
            if (m13192h(j)) {
                arrayList.add(mo2356a(j));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public boolean mo2139e(ak akVar) {
        if (!this.f9363d.f.ak()) {
            return super.mo2139e(akVar);
        }
        this.f9363d.c.getDocument().mo1233d((C0896a) akVar);
        akVar.mo1192e();
        long a = mo2354a() - 1;
        if (akVar instanceof C0939a) {
            akVar = ((C0939a) akVar).mo1433p();
        }
        if (mo2358a(akVar)[0] < a || !akVar.m5817f()) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public boolean mo2192c(String str) {
        return ((ee) this.f9363d.f).mo1041v(str);
    }

    /* renamed from: i */
    public af<Integer> mo2196i(long j) {
        return (af) this.f9363d.f9311a.get(mo2356a(j));
    }

    /* renamed from: j */
    public af<Boolean> mo2197j(long j) {
        af<Boolean> afVar;
        if (!this.f9363d.f.al()) {
            bb b = av.m5316a().m5334b();
            long j2 = this.f9363d.f.m4239l() ? b.f3742c : b.f3741b;
            if (this.f9363d.f.m4159L() == 0 || (j2 > System.currentTimeMillis() && this.f9363d.f.mo1019v())) {
                afVar = new af(Boolean.valueOf(true));
            } else if (mo2194g(j) == (short) 0) {
                afVar = new af(Boolean.valueOf(true));
            } else {
                afVar = new af(Boolean.valueOf(false));
            }
        } else if (mo2194g(j) == (short) 0) {
            afVar = new af(Boolean.valueOf(true));
        } else {
            afVar = new af();
        }
        String a = mo2356a(j);
        if (!TextUtils.isEmpty(a)) {
            DkCloudPurchasedFiction b2 = DkUserPurchasedFictionsManager.m5072a().m5101b(this.f9363d.f.m4156I());
            if (b2 != null) {
                if (this.f9363d.f.al()) {
                    af checkChapterPurchased = b2.checkChapterPurchased(a);
                    if (checkChapterPurchased.m861b()) {
                        afVar.mo975a(checkChapterPurchased.m858a());
                    }
                } else if (b2.isEntirePaid()) {
                    afVar.mo975a(Boolean.valueOf(true));
                } else if (!this.f9363d.c.bo()) {
                    afVar.mo975a(Boolean.valueOf(true));
                } else if (b2.checkChapterPurchased(a).m862b(Boolean.valueOf(true))) {
                    afVar.mo975a(Boolean.valueOf(true));
                }
            }
        }
        return afVar;
    }

    /* renamed from: c */
    public boolean mo2191c(long j) {
        if (!this.f9363d.c.ah() || !mo2197j(j).m862b(Boolean.valueOf(false))) {
            return false;
        }
        String a = mo2356a(j);
        if (TextUtils.isEmpty(a) || mo2192c(a)) {
            return false;
        }
        return true;
    }

    public boolean h_() {
        return (this.f9363d.f.al() || this.f9363d.c.mo2155h()) ? false : true;
    }

    /* renamed from: c */
    public void mo2190c() {
        if (C0559f.m2476b().m2486e()) {
            Runnable abb = new abb(this);
            if (this.f9363d.f.aI()) {
                ((ee) this.f9363d.f).m4405a(new abc(this, abb));
                return;
            } else {
                abb.run();
                return;
            }
        }
        be.m10286a(this.f9363d.getContext(), C0258j.general__shared__network_error, 1).show();
    }

    /* renamed from: b */
    public boolean mo2187b(ba baVar) {
        WebLog.init().w(UThread.isCurrentThread());
        if (this.f9363d.f9304K.contains(mo2356a(mo2355a(baVar)))) {
            return true;
        }
        List<String> D = ((as) baVar).mo1456D();
        if (D.isEmpty()) {
            return false;
        }
        for (String containsKey : D) {
            if (this.f9363d.f9310Q.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public int mo2188c(ba baVar) {
        WebLog.init().w(UThread.isCurrentThread());
        if (this.f9363d.f9305L.isEmpty() && this.f9363d.f9310Q.isEmpty()) {
            return -1;
        }
        Integer num = (Integer) this.f9363d.f9305L.get(mo2356a(mo2355a(baVar)));
        if (num != null) {
            return num.intValue();
        }
        for (String str : ((as) baVar).mo1456D()) {
            num = (Integer) this.f9363d.f9310Q.get(str);
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void mo1221a(C0903n c0903n, as asVar) {
        super.mo1221a(c0903n, asVar);
        if (this.f9363d.f.mo1038k()) {
            this.f9363d.m12865F();
        }
    }

    /* renamed from: b */
    public void mo1225b(C0903n c0903n, as asVar) {
        super.mo1225b(c0903n, asVar);
        if (this.f9363d.f.mo1038k()) {
            this.f9363d.m12868I();
        }
    }

    /* renamed from: e */
    public void mo966e() {
        if (this.f9363d.f.mo1038k()) {
            mo2159j(true);
        }
    }

    /* renamed from: b */
    public void mo964b(String[] strArr) {
    }

    /* renamed from: b */
    public void mo963b(List<DkCloudStoreBook> list) {
    }
}
