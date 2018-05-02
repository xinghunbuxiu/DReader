package com.duokan.reader.domain.p044b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.FileObserver;
import android.text.TextUtils;
import com.duokan.common.C0261c;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.UThread;
import com.duokan.kernel.DkUtils;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.downloadcenter.C0780k;
import com.duokan.reader.domain.downloadcenter.C1014m;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.C1025l;
import com.duokan.reader.domain.downloadcenter.C1027o;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.duokan.reader.domain.b.b */
public class C0781b extends BroadcastReceiver implements ai, C0780k {
    /* renamed from: a */
    static final /* synthetic */ boolean f2619a = (!C0781b.class.desiredAssertionStatus());
    /* renamed from: c */
    private static final aj<C0781b> f2620c = new aj();
    /* renamed from: b */
    private final Context f2621b;
    /* renamed from: d */
    private boolean f2622d = false;
    /* renamed from: e */
    private final LinkedList<C0794o> f2623e = new LinkedList();
    /* renamed from: f */
    private final LinkedList<C0795p> f2624f = new LinkedList();
    /* renamed from: g */
    private final LinkedList<C0795p> f2625g = new LinkedList();
    /* renamed from: h */
    private final LinkedList<C0779a> f2626h = new LinkedList();
    /* renamed from: i */
    private final FileObserver f2627i;
    /* renamed from: j */
    private WebSession f2628j = null;
    /* renamed from: k */
    private boolean f2629k = false;
    /* renamed from: l */
    private boolean f2630l = false;

    private C0781b(Context context) {
        this.f2621b = context;
        this.f2625g.add(new C0795p(this, "方正书宋_GBK", "方正书宋_GBK.ttf", 11057836));
        this.f2625g.add(new C0795p(this, "方正仿宋_GBK", "方正仿宋_GBK.ttf", 12434444));
        this.f2625g.add(new C0795p(this, "方正小标宋_GBK", "方正小标宋_GBK.ttf", 13099364));
        this.f2625g.add(new C0795p(this, "方正楷体_GBK", "方正楷体_GBK.ttf", 13438872));
        this.f2625g.add(new C0795p(this, "方正兰亭刊黑_GBK", "方正兰亭刊黑_GBK.ttf", 6902564));
        this.f2625g.add(new C0795p(this, "方正中等线_GBK", "方正中等线_GBK.ttf", 10825276));
        this.f2625g.add(new C0795p(this, "方正兰亭黑_GBK", "fzlth_gbk.ttf", 6846680));
        this.f2627i = new C0782c(this, ReaderEnv.get().getUserFontDirectory().getPath());
    }

    /* renamed from: a */
    public synchronized void m3684a() {
        UThread.runOnThread(new C0783d(this));
    }

    public void onTaskRunning(DownloadCenterTask downloadCenterTask) {
        m3677i();
    }

    public void onTaskStatusChanged(DownloadCenterTask downloadCenterTask) {
        m3677i();
        DownloadCenterTask[] h = C1016b.m7857p().m7892h();
        for (DownloadCenterTask i : h) {
            if (new File(Uri.parse(i.m7795i()).getPath()).exists()) {
                m3676h();
            }
        }
        if (h.length > 0) {
            m3682n();
            C1016b.m7857p().m7882b(h);
            m3694g();
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
            m3676h();
        }
    }

    /* renamed from: a */
    public static void m3659a(Context context) {
        f2620c.m709a(new C0781b(context));
    }

    /* renamed from: b */
    public static C0781b m3667b() {
        return (C0781b) f2620c.m707a();
    }

    /* renamed from: c */
    public synchronized C0796q m3690c() {
        C0796q c0796q;
        m3677i();
        c0796q = new C0796q();
        c0796q.f2661a = this.f2625g.size();
        c0796q.f2663c = c0796q.f2661a - this.f2624f.size();
        Iterator it = this.f2625g.iterator();
        while (it.hasNext()) {
            C0795p c0795p = (C0795p) it.next();
            c0796q.f2662b += c0795p.m3705d();
            File file = new File(ReaderEnv.get().getUserFontDirectory(), c0795p.b);
            DownloadCenterTask b = C1016b.m7857p().m7877b(Uri.fromFile(file).toString());
            if (b != null && !b.m7794h()) {
                c0796q.f2664d = (long) ((((float) c0795p.m3705d()) * (b.m7796j() / 100.0f)) + ((float) c0796q.f2664d));
            } else if (file.exists()) {
                c0796q.f2664d += c0795p.m3705d();
            }
        }
        c0796q.f2665e = m3678j();
        return c0796q;
    }

