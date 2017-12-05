package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.r;
import com.duokan.reader.common.classc;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.micloud.ba;
import com.duokan.reader.domain.micloud.bj;
import com.duokan.reader.domain.micloud.bl;
import com.duokan.reader.domain.micloud.m;
import com.duokan.reader.domain.micloud.t;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

import org.json.JSONException;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class iz implements ah, h {
    private static final ai o = new ai();
    private Context a;
    private i b;
    private final classc.IConnectChanged c;
    private final List d = new LinkedList();
    private final List e = new LinkedList();
    private final List f = new LinkedList();
    private final List g = new LinkedList();
    private final t h = new ja(this);
    private String i;
    private ba j;
    private jj k = new jj();
    private boolean l = false;
    private final Object m = new Object();
    @SuppressLint({"HandlerLeak"})
    private Handler n = new jf(this, Looper.getMainLooper());

    private iz(Context context, i iVar) {
        this.a = context;
        this.b = iVar;
        this.b.add((h) this);
        this.c = new jg(this);
        DkApp.get().runPreReady(new jh(this));
    }

    public static void a(Context context, i iVar) {
        o.a(new iz(context, iVar));
    }

    public static iz a() {
        return (iz) o.a();
    }

    public void a(a aVar) {
        h();
    }

    public void b(a aVar) {
    }

    public void c(a aVar) {
        h();
    }

    public void d(a aVar) {
    }

    private void h() {
        if (this.b.b()) {
            if (TextUtils.isEmpty(this.i)) {
                this.i = this.b.c().c();
                this.j = ba.a(this.a, this.i, "duokan");
                this.j.c().a(this.h);
                for (t a : this.d) {
                    this.j.c().a(a);
                }
                for (IAsyncWorkProgressListener a2 : this.e) {
                    this.j.c().a(a2);
                }
                for (r a3 : this.f) {
                    this.j.a().a(a3);
                }
                for (IAsyncWorkProgressListener a22 : this.g) {
                    this.j.a().a(a22);
                }
                a(true, null);
            }
        } else if (!TextUtils.isEmpty(this.i)) {
            this.n.removeMessages(0);
            this.n.removeMessages(1);
            this.j.d();
            this.j.c().b(this.h);
            for (t a4 : this.d) {
                this.j.c().b(a4);
            }
            for (IAsyncWorkProgressListener a222 : this.e) {
                this.j.c().b(a222);
            }
            for (IAsyncWorkProgressListener a2222 : this.g) {
                this.j.a().b(a2222);
            }
            for (r a32 : this.f) {
                this.j.a().b(a32);
            }
            this.j = null;
            this.i = null;
            this.k = new jj();
            this.l = false;
        }
    }

    public void a(t tVar) {
        if (!this.d.contains(tVar)) {
            this.d.add(tVar);
            if (this.j != null) {
                this.j.c().a(tVar);
            }
        }
    }

    public void a(IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        if (!this.e.contains(iAsyncWorkProgressListener)) {
            this.e.add(iAsyncWorkProgressListener);
            if (this.j != null) {
                this.j.c().a(iAsyncWorkProgressListener);
            }
        }
    }

    public void b(IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.e.remove(iAsyncWorkProgressListener);
        if (this.j != null) {
            this.j.c().b(iAsyncWorkProgressListener);
        }
    }

    public static boolean a(bl blVar) {
        return blVar.w().equals("/Books");
    }

    public synchronized bj b() {
        return this.k.a;
    }

    public synchronized iy a(String str) {
        return this.k.b(str);
    }

    public synchronized Collection c() {
        return this.k.b;
    }

    public synchronized boolean a(c cVar) {
        boolean a;
        if (this.b.b()) {
            a = a(cVar, this.k.b, this.k.c);
        } else {
            a = false;
        }
        return a;
    }

    public synchronized iy b(c cVar) {
        return a(cVar, this.k.b, this.k.c);
    }

    public boolean d() {
        return this.l;
    }

    public void a(jk jkVar) {
        a(false, jkVar);
    }

    private void a(boolean z, jk jkVar) {
        if (this.j != null) {
            if (z || !this.l) {
                new ji(this, this.j, this.i, jkVar).open();
            } else if (jkVar != null) {
                jkVar.a();
            }
        } else if (jkVar != null) {
            jkVar.a();
        }
    }

    public void a(boolean z) {
        ba baVar = this.j;
        if (baVar != null) {
            Context topActivity = ManagedApp.get().getTopActivity();
            if (topActivity == null) {
                topActivity = this.a;
            }
            e.b(topActivity);
            baVar.c().a("/Books", z, true, true, 1);
        }
    }

    public void a(r rVar) {
        if (!this.f.contains(rVar)) {
            this.f.add(rVar);
            if (this.j != null) {
                this.j.a().a(rVar);
            }
        }
    }

    public void b(r rVar) {
        this.f.remove(rVar);
        if (this.j != null) {
            this.j.a().b(rVar);
        }
    }

    public void c(IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        if (!this.g.contains(iAsyncWorkProgressListener)) {
            this.g.add(iAsyncWorkProgressListener);
            if (this.j != null) {
                this.j.a().a(iAsyncWorkProgressListener);
            }
        }
    }

    public void d(IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.g.remove(iAsyncWorkProgressListener);
        if (this.j != null) {
            this.j.a().b(iAsyncWorkProgressListener);
        }
    }

    public final boolean e() {
        ba baVar = this.j;
        if (baVar != null) {
            return baVar.a().c();
        }
        return false;
    }

    public final ArrayList f() {
        ba baVar = this.j;
        if (baVar != null) {
            return baVar.a().d();
        }
        return new ArrayList();
    }

    public final ArrayList g() {
        ba baVar = this.j;
        if (baVar != null) {
            return baVar.a().e();
        }
        return new ArrayList();
    }

    public com.duokan.reader.domain.micloud.i a(String str, String str2) {
        ba baVar = this.j;
        if (baVar == null) {
            return null;
        }
        e.b(ManagedApp.get().getTopActivity());
        c a = baVar.a().a(str, "/Books", str2, 5);
        try {
            a.u().put("book_upload_choice_at_flow_charging", FlowChargingTransferChoice.NoTransfer.name());
        } catch (Throwable th) {
        }
        com.duokan.reader.domain.statistics.dailystats.a.d().c(str2);
        a.a(new File(str).length());
        baVar.a().a(a);
        return a;
    }

    public com.duokan.reader.domain.micloud.i b(String str) {
        ba baVar = this.j;
        if (baVar != null) {
            return baVar.a().b(str);
        }
        return null;
    }

    public void a(com.duokan.reader.domain.micloud.i iVar) {
        ba baVar = this.j;
        if (baVar != null) {
            baVar.a().d((c) iVar);
        }
    }

    public void b(com.duokan.reader.domain.micloud.i iVar) {
        ba baVar = this.j;
        if (baVar != null) {
            baVar.a().a((c) iVar, true);
        }
    }

    public void a(com.duokan.reader.domain.micloud.i iVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        ba baVar = this.j;
        if (baVar != null) {
            baVar.a().a(iVar);
            try {
                iVar.u().put("book_upload_choice_at_flow_charging", flowChargingTransferChoice == null ? FlowChargingTransferChoice.Default.name() : flowChargingTransferChoice.name());
            } catch (JSONException e) {
            }
            baVar.a().a((c) iVar);
            if (f.b().c() && !c(iVar)) {
                baVar.a().a((c) iVar, false);
            }
        }
    }

    public m a(List list, boolean z, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        ba baVar = this.j;
        if (baVar == null) {
            return null;
        }
        List arrayList = new ArrayList(list.size());
        for (iy a : list) {
            arrayList.add(a.a());
        }
        return baVar.a(arrayList, z, iAsyncWorkProgressListener);
    }

    public static boolean a(c cVar, Collection collection) {
        return a(cVar, collection, null);
    }

    private static boolean a(c cVar, Collection collection, Map map) {
        if (cVar.ai()) {
            return false;
        }
        iy iyVar;
        com.duokan.reader.domain.micloud.i b;
        if (!cVar.am()) {
            File file = new File(cVar.e());
            for (iy iyVar2 : collection) {
                if (cVar.C() == iyVar2.d() && iyVar2.b().equals(file.getName())) {
                    return false;
                }
            }
            String absolutePath = ReaderEnv.get().getExternalFilesDirectory().getAbsolutePath();
            if (!absolutePath.endsWith("/")) {
                absolutePath + "/";
            }
            b = a().b(cVar.e());
            if (b == null || b.m() || b.n()) {
                return true;
            }
            return false;
        } else if (cVar.V()) {
            return false;
        } else {
            if (map != null) {
                iyVar2 = (iy) map.get(cVar.ap());
            } else {
                for (iy iyVar22 : collection) {
                    if (cVar.ap().equals(iyVar22.f())) {
                        break;
                    }
                }
                iyVar22 = null;
            }
            if (iyVar22 != null) {
                return false;
            }
            b = a().b(cVar.e());
            if (b == null || b.m() || b.n()) {
                return true;
            }
            return false;
        }
    }

    public static iy b(c cVar, Collection collection) {
        return a(cVar, collection, null);
    }

    private static iy a(c cVar, Collection collection, HashMap hashMap) {
        if (cVar.ai()) {
            return null;
        }
        if (!cVar.am()) {
            File file = new File(cVar.e());
            for (iy iyVar : collection) {
                if (cVar.C() == iyVar.d() && iyVar.b().equals(file.getName())) {
                    return iyVar;
                }
            }
        } else if (hashMap != null) {
            return (iy) hashMap.get(cVar.ap());
        } else {
            for (iy iyVar2 : collection) {
                if (cVar.ap().equals(iyVar2.f())) {
                    return iyVar2;
                }
            }
        }
        return null;
    }

    private void a(classc.ConnectivityReceiver connectivity) {
        if (this.j == null) {
            return;
        }
        if (!connectivity.e()) {
            j();
        } else if (connectivity.d()) {
            i();
        } else if (connectivity.c()) {
            k();
            l();
        }
    }

    private void i() {
        if (this.j != null) {
            Collection linkedList = new LinkedList();
            Iterator it = f().iterator();
            while (it.hasNext()) {
                com.duokan.reader.domain.micloud.i iVar = (com.duokan.reader.domain.micloud.i) it.next();
                if (iVar.k()) {
                    linkedList.add(iVar);
                }
            }
            a(linkedList);
        }
    }

    private void j() {
        if (this.j != null) {
            Collection linkedList = new LinkedList();
            Iterator it = f().iterator();
            while (it.hasNext()) {
                com.duokan.reader.domain.micloud.i iVar = (com.duokan.reader.domain.micloud.i) it.next();
                if (iVar.o()) {
                    linkedList.add(iVar);
                }
            }
            b(linkedList);
        }
    }

    private void k() {
        if (this.j != null) {
            Collection linkedList = new LinkedList();
            Iterator it = f().iterator();
            while (it.hasNext()) {
                com.duokan.reader.domain.micloud.i iVar = (com.duokan.reader.domain.micloud.i) it.next();
                if (iVar.o() && !c(iVar)) {
                    linkedList.add(iVar);
                }
            }
            b(linkedList);
        }
    }

    private void l() {
        if (this.j != null) {
            Collection linkedList = new LinkedList();
            Iterator it = f().iterator();
            while (it.hasNext()) {
                com.duokan.reader.domain.micloud.i iVar = (com.duokan.reader.domain.micloud.i) it.next();
                if (iVar.k() && c(iVar)) {
                    linkedList.add(iVar);
                }
            }
            a(linkedList);
        }
    }

    private static boolean c(com.duokan.reader.domain.micloud.i iVar) {
        FlowChargingTransferChoice valueOf = FlowChargingTransferChoice.valueOf(iVar.u().optString("book_upload_choice_at_flow_charging", FlowChargingTransferChoice.Default.name()));
        if (valueOf == null) {
            valueOf = FlowChargingTransferChoice.Default;
        }
        return valueOf == FlowChargingTransferChoice.Transfer || (valueOf == FlowChargingTransferChoice.Default && !ReaderEnv.get().getIsOnlyWifiUploadDownload());
    }

    private void a(Collection collection) {
        if (this.j != null) {
            this.n.sendMessageDelayed(this.n.obtainMessage(0, collection), 0);
        }
    }

    private void b(Collection collection) {
        if (this.j != null) {
            this.n.sendMessageDelayed(this.n.obtainMessage(1, collection), 0);
        }
    }
}
