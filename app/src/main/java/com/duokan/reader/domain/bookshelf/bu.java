package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Pair;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.UThread;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class bu implements ai {
    /* renamed from: a */
    private static final aj<bu> f2866a = new aj();
    /* renamed from: b */
    private final Context f2867b;
    /* renamed from: c */
    private al f2868c;
    /* renamed from: d */
    private cp f2869d = new cp();
    /* renamed from: e */
    private boolean f2870e = true;
    /* renamed from: f */
    private long f2871f = System.currentTimeMillis();
    /* renamed from: g */
    private final LinkedList<cw> f2872g = new LinkedList();
    /* renamed from: h */
    private final LinkedList<cz> f2873h = new LinkedList();

    /* renamed from: a */
    public static void m4079a(Context context) {
        f2866a.m709a(new bu(context));
    }

    /* renamed from: a */
    public static bu m4077a() {
        return (bu) f2866a.m707a();
    }

    private bu(Context context) {
        this.f2867b = context;
        this.f2868c = new al(C0709k.m3476a().m3508d());
        DkApp.get().runPreReady(new bv(this));
    }

    /* renamed from: c */
    private void m4097c() {
        this.f2870e = true;
        this.f2871f = System.currentTimeMillis();
        if (this.f2868c.m3367c()) {
            m4089a(null, true);
        }
    }

    /* renamed from: a */
    private void m4088a(cp cpVar) {
        if (this.f2870e) {
            this.f2869d = cpVar;
            Iterator it = cpVar.f2980a.iterator();
            while (it.hasNext()) {
                bt btVar = (bt) it.next();
                if (btVar.f2863g && btVar.f2865i >= this.f2871f) {
                    int i = btVar.f2857a;
                    String str = btVar.f2858b;
                    if (btVar.f2864h == 1) {
                        m4076a(this.f2869d, i, str, btVar.f2859c, btVar.f2865i);
                    } else if (btVar.f2864h == 2) {
                        m4094b(this.f2869d, i, str, btVar.f2859c, btVar.f2865i);
                    } else if (btVar.f2864h == 3) {
                        m4075a(this.f2869d, i, str, btVar.f2865i);
                    }
                }
            }
            this.f2870e = false;
        }
    }

    /* renamed from: b */
    public List<bt> m4112b() {
        return this.f2869d.f2981b;
    }

    /* renamed from: a */
    public void m4107a(ct ctVar) {
        m4089a(ctVar, false);
    }

    /* renamed from: a */
    private void m4089a(ct ctVar, boolean z) {
        if (this.f2868c.m3367c()) {
            if (ctVar != null) {
                ctVar.mo984a();
            }
        } else if (this.f2870e) {
            new ce(this, aq.f2771a, this.f2868c, ctVar).open();
        } else if (ctVar != null) {
            ctVar.mo984a();
        }
    }

    /* renamed from: a */
    public void m4106a(int i, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        UThread.runOnThread(new cf(this, i, str, str2));
    }

    /* renamed from: a */
    public void m4105a(int i, String str) {
        UThread.runOnThread(new cg(this, i, str));
    }

    /* renamed from: a */
    public void m4109a(String str, Collection<Pair<Integer, String>> collection) {
        if (str == null) {
            str = "";
        }
        UThread.runOnThread(new ch(this, collection, str));
    }

    /* renamed from: a */
    public void m4110a(List<cq> list) {
        UThread.runOnThread(new ci(this, list));
    }

    /* renamed from: a */
    private void m4090a(Collection<bt> collection) {
        if (!collection.isEmpty()) {
            ArrayList arrayList = new ArrayList(collection);
            for (bt a : collection) {
                arrayList.add(a.m4068a());
            }
            new cj(this, aq.f2771a, this.f2868c, this.f2870e, arrayList).open();
        }
    }

    /* renamed from: a */
    private bt m4076a(cp cpVar, int i, String str, String str2, long j) {
        bt a = cpVar.m4277a(i, str);
        if (a == null) {
            a = new bt(i, str, str2);
            cpVar.m4279a(a);
            a.f2862f = 0;
            a.f2860d = 0;
            a.f2861e = j;
            a.f2863g = true;
            a.f2864h = 1;
            a.f2865i = j;
            return a;
        } else if (!a.f2863g) {
            a.f2859c = str2;
            a.f2861e = j;
            a.f2863g = true;
            a.f2864h = 2;
            a.f2865i = j;
            return a;
        } else if (a.m4070c()) {
            a.f2859c = str2;
            a.f2862f = 0;
            a.f2861e = j;
            if (a.f2860d == 0) {
                a.f2864h = 1;
            } else {
                a.f2864h = 2;
            }
            a.f2865i = j;
            return a;
        } else {
            a.f2859c = str2;
            a.f2861e = j;
            a.f2864h = 2;
            a.f2865i = j;
            return a;
        }
    }

    /* renamed from: b */
    private bt m4094b(cp cpVar, int i, String str, String str2, long j) {
        bt a = cpVar.m4277a(i, str);
        if (a == null) {
            a = new bt(i, str, str2);
            cpVar.m4279a(a);
            a.f2862f = 0;
            a.f2860d = 0;
            a.f2861e = j;
            a.f2863g = true;
            a.f2864h = 1;
            a.f2865i = j;
            return a;
        } else if (!a.f2863g) {
            a.f2859c = str2;
            a.f2861e = j;
            a.f2863g = true;
            a.f2864h = 2;
            a.f2865i = j;
            return a;
        } else if (a.m4070c()) {
            a.f2859c = str2;
            a.f2862f = 0;
            a.f2861e = j;
            if (a.f2860d == 0) {
                a.f2864h = 1;
            } else {
                a.f2864h = 2;
            }
            a.f2865i = j;
            return a;
        } else {
            a.f2859c = str2;
            a.f2861e = j;
            a.f2864h = 2;
            a.f2865i = j;
            return a;
        }
    }

    /* renamed from: a */
    private bt m4075a(cp cpVar, int i, String str, long j) {
        bt a = cpVar.m4277a(i, str);
        if (a == null) {
            a = new bt(i, str, "");
            cpVar.m4279a(a);
            a.f2860d = 0;
        }
        a.f2862f = 1;
        a.f2861e = j;
        a.f2863g = true;
        a.f2864h = 3;
        a.f2865i = j;
        return a;
    }

    /* renamed from: a */
    public void m4111a(boolean z, cu cuVar) {
        if (this.f2868c.m3367c()) {
            cw cwVar = new cw();
            cwVar.f2990a = this.f2868c;
            cwVar.f2991b = z;
            cwVar.f2992c = cuVar;
            this.f2872g.add(cwVar);
            if (this.f2872g.size() == 1) {
                m4099d();
                return;
            }
            return;
        }
        cuVar.mo986a("");
    }

    /* renamed from: d */
    private void m4099d() {
        cw cwVar;
        while (!this.f2872g.isEmpty()) {
            cwVar = (cw) this.f2872g.peek();
            if (cwVar.f2990a.m3365a(this.f2868c)) {
                break;
            }
            cwVar.f2992c.mo986a("");
            this.f2872g.poll();
        }
        cwVar = null;
        if (cwVar != null) {
            new ck(this, aq.f2771a, cwVar).open();
        }
    }

    /* renamed from: a */
    private void m4080a(bs bsVar, cu cuVar) {
        m4081a(bsVar, new cm(this, bsVar, cuVar));
    }

    /* renamed from: a */
    private void m4081a(bs bsVar, cv cvVar) {
        if (this.f2868c.m3367c()) {
            al alVar = this.f2868c;
            new by(this, alVar.f2360a, al.f2767a, alVar, bsVar, cvVar).open();
            return;
        }
        cvVar.mo998a("");
    }

    /* renamed from: a */
    public void m4108a(jx jxVar, cx cxVar) {
        if (this.f2868c.m3367c()) {
            this.f2873h.add(new cz(this.f2868c, jxVar, cxVar));
            if (this.f2873h.size() == 1) {
                m4100e();
                return;
            }
            return;
        }
        cxVar.mo977a("");
    }

    /* renamed from: e */
    private void m4100e() {
        cz czVar;
        while (!this.f2873h.isEmpty()) {
            czVar = (cz) this.f2873h.peek();
            if (czVar.f2994a.m3365a(this.f2868c)) {
                break;
            }
            czVar.f2996c.mo977a("");
            this.f2873h.poll();
        }
        czVar = null;
        if (czVar != null) {
            al alVar = czVar.f2994a;
            jx jxVar = czVar.f2995b;
            cx cxVar = czVar.f2996c;
            new bz(this, aq.f2771a, jxVar, alVar, this.f2870e, cxVar).open();
        }
    }

    /* renamed from: a */
    private void m4082a(bs bsVar, List<bt> list, cx cxVar) {
        if (list.isEmpty()) {
            cxVar.mo976a();
        } else {
            m4083a(bsVar, (List) list, new cb(this, list, cxVar));
        }
    }

    /* renamed from: a */
    private void m4083a(bs bsVar, List<bt> list, cy cyVar) {
        new cd(this, this.f2868c.f2360a, al.f2767a, this.f2868c, list, bsVar, cyVar).open();
    }
}
