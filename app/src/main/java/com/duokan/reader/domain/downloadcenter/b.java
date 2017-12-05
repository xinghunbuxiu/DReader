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

import com.duokan.b.i;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkNotificationManager;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.download.DownloadTask;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.common.download.d;
import com.duokan.reader.common.download.e;
import com.duokan.reader.common.download.k;
import com.duokan.reader.domain.b.q;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask.TaskResult;
import com.duokan.reader.domain.statistics.dailystats.a;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class b implements ah, d {
    static final /* synthetic */ boolean a;
    private static final ai b = new ai();
    private final Context c;
    private final r d;
    private final e e;
    private final LinkedList f = new LinkedList();
    private final CopyOnWriteArrayList g = new CopyOnWriteArrayList();
    private final DkNotificationManager h;
    private Runnable i = null;
    private Intent j = null;
    private Intent k = null;
    private Intent l = null;
    private classc.IConnectChanged m;
    @SuppressLint({"HandlerLeak"})
    private Handler n = new c(this, Looper.getMainLooper());

    static {
        boolean z;
        if (b.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        a = z;
    }

    protected b(Context context, r rVar, e eVar, DkNotificationManager dkNotificationManager) {
        if (a || eVar != null) {
            this.c = context;
            this.d = rVar;
            this.e = eVar;
            this.h = dkNotificationManager;
            this.e.a((d) this, null);
            this.d.a((d) this, null);
            r();
            s();
            u();
            v();
            DkApp.get().runPreReady(new d(this));
            return;
        }
        throw new AssertionError();
    }

    public DownloadCenterTask[] a() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.f()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    public DownloadCenterTask[] b() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.d()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    public DownloadCenterTask[] c() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.g()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    public DownloadCenterTask[] d() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.g() && !downloadCenterTask.q()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    public DownloadCenterTask[] e() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.h()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    public DownloadCenterTask[] f() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.h() && !downloadCenterTask.q()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    public DownloadCenterTask[] g() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.p() && downloadCenterTask.q()) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    public DownloadCenterTask[] h() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.p() && downloadCenterTask.g() && downloadCenterTask.o().a() == DownloadType.FONT) {
                linkedList.addLast(downloadCenterTask);
                q c = com.duokan.reader.domain.b.b.b().c();
                if (c.a == c.c && ReaderEnv.get().getPrefBoolean(PrivatePref.READING, "FONT_ALERT", false)) {
                    ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "FONT_ALERT", true);
                    ReaderEnv.get().commitPrefs();
                    a.d().d("s");
                } else if (c.a != c.c) {
                    ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "FONT_ALERT", false);
                    ReaderEnv.get().commitPrefs();
                }
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    public DownloadCenterTask[] i() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.p() && downloadCenterTask.g() && downloadCenterTask.o().a() == DownloadType.DICT) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    public DownloadCenterTask[] j() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.p() && (downloadCenterTask.o() instanceof o)) {
                linkedList.addLast(downloadCenterTask);
            }
        }
        return (DownloadCenterTask[]) linkedList.toArray(new DownloadCenterTask[0]);
    }

    public void a(DownloadCenterTask[] downloadCenterTaskArr, boolean z) {
        Arrays.sort(downloadCenterTaskArr, new e(this, z));
    }

    public Intent k() {
        return this.j;
    }

    public void a(Intent intent) {
        this.j = intent;
        u();
    }

    public Intent l() {
        return this.k;
    }

    public void b(Intent intent) {
        this.k = intent;
        v();
    }

    public Intent m() {
        return this.l;
    }

    public void c(Intent intent) {
        this.l = intent;
        w();
    }

    public static void a(Context context, r rVar, e eVar, DkNotificationManager dkNotificationManager) {
        b.a(new b(context, rVar, eVar, dkNotificationManager));
    }

    public static b n() {
        return (b) b.a();
    }

    public DownloadCenterTask a(l lVar) {
        if (a || lVar != null) {
            DownloadCenterTask a;
            if (!(lVar.e instanceof a) || ((a) lVar.e).i == null) {
                IDownloadTask a2 = this.e.a(b(lVar));
                a = DownloadCenterTask.a(a2);
                if (a != null) {
                    this.f.addFirst(a);
                    this.e.b(a2);
                }
            } else {
                a aVar = (a) lVar.e;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("download_info", aVar.c());
                } catch (Exception e) {
                    if (!a) {
                        throw new AssertionError();
                    }
                }
                p a3 = this.d.a("3D7E8CAD-6534-415F-9484-F69F92B18637", lVar.c, aVar.i.a(), jSONObject);
                a = DownloadCenterTask.a((IDownloadTask) a3);
                if (a != null) {
                    this.f.addFirst(a);
                    this.d.a(a3);
                }
            }
            a(a, true);
            if (f.b().c() && !h(a)) {
                g(a);
            }
            return a;
        }
        throw new AssertionError();
    }

    public void a(DownloadCenterTask downloadCenterTask) {
        if (a || downloadCenterTask != null) {
            c(downloadCenterTask);
            if (!downloadCenterTask.g()) {
                new File(Uri.parse(downloadCenterTask.i() + ".tmp").getPath()).delete();
            }
            this.f.remove(downloadCenterTask);
            if (downloadCenterTask.a instanceof DownloadTask) {
                this.e.a((DownloadTask) downloadCenterTask.a);
            } else {
                this.d.b((p) downloadCenterTask.a);
            }
            a(downloadCenterTask, true);
            return;
        }
        throw new AssertionError();
    }

    public void a(DownloadCenterTask[] downloadCenterTaskArr) {
        if (a || downloadCenterTaskArr != null) {
            for (DownloadCenterTask a : downloadCenterTaskArr) {
                a(a);
            }
            return;
        }
        throw new AssertionError();
    }

    public void o() {
        a(g());
    }

    public void b(DownloadCenterTask downloadCenterTask) {
        if (!a && downloadCenterTask == null) {
            throw new AssertionError();
        } else if (!downloadCenterTask.g() && downloadCenterTask.m() != TaskResult.DECODE_ERROR && downloadCenterTask.m() != TaskResult.URI_EXPIRED && !downloadCenterTask.a() && !downloadCenterTask.d()) {
            downloadCenterTask.a(TaskResult.NONE);
            if (downloadCenterTask.a instanceof DownloadTask) {
                this.e.b((DownloadTask) downloadCenterTask.a);
            } else {
                this.d.a((p) downloadCenterTask.a);
            }
            a(downloadCenterTask, true);
            if (f.b().c() && !h(downloadCenterTask)) {
                g(downloadCenterTask);
            }
        }
    }

    public void c(DownloadCenterTask downloadCenterTask) {
        if (downloadCenterTask.a instanceof DownloadTask) {
            this.e.c((DownloadTask) downloadCenterTask.a);
        } else {
            this.d.a((p) downloadCenterTask.a, true);
        }
        a(downloadCenterTask, true);
    }

    public void d(DownloadCenterTask downloadCenterTask) {
        if (!a && downloadCenterTask == null) {
            throw new AssertionError();
        } else if (!downloadCenterTask.p()) {
            downloadCenterTask.r();
            a(downloadCenterTask, true);
        }
    }

    public void b(DownloadCenterTask[] downloadCenterTaskArr) {
        if (a || downloadCenterTaskArr != null) {
            for (DownloadCenterTask d : downloadCenterTaskArr) {
                d(d);
            }
            return;
        }
        throw new AssertionError();
    }

    public void p() {
        for (DownloadCenterTask s : c()) {
            s.s();
        }
        u();
    }

    public void q() {
        for (DownloadCenterTask s : e()) {
            s.s();
        }
        v();
    }

    public void a(k kVar) {
        if (a || kVar != null) {
            this.g.add(kVar);
            return;
        }
        throw new AssertionError();
    }

    public void b(k kVar) {
        if (a || kVar != null) {
            this.g.remove(kVar);
            return;
        }
        throw new AssertionError();
    }

    public DownloadCenterTask a(String str) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.p() && (downloadCenterTask.o() instanceof a) && ((a) downloadCenterTask.o()).c.equals(str)) {
                return downloadCenterTask;
            }
        }
        return null;
    }

    public DownloadCenterTask b(String str) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (!downloadCenterTask.p() && downloadCenterTask.i().equals(str)) {
                return downloadCenterTask;
            }
        }
        return null;
    }

    public void a(IDownloadTask iDownloadTask) {
        if (iDownloadTask.b().equals("3D7E8CAD-6534-415F-9484-F69F92B18637")) {
            TaskHandler.a(new classc.ConnectivityReceiver(this));
        }
    }

    public void a(IDownloadTask iDownloadTask, TaskStatus taskStatus) {
        if (iDownloadTask.b().equals("3D7E8CAD-6534-415F-9484-F69F92B18637")) {
            TaskHandler.a(new classc.IConnectChanged(this, iDownloadTask));
        }
    }

    public void a(IDownloadTask iDownloadTask, TaskState taskState) {
        if (iDownloadTask.b().equals("3D7E8CAD-6534-415F-9484-F69F92B18637")) {
            TaskResult b;
            if (taskState != TaskState.UNFINISHED) {
                b = b(iDownloadTask, taskState);
            } else {
                b = TaskResult.NONE;
            }
            TaskHandler.postTask(new h(this, iDownloadTask, b));
        }
    }

    private TaskResult b(IDownloadTask iDownloadTask, TaskState taskState) {
        try {
            if ((taskState == TaskState.SUCCEEDED ? 1 : null) == null) {
                return TaskResult.DOWNLOAD_FAILED;
            }
            if (!(iDownloadTask instanceof DownloadTask)) {
                return TaskResult.OK;
            }
            DownloadTask downloadTask = (DownloadTask) iDownloadTask;
            if (downloadTask.p().equals("text/html")) {
                return TaskResult.URI_EXPIRED;
            }
            DownloadCenterTask downloadCenterTask;
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                downloadCenterTask = (DownloadCenterTask) it.next();
                if (downloadCenterTask.a == iDownloadTask) {
                    break;
                }
            }
            downloadCenterTask = null;
            return downloadCenterTask.o().a() == DownloadType.PLUGIN ? b(downloadTask) ? TaskResult.OK : TaskResult.DECODE_ERROR : a(downloadTask) ? TaskResult.OK : TaskResult.DECODE_ERROR;
        } catch (Exception e) {
            return TaskResult.DOWNLOAD_FAILED;
        } catch (Error e2) {
            return TaskResult.DOWNLOAD_FAILED;
        }
    }

    private boolean a(DownloadTask downloadTask) {
        String p = downloadTask.p();
        if (a || p != null) {
            boolean renameTo;
            String path = Uri.parse(downloadTask.j()).getPath();
            String substring = path.substring(0, path.length() - ".tmp".length());
            File file = new File(path);
            File file2 = new File(substring);
            if (p.equals(HTTP.PLAIN_TEXT_TYPE)) {
                renameTo = file.renameTo(file2);
            } else if (p.equals("application/epub+zip")) {
                renameTo = file.renameTo(file2);
            } else if (p.equals("application/zip") || p.equals("application/MyContextWrapper-gzip") || p.equals("application/MyContextWrapper-winzip") || p.equals("applicatoin/MyContextWrapper-zip") || p.equals("application/MyContextWrapper-zip-compressed")) {
                DkPublic.unzip(file, file.getParentFile());
                renameTo = file2.exists();
                if (renameTo) {
                    file.delete();
                }
            } else {
                renameTo = file.renameTo(file2);
            }
            if (renameTo) {
                downloadTask.a(Uri.parse(substring).toString());
            }
            return renameTo;
        }
        throw new AssertionError();
    }

    private boolean b(DownloadTask downloadTask) {
        String p = downloadTask.p();
        if (a || p != null) {
            File file = new File(Uri.parse(downloadTask.j()).getPath());
            boolean unzip = DkPublic.unzip(file, file.getParentFile());
            file.delete();
            return unzip;
        }
        throw new AssertionError();
    }

    private k b(l lVar) {
        if (!a && lVar.b == null) {
            throw new AssertionError();
        } else if (!a && lVar.c == null) {
            throw new AssertionError();
        } else if (!a && lVar.a == null) {
            throw new AssertionError();
        } else if (a || lVar.e != null) {
            k kVar = new k();
            kVar.a = lVar.a;
            kVar.b = lVar.b;
            kVar.c = lVar.c + ".tmp";
            kVar.d = lVar.d;
            kVar.e = "3D7E8CAD-6534-415F-9484-F69F92B18637";
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("download_info", lVar.e.c());
            } catch (Exception e) {
                if (!a) {
                    throw new AssertionError();
                }
            }
            kVar.f = jSONObject.toString();
            return kVar;
        } else {
            throw new AssertionError();
        }
    }

    private void r() {
        int i = 0;
        for (IDownloadTask a : this.e.a("3D7E8CAD-6534-415F-9484-F69F92B18637")) {
            DownloadCenterTask a2 = DownloadCenterTask.a(a);
            if (a2 != null) {
                this.f.addFirst(a2);
            }
        }
        p[] a3 = this.d.a("3D7E8CAD-6534-415F-9484-F69F92B18637");
        int length = a3.length;
        while (i < length) {
            DownloadCenterTask a4 = DownloadCenterTask.a(a3[i]);
            if (a4 != null) {
                this.f.addFirst(a4);
            }
            i++;
        }
    }

    private void s() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.a.b().equals("3D7E8CAD-6534-415F-9484-F69F92B18637")) {
                if (!downloadCenterTask.h() && downloadCenterTask.a.f() == TaskState.FAILED) {
                    downloadCenterTask.a(TaskResult.DOWNLOAD_FAILED);
                } else if (!downloadCenterTask.f() && downloadCenterTask.a.f() == TaskState.SUCCEEDED) {
                    downloadCenterTask.a(b(downloadCenterTask.a, TaskState.SUCCEEDED));
                }
            }
        }
    }

    private void t() {
        if (this.i == null) {
            this.i = new i(this);
            TaskHandler.PostTask(this.i);
        }
    }

    private void e(DownloadCenterTask downloadCenterTask) {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a(downloadCenterTask);
        }
        w();
    }

    private void f(DownloadCenterTask downloadCenterTask) {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((k) it.next()).b(downloadCenterTask);
        }
        u();
        v();
        w();
    }

    private void a(DownloadCenterTask downloadCenterTask, boolean z) {
    }

    private void u() {
        if (this.j != null) {
            DownloadCenterTask[] d = d();
            if (d.length < 1) {
                this.h.cancel("3D7E8CAD-6534-415F-9484-F69F92B18637", 1);
                return;
            }
            a(d, false);
            CharSequence c = c(d);
            CharSequence format = String.format(this.c.getString(i.personal__succeeded_download_tasks_view__ticker), new Object[]{c});
            CharSequence string = this.c.getString(i.personal__succeeded_download_tasks_view__detail);
            Builder builder = new Builder(this.c);
            builder.setAutoCancel(true);
            builder.setSmallIcon(com.duokan.b.e.personal__succeeded_download_tasks_view__icon);
            builder.setWhen(System.currentTimeMillis());
            builder.setTicker(format);
            builder.setContentTitle(c);
            builder.setContentText(string);
            builder.setContentIntent(PendingIntent.getService(this.c, 0, new Intent(this.c, DownloadNotificationService.class).setAction("com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_SUCCEEDED"), 134217728));
            builder.setDeleteIntent(PendingIntent.getService(this.c, 0, new Intent(this.c, DownloadNotificationService.class).setAction("com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_DELETE_SUCCEEDED"), 134217728));
            this.h.notify("3D7E8CAD-6534-415F-9484-F69F92B18637", 1, builder.build());
        }
    }

    private void v() {
        if (this.k != null) {
            DownloadCenterTask[] f = f();
            if (f.length < 1) {
                this.h.cancel("3D7E8CAD-6534-415F-9484-F69F92B18637", 2);
                return;
            }
            a(f, false);
            CharSequence c = c(f);
            CharSequence format = String.format(this.c.getString(i.personal__failed_download_tasks_view__ticker), new Object[]{c});
            CharSequence string = this.c.getString(i.personal__failed_download_tasks_view__detail);
            Builder builder = new Builder(this.c);
            builder.setAutoCancel(true);
            builder.setSmallIcon(com.duokan.b.e.personal__failed_download_tasks_view__icon);
            builder.setWhen(System.currentTimeMillis());
            builder.setTicker(format);
            builder.setContentTitle(c);
            builder.setContentText(string);
            builder.setDeleteIntent(PendingIntent.getService(this.c, 0, new Intent(this.c, DownloadNotificationService.class).setAction("com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_DELETE_FAILED"), 134217728));
            builder.setContentIntent(PendingIntent.getService(this.c, 0, new Intent(this.c, DownloadNotificationService.class).setAction("com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_FAILED"), 134217728));
            this.h.notify("3D7E8CAD-6534-415F-9484-F69F92B18637", 2, builder.build());
        }
    }

    private void w() {
        if (this.l != null) {
            DownloadCenterTask[] b = b();
            if (b.length < 1) {
                this.h.cancel("3D7E8CAD-6534-415F-9484-F69F92B18637", 3);
                return;
            }
            a(b, false);
            long j = 0;
            DownloadCenterTask[] a = a();
            float f = 0.0f;
            for (DownloadCenterTask downloadCenterTask : a) {
                f += (1.0f / ((float) a.length)) * downloadCenterTask.j();
                j += downloadCenterTask.k();
            }
            float max = Math.max(0.0f, Math.min(f, 100.0f));
            CharSequence format = String.format(this.c.getString(i.personal__running_download_tasks_view__ticker), new Object[]{c(b)});
            CharSequence format2 = String.format(this.c.getString(i.personal__running_download_tasks_view__detail), new Object[]{DkPublic.formatBytes(j), Float.valueOf(max)});
            Builder builder = new Builder(this.c);
            builder.setSmallIcon(com.duokan.b.e.personal__running_download_tasks_view__icon);
            builder.setWhen(System.currentTimeMillis());
            builder.setTicker(format);
            builder.setContentTitle(r4);
            builder.setContentText(format2);
            builder.setContentIntent(PendingIntent.getService(this.c, 0, new Intent(this.c, DownloadNotificationService.class).setAction("com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_RUNNING"), 134217728));
            Notification build = builder.build();
            build.flags |= 32;
            this.h.notify("3D7E8CAD-6534-415F-9484-F69F92B18637", 3, build);
        }
    }

    private String c(DownloadCenterTask[] downloadCenterTaskArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < downloadCenterTaskArr.length; i++) {
            m o = downloadCenterTaskArr[i].o();
            if (i > 0) {
                stringBuilder.append(this.c.getResources().getString(i.general__shared__comma));
            }
            if (o instanceof a) {
                stringBuilder.append(String.format(this.c.getResources().getString(i.general__shared__book_title_marks), new Object[]{o.b()}));
            } else {
                stringBuilder.append(o.b());
            }
        }
        return stringBuilder.toString();
    }

    private void g(DownloadCenterTask downloadCenterTask) {
        if (downloadCenterTask.a instanceof DownloadTask) {
            this.e.d((DownloadTask) downloadCenterTask.a);
        } else {
            this.d.a((p) downloadCenterTask.a, false);
        }
        a(downloadCenterTask, true);
    }

    private void x() {
        a(f.b());
        if (this.m == null) {
            this.m = new j(this);
        }
        f.b().a(this.m);
    }

    private void a(classc.ConnectivityReceiver connectivity) {
        if (connectivity.d()) {
            y();
        } else if (connectivity.c()) {
            z();
            A();
        }
    }

    private void y() {
        Collection linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.c()) {
                linkedList.add(downloadCenterTask);
            }
        }
        b(linkedList);
    }

    private void z() {
        Collection linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.e() && !h(downloadCenterTask)) {
                linkedList.add(downloadCenterTask);
            }
        }
        a(linkedList);
    }

    private void a(Collection collection) {
        this.n.sendMessageDelayed(this.n.obtainMessage(1, collection), 0);
    }

    private void A() {
        Collection linkedList = new LinkedList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.c() && h(downloadCenterTask)) {
                linkedList.add(downloadCenterTask);
            }
        }
        b(linkedList);
    }

    private void b(Collection collection) {
        this.n.sendMessageDelayed(this.n.obtainMessage(0, collection), 0);
    }

    private boolean h(DownloadCenterTask downloadCenterTask) {
        return downloadCenterTask.o().m == FlowChargingTransferChoice.Transfer || (downloadCenterTask.o().m == FlowChargingTransferChoice.Default && !ReaderEnv.get().getIsOnlyWifiUploadDownload());
    }
}
