package com.duokan.reader.domain.downloadcenter;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.download.C0594d;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.micloud.C1084z;
import com.duokan.reader.domain.micloud.ba;
import com.duokan.reader.domain.micloud.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.downloadcenter.r */
public class C1030r implements ai, C0594d, C0586j {
    /* renamed from: a */
    private static final aj<C1030r> f5101a = new aj();
    /* renamed from: b */
    private final Context f5102b;
    /* renamed from: c */
    private final C0709k f5103c;
    /* renamed from: d */
    private final String[] f5104d;
    /* renamed from: e */
    private final CopyOnWriteArrayList<C0594d> f5105e = new CopyOnWriteArrayList();
    /* renamed from: f */
    private final CopyOnWriteArrayList<C1028p> f5106f = new CopyOnWriteArrayList();
    /* renamed from: g */
    private String f5107g;

    private C1030r(Context context, C0709k c0709k, String[] strArr) {
        this.f5102b = context;
        this.f5103c = c0709k;
        this.f5104d = strArr;
        this.f5103c.m3494a((C0586j) this);
        m7949a(this.f5103c.m3508d());
    }

    /* renamed from: a */
    public static void m7948a(Context context, C0709k c0709k, String[] strArr) {
        f5101a.m709a(new C1030r(context, c0709k, strArr));
    }

    /* renamed from: a */
    public static C1030r m7946a() {
        return (C1030r) f5101a.m707a();
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        C1030r.m7951a(new C1031s(this, this.f5103c.m3508d()));
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
    }

    public void onAccountLogoff(C0672a c0672a) {
        C1030r.m7951a(new C1032t(this, this.f5103c.m3508d()));
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    /* renamed from: a */
    private void m7949a(UserAccount userAccount) {
        if (userAccount.mo839i()) {
            if (!TextUtils.isEmpty(this.f5107g)) {
                ba.m8108a(this.f5107g);
                this.f5107g = null;
            }
        } else if (TextUtils.isEmpty(this.f5107g)) {
            this.f5107g = userAccount.mo833c();
            for (String a : this.f5104d) {
                Iterator it = ba.m8105a(this.f5102b, this.f5107g, a).m8114b().m2368c().iterator();
                while (it.hasNext()) {
                    this.f5106f.add(new C1028p(this.f5102b, (C1084z) it.next(), this));
                }
            }
        }
    }

    /* renamed from: a */
    public void m7958a(C0594d c0594d) {
        this.f5105e.add(c0594d);
    }

    /* renamed from: b */
    public void m7962b(C0594d c0594d) {
        this.f5105e.remove(c0594d);
    }

    /* renamed from: a */
    public C1028p[] m7961a(String str) {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5106f.iterator();
        while (it.hasNext()) {
            C1028p c1028p = (C1028p) it.next();
            if (c1028p.mo790b().equals(str)) {
                linkedList.addLast(c1028p);
            }
        }
        return (C1028p[]) linkedList.toArray(new C1028p[0]);
    }

    /* renamed from: a */
    public C1028p m7954a(String str, String str2, bi biVar, JSONObject jSONObject) {
        return new C1028p(this.f5102b, str, str2, biVar, jSONObject, this);
    }

    /* renamed from: a */
    public void m7959a(C1028p c1028p) {
        this.f5106f.addIfAbsent(c1028p);
        C1030r.m7951a(new C1033u(this, c1028p));
    }

    /* renamed from: a */
    public void m7960a(C1028p c1028p, boolean z) {
        C1030r.m7951a(new C1034v(this, c1028p, z));
    }

    /* renamed from: b */
    public void m7963b(C1028p c1028p) {
        this.f5106f.remove(c1028p);
        C1030r.m7951a(new C1035w(this, c1028p));
    }

    /* renamed from: b */
    public boolean m7964b() {
        Iterator it = this.f5106f.iterator();
        while (it.hasNext()) {
            TaskStatus e = ((C1028p) it.next()).mo792e();
            if (e != TaskStatus.RUNNING) {
                if (e == TaskStatus.PENDING) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo1471a(IDownloadTask iDownloadTask) {
        UThread.runOnThread(new C1036x(this, iDownloadTask));
    }

    /* renamed from: a */
    public void mo1473a(IDownloadTask iDownloadTask, TaskStatus taskStatus) {
        UThread.runOnThread(new C1037y(this, iDownloadTask, taskStatus));
    }

    /* renamed from: a */
    public void mo1472a(IDownloadTask iDownloadTask, TaskState taskState) {
        UThread.runOnThread(new C1038z(this, iDownloadTask, taskState));
    }

    /* renamed from: a */
    private static void m7951a(Runnable runnable) {
        ah.m866a(runnable, "micloud");
    }
}
