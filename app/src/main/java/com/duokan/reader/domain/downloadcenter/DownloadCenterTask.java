package com.duokan.reader.domain.downloadcenter;

import com.duokan.reader.common.download.DownloadFailCode;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.domain.plugins.dict.C1113h;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadCenterTask {
    /* renamed from: b */
    static final /* synthetic */ boolean f5028b = (!DownloadCenterTask.class.desiredAssertionStatus());
    /* renamed from: a */
    protected final IDownloadTask f5029a;
    /* renamed from: c */
    private TaskResult f5030c = TaskResult.NONE;
    /* renamed from: d */
    private C1014m f5031d = null;
    /* renamed from: e */
    private boolean f5032e = false;
    /* renamed from: f */
    private boolean f5033f = false;

    public enum TaskResult {
        NONE,
        OK,
        DOWNLOAD_FAILED,
        DECODE_ERROR,
        URI_EXPIRED
    }

    private DownloadCenterTask(IDownloadTask iDownloadTask) {
        this.f5029a = iDownloadTask;
        try {
            JSONObject d = iDownloadTask.mo791d();
            if (d.length() > 0) {
                this.f5030c = TaskResult.valueOf(d.optString("task_result", TaskResult.NONE.toString()));
                this.f5032e = d.optBoolean("is_handled", false);
                this.f5033f = d.optBoolean("is_finished_notification_read", false);
                JSONObject optJSONObject = d.optJSONObject("download_info");
                if (optJSONObject != null) {
                    C1014m a = C1015a.m7815a(optJSONObject);
                    if (a != null) {
                        this.f5031d = a;
                        return;
                    }
                    a = C1027o.m7904a(optJSONObject);
                    if (a != null) {
                        this.f5031d = a;
                        return;
                    }
                    a = aa.m7819a(optJSONObject);
                    if (a != null) {
                        this.f5031d = a;
                        return;
                    }
                    a = C1113h.m8403a(optJSONObject);
                    if (a != null) {
                        this.f5031d = a;
                        return;
                    }
                    a = ab.m7823a(optJSONObject);
                    if (a != null) {
                        this.f5031d = a;
                        return;
                    }
                    throw new IllegalArgumentException();
                }
                C1014m c1015a = new C1015a();
                d = d.getJSONObject("book_info");
                c1015a.f5039b = d.optString("order_uuid");
                c1015a.f5040c = d.optString("book_uuid");
                c1015a.f5041d = d.getString("book_name");
                c1015a.f5042e = d.optString("book_revision");
                c1015a.f5043f = d.optString("author");
                c1015a.f5044g = d.optString("abstract");
                c1015a.l = d.optLong("size", 0);
                c1015a.f5045h = d.optString("cover_url");
                this.f5031d = c1015a;
            }
        } catch (JSONException e) {
            if (!f5028b) {
                throw new AssertionError();
            }
        }
    }

    /* renamed from: a */
    protected static DownloadCenterTask m7784a(IDownloadTask iDownloadTask) {
        try {
            return new DownloadCenterTask(iDownloadTask);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public boolean m7787a() {
        return this.f5029a.mo792e() == TaskStatus.PENDING;
    }

    /* renamed from: b */
    public boolean m7788b() {
        return this.f5029a.mo793f() == TaskState.UNFINISHED && this.f5029a.mo792e() == TaskStatus.STOPPED;
    }

    /* renamed from: c */
    public boolean m7789c() {
        return this.f5029a.mo793f() == TaskState.UNFINISHED && this.f5029a.mo792e() == TaskStatus.PAUSED;
    }

    /* renamed from: d */
    public boolean m7790d() {
        if (m7788b() || m7789c() || this.f5030c != TaskResult.NONE) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public boolean m7791e() {
        return m7787a() || m7790d();
    }

    /* renamed from: f */
    public boolean m7792f() {
        return this.f5030c != TaskResult.NONE;
    }

    /* renamed from: g */
    public boolean m7793g() {
        return this.f5030c == TaskResult.OK;
    }

    /* renamed from: h */
    public boolean m7794h() {
        return (this.f5030c == TaskResult.NONE || this.f5030c == TaskResult.OK) ? false : true;
    }

    /* renamed from: i */
    public String m7795i() {
        String j = this.f5029a.mo796j();
        if (j.endsWith(".tmp")) {
            return j.substring(0, j.length() - ".tmp".length());
        }
        return j;
    }

    /* renamed from: j */
    public float m7796j() {
        return this.f5029a.mo799n();
    }

    /* renamed from: k */
    public long m7797k() {
        return this.f5029a.mo797l();
    }

    /* renamed from: l */
    public long m7798l() {
        return this.f5029a.mo798m();
    }

    /* renamed from: m */
    public long m7799m() {
        return this.f5029a.mo800o();
    }

    /* renamed from: n */
    public TaskResult m7800n() {
        return this.f5030c;
    }

    /* renamed from: o */
    public DownloadFailCode m7801o() {
        return this.f5029a.mo795h();
    }

    /* renamed from: a */
    public void m7786a(TaskResult taskResult) {
        this.f5030c = taskResult;
        m7785u();
    }

    /* renamed from: p */
    public C1014m m7802p() {
        return this.f5031d;
    }

    /* renamed from: q */
    public boolean m7803q() {
        return this.f5032e;
    }

    /* renamed from: r */
    public boolean m7804r() {
        return this.f5033f;
    }

    /* renamed from: s */
    protected void m7805s() {
        this.f5032e = true;
        m7785u();
    }

    /* renamed from: t */
    protected void m7806t() {
        this.f5033f = true;
        m7785u();
    }

    /* renamed from: u */
    private void m7785u() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("task_result", this.f5030c);
            jSONObject.put("download_info", this.f5031d.m7814c());
            jSONObject.put("is_handled", this.f5032e);
            jSONObject.put("is_finished_notification_read", this.f5033f);
            this.f5029a.mo789a(jSONObject);
        } catch (Exception e) {
            if (!f5028b) {
                throw new AssertionError();
            }
        }
    }
}
