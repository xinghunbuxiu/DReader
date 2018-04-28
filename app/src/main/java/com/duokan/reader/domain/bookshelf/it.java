package com.duokan.reader.domain.bookshelf;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.ah;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.async.work.C0537r;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.micloud.C0812t;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.domain.micloud.C1073n;
import com.duokan.reader.domain.micloud.bj;
import com.duokan.reader.domain.micloud.bl;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

public class it implements ai, C0586j {
    /* renamed from: a */
    private static final aj<it> f3357a = new aj();
    /* renamed from: b */
    private final C0563j f3358b;
    /* renamed from: c */
    private final CopyOnWriteArrayList<C0812t> f3359c = new CopyOnWriteArrayList();
    /* renamed from: d */
    private final CopyOnWriteArrayList<IAsyncWorkProgressListener<bl>> f3360d = new CopyOnWriteArrayList();
    /* renamed from: e */
    private final CopyOnWriteArrayList<C0537r> f3361e = new CopyOnWriteArrayList();
    /* renamed from: f */
    private final CopyOnWriteArrayList<IAsyncWorkProgressListener<C1068i>> f3362f = new CopyOnWriteArrayList();
    /* renamed from: g */
    private final Context f3363g;
    /* renamed from: h */
    private final C0709k f3364h;
    /* renamed from: i */
    private jp f3365i = null;

    private it(Context context, C0709k c0709k) {
        this.f3363g = context;
        this.f3364h = c0709k;
        this.f3364h.m3494a((C0586j) this);
        this.f3358b = new iu(this);
        UserAccount d = this.f3364h.m3508d();
        if (!d.mo839i()) {
            this.f3365i = new jp(this, this.f3363g, d.mo833c());
        }
        DkApp.get().runPreReady(new je(this));
    }

    /* renamed from: a */
    public static void m4695a(Context context, C0709k c0709k) {
        f3357a.m709a(new it(context, c0709k));
    }

    /* renamed from: a */
    public static it m4692a() {
        return (it) f3357a.m707a();
    }

    /* renamed from: a */
    public static boolean m4698a(bl blVar) {
        return blVar.m8175w().equals("/Books");
    }

    /* renamed from: a */
    public static is m4690a(C0800c c0800c, Collection<is> collection) {
        return m4691a(c0800c, (Collection) collection, null);
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        UserAccount d = this.f3364h.m3508d();
        if (!d.mo839i()) {
            m4700b(new jf(this, d));
        }
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
    }

