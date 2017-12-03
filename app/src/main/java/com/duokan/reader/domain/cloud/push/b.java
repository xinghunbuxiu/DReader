package com.duokan.reader.domain.cloud.push;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.duokan.n;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;
import com.duokan.reader.domain.social.message.DkMessagesManager;
import com.duokan.reader.domain.social.message.aa;
import com.duokan.reader.domain.social.message.aw;
import com.duokan.reader.domain.social.message.ay;
import com.duokan.reader.domain.social.message.bb;
import com.duokan.reader.domain.social.message.k;
import com.duokan.reader.ui.general.jq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class b implements ah, h, ay {
    protected static final String a = b.class.getName();
    static final /* synthetic */ boolean b = (!b.class.desiredAssertionStatus());
    private static final ai c = new ai();
    private final Context d;
    private final i e;
    private final bb f;
    private final ReaderEnv g;
    private final LinkedList h = new LinkedList();
    private final HashMap i = new HashMap();

    public DkCloudPushMessage a(String str) {
        return TaskHandler.getThead().a(str);
    }

    protected b(Context context, i iVar, bb bbVar, ReaderEnv readerEnv) {
        this.d = context;
        this.e = iVar;
        this.f = bbVar;
        this.g = readerEnv;
        DkApp.get().runPreReady(new c(this));
        DkApp.get().runWhenAppReady(new g(this));
    }

    public void a(a aVar) {
    }

    public void b(a aVar) {
        if (h()) {
            a(i(), aVar, true, null);
        }
    }

    public void c(a aVar) {
        if (h()) {
            String prefString = this.g.getPrefString(PrivatePref.PERSONAL, "mi_push_account", "");
            String prefString2 = this.g.getPrefString(PrivatePref.PERSONAL, "mi_push_account_token", "");
            if (!TextUtils.isEmpty(prefString2)) {
                e(prefString2);
            } else if (!TextUtils.isEmpty(prefString)) {
                f(prefString);
            }
        }
    }

    public void d(a aVar) {
    }

    public void a(DkMessagesManager dkMessagesManager, ArrayList arrayList, aa aaVar) {
        e();
    }

    public void a(DkMessagesManager dkMessagesManager) {
        e();
    }

    public static void a(Context context, i iVar, bb bbVar, ReaderEnv readerEnv) {
        c.a(new b(context, iVar, bbVar, readerEnv));
    }

    public static b a() {
        return (b) c.a();
    }

    public void a(boolean z, s sVar) {
        if (h()) {
            j a = jq.a(DkApp.get().getTopActivity(), "", this.d.getString(com.duokan.b.i.general__shared__push_server_accept), true, true);
            a(i(), this.e.b(PersonalAccount.class), z, a, sVar);
            return;
        }
        sVar.a(this.d.getString(com.duokan.b.i.general__shared__push_client_server_error));
    }

    public void a(DkCloudPushMessage dkCloudPushMessage) {
        TaskHandler.getThead().a(dkCloudPushMessage);
    }

    public void b(String str) {
        TaskHandler.getThead().b(str);
        e();
    }

    public void b() {
        TaskHandler.getThead().d();
        e();
        this.f.d();
    }

    public int c() {
        return TaskHandler.getThead().c() + this.f.b();
    }

    public void a(int i, long j, r rVar) {
        if (((PersonalAccount) this.e.b(PersonalAccount.class)).i()) {
            a(j, new k[0], false, rVar);
            return;
        }
        this.f.a(i, 10, true, new j(this, j, rVar));
    }

    public void a(List list, aw awVar) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (q qVar : list) {
            if (qVar.a != null) {
                arrayList2.add(qVar.a);
            } else if (qVar.b != null) {
                arrayList.add(qVar.b);
            }
        }
        this.f.a(arrayList2, new k(this, arrayList, awVar));
    }

    public void a(MessageSubType messageSubType, MessageWakeupListener messageWakeupListener) {
        this.i.put(messageSubType, messageWakeupListener);
    }

    public void a(a aVar) {
        if (b || aVar != null) {
            this.h.add(aVar);
            return;
        }
        throw new AssertionError();
    }

    public void b(a aVar) {
        if (b || aVar != null) {
            this.h.remove(aVar);
            return;
        }
        throw new AssertionError();
    }

    public void c(String str) {
        z.a().b(str);
    }

    public void d(String str) {
        z.a().c(str);
    }

    public List d() {
        return z.a().b();
    }

    private void e() {
        TaskHandler.postTask(new l(this));
    }

    private void a(String str, a aVar, boolean z, Runnable runnable) {
        Object c = (aVar == null || aVar.i()) ? "" : aVar.c();
        CharSequence prefString = this.g.getPrefString(PrivatePref.PERSONAL, "mi_push_token", "");
        CharSequence prefString2 = this.g.getPrefString(PrivatePref.PERSONAL, "mi_push_account", "");
        long prefLong = this.g.getPrefLong(PrivatePref.PERSONAL, "mi_push_register_time", 0);
        if (z || System.currentTimeMillis() - prefLong > 86400000 || !TextUtils.equals(prefString, str) || !TextUtils.equals(prefString2, c) || p.i().l()) {
            n mVar = new m(this, aVar, str, c, runnable);
            mVar.setMaxRetryCount(1);
            mVar.open();
        }
    }

    private void f() {
        if (h() && !this.g.getPrefBoolean(PrivatePref.PERSONAL, "mi_push_notify_server", false)) {
            a(i(), this.e.b(PersonalAccount.class), ReaderEnv.get().getReceivePushes(), null, null);
        }
    }

    private void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.g.setPrefString(PrivatePref.PERSONAL, "mi_push_notify_account_token", str);
            this.g.commitPrefs();
            n nVar = new n(this, str);
            nVar.setMaxRetryCount(1);
            nVar.open();
        }
    }

    private void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.g.setPrefString(PrivatePref.PERSONAL, "mi_push_notify_account", str);
            this.g.commitPrefs();
            n oVar = new o(this, str);
            oVar.setMaxRetryCount(1);
            oVar.open();
        }
    }

    private void g() {
        this.g.setPrefString(PrivatePref.PERSONAL, "mi_push_notify_account", "");
        this.g.setPrefString(PrivatePref.PERSONAL, "mi_push_account", "");
        this.g.setPrefString(PrivatePref.PERSONAL, "mi_push_account_token", "");
        this.g.setPrefString(PrivatePref.PERSONAL, "mi_push_notify_account_token", "");
        this.g.commitPrefs();
    }

    private void a(String str, a aVar, boolean z, j jVar, s sVar) {
        new d(this, aVar, str, z, new p(this, jVar, sVar)).open();
    }

    private void a(String str, a aVar, String... strArr) {
        new e(this, aVar, str, strArr).open();
    }

    private boolean h() {
        return !TextUtils.isEmpty(this.g.getPrefString(PrivatePref.PERSONAL, "mi_push_token", ""));
    }

    private String i() {
        return this.g.getPrefString(PrivatePref.PERSONAL, "mi_push_token", "");
    }

    private void a(long j, k[] kVarArr, boolean z, r rVar) {
        q[] qVarArr;
        boolean z2;
        int i = 20;
        DkCloudPushMessage[] a = TaskHandler.getThead().a(j);
        Collection a2 = q.a(a);
        Collection a3 = q.a(kVarArr);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(a2);
        linkedList.addAll(a3);
        Collections.sort(linkedList, new f(this));
        if (linkedList.size() > 0) {
            if (linkedList.size() <= 20) {
                i = linkedList.size();
            }
            qVarArr = (q[]) linkedList.subList(0, i).toArray(new q[0]);
        } else {
            qVarArr = new q[0];
        }
        if (z || a.length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        rVar.a(qVarArr, z2);
    }
}
