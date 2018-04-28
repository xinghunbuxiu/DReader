package com.duokan.reader.common.download;

import org.json.JSONObject;

public interface IDownloadTask {

    public enum TaskState {
        SUCCEEDED,
        FAILED,
        UNFINISHED
    }

    public enum TaskStatus {
        RUNNING,
        PENDING,
        PAUSED,
        STOPPED
    }

    /* renamed from: a */
    void mo789a(JSONObject jSONObject);

    /* renamed from: b */
    String mo790b();

    /* renamed from: d */
    JSONObject mo791d();

    /* renamed from: e */
    TaskStatus mo792e();

    /* renamed from: f */
    TaskState mo793f();

    /* renamed from: g */
    long mo794g();

    /* renamed from: h */
    DownloadFailCode mo795h();

    /* renamed from: j */
    String mo796j();

    /* renamed from: l */
    long mo797l();

    /* renamed from: m */
    long mo798m();

    /* renamed from: n */
    float mo799n();

    /* renamed from: o */
    long mo800o();
}
