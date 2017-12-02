package com.duokan.reader.domain.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.FileObserver;
import android.text.TextUtils;

import com.duokan.b.i;
import com.duokan.common.c;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.sys.t;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.k;
import com.duokan.reader.domain.downloadcenter.l;
import com.duokan.reader.domain.downloadcenter.m;
import com.duokan.reader.domain.downloadcenter.o;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ap;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class b extends BroadcastReceiver implements ah, k {
    static final /* synthetic */ boolean a = (!b.class.desiredAssertionStatus());
    private static final ai c = new ai();
    private final Context b;
    private boolean d = false;
    private final LinkedList e = new LinkedList();
    private final LinkedList f = new LinkedList();
    private final LinkedList g = new LinkedList();
    private final LinkedList h = new LinkedList();
    private final FileObserver i;
    private WebSession j = null;
    private boolean k = false;
    private boolean l = false;

    private b(Context context) {
        this.b = context;
        this.g.add(new p(this, "方正书宋_GBK", "方正书宋_GBK.ttf", 11057836));
        this.g.add(new p(this, "方正仿宋_GBK", "方正仿宋_GBK.ttf", 12434444));
        this.g.add(new p(this, "方正小标宋_GBK", "方正小标宋_GBK.ttf", 13099364));
        this.g.add(new p(this, "方正楷体_GBK", "方正楷体_GBK.ttf", 13438872));
        this.g.add(new p(this, "方正兰亭刊黑_GBK", "方正兰亭刊黑_GBK.ttf", 6902564));
        this.g.add(new p(this, "方正中等线_GBK", "方正中等线_GBK.ttf", 10825276));
        this.g.add(new p(this, "方正兰亭黑_GBK", "fzlth_gbk.ttf", 6846680));
        this.i = new c(this, ReaderEnv.get().getUserFontDirectory().getPath());
    }

    public synchronized void a() {
        t.a(new d(this));
    }

    public void a(DownloadCenterTask downloadCenterTask) {
        i();
    }

    public void b(DownloadCenterTask downloadCenterTask) {
        i();
        DownloadCenterTask[] h = com.duokan.reader.domain.downloadcenter.b.n().h();
        for (DownloadCenterTask i : h) {
            if (new File(Uri.parse(i.i()).getPath()).exists()) {
                h();
            }
        }
        if (h.length > 0) {
            n();
            com.duokan.reader.domain.downloadcenter.b.n().b(h);
            g();
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
            h();
        }
    }

    public static void a(Context context) {
        c.a(new b(context));
    }

    public static b b() {
        return (b) c.a();
    }

    public synchronized q c() {
        q qVar;
        i();
        qVar = new q();
        qVar.a = this.g.size();
        qVar.c = qVar.a - this.f.size();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            qVar.b += pVar.d();
            File file = new File(ReaderEnv.get().getUserFontDirectory(), pVar.b);
            DownloadCenterTask b = com.duokan.reader.domain.downloadcenter.b.n().b(Uri.fromFile(file).toString());
            if (b != null && !b.h()) {
                qVar.d = (long) ((((float) pVar.d()) * (b.j() / 100.0f)) + ((float) qVar.d));
            } else if (file.exists()) {
                qVar.d += pVar.d();
            }
        }
        qVar.e = j();
        return qVar;
    }

    public synchronized void a(boolean z) {
        i();
        t.a(new f(this, z));
    }

    public synchronized boolean d() {
        boolean z = false;
        synchronized (this) {
            i();
            if (!(this.f == null || this.f.size() <= 0 || com.duokan.reader.domain.downloadcenter.b.n().j().length == this.f.size())) {
                z = true;
            }
        }
        return z;
    }

    public synchronized o[] e() {
        i();
        return (o[]) this.e.toArray(new o[0]);
    }

    public synchronized void a(a aVar) {
        if (a || aVar != null) {
            i();
            this.h.add(aVar);
        } else {
            throw new AssertionError();
        }
    }

    public synchronized void b(a aVar) {
        if (a || aVar != null) {
            i();
            this.h.remove(aVar);
        } else {
            throw new AssertionError();
        }
    }

    public synchronized void f() {
        i();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            DownloadCenterTask b = com.duokan.reader.domain.downloadcenter.b.n().b(Uri.fromFile(new File(ReaderEnv.get().getUserFontDirectory(), ((p) it.next()).b)).toString());
            if (b != null) {
                com.duokan.reader.domain.downloadcenter.b.n().a(b);
            }
        }
    }

    public synchronized void a(FlowChargingTransferChoice flowChargingTransferChoice) {
        i();
        a(new g(this, flowChargingTransferChoice));
    }

    public synchronized void a(Activity activity, n nVar) {
        i();
        if (this.k) {
            b(activity, nVar);
        } else {
            a(new h(this));
        }
    }

    public synchronized void g() {
        i();
    }

    private synchronized void h() {
        k();
        l();
        m();
        this.d = true;
    }

    private synchronized void i() {
        if (!this.d) {
            h();
        }
    }

    private boolean j() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            DownloadCenterTask b = com.duokan.reader.domain.downloadcenter.b.n().b(Uri.fromFile(new File(ReaderEnv.get().getUserFontDirectory(), ((p) it.next()).b)).toString());
            if (b != null && !b.h()) {
                return true;
            }
        }
        return false;
    }

    private void k() {
        this.e.clear();
        this.l = a(this.e, ReaderEnv.get().getKernelFontDirectory().getAbsolutePath());
        this.l &= a(this.e, ReaderEnv.get().getUserFontDirectory().getAbsolutePath());
        try {
            o oVar = new o(this);
            oVar.g = true;
            oVar.f = "";
            oVar.e = null;
            oVar.b = "";
            oVar.a = this.b.getString(i.general__shared__system_font);
            this.e.add(oVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(LinkedList linkedList, String str) {
        if (!ReaderEnv.get().isExternalStorageMounted()) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return true;
            }
            File[] listFiles = file.listFiles(new i(this));
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!(!file2.isFile() || file2.getName().equalsIgnoreCase("dk-symbol.ttf") || file2.getName().equalsIgnoreCase("DroidSansFallback.ttf"))) {
                        Object obj;
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            if (((o) it.next()).b.equals(file2.getName())) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            try {
                                o oVar = new o(this);
                                oVar.f = file2.getAbsolutePath();
                                oVar.e = new File(oVar.f);
                                oVar.b = file2.getName();
                                oVar.a = a(oVar.f);
                                if (!TextUtils.isEmpty(oVar.a)) {
                                    linkedList.add(oVar);
                                }
                                oVar.c = DkUtils.isZhFont(Uri.fromFile(oVar.d()).getPath());
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

    private void l() {
        this.f.clear();
        this.f.addAll(this.g);
        this.k = false;
    }

    private void m() {
        Collection arrayList = new ArrayList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            Object obj;
            p pVar = (p) it.next();
            Iterator it2 = this.e.iterator();
            while (it2.hasNext()) {
                if (pVar.b.equalsIgnoreCase(((o) it2.next()).b)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                arrayList.add(pVar);
            }
        }
        this.f.clear();
        this.f.addAll(arrayList);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new c().b(str);
    }

    private void n() {
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    private void a(Runnable runnable) {
        if (this.k) {
            runnable.run();
            return;
        }
        this.j = new j(this, com.duokan.reader.domain.account.i.f().e(), runnable);
        this.j.open();
    }

    private void b(Activity activity, n nVar) {
        b();
        ap kVar = new k(this, activity, activity, nVar);
        kVar.setTitle(i.reading__reading_menu_bottom_view_epub__wifi_auto_download_font_title);
        kVar.setPrompt(i.reading__reading_menu_bottom_view_epub__wifi_auto_download_font_prompt);
        kVar.setCancelLabel(i.general__shared__cancel);
        kVar.setOkLabel(i.general__shared__confirm);
        kVar.setCancelOnTouchOutside(false);
        kVar.setCancelOnBack(false);
        kVar.show();
    }

    private void a(Activity activity) {
        ap apVar = new ap(activity);
        apVar.setTitle(i.reading__reading_menu_bottom_view_epub__confirm_disable_wifi_auto_download_font_title);
        apVar.setPrompt(i.reading__reading_menu_bottom_view_epub__confirm_disable_wifi_auto_download_font_prompt);
        apVar.setOkLabel(i.reading__reading_menu_bottom_view_epub__confirm_disable_wifi_auto_download_font_ok);
        apVar.show();
    }

    private void b(FlowChargingTransferChoice flowChargingTransferChoice) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            a((p) it.next(), flowChargingTransferChoice);
        }
    }

    private void a(p pVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        File file = new File(ReaderEnv.get().getUserFontDirectory(), pVar.b);
        if (!file.exists()) {
            DownloadCenterTask b = com.duokan.reader.domain.downloadcenter.b.n().b(Uri.fromFile(file).toString());
            if (b != null) {
                if (b.h()) {
                    com.duokan.reader.domain.downloadcenter.b.n().a(b);
                } else {
                    return;
                }
            }
            UmengManager.get().onEvent("V2_READING_FONT_DOWNLOAD", pVar.a());
            l lVar = new l();
            m oVar = new o();
            oVar.m = flowChargingTransferChoice;
            oVar.a = pVar.a;
            lVar.b = pVar.e;
            lVar.c = Uri.fromFile(file).toString();
            lVar.a = pVar.a;
            lVar.d = pVar.f;
            lVar.e = oVar;
            com.duokan.reader.domain.downloadcenter.b.n().a(lVar);
        }
    }

    private boolean o() {
        DownloadCenterTask[] h = com.duokan.reader.domain.downloadcenter.b.n().h();
        if (h.length <= 0) {
            return false;
        }
        com.duokan.reader.domain.downloadcenter.b.n().b(h);
        return true;
    }
}
