package com.duokan.reader.domain.downloadcenter;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;

import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.download.DownloadFailCode;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.common.download.d;
import com.duokan.reader.domain.micloud.ba;
import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.micloud.z;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class p implements IDownloadTask {
    static final /* synthetic */ boolean a = (!p.class.desiredAssertionStatus());
    private Context b;
    private String c;
    private String d;
    private bi e;
    private JSONObject f;
    private d g;
    private z h;
    private TaskStatus i = TaskStatus.STOPPED;
    private TaskState j = TaskState.UNFINISHED;

    public p(Context context, String str, String str2, bi biVar, JSONObject jSONObject, d dVar) {
        this.b = context;
        this.c = str;
        this.h = null;
        this.d = str2;
        this.e = biVar;
        this.f = jSONObject;
        this.g = dVar;
        this.i = TaskStatus.STOPPED;
        this.j = TaskState.UNFINISHED;
    }

    public p(Context context, z zVar, d dVar) {
        this.b = context;
        this.c = zVar.u().optString("json_tag_idownloadtask_tag");
        this.h = zVar;
        this.d = Uri.fromFile(new File(this.h.w())).toString();
        this.e = zVar.z();
        this.f = this.h.u().optJSONObject("json_tag_idownloadtask_user_value");
        if (this.f == null) {
            String optString = this.h.u().optString("json_tag_idownloadtask_user_value");
            if (optString == null) {
                this.f = new JSONObject();
            } else {
                try {
                    this.f = new JSONObject(optString);
                } catch (JSONException e) {
                    this.f = new JSONObject();
                }
            }
        }
        this.g = dVar;
        this.i = TaskStatus.STOPPED;
        this.j = TaskState.UNFINISHED;
        if (this.h.g()) {
            this.i = TaskStatus.PENDING;
            this.j = TaskState.UNFINISHED;
        } else if (this.h.h()) {
            this.i = TaskStatus.RUNNING;
            this.j = TaskState.UNFINISHED;
        } else if (this.h.k()) {
            this.i = TaskStatus.PAUSED;
            this.j = TaskState.UNFINISHED;
        } else if (this.h.j()) {
            this.i = TaskStatus.STOPPED;
            this.j = TaskState.UNFINISHED;
        } else if (this.h.m()) {
            this.i = TaskStatus.STOPPED;
            this.j = TaskState.FAILED;
        } else if (this.h.l()) {
            this.i = TaskStatus.STOPPED;
            this.j = TaskState.SUCCEEDED;
        } else if (this.h.n()) {
            this.i = TaskStatus.STOPPED;
            this.j = TaskState.UNFINISHED;
        }
    }

    public bi a() {
        return this.e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.j;	 Catch:{ all -> 0x0017 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskState.SUCCEEDED;	 Catch:{ all -> 0x0017 }
        if (r0 != r1) goto L_0x0009;
    L_0x0007:
        monitor-exit(r5);	 Catch:{ all -> 0x0017 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r5.i;	 Catch:{ all -> 0x0017 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.RUNNING;	 Catch:{ all -> 0x0017 }
        if (r0 == r1) goto L_0x0015;
    L_0x000f:
        r0 = r5.i;	 Catch:{ all -> 0x0017 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.PENDING;	 Catch:{ all -> 0x0017 }
        if (r0 != r1) goto L_0x001a;
    L_0x0015:
        monitor-exit(r5);	 Catch:{ all -> 0x0017 }
        goto L_0x0008;
    L_0x0017:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0017 }
        throw r0;
    L_0x001a:
        r0 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.PENDING;	 Catch:{ all -> 0x0017 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskState.UNFINISHED;	 Catch:{ all -> 0x0017 }
        r5.i = r0;	 Catch:{ all -> 0x0017 }
        r5.j = r1;	 Catch:{ all -> 0x0017 }
        monitor-exit(r5);	 Catch:{ all -> 0x0017 }
        r5.a(r0);
        r5.a(r1);
        r0 = r5.b;
        r1 = r5.e;
        r1 = r1.b();
        r2 = r5.e;
        r2 = r2.c();
        r0 = com.duokan.reader.domain.micloud.ba.a(r0, r1, r2);
        r1 = r0.b();
        r0 = r5.h;
        if (r0 != 0) goto L_0x0090;
    L_0x0043:
        r0 = r5.d;
        r0 = android.net.Uri.parse(r0);
        r0 = r0.getPath();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r0);
        r3 = ".micloud.temp";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = r5.e;
        r4 = 5;
        r0 = r1.a(r0, r2, r3, r4);
    L_0x0067:
        r2 = r0.u();	 Catch:{ JSONException -> 0x009a }
        r3 = "json_tag_idownloadtask_user_value";
        r4 = r5.f;	 Catch:{ JSONException -> 0x009a }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x009a }
        r2 = r0.u();	 Catch:{ JSONException -> 0x009a }
        r3 = "json_tag_idownloadtask_tag";
        r4 = r5.c;	 Catch:{ JSONException -> 0x009a }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x009a }
    L_0x007d:
        r1.a(r0);
        monitor-enter(r5);
        r5.h = r0;	 Catch:{ all -> 0x0097 }
        monitor-exit(r5);	 Catch:{ all -> 0x0097 }
        r0 = r5.h;
        r2 = new com.duokan.reader.domain.downloadcenter.q;
        r2.<init>(r5, r1);
        r1.a(r0, r2);
        goto L_0x0008;
    L_0x0090:
        r0 = r1.c(r0);
        r0 = (com.duokan.reader.domain.micloud.z) r0;
        goto L_0x0067;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0097 }
        throw r0;
    L_0x009a:
        r2 = move-exception;
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.downloadcenter.p.c():void");
    }

    public void a(boolean z) {
        ba a = ba.a(this.b, this.e.b(), this.e.c());
        c cVar = this.h;
        if (cVar != null) {
            a.b().a(cVar, z);
        }
    }

    public void i() {
        ba a = ba.a(this.b, this.e.b(), this.e.c());
        c cVar = this.h;
        if (cVar != null) {
            a.b().d(cVar);
        }
    }

    public JSONObject d() {
        return this.f;
    }

    public void a(JSONObject jSONObject) {
        try {
            c cVar = this.h;
            if (cVar != null) {
                this.f = jSONObject;
                cVar.u().put("json_tag_idownloadtask_user_value", jSONObject);
                ba.a(this.b, this.e.b(), this.e.c()).b().a(cVar);
            }
        } catch (JSONException e) {
        }
    }

    public TaskStatus e() {
        return this.i;
    }

    public TaskState f() {
        return this.j;
    }

    public String j() {
        return this.d;
    }

    public float n() {
        z zVar = this.h;
        if (zVar == null) {
            return 0.0f;
        }
        Pair i = zVar.i();
        if (((Long) i.second).longValue() == 0) {
            return 0.0f;
        }
        return (((float) ((Long) i.first).longValue()) / ((float) ((Long) i.second).longValue())) * 100.0f;
    }

    public long l() {
        z zVar = this.h;
        if (zVar == null || !zVar.h() || zVar.E() == 0 || zVar.F() == 0) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - zVar.E();
        if (currentTimeMillis != 0) {
            return (zVar.F() * 1000) / currentTimeMillis;
        }
        return 0;
    }

    public long m() {
        return this.e.j();
    }

    public long g() {
        z zVar = this.h;
        if (zVar == null) {
            return 0;
        }
        return zVar.t();
    }

    public String b() {
        return this.c;
    }

    public DownloadFailCode h() {
        return DownloadFailCode.NONE;
    }

    protected void k() {
        if (a || this.g != null) {
            this.g.a(this);
            return;
        }
        throw new AssertionError();
    }

    protected void a(TaskStatus taskStatus) {
        if (a || this.g != null) {
            this.g.a((IDownloadTask) this, taskStatus);
            return;
        }
        throw new AssertionError();
    }

    protected void a(TaskState taskState) {
        if (a || this.g != null) {
            this.g.a((IDownloadTask) this, taskState);
            return;
        }
        throw new AssertionError();
    }
}
