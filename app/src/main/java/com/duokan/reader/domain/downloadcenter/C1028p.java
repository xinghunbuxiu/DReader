package com.duokan.reader.domain.downloadcenter;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.download.C0594d;
import com.duokan.reader.common.download.DownloadFailCode;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.domain.micloud.C1084z;
import com.duokan.reader.domain.micloud.ba;
import com.duokan.reader.domain.micloud.bi;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.downloadcenter.p */
public class C1028p implements IDownloadTask {
    /* renamed from: a */
    static final /* synthetic */ boolean f5089a = (!C1028p.class.desiredAssertionStatus());
    /* renamed from: b */
    private Context f5090b;
    /* renamed from: c */
    private String f5091c;
    /* renamed from: d */
    private String f5092d;
    /* renamed from: e */
    private bi f5093e;
    /* renamed from: f */
    private JSONObject f5094f;
    /* renamed from: g */
    private C0594d f5095g;
    /* renamed from: h */
    private C1084z f5096h;
    /* renamed from: i */
    private TaskStatus f5097i = TaskStatus.STOPPED;
    /* renamed from: j */
    private TaskState f5098j = TaskState.UNFINISHED;

    public C1028p(Context context, String str, String str2, bi biVar, JSONObject jSONObject, C0594d c0594d) {
        this.f5090b = context;
        this.f5091c = str;
        this.f5096h = null;
        this.f5092d = str2;
        this.f5093e = biVar;
        this.f5094f = jSONObject;
        this.f5095g = c0594d;
        this.f5097i = TaskStatus.STOPPED;
        this.f5098j = TaskState.UNFINISHED;
    }

    public C1028p(Context context, C1084z c1084z, C0594d c0594d) {
        this.f5090b = context;
        this.f5091c = c1084z.m2306u().optString("json_tag_idownloadtask_tag");
        this.f5096h = c1084z;
        this.f5092d = Uri.fromFile(new File(this.f5096h.m8326w())).toString();
        this.f5093e = c1084z.m8329z();
        this.f5094f = this.f5096h.m2306u().optJSONObject("json_tag_idownloadtask_user_value");
        if (this.f5094f == null) {
            String optString = this.f5096h.m2306u().optString("json_tag_idownloadtask_user_value");
            if (optString == null) {
                this.f5094f = new JSONObject();
            } else {
                try {
                    this.f5094f = new JSONObject(optString);
                } catch (JSONException e) {
                    this.f5094f = new JSONObject();
                }
            }
        }
        this.f5095g = c0594d;
        this.f5097i = TaskStatus.STOPPED;
        this.f5098j = TaskState.UNFINISHED;
        if (this.f5096h.m2292g()) {
            this.f5097i = TaskStatus.PENDING;
            this.f5098j = TaskState.UNFINISHED;
        } else if (this.f5096h.m2293h()) {
            this.f5097i = TaskStatus.RUNNING;
            this.f5098j = TaskState.UNFINISHED;
        } else if (this.f5096h.m2296k()) {
            this.f5097i = TaskStatus.PAUSED;
            this.f5098j = TaskState.UNFINISHED;
        } else if (this.f5096h.m2295j()) {
            this.f5097i = TaskStatus.STOPPED;
            this.f5098j = TaskState.UNFINISHED;
        } else if (this.f5096h.m2298m()) {
            this.f5097i = TaskStatus.STOPPED;
            this.f5098j = TaskState.FAILED;
        } else if (this.f5096h.m2297l()) {
            this.f5097i = TaskStatus.STOPPED;
            this.f5098j = TaskState.SUCCEEDED;
        } else if (this.f5096h.m2299n()) {
            this.f5097i = TaskStatus.STOPPED;
            this.f5098j = TaskState.UNFINISHED;
        }
    }

