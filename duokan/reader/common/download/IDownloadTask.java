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

    void a(JSONObject jSONObject);

    String b();

    JSONObject d();

    TaskStatus e();

    TaskState f();

    long g();

    DownloadFailCode h();

    String j();

    long l();

    long m();

    float n();
}
