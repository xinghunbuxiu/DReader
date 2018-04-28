package com.duokan.reader.ui.reading;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.bookshelf.in;
import com.duokan.reader.domain.cloud.bb;
import com.duokan.reader.domain.cloud.bc;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0930b;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.epub.C0936c;
import com.duokan.reader.domain.document.epub.C0942i;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.az;
import java.util.ArrayList;
import java.util.List;

class ht extends aaw implements in, bc, hy {
    /* renamed from: a */
    final /* synthetic */ hl f10351a;

    private ht(hl hlVar) {
        this.f10351a = hlVar;
        super(hlVar);
    }

    public boolean h_() {
        if (this.f10351a.f.mo1038k()) {
            return super.h_();
        }
        return this.f10351a.f.mo1037j();
    }

    /* renamed from: a */
    public void mo2185a(boolean z) {
        if (!this.f10351a.f10337P.isEmpty()) {
            List arrayList = new ArrayList(this.f10351a.f10337P.keySet());
            this.f10351a.f10337P.clear();
            this.f10351a.m14337b(arrayList, null);
        }
        super.mo2185a(z);
    }

    /* renamed from: a */
    public void mo1914a(bb bbVar) {
        long j;
        if (this.f10351a.f.mo1038k()) {
            j = bbVar.f3741b;
        } else if (this.f10351a.f.mo1038k() && this.f10351a.f.m4239l()) {
            j = bbVar.f3742c;
        } else {
            j = bbVar.f3740a;
        }
        if (System.currentTimeMillis() < j) {
            ((fp) this.f10351a.f).m4483a(null);
        }
    }