    public void onAccountLogoff(C0672a c0672a) {
        m4700b(new jg(this));
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    /* renamed from: a */
    public void m4719a(C0812t c0812t) {
        this.f3359c.addIfAbsent(c0812t);
    }

    /* renamed from: a */
    public void m4714a(IAsyncWorkProgressListener<bl> iAsyncWorkProgressListener) {
        this.f3360d.addIfAbsent(iAsyncWorkProgressListener);
    }

    /* renamed from: b */
    public void m4727b(IAsyncWorkProgressListener<bl> iAsyncWorkProgressListener) {
        this.f3360d.remove(iAsyncWorkProgressListener);
    }

    /* renamed from: b */
    public bj m4725b() {
        jp jpVar = this.f3365i;
        if (jpVar == null) {
            bj bjVar = new bj();
        }
        return jpVar.f3406c.f3402a;
    }

    /* renamed from: a */
    public is m4713a(String str) {
        jp jpVar = this.f3365i;
        if (jpVar == null) {
            return null;
        }
        return jpVar.f3406c.m4740b(str);
    }

    /* renamed from: c */
    public Collection<is> m4730c() {
        jp jpVar = this.f3365i;
        if (jpVar == null) {
            return new LinkedList();
        }
        return jpVar.f3406c.f3403b.values();
    }

    /* renamed from: a */
    public is m4712a(C0800c c0800c) {
        jp jpVar = this.f3365i;
        if (jpVar == null) {
            return null;
        }
        return m4691a(c0800c, null, jpVar.f3406c.f3403b);
    }

    /* renamed from: a */
    public void m4716a(jo joVar) {
        m4700b(new jh(this, joVar));
    }

    /* renamed from: a */
    public void m4724a(boolean z) {
        m4700b(new jj(this, z));
    }

    /* renamed from: a */
    public void m4715a(C0537r c0537r) {
        this.f3361e.addIfAbsent(c0537r);
    }

    /* renamed from: b */
    public void m4728b(C0537r c0537r) {
        this.f3361e.remove(c0537r);
    }

    /* renamed from: c */
    public void m4731c(IAsyncWorkProgressListener<C1068i> iAsyncWorkProgressListener) {
        this.f3362f.addIfAbsent(iAsyncWorkProgressListener);
    }

    /* renamed from: d */
    public void m4733d(IAsyncWorkProgressListener<C1068i> iAsyncWorkProgressListener) {
        this.f3362f.remove(iAsyncWorkProgressListener);
    }

    @Deprecated
    /* renamed from: d */
    public ArrayList<C1068i> m4732d() {
        jp jpVar = this.f3365i;
        if (jpVar == null) {
            return new ArrayList();
        }
        return jpVar.f3405b.m8112a().m2368c();
    }

    /* renamed from: e */
    public final ArrayList<C1068i> m4734e() {
        jp jpVar = this.f3365i;
        if (jpVar == null) {
            return new ArrayList();
        }
        return jpVar.f3405b.m8112a().m2369d();
    }

    /* renamed from: a */
    public void m4721a(String str, String str2, FlowChargingTransferChoice flowChargingTransferChoice) {
        m4700b(new jk(this, str, str2, flowChargingTransferChoice));
    }

    /* renamed from: a */
    public void m4722a(List<File> list, FlowChargingTransferChoice flowChargingTransferChoice) {
        m4700b(new jl(this, list, flowChargingTransferChoice));
    }

    @Deprecated
    /* renamed from: b */
    public C1068i m4726b(String str) {
        jp jpVar = this.f3365i;
        if (jpVar == null) {
            return null;
        }
        return jpVar.f3405b.m8112a().m8235b(str);
    }

    /* renamed from: a */
    public void m4718a(C1068i c1068i, FlowChargingTransferChoice flowChargingTransferChoice) {
        m4700b(new jm(this, c1068i, flowChargingTransferChoice));
    }

    /* renamed from: a */
    public void m4717a(C1068i c1068i) {
        m4700b(new iv(this, c1068i));
    }

    /* renamed from: a */
    public void m4720a(File file) {
        m4700b(new iw(this, file));
    }

    /* renamed from: b */
    public void m4729b(C1068i c1068i) {
        m4700b(new ix(this, c1068i));
    }

    /* renamed from: f */
    public void m4735f() {
        m4700b(new iy(this));
    }

    /* renamed from: a */
    public void m4723a(List<is> list, boolean z, IAsyncWorkProgressListener<C1073n> iAsyncWorkProgressListener) {
        m4700b(new iz(this, list, z, iAsyncWorkProgressListener));
    }

    /* renamed from: a */
    private void m4696a(C0559f c0559f) {
        if (!c0559f.m2486e()) {
            m4709h();
        } else if (c0559f.m2485d()) {
            m4708g();
        } else if (c0559f.m2484c()) {
            m4710i();
            m4711j();
        }
    }

    /* renamed from: g */
    private void m4708g() {
        m4700b(new ja(this));
    }

    /* renamed from: h */
    private void m4709h() {
        m4700b(new jb(this));
    }

    /* renamed from: i */
    private void m4710i() {
        m4700b(new jc(this));
    }

    /* renamed from: j */
    private void m4711j() {
        m4700b(new jd(this));
    }

    /* renamed from: d */
    private static boolean m4704d(C1068i c1068i) {
        FlowChargingTransferChoice valueOf = FlowChargingTransferChoice.valueOf(c1068i.m2306u().optString("book_upload_choice_at_flow_charging", FlowChargingTransferChoice.Default.name()));
        if (valueOf == null) {
            valueOf = FlowChargingTransferChoice.Default;
        }
        return valueOf == FlowChargingTransferChoice.Transfer || (valueOf == FlowChargingTransferChoice.Default && !ReaderEnv.get().getIsOnlyWifiUploadDownload());
    }

    /* renamed from: a */
    private static is m4691a(C0800c c0800c, Collection<is> collection, Map<String, is> map) {
        if (c0800c.ak()) {
            return null;
        }
        if (!c0800c.ao()) {
            File file = new File(c0800c.m4222e());
            if (map != null) {
                Collection collection2 = map.values();
            }
            for (is isVar : collection2) {
                if (c0800c.m4151D() == isVar.m4684d() && isVar.m4682b().equals(file.getName())) {
                    return isVar;
                }
            }
        } else if (map != null) {
            return (is) map.get(c0800c.ar());
        } else {
            for (is isVar2 : collection2) {
                if (c0800c.ar().equals(isVar2.m4686f())) {
                    return isVar2;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private static Future<?> m4700b(Runnable runnable) {
        return ah.m866a(runnable, "micloud");
    }
}
