package com.duokan.reader.domain.downloadcenter;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.UThread;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkNotificationManager;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.download.C0594d;
import com.duokan.reader.common.download.C0596e;
import com.duokan.reader.common.download.C0602k;
import com.duokan.reader.common.download.DownloadTask;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask.TaskResult;
import com.duokan.reader.domain.p044b.C0781b;
import com.duokan.reader.domain.p044b.C0796q;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.downloadcenter.b */
public class C1016b implements ai, C0594d {
    /* renamed from: a */
    static final /* synthetic */ boolean f5053a;
    /* renamed from: b */
    private static final aj<C1016b> f5054b = new aj();
    /* renamed from: c */
    private final Context f5055c;
    /* renamed from: d */
    private final C1030r f5056d;
    /* renamed from: e */
    private final C0596e f5057e;
    /* renamed from: f */
    private final LinkedList<DownloadCenterTask> f5058f = new LinkedList();
    /* renamed from: g */
    private final CopyOnWriteArrayList<C0780k> f5059g = new CopyOnWriteArrayList();
    /* renamed from: h */
    private final DkNotificationManager f5060h;
    /* renamed from: i */
    private Runnable f5061i = null;
    /* renamed from: j */
    private Intent f5062j = null;
    /* renamed from: k */
    private Intent f5063k = null;
    /* renamed from: l */
    private Intent f5064l = null;
    /* renamed from: m */
    private C0563j f5065m;
    @SuppressLint({"HandlerLeak"})
    /* renamed from: n */
    private Handler f5066n = new C1017c(this, Looper.getMainLooper());