    /* renamed from: b */
    public boolean mo2186b(ak akVar) {
        if (this.f10351a.f.mo1038k()) {
            return super.mo2186b(akVar);
        }
        if (akVar.m5817f()) {
            return false;
        }
        long[] a = mo2358a(akVar);
        for (long j : a) {
            if (j < 0 || j >= this.f10351a.m14327C().m7027D()) {
                return false;
            }
            fp fpVar = (fp) this.f10351a.f;
            if (fpVar.m4247s() == BookPackageType.EPUB_OPF) {
                av d = this.f10351a.m14327C().m7064d(j);
                if (!(d == null || !d.mo1075k() || fpVar.aZ())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: d */
    public void mo2360d(long j) {
        C0709k.m3476a().m3495a(new hu(this, j));
    }

    /* renamed from: a */
    public long mo2354a() {
        return this.f10351a.m14327C().m7027D();
    }

    /* renamed from: a */
    public long mo2355a(ba baVar) {
        return ((az) baVar).m6615c();
    }

    /* renamed from: a */
    public long[] mo2358a(ak akVar) {
        if (!this.f10351a.h.mo1233d((C0896a) akVar) || !akVar.mo1192e()) {
            return new long[0];
        }
        if (((C0936c) akVar.mo1198g()).m6780g() == ((C0936c) akVar.mo1199h()).m6780g()) {
            return new long[]{((C0936c) akVar.mo1198g()).m6780g()};
        }
        return new long[]{((C0936c) akVar.mo1198g()).m6780g(), ((C0936c) akVar.mo1199h()).m6780g()};
    }

    /* renamed from: a */
    public String mo2356a(long j) {
        return this.f10351a.m14327C().m7071f(j);
    }

    /* renamed from: b */
    public String mo2359b(long j) {
        C0901g a = this.f10351a.m14327C().m7028E().mo1367a(j);
        return a == null ? "" : a.mo1202e();
    }

    /* renamed from: a */
    public boolean mo2357a(as asVar) {
        boolean z = true;
        if (!asVar.mo1284G()) {
            return false;
        }
        C0901g b = this.f10351a.m14327C().m7028E().mo1267b(asVar.mo1332l());
        if (b == null || b.mo1205h() > 0) {
            return false;
        }
        if (asVar instanceof az) {
            if (((az) asVar).m6620d() != 0) {
                z = false;
            }
            return z;
        }
        C0942i c0942i = (C0942i) asVar;
        if (c0942i.m6901R().m6620d() == 0 || c0942i.m6902S().m6620d() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public boolean mo2361e(long j) {
        fp fpVar = (fp) this.f10351a.f;
        Object a = mo2356a(j);
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        return TextUtils.equals(this.f10351a.m14327C().m7074g(j), fpVar.m4500y(a).getName());
    }

    /* renamed from: a */
    public void mo2022a(ak akVar, boolean z, ag<as> agVar) {
        if (this.f10351a.f.mo1038k()) {
            super.mo2022a(akVar, z, agVar);
        } else {
            m13100b(akVar, z, new hv(this, agVar, z));
        }
    }

    /* renamed from: a */
    public int mo2353a(av avVar) {
        Integer num = (Integer) this.f10351a.f10337P.get(avVar);
        return num == null ? 0 : num.intValue();
    }

    /* renamed from: a */
    public View mo2014a(Context context) {
        return null;
    }

    /* renamed from: d */
    public boolean mo2133d() {
        if (this.f10351a.f.m4248t().m3772a("HK") || this.f10351a.f.m4248t().m3772a("TW")) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo2362f() {
        if (this.f10351a.f.m4248t().m3772a("HK") || this.f10351a.f.m4248t().m3772a("TW")) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public void mo2105b(boolean z) {
    }

    /* renamed from: g */
    public boolean mo2145g() {
        return false;
    }

    /* renamed from: h */
    public boolean mo2155h() {
        return this.f10351a.f10334M;
    }

    /* renamed from: a */
    public void mo2025a(ay ayVar, boolean z) {
        if (!(z || aT())) {
            if (this.f10351a.f10331J != null) {
                ayVar = this.f10351a.f10331J;
            } else if (mo2160j()) {
                ayVar = mo2009Z();
            } else {
                ayVar = null;
            }
        }
        if (ayVar != null) {
            ay e = AudioPlayer.m3613a().m3644e();
            if (e == null || ayVar == null || !ayVar.m5813a(e)) {
                int d;
                C0896a c0896a = (C0936c) ayVar.mo1198g();
                C0896a c0896a2 = (C0936c) ayVar.mo1199h();
                C0901g a = this.f10351a.h.mo1240h().m6046a(c0896a);
                C0901g a2 = this.f10351a.h.mo1240h().m6046a(c0896a2);
                List arrayList = new ArrayList();
                if (c0896a != null) {
                    d = a.mo1201d();
                    AudioPlayer.m3613a().m3639a(this.f10351a.m14340d(d), Integer.valueOf(d), mo1992G().aH());
                    arrayList.add(Integer.valueOf(d));
                }
                if (!(a2 == null || a2 == a)) {
                    d = a2.mo1201d();
                    AudioPlayer.m3613a().m3639a(this.f10351a.m14340d(d), Integer.valueOf(d), mo1992G().aH());
                    arrayList.add(Integer.valueOf(d));
                }
                if (arrayList.size() > 0) {
                    this.f10351a.c.mo2040a(16, 0);
                    AudioPlayer.m3613a().m3638a(ayVar, (Integer[]) arrayList.toArray(new Integer[0]));
                    return;
                }
                return;
            }
            this.f10351a.c.mo2040a(16, 0);
            AudioPlayer.m3613a().m3643d();
        }
    }

    /* renamed from: i */
    public void mo2156i() {
        AudioPlayer.m3613a().m3642c();
    }

    /* renamed from: j */
    public boolean mo2160j() {
        C0952s c0952s = (C0952s) getDocument();
        ak Z = mo2009Z();
        if (Z == null || !Z.m5777b()) {
            return false;
        }
        long[] jArr;
        if (((C0936c) Z.mo1198g()).m6780g() == ((C0936c) Z.mo1199h()).m6780g()) {
            jArr = new long[]{((C0936c) Z.mo1198g()).m6780g()};
        } else {
            jArr = new long[]{((C0936c) Z.mo1198g()).m6780g(), ((C0936c) Z.mo1199h()).m6780g()};
        }
        for (long c : jArr) {
            C0930b[] c2 = c0952s.m7060c(c);
            if (c2 != null && c2.length > 0) {
                for (C0930b a : c2) {
                    if (Z.m5814b(a.mo1443a())) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* renamed from: k */
    public com.duokan.reader.domain.document.bb mo2161k() {
        return this.f10351a.f10331J;
    }

    /* renamed from: a */
    public void mo1683a(C0800c c0800c) {
        if (this.f10351a.f == c0800c && this.f10351a.p && !this.f10351a.q && this.f10351a.f.mo1037j() && !this.f10351a.f.m4171X()) {
            mo2185a(true);
        }
    }

    public void onItemChanged(an anVar, int i) {
        super.onItemChanged(anVar, i);
        if (anVar == this.f10351a.f) {
            mo2103b(new hx(this, i));
        }
    }

    /* renamed from: b */
    public void mo1225b(C0903n c0903n, as asVar) {
        super.mo1225b(c0903n, asVar);
        if (this.f10351a.f.mo1037j()) {
            this.f10351a.m14332a((com.duokan.reader.domain.document.epub.as) asVar);
        }
    }
}
