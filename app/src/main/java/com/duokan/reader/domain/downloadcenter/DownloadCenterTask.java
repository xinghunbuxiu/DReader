package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.download.DownloadFailCode;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.domain.plugins.dict.h;

import org.json.JSONException;
import org.json.JSONObject;

public class DownloadCenterTask {
    static final boolean b = (!DownloadCenterTask.class.desiredAssertionStatus());
    protected final IDownloadTask a;
    private TaskResult c = TaskResult.NONE;
    private m d = null;
    private boolean e = false;
    private boolean f = false;

    public enum TaskResult {
        NONE,
        OK,
        DOWNLOAD_FAILED,
        DECODE_ERROR,
        URI_EXPIRED
    }

    private DownloadCenterTask(IDownloadTask iDownloadTask) {
        this.a = iDownloadTask;
        try {
            JSONObject d = iDownloadTask.d();
            if (d.length() > 0) {
                this.c = TaskResult.valueOf(d.optString("task_result", TaskResult.NONE.toString()));
                this.e = d.optBoolean("is_handled", false);
                this.f = d.optBoolean("is_finished_notification_read", false);
                JSONObject optJSONObject = d.optJSONObject("download_info");
                if (optJSONObject != null) {
                    m a = a.a(optJSONObject);
                    if (a != null) {
                        this.d = a;
                        return;
                    }
                    a = o.a(optJSONObject);
                    if (a != null) {
                        this.d = a;
                        return;
                    }
                    a = v.a(optJSONObject);
                    if (a != null) {
                        this.d = a;
                        return;
                    }
                    a = h.a(optJSONObject);
                    if (a != null) {
                        this.d = a;
                        return;
                    }
                    throw new IllegalArgumentException();
                }
                m aVar = new a();
                d = d.getJSONObject("book_info");
                aVar.b = d.optString("order_uuid");
                aVar.c = d.optString("book_uuid");
                aVar.d = d.getString("book_name");
                aVar.e = d.optString("book_revision");
                aVar.f = d.optString("author");
                aVar.g = d.optString("abstract");
                aVar.l = d.optLong("size", 0);
                aVar.h = d.optString("cover_url");
                this.d = aVar;
            }
        } catch (JSONException e) {
            if (!b) {
                throw new AssertionError();
            }
        }
    }

    protected static DownloadCenterTask a(IDownloadTask iDownloadTask) {
        try {
            return new DownloadCenterTask(iDownloadTask);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean a() {
        return this.a.e() == TaskStatus.PENDING;
    }

    public boolean b() {
        return this.a.f() == TaskState.UNFINISHED && this.a.e() == TaskStatus.STOPPED;
    }

    public boolean c() {
        return this.a.f() == TaskState.UNFINISHED && this.a.e() == TaskStatus.PAUSED;
    }

    public boolean d() {
        if (b() || c() || this.c != TaskResult.NONE) {
            return false;
        }
        return true;
    }

    public boolean e() {
        return a() || d();
    }

    public boolean f() {
        return this.c != TaskResult.NONE;
    }

    public boolean g() {
        return this.c == TaskResult.OK;
    }

    public boolean h() {
        return (this.c == TaskResult.NONE || this.c == TaskResult.OK) ? false : true;
    }

    public String i() {
        String j = this.a.j();
        if (j.endsWith(".tmp")) {
            return j.substring(0, j.length() - ".tmp".length());
        }
        return j;
    }

    public float j() {
        return this.a.n();
    }

    public long k() {
        return this.a.l();
    }

    public long l() {
        return this.a.m();
    }

    public TaskResult m() {
        return this.c;
    }

    public DownloadFailCode n() {
        return this.a.h();
    }

    public void a(TaskResult taskResult) {
        this.c = taskResult;
        t();
    }

    public m o() {
        return this.d;
    }

    public boolean p() {
        return this.e;
    }

    public boolean q() {
        return this.f;
    }

    protected void r() {
        this.e = true;
        t();
    }

    protected void s() {
        this.f = true;
        t();
    }

    private void t() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("task_result", this.c);
            jSONObject.put("download_info", this.d.c());
            jSONObject.put("is_handled", this.e);
            jSONObject.put("is_finished_notification_read", this.f);
            this.a.a(jSONObject);
        } catch (Exception e) {
            if (!b) {
                throw new AssertionError();
            }
        }
    }
}