    /* renamed from: a */
    public bi m7911a() {
        return this.f5093e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public void m7917c() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f5098j;	 Catch:{ all -> 0x0017 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskState.SUCCEEDED;	 Catch:{ all -> 0x0017 }
        if (r0 != r1) goto L_0x0009;
    L_0x0007:
        monitor-exit(r5);	 Catch:{ all -> 0x0017 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r5.f5097i;	 Catch:{ all -> 0x0017 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.RUNNING;	 Catch:{ all -> 0x0017 }
        if (r0 == r1) goto L_0x0015;
    L_0x000f:
        r0 = r5.f5097i;	 Catch:{ all -> 0x0017 }
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
        r5.f5097i = r0;	 Catch:{ all -> 0x0017 }
        r5.f5098j = r1;	 Catch:{ all -> 0x0017 }
        monitor-exit(r5);	 Catch:{ all -> 0x0017 }
        r5.m7913a(r0);
        r5.m7912a(r1);
        r0 = r5.f5090b;
        r1 = r5.f5093e;
        r1 = r1.m8152b();
        r2 = r5.f5093e;
        r2 = r2.m8153c();
        r0 = com.duokan.reader.domain.micloud.ba.m8105a(r0, r1, r2);
        r1 = r0.m8114b();
        r0 = r5.f5096h;
        if (r0 != 0) goto L_0x0090;
    L_0x0043:
        r0 = r5.f5092d;
        r0 = android.net.Uri.parse(r0);
        r0 = r0.getPath();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r0);
        r3 = ".micloud.temp";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = r5.f5093e;
        r4 = 5;
        r0 = r1.m8044a(r0, r2, r3, r4);
    L_0x0067:
        r2 = r0.m2306u();	 Catch:{ JSONException -> 0x009a }
        r3 = "json_tag_idownloadtask_user_value";
        r4 = r5.f5094f;	 Catch:{ JSONException -> 0x009a }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x009a }
        r2 = r0.m2306u();	 Catch:{ JSONException -> 0x009a }
        r3 = "json_tag_idownloadtask_tag";
        r4 = r5.f5091c;	 Catch:{ JSONException -> 0x009a }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x009a }
    L_0x007d:
        r1.m2358a(r0);
        monitor-enter(r5);
        r5.f5096h = r0;	 Catch:{ all -> 0x0097 }
        monitor-exit(r5);	 Catch:{ all -> 0x0097 }
        r0 = r5.f5096h;
        r2 = new com.duokan.reader.domain.downloadcenter.q;
        r2.<init>(r5, r1);
        r1.m2359a(r0, r2);
        goto L_0x0008;
    L_0x0090:
        r0 = r1.m2367c(r0);
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;
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

    /* renamed from: a */
    public void m7915a(boolean z) {
        ba a = ba.m8105a(this.f5090b, this.f5093e.m8152b(), this.f5093e.m8153c());
        C0523c c0523c = this.f5096h;
        if (c0523c != null) {
            a.m8114b().m2360a(c0523c, z);
        }
    }

    /* renamed from: i */
    public void m7923i() {
        ba a = ba.m8105a(this.f5090b, this.f5093e.m8152b(), this.f5093e.m8153c());
        C0523c c0523c = this.f5096h;
        if (c0523c != null) {
            a.m8114b().m2370d(c0523c);
        }
    }

    /* renamed from: d */
    public JSONObject mo791d() {
        return this.f5094f;
    }

    /* renamed from: a */
    public void mo789a(JSONObject jSONObject) {
        try {
            C0523c c0523c = this.f5096h;
            if (c0523c != null) {
                this.f5094f = jSONObject;
                c0523c.m2306u().put("json_tag_idownloadtask_user_value", jSONObject);
                ba.m8105a(this.f5090b, this.f5093e.m8152b(), this.f5093e.m8153c()).m8114b().m2358a(c0523c);
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: e */
    public TaskStatus mo792e() {
        return this.f5097i;
    }

    /* renamed from: f */
    public TaskState mo793f() {
        return this.f5098j;
    }

    /* renamed from: j */
    public String mo796j() {
        return this.f5092d;
    }

    /* renamed from: n */
    public float mo799n() {
        C1084z c1084z = this.f5096h;
        if (c1084z == null) {
            return 0.0f;
        }
        Pair i = c1084z.m2294i();
        if (((Long) i.second).longValue() == 0) {
            return 0.0f;
        }
        return (((float) ((Long) i.first).longValue()) / ((float) ((Long) i.second).longValue())) * 100.0f;
    }

    /* renamed from: l */
    public long mo797l() {
        C1084z c1084z = this.f5096h;
        if (c1084z == null || !c1084z.m2293h() || c1084z.m8318E() == 0 || c1084z.m8319F() == 0) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - c1084z.m8318E();
        if (currentTimeMillis != 0) {
            return (c1084z.m8319F() * 1000) / currentTimeMillis;
        }
        return 0;
    }

    /* renamed from: m */
    public long mo798m() {
        return this.f5093e.m8160j();
    }

    /* renamed from: o */
    public long mo800o() {
        C1084z c1084z = this.f5096h;
        if (c1084z == null) {
            return 0;
        }
        return c1084z.m8315B();
    }

    /* renamed from: g */
    public long mo794g() {
        C1084z c1084z = this.f5096h;
        if (c1084z == null) {
            return 0;
        }
        return c1084z.m2305t();
    }

    /* renamed from: b */
    public String mo790b() {
        return this.f5091c;
    }

    /* renamed from: h */
    public DownloadFailCode mo795h() {
        return DownloadFailCode.NONE;
    }

    /* renamed from: k */
    protected void m7925k() {
        if (f5089a || this.f5095g != null) {
            this.f5095g.mo1471a(this);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    protected void m7913a(TaskStatus taskStatus) {
        if (f5089a || this.f5095g != null) {
            this.f5095g.mo1473a((IDownloadTask) this, taskStatus);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    protected void m7912a(TaskState taskState) {
        if (f5089a || this.f5095g != null) {
            this.f5095g.mo1472a((IDownloadTask) this, taskState);
            return;
        }
        throw new AssertionError();
    }
}
