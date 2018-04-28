package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Pair;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class de implements ai {
    /* renamed from: a */
    private static final aj<de> f3009a = new aj();
    /* renamed from: b */
    private final Context f3010b;
    /* renamed from: c */
    private al f3011c;
    /* renamed from: d */
    private dv f3012d = new dv();
    /* renamed from: e */
    private boolean f3013e = true;
    /* renamed from: f */
    private long f3014f = System.currentTimeMillis();
    /* renamed from: g */
    private final LinkedList<Pair<al, dw>> f3015g = new LinkedList();
    /* renamed from: h */
    private final LinkedList<dy> f3016h = new LinkedList();

    /* renamed from: a */
    public static void m4315a(Context context) {
        f3009a.m709a(new de(context));
    }

    /* renamed from: a */
    public static de m4313a() {
        return (de) f3009a.m707a();
    }

    private de(Context context) {
        this.f3010b = context;
        this.f3011c = new al(C0709k.m3476a().m3508d());
        DkApp.get().runPreReady(new df(this));
    }

    /* renamed from: c */
    private void m4330c() {
        this.f3013e = true;
        this.f3014f = System.currentTimeMillis();
        if (this.f3011c.m3367c()) {
            m4320a(null, true);
        }
    }

    /* renamed from: a */
    private void m4321a(dv dvVar) {
        if (this.f3013e) {
            dv dvVar2 = this.f3012d;
            this.f3012d = dvVar;
            Iterator it = dvVar2.f3067a.iterator();
            while (it.hasNext()) {
                dd ddVar = (dd) it.next();
                if (ddVar.f3006e && ddVar.f3008g >= this.f3014f) {
                    int i = ddVar.f3002a;
                    String str = ddVar.f3003b;
                    long j = ddVar.f3008g;
                    if (ddVar.f3005d) {
                        m4311a(this.f3012d, i, str, j);
                    } else {
                        m4312a(this.f3012d, i, str, ddVar.f3004c, j);
                    }
                }
            }
            this.f3013e = false;
        }
    }

    /* renamed from: b */
    public List<dd> m4343b() {
        return this.f3012d.f3068b;
    }

    /* renamed from: a */
    public dd m4338a(int i, String str) {
        return this.f3012d.m4375b(i, str);
    }

    /* renamed from: a */
    public void m4340a(du duVar) {
        m4320a(duVar, false);
    }

    /* renamed from: a */
    private void m4320a(du duVar, boolean z) {
        if (this.f3011c.m3367c()) {
            if (duVar != null) {
                duVar.mo980a();
            }
        } else if (this.f3013e) {
            new di(this, aq.f2771a, this.f3011c, duVar).open();
        } else if (duVar != null) {
            duVar.mo980a();
        }
    }

    /* renamed from: b */
    public void m4344b(int i, String str) {
        if (this.f3011c.m3367c() && i != -1) {
            dd a = m4311a(this.f3012d, i, str, System.currentTimeMillis());
            m4322a(Arrays.asList(new dd[]{a}));
        }
    }

    /* renamed from: a */
    public void m4339a(int i, String str, long j) {
        if (this.f3011c.m3367c() && i != -1) {
            dd a = m4312a(this.f3012d, i, str, j, System.currentTimeMillis());
            m4322a(Arrays.asList(new dd[]{a}));
        }
    }

    /* renamed from: a */
    private dd m4311a(dv dvVar, int i, String str, long j) {
        dd a = dvVar.m4371a(i, str);
        if (a == null) {
            a = new dd(i, str);
            dvVar.m4373a(a);
        }
        a.f3005d = true;
        a.f3004c = -1;
        a.f3006e = true;
        a.f3007f = 2;
        a.f3008g = j;
        return a;
    }

    /* renamed from: a */
    private dd m4312a(dv dvVar, int i, String str, long j, long j2) {
        dd a = dvVar.m4371a(i, str);
        if (a == null) {
            a = new dd(i, str);
            dvVar.m4373a(a);
        }
        a.f3005d = false;
        a.f3004c = j;
        a.f3006e = true;
        a.f3007f = 1;
        a.f3008g = j2;
        return a;
    }

    /* renamed from: a */
    private void m4322a(Collection<dd> collection) {
        if (!collection.isEmpty()) {
            ArrayList arrayList = new ArrayList(collection);
            for (dd a : collection) {
                arrayList.add(a.m4305a());
            }
            new dj(this, aq.f2771a, this.f3011c, this.f3013e, arrayList).open();
        }
    }

    /* renamed from: a */
    public void m4341a(dw dwVar) {
        if (this.f3011c.m3367c()) {
            this.f3015g.add(new Pair(this.f3011c, dwVar));
            if (this.f3015g.size() == 1) {
                m4331d();
                return;
            }
            return;
        }
        dwVar.mo982a("");
    }

    /* renamed from: d */
    private void m4331d() {
        Pair pair;
        while (!this.f3015g.isEmpty()) {
            Pair pair2 = (Pair) this.f3015g.peek();
            if (((al) pair2.first).m3365a(this.f3011c)) {
                pair = pair2;
                break;
            } else {
                ((dw) pair2.second).mo982a("");
                this.f3015g.poll();
            }
        }
        pair = null;
        if (pair != null) {
            new dk(this, aq.f2771a, (al) pair.first, (dw) pair.second).open();
        }
    }

    /* renamed from: a */
    private void m4316a(dc dcVar, dw dwVar) {
        m4327b(dcVar, new dm(this, dwVar));
    }

    /* renamed from: b */
    private void m4327b(dc dcVar, dw dwVar) {
        new C0803do(this, this.f3011c.f2360a, al.f2767a, this.f3011c, dcVar, dwVar).open();
    }

    /* renamed from: a */
    public void m4342a(jx jxVar, dz dzVar) {
        if (this.f3011c.m3367c()) {
            this.f3016h.add(new dy(this.f3011c, jxVar, dzVar));
            if (this.f3016h.size() == 1) {
                m4333e();
                return;
            }
            return;
        }
        dzVar.mo1005a("");
    }

    /* renamed from: e */
    private void m4333e() {
        dy dyVar;
        while (!this.f3016h.isEmpty()) {
            dyVar = (dy) this.f3016h.peek();
            if (dyVar.f3071a.m3365a(this.f3011c)) {
                break;
            }
            dyVar.f3073c.mo1005a("");
            this.f3016h.poll();
        }
        dyVar = null;
        if (dyVar != null) {
            al alVar = dyVar.f3071a;
            jx jxVar = dyVar.f3072b;
            dz dzVar = dyVar.f3073c;
            new dp(this, aq.f2771a, jxVar, alVar, this.f3013e, dzVar).open();
        }
    }

    /* renamed from: a */
    private void m4324a(List<dd> list, dz dzVar) {
        if (list.isEmpty()) {
            dzVar.mo1004a();
        } else {
            m4323a((List) list, new dr(this, list, dzVar));
        }
    }

    /* renamed from: a */
    private void m4323a(List<dd> list, dx dxVar) {
        new dt(this, this.f3011c.f2360a, al.f2767a, this.f3011c, list, dxVar).open();
    }
}