    static {
        boolean z;
        if (C1016b.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f5053a = z;
    }

    protected C1016b(Context context, C1030r c1030r, C0596e c0596e, DkNotificationManager dkNotificationManager) {
        if (f5053a || c0596e != null) {
            this.f5055c = context;
            this.f5056d = c1030r;
            this.f5057e = c0596e;
            this.f5060h = dkNotificationManager;
            this.f5057e.m2764a((C0594d) this, null);
            this.f5056d.m7958a((C0594d) this);
            m7858t();
            m7859u();
            m7861w();
            m7862x();
            DkApp.get().runPreReady(new C1018d(this));
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public DownloadCenterTask[] m7876a() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.m7792f()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: b */
    public DownloadCenterTask[] m7883b() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.m7790d()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: c */
    public DownloadCenterTask[] m7886c() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.m7793g()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: d */
    public DownloadCenterTask[] m7888d() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.m7793g() && !downloadCenterTask.m7804r()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: e */
    public DownloadCenterTask[] m7889e() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.m7794h()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: f */
    public DownloadCenterTask[] m7890f() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.m7794h() && !downloadCenterTask.m7804r()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: g */
    public DownloadCenterTask[] m7891g() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.m7803q() && downloadCenterTask.m7804r()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: h */
    public DownloadCenterTask[] m7892h() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.m7803q() && downloadCenterTask.m7793g() && downloadCenterTask.m7802p().mo1474a() == DownloadType.FONT) {
                linkedList.addLast(downloadCenterTask);
                C0796q c = C0781b.m3667b().m3690c();
                if (c.f2661a == c.f2663c && ReaderEnv.get().getPrefBoolean(PrivatePref.READING, "FONT_ALERT", false)) {
                    ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "FONT_ALERT", true);
                    ReaderEnv.get().commitPrefs();
                    C1167a.m8671d().m8687d("s");
                } else if (c.f2661a != c.f2663c) {
                    ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "FONT_ALERT", false);
                    ReaderEnv.get().commitPrefs();
                }
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: i */
    public DownloadCenterTask[] m7893i() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.m7803q() && downloadCenterTask.m7793g() && downloadCenterTask.m7802p().mo1474a() == DownloadType.DICT) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: j */
    public DownloadCenterTask[] m7894j() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.m7803q() && (downloadCenterTask.m7802p() instanceof C1027o)) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: k */
    public DownloadCenterTask[] m7895k() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.m7803q() && (downloadCenterTask.m7802p() instanceof ab)) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    /* renamed from: l */
    public LinkedList<DownloadCenterTask> m7896l() {
        LinkedList<DownloadCenterTask> linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.m7792f() && (downloadCenterTask.m7802p() instanceof ab)) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    public void m7875a(DownloadCenterTask[] downloadCenterTaskArr, boolean z) {
        Arrays.sort(downloadCenterTaskArr, new C1019e(this, z));
    }

    /* renamed from: m */
    public Intent m7897m() {
        return this.f5062j;
    }

    /* renamed from: a */
    public void m7867a(Intent intent) {
        this.f5062j = intent;
        m7861w();
    }

    /* renamed from: n */
    public Intent m7898n() {
        return this.f5063k;
    }

    /* renamed from: b */
    public void m7878b(Intent intent) {
        this.f5063k = intent;
        m7862x();
    }

    /* renamed from: o */
    public Intent m7899o() {
        return this.f5064l;
    }

    /* renamed from: c */
    public void m7884c(Intent intent) {
        this.f5064l = intent;
        m7863y();
    }

    /* renamed from: a */
    public static void m7833a(Context context, C1030r c1030r, C0596e c0596e, DkNotificationManager dkNotificationManager) {
        f5054b.m709a(new C1016b(context, c1030r, c0596e, dkNotificationManager));
    }

    /* renamed from: p */
    public static C1016b m7857p() {
        return (C1016b) f5054b.m707a();
    }

    /* renamed from: a */
    public DownloadCenterTask m7865a(C1025l c1025l) {
        if (f5053a || c1025l != null) {
            DownloadCenterTask a;
            if (!(c1025l.f5083e instanceof C1015a) || ((C1015a) c1025l.f5083e).f5046i == null) {
                IDownloadTask a2 = this.f5057e.m2758a(m7840b(c1025l));
                a = DownloadCenterTask.m7784a(a2);
                if (a != null) {
                    this.f5058f.addFirst(a);
                    this.f5057e.m2768b(a2);
                }
            } else {
                C1015a c1015a = (C1015a) c1025l.f5083e;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("download_info", c1015a.m7814c());
                } catch (Exception e) {
                    if (!f5053a) {
                        throw new AssertionError();
                    }
                }
                C1028p a3 = this.f5056d.m7954a("3D7E8CAD-6534-415F-9484-F69F92B18637", c1025l.f5081c, c1015a.f5046i.m4680a(), jSONObject);
                a = DownloadCenterTask.m7784a((IDownloadTask) a3);
                if (a != null) {
                    this.f5058f.addFirst(a);
                    this.f5056d.m7959a(a3);
                }
            }
            m7835a(a, true);
            if (C0559f.m2476b().m2484c() && !m7856h(a)) {
                m7855g(a);
            }
            return a;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m7871a(DownloadCenterTask downloadCenterTask) {
        if (f5053a || downloadCenterTask != null) {
            m7885c(downloadCenterTask);
            if (!downloadCenterTask.m7793g()) {
                new File(Uri.parse(downloadCenterTask.m7795i() + ".tmp").getPath()).delete();
            }
            this.f5058f.remove(downloadCenterTask);
            if (downloadCenterTask.f5029a instanceof DownloadTask) {
                this.f5057e.m2759a((DownloadTask) downloadCenterTask.f5029a);
            } else {
                this.f5056d.m7963b((C1028p) downloadCenterTask.f5029a);
            }
            m7835a(downloadCenterTask, true);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m7874a(DownloadCenterTask[] downloadCenterTaskArr) {
        if (f5053a || downloadCenterTaskArr != null) {
            for (DownloadCenterTask a : downloadCenterTaskArr) {
                m7871a(a);
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: q */
    public void m7900q() {
        m7874a(m7891g());
    }

    /* renamed from: b */
    public void m7879b(DownloadCenterTask downloadCenterTask) {
        if (!f5053a && downloadCenterTask == null) {
            throw new AssertionError();
        } else if (!downloadCenterTask.m7793g() && downloadCenterTask.m7800n() != TaskResult.DECODE_ERROR && downloadCenterTask.m7800n() != TaskResult.URI_EXPIRED && !downloadCenterTask.m7787a() && !downloadCenterTask.m7790d()) {
            downloadCenterTask.m7786a(TaskResult.NONE);
            if (downloadCenterTask.f5029a instanceof DownloadTask) {
                this.f5057e.m2768b((DownloadTask) downloadCenterTask.f5029a);
            } else {
                this.f5056d.m7959a((C1028p) downloadCenterTask.f5029a);
            }
            m7835a(downloadCenterTask, true);
            if (C0559f.m2476b().m2484c() && !m7856h(downloadCenterTask)) {
                m7855g(downloadCenterTask);
            }
        }
    }

    /* renamed from: c */
    public void m7885c(DownloadCenterTask downloadCenterTask) {
        if (downloadCenterTask.f5029a instanceof DownloadTask) {
            this.f5057e.m2771c((DownloadTask) downloadCenterTask.f5029a);
        } else {
            this.f5056d.m7960a((C1028p) downloadCenterTask.f5029a, true);
        }
        m7835a(downloadCenterTask, true);
    }

    /* renamed from: a */
    public void m7873a(Collection<DownloadCenterTask> collection) {
        for (DownloadCenterTask b : collection) {
            m7879b(b);
        }
    }

    /* renamed from: b */
    public void m7881b(Collection<DownloadCenterTask> collection) {
        for (DownloadCenterTask c : collection) {
            m7885c(c);
        }
    }

    /* renamed from: d */
    public void m7887d(DownloadCenterTask downloadCenterTask) {
        if (!f5053a && downloadCenterTask == null) {
            throw new AssertionError();
        } else if (!downloadCenterTask.m7803q()) {
            downloadCenterTask.m7805s();
            m7835a(downloadCenterTask, true);
        }
    }

    /* renamed from: b */
    public void m7882b(DownloadCenterTask[] downloadCenterTaskArr) {
        if (f5053a || downloadCenterTaskArr != null) {
            for (DownloadCenterTask d : downloadCenterTaskArr) {
                m7887d(d);
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: r */
    public void m7901r() {
        for (DownloadCenterTask t : m7886c()) {
            t.m7806t();
        }
        m7861w();
    }

    /* renamed from: s */
    public void m7902s() {
        for (DownloadCenterTask t : m7889e()) {
            t.m7806t();
        }
        m7862x();
    }

    /* renamed from: a */
    public void m7872a(C0780k c0780k) {
        if (f5053a || c0780k != null) {
            this.f5059g.add(c0780k);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void m7880b(C0780k c0780k) {
        if (f5053a || c0780k != null) {
            this.f5059g.remove(c0780k);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public DownloadCenterTask m7866a(String str) {
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.m7803q() && (downloadCenterTask.m7802p() instanceof C1015a) && ((C1015a) downloadCenterTask.m7802p()).f5040c.equals(str)) {
                return downloadCenterTask;
            }
        }
        return null;
    }

    /* renamed from: b */
    public DownloadCenterTask m7877b(String str) {
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.m7803q() && downloadCenterTask.m7795i().equals(str)) {
                return downloadCenterTask;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo1471a(IDownloadTask iDownloadTask) {
        if (iDownloadTask.mo790b().equals("3D7E8CAD-6534-415F-9484-F69F92B18637")) {
            UThread.runOnThread(new C1020f(this));
        }
    }

    /* renamed from: a */
    public void mo1473a(IDownloadTask iDownloadTask, TaskStatus taskStatus) {
        if (iDownloadTask.mo790b().equals("3D7E8CAD-6534-415F-9484-F69F92B18637")) {
            UThread.runOnThread(new C1021g(this, iDownloadTask));
        }
    }

    /* renamed from: a */
    public void mo1472a(IDownloadTask iDownloadTask, TaskState taskState) {
        if (iDownloadTask.mo790b().equals("3D7E8CAD-6534-415F-9484-F69F92B18637")) {
            TaskResult b;
            if (taskState != TaskState.UNFINISHED) {
                b = m7841b(iDownloadTask, taskState);
            } else {
                b = TaskResult.NONE;
            }
            UThread.runOnThread(new C1022h(this, iDownloadTask, b));
        }
    }

    /* renamed from: b */
    private TaskResult m7841b(IDownloadTask iDownloadTask, TaskState taskState) {
        try {
            if ((taskState == TaskState.SUCCEEDED ? 1 : null) == null) {
                return TaskResult.DOWNLOAD_FAILED;
            }
            if (!(iDownloadTask instanceof DownloadTask)) {
                return TaskResult.OK;
            }
            DownloadTask downloadTask = (DownloadTask) iDownloadTask;
            if (downloadTask.m2724p().equals("text/html")) {
                return TaskResult.URI_EXPIRED;
            }
            DownloadCenterTask downloadCenterTask;
            Iterator it = this.f5058f.iterator();
            while (it.hasNext()) {
                downloadCenterTask = (DownloadCenterTask) it.next();
                if (downloadCenterTask.f5029a == iDownloadTask) {
                    break;
                }
            }
            downloadCenterTask = null;
            DownloadType a = downloadCenterTask.m7802p().mo1474a();
            return (a == DownloadType.PLUGIN || a == DownloadType.TTS_PACK) ? m7843b(downloadTask) ? TaskResult.OK : TaskResult.DECODE_ERROR : m7837a(downloadTask) ? TaskResult.OK : TaskResult.DECODE_ERROR;
        } catch (Exception e) {
            return TaskResult.DOWNLOAD_FAILED;
        } catch (Error e2) {
            return TaskResult.DOWNLOAD_FAILED;
        }
    }

    /* renamed from: a */
    private boolean m7837a(DownloadTask downloadTask) {
        String p = downloadTask.m2724p();
        if (f5053a || p != null) {
            boolean renameTo;
            String path = Uri.parse(downloadTask.mo796j()).getPath();
            String substring = path.substring(0, path.length() - ".tmp".length());
            File file = new File(path);
            File file2 = new File(substring);
            if (p.equals(HTTP.PLAIN_TEXT_TYPE)) {
                renameTo = file.renameTo(file2);
            } else if (p.equals("application/epub+zip")) {
                renameTo = file.renameTo(file2);
            } else if (p.equals("application/zip") || p.equals("application/x-gzip") || p.equals("application/x-winzip") || p.equals("applicatoin/x-zip") || p.equals("application/x-zip-compressed")) {
                DkPublic.unzip(file, file.getParentFile());
                renameTo = file2.exists();
                if (renameTo) {
                    file.delete();
                }
            } else {
                renameTo = file.renameTo(file2);
            }
            if (renameTo) {
                downloadTask.m2702a(Uri.parse(substring).toString());
            }
            return renameTo;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private boolean m7843b(DownloadTask downloadTask) {
        String p = downloadTask.m2724p();
        if (f5053a || p != null) {
            File file = new File(Uri.parse(downloadTask.mo796j()).getPath());
            boolean unzip = DkPublic.unzip(file, file.getParentFile());
            file.delete();
            return unzip;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private C0602k m7840b(C1025l c1025l) {
        if (!f5053a && c1025l.f5080b == null) {
            throw new AssertionError();
        } else if (!f5053a && c1025l.f5081c == null) {
            throw new AssertionError();
        } else if (!f5053a && c1025l.f5079a == null) {
            throw new AssertionError();
        } else if (f5053a || c1025l.f5083e != null) {
            C0602k c0602k = new C0602k();
            c0602k.f2009a = c1025l.f5079a;
            c0602k.f2010b = c1025l.f5080b;
            c0602k.f2011c = c1025l.f5081c + ".tmp";
            c0602k.f2012d = c1025l.f5082d;
            c0602k.f2013e = "3D7E8CAD-6534-415F-9484-F69F92B18637";
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("download_info", c1025l.f5083e.m7814c());
            } catch (Exception e) {
                if (!f5053a) {
                    throw new AssertionError();
                }
            }
            c0602k.f2014f = jSONObject.toString();
            return c0602k;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: t */
    private void m7858t() {
        int i = 0;
        for (IDownloadTask a : this.f5057e.m2767a("3D7E8CAD-6534-415F-9484-F69F92B18637")) {
            DownloadCenterTask a2 = DownloadCenterTask.m7784a(a);
            if (a2 != null) {
                this.f5058f.addFirst(a2);
            }
        }
        C1028p[] a3 = this.f5056d.m7961a("3D7E8CAD-6534-415F-9484-F69F92B18637");
        int length = a3.length;
        while (i < length) {
            DownloadCenterTask a4 = DownloadCenterTask.m7784a(a3[i]);
            if (a4 != null) {
                this.f5058f.addFirst(a4);
            }
            i++;
        }
    }

    /* renamed from: u */
    private void m7859u() {
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.f5029a.mo790b().equals("3D7E8CAD-6534-415F-9484-F69F92B18637")) {
                if (!downloadCenterTask.m7794h() && downloadCenterTask.f5029a.mo793f() == TaskState.FAILED) {
                    downloadCenterTask.m7786a(TaskResult.DOWNLOAD_FAILED);
                } else if (!downloadCenterTask.m7792f() && downloadCenterTask.f5029a.mo793f() == TaskState.SUCCEEDED) {
                    downloadCenterTask.m7786a(m7841b(downloadCenterTask.f5029a, TaskState.SUCCEEDED));
                }
            }
        }
    }

    /* renamed from: v */
    private void m7860v() {
        if (this.f5061i == null) {
            this.f5061i = new C1023i(this);
            UThread.post(this.f5061i);
        }
    }

    /* renamed from: e */
    private void m7852e(DownloadCenterTask downloadCenterTask) {
        Iterator it = this.f5059g.iterator();
        while (it.hasNext()) {
            ((C0780k) it.next()).onTaskRunning(downloadCenterTask);
        }
        m7863y();
    }

    /* renamed from: f */
    private void m7854f(DownloadCenterTask downloadCenterTask) {
        Iterator it = this.f5059g.iterator();
        while (it.hasNext()) {
            ((C0780k) it.next()).onTaskStatusChanged(downloadCenterTask);
        }
        m7861w();
        m7862x();
        m7863y();
    }

    /* renamed from: a */
    private void m7835a(DownloadCenterTask downloadCenterTask, boolean z) {
    }

    /* renamed from: w */
    private void m7861w() {
        if (this.f5062j != null) {
            DownloadCenterTask[] d = m7888d();
            if (d.length < 1) {
                this.f5060h.cancel("3D7E8CAD-6534-415F-9484-F69F92B18637", 1);
                return;
            }
            m7875a(d, false);
            CharSequence c = m7844c(d);
            CharSequence format = String.format(this.f5055c.getString(C0247i.personal__succeeded_download_tasks_view__ticker), new Object[]{c});
            CharSequence string = this.f5055c.getString(C0247i.personal__succeeded_download_tasks_view__detail);
            Builder builder = new Builder(this.f5055c);
            builder.setAutoCancel(true);
            builder.setSmallIcon(C0243e.personal__succeeded_download_tasks_view__icon);
            builder.setWhen(System.currentTimeMillis());
            builder.setTicker(format);
            builder.setContentTitle(c);
            builder.setContentText(string);
            builder.setContentIntent(PendingIntent.getService(this.f5055c, 0, new Intent(this.f5055c, DownloadNotificationService.class).setAction("com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_SUCCEEDED"), 134217728));
            builder.setDeleteIntent(PendingIntent.getService(this.f5055c, 0, new Intent(this.f5055c, DownloadNotificationService.class).setAction("com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_DELETE_SUCCEEDED"), 134217728));
            this.f5060h.notify("3D7E8CAD-6534-415F-9484-F69F92B18637", 1, builder.build());
        }
    }

    /* renamed from: x */
    private void m7862x() {
        if (this.f5063k != null) {
            DownloadCenterTask[] f = m7890f();
            if (f.length < 1) {
                this.f5060h.cancel("3D7E8CAD-6534-415F-9484-F69F92B18637", 2);
                return;
            }
            m7875a(f, false);
            CharSequence c = m7844c(f);
            CharSequence format = String.format(this.f5055c.getString(C0247i.personal__failed_download_tasks_view__ticker), new Object[]{c});
            CharSequence string = this.f5055c.getString(C0247i.personal__failed_download_tasks_view__detail);
            Builder builder = new Builder(this.f5055c);
            builder.setAutoCancel(true);
            builder.setSmallIcon(C0243e.personal__failed_download_tasks_view__icon);
            builder.setWhen(System.currentTimeMillis());
            builder.setTicker(format);
            builder.setContentTitle(c);
            builder.setContentText(string);
            builder.setDeleteIntent(PendingIntent.getService(this.f5055c, 0, new Intent(this.f5055c, DownloadNotificationService.class).setAction("com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_DELETE_FAILED"), 134217728));
            builder.setContentIntent(PendingIntent.getService(this.f5055c, 0, new Intent(this.f5055c, DownloadNotificationService.class).setAction("com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_FAILED"), 134217728));
            this.f5060h.notify("3D7E8CAD-6534-415F-9484-F69F92B18637", 2, builder.build());
        }
    }

    /* renamed from: y */
    private void m7863y() {
        if (this.f5064l != null) {
            DownloadCenterTask[] b = m7883b();
            if (b.length < 1) {
                this.f5060h.cancel("3D7E8CAD-6534-415F-9484-F69F92B18637", 3);
                return;
            }
            m7875a(b, false);
            long j = 0;
            DownloadCenterTask[] a = m7876a();
            float f = 0.0f;
            for (DownloadCenterTask downloadCenterTask : a) {
                f += (1.0f / ((float) a.length)) * downloadCenterTask.m7796j();
                j += downloadCenterTask.m7797k();
            }
            float max = Math.max(0.0f, Math.min(f, 100.0f));
            CharSequence format = String.format(this.f5055c.getString(C0247i.personal__running_download_tasks_view__ticker), new Object[]{m7844c(b)});
            CharSequence format2 = String.format(this.f5055c.getString(C0247i.personal__running_download_tasks_view__detail), new Object[]{DkPublic.formatBytes(j), Float.valueOf(max)});
            Builder builder = new Builder(this.f5055c);
            builder.setSmallIcon(C0243e.personal__running_download_tasks_view__icon);
            builder.setWhen(System.currentTimeMillis());
            builder.setTicker(format);
            builder.setContentTitle(r4);
            builder.setContentText(format2);
            builder.setContentIntent(PendingIntent.getService(this.f5055c, 0, new Intent(this.f5055c, DownloadNotificationService.class).setAction("com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_RUNNING"), 134217728));
            Notification build = builder.build();
            build.flags |= 32;
            this.f5060h.notify("3D7E8CAD-6534-415F-9484-F69F92B18637", 3, build);
        }
    }

    /* renamed from: c */
    private String m7844c(DownloadCenterTask[] downloadCenterTaskArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < downloadCenterTaskArr.length; i++) {
            C1014m p = downloadCenterTaskArr[i].m7802p();
            if (i > 0) {
                stringBuilder.append(this.f5055c.getResources().getString(C0247i.general__shared__comma));
            }
            if (p instanceof C1015a) {
                stringBuilder.append(String.format(this.f5055c.getResources().getString(C0247i.general__shared__book_title_marks), new Object[]{p.mo1475b()}));
            } else if (p instanceof ab) {
                stringBuilder.append(String.format(this.f5055c.getString(C0247i.reading__tts_notification_view__prefix), new Object[]{p.mo1475b()}));
            } else {
                stringBuilder.append(p.mo1475b());
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: g */
    private void m7855g(DownloadCenterTask downloadCenterTask) {
        if (downloadCenterTask.f5029a instanceof DownloadTask) {
            this.f5057e.m2772d((DownloadTask) downloadCenterTask.f5029a);
        } else {
            this.f5056d.m7960a((C1028p) downloadCenterTask.f5029a, false);
        }
        m7835a(downloadCenterTask, true);
    }

    /* renamed from: z */
    private void m7864z() {
        m7834a(C0559f.m2476b());
        if (this.f5065m == null) {
            this.f5065m = new C1024j(this);
        }
        C0559f.m2476b().m2481a(this.f5065m);
    }

    /* renamed from: a */
    private void m7834a(C0559f c0559f) {
        if (c0559f.m2485d()) {
            m7828A();
        } else if (c0559f.m2484c()) {
            m7829B();
            m7830C();
        }
    }

    /* renamed from: A */
    private void m7828A() {
        Collection linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.m7789c()) {
                linkedList.add(downloadCenterTask);
            }
        }
        m7850d(linkedList);
    }

    /* renamed from: B */
    private void m7829B() {
        Collection linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.m7791e() && !m7856h(downloadCenterTask)) {
                linkedList.add(downloadCenterTask);
            }
        }
        m7847c(linkedList);
    }

    /* renamed from: c */
    private void m7847c(Collection<DownloadCenterTask> collection) {
        this.f5066n.sendMessageDelayed(this.f5066n.obtainMessage(1, collection), 0);
    }

    /* renamed from: C */
    private void m7830C() {
        Collection linkedList = new LinkedList();
        Iterator it = this.f5058f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.m7789c() && m7856h(downloadCenterTask)) {
                linkedList.add(downloadCenterTask);
            }
        }
        m7850d(linkedList);
    }

    /* renamed from: d */
    private void m7850d(Collection<DownloadCenterTask> collection) {
        this.f5066n.sendMessageDelayed(this.f5066n.obtainMessage(0, collection), 0);
    }

    /* renamed from: h */
    private boolean m7856h(DownloadCenterTask downloadCenterTask) {
        return downloadCenterTask.m7802p().f5036m == FlowChargingTransferChoice.Transfer || (downloadCenterTask.m7802p().f5036m == FlowChargingTransferChoice.Default && !ReaderEnv.get().getIsOnlyWifiUploadDownload());
    }
}