    /* renamed from: a */
    public synchronized void m3688a(boolean z) {
        m3677i();
        UThread.runOnThread(new C0785f(this, z));
    }

    /* renamed from: d */
    public synchronized boolean m3691d() {
        boolean z = false;
        synchronized (this) {
            m3677i();
            if (!(this.f2624f == null || this.f2624f.size() <= 0 || C1016b.m7857p().m7894j().length == this.f2624f.size())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: e */
    public synchronized C0794o[] m3692e() {
        m3677i();
        return (C0794o[]) this.f2623e.toArray(new C0794o[0]);
    }

    /* renamed from: a */
    public synchronized void m3686a(C0779a c0779a) {
        if (f2619a || c0779a != null) {
            m3677i();
            this.f2626h.add(c0779a);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public synchronized void m3689b(C0779a c0779a) {
        if (f2619a || c0779a != null) {
            m3677i();
            this.f2626h.remove(c0779a);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: f */
    public synchronized void m3693f() {
        m3677i();
        Iterator it = this.f2625g.iterator();
        while (it.hasNext()) {
            DownloadCenterTask b = C1016b.m7857p().m7877b(Uri.fromFile(new File(ReaderEnv.get().getUserFontDirectory(), ((C0795p) it.next()).b)).toString());
            if (b != null) {
                C1016b.m7857p().m7871a(b);
            }
        }
    }

    /* renamed from: a */
    public synchronized void m3687a(FlowChargingTransferChoice flowChargingTransferChoice) {
        m3677i();
        m3664a(new C0786g(this, flowChargingTransferChoice));
    }

    /* renamed from: a */
    public synchronized void m3685a(Activity activity, C0793n c0793n) {
        m3677i();
        if (this.f2629k) {
            m3668b(activity, c0793n);
        } else {
            m3664a(new C0787h(this));
        }
    }

    /* renamed from: g */
    public synchronized void m3694g() {
        m3677i();
    }

    /* renamed from: h */
    private synchronized void m3676h() {
        m3679k();
        m3680l();
        m3681m();
        this.f2622d = true;
    }

    /* renamed from: i */
    private synchronized void m3677i() {
        if (!this.f2622d) {
            m3676h();
        }
    }

    /* renamed from: j */
    private boolean m3678j() {
        Iterator it = this.f2625g.iterator();
        while (it.hasNext()) {
            DownloadCenterTask b = C1016b.m7857p().m7877b(Uri.fromFile(new File(ReaderEnv.get().getUserFontDirectory(), ((C0795p) it.next()).b)).toString());
            if (b != null && !b.m7794h()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    private void m3679k() {
        this.f2623e.clear();
        this.f2630l = m3666a(this.f2623e, ReaderEnv.get().getKernelFontDirectory().getAbsolutePath());
        this.f2630l &= m3666a(this.f2623e, ReaderEnv.get().getUserFontDirectory().getAbsolutePath());
        try {
            C0794o c0794o = new C0794o(this);
            c0794o.f2655g = true;
            c0794o.f2654f = "";
            c0794o.f2653e = null;
            c0794o.b = "";
            c0794o.a = this.f2621b.getString(C0247i.general__shared__system_font);
            this.f2623e.add(c0794o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m3666a(LinkedList<C0794o> linkedList, String str) {
        if (!ReaderEnv.get().isExternalStorageMounted()) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return true;
            }
            File[] listFiles = file.listFiles(new C0788i(this));
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!(!file2.isFile() || file2.getName().equalsIgnoreCase("dk-symbol.ttf") || file2.getName().equalsIgnoreCase("DroidSansFallback.ttf"))) {
                        Object obj;
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            if (((C0794o) it.next()).b.equals(file2.getName())) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            try {
                                C0794o c0794o = new C0794o(this);
                                c0794o.f2654f = file2.getAbsolutePath();
                                c0794o.f2653e = new File(c0794o.f2654f);
                                c0794o.b = file2.getName();
                                c0794o.a = m3657a(c0794o.f2654f);
                                if (!TextUtils.isEmpty(c0794o.a)) {
                                    linkedList.add(c0794o);
                                }
                                c0794o.c = DkUtils.isZhFont(Uri.fromFile(c0794o.m3703d()).getPath());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: l */
    private void m3680l() {
        this.f2624f.clear();
        this.f2624f.addAll(this.f2625g);
        this.f2629k = false;
    }

    /* renamed from: m */
    private void m3681m() {
        Collection arrayList = new ArrayList();
        Iterator it = this.f2624f.iterator();
        while (it.hasNext()) {
            Object obj;
            C0795p c0795p = (C0795p) it.next();
            Iterator it2 = this.f2623e.iterator();
            while (it2.hasNext()) {
                if (c0795p.b.equalsIgnoreCase(((C0794o) it2.next()).b)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                arrayList.add(c0795p);
            }
        }
        this.f2624f.clear();
        this.f2624f.addAll(arrayList);
    }

    /* renamed from: a */
    private String m3657a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new C0261c().m592b(str);
    }

    /* renamed from: n */
    private void m3682n() {
        Iterator it = this.f2626h.iterator();
        while (it.hasNext()) {
            ((C0779a) it.next()).mo2311a();
        }
    }

    /* renamed from: a */
    private void m3664a(Runnable runnable) {
        if (this.f2629k) {
            runnable.run();
            return;
        }
        this.f2628j = new C0789j(this, C0709k.m3476a().m3511f(), runnable);
        this.f2628j.open();
    }

    /* renamed from: b */
    private void m3668b(Activity activity, C0793n c0793n) {
        C0781b.m3667b();
        ap c0790k = new C0790k(this, activity, activity, c0793n);
        c0790k.setTitle(C0247i.f407x96d463da);
        c0790k.setPrompt(C0247i.f406x3d614822);
        c0790k.setCancelLabel(C0247i.general__shared__cancel);
        c0790k.setOkLabelResid(C0247i.general__shared__confirm);
        c0790k.setCancelOnTouchOutside(false);
        c0790k.setCancelOnBack(false);
        c0790k.show();
    }

    /* renamed from: a */
    private void m3658a(Activity activity) {
        ap apVar = new ap(activity);
        apVar.setTitle(C0247i.f401xfe180484);
        apVar.setPrompt(C0247i.f400xbe91bcb8);
        apVar.setOkLabelResid(C0247i.f399x2db73b30);
        apVar.show();
    }

    /* renamed from: b */
    private void m3669b(FlowChargingTransferChoice flowChargingTransferChoice) {
        Iterator it = this.f2624f.iterator();
        while (it.hasNext()) {
            m3663a((C0795p) it.next(), flowChargingTransferChoice);
        }
    }

    /* renamed from: a */
    private void m3663a(C0795p c0795p, FlowChargingTransferChoice flowChargingTransferChoice) {
        File file = new File(ReaderEnv.get().getUserFontDirectory(), c0795p.b);
        if (!file.exists()) {
            DownloadCenterTask b = C1016b.m7857p().m7877b(Uri.fromFile(file).toString());
            if (b != null) {
                if (b.m7794h()) {
                    C1016b.m7857p().m7871a(b);
                } else {
                    return;
                }
            }
            UmengManager.get().onEvent("V2_READING_FONT_DOWNLOAD", c0795p.mo947a());
            C1025l c1025l = new C1025l();
            C1014m c1027o = new C1027o();
            c1027o.m = flowChargingTransferChoice;
            c1027o.f5088a = c0795p.a;
            c1025l.f5080b = c0795p.f2657e;
            c1025l.f5081c = Uri.fromFile(file).toString();
            c1025l.f5079a = c0795p.a;
            c1025l.f5082d = c0795p.f2658f;
            c1025l.f5083e = c1027o;
            C1016b.m7857p().m7865a(c1025l);
        }
    }

    /* renamed from: o */
    private boolean m3683o() {
        DownloadCenterTask[] h = C1016b.m7857p().m7892h();
        if (h.length <= 0) {
            return false;
        }
        C1016b.m7857p().m7882b(h);
        return true;
    }
}
