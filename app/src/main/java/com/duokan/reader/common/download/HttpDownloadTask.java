package com.duokan.reader.common.download;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.http.Headers;
import com.duokan.reader.common.p037c.C0554a;
import java.io.File;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

class HttpDownloadTask extends DownloadTask {
    /* renamed from: u */
    static final /* synthetic */ boolean f1978u;
    /* renamed from: v */
    private static final DefaultHttpClient f1979v = C0554a.m2459b().m2461a(HttpDownloadTask.class.getName());

    static {
        boolean z;
        if (HttpDownloadTask.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f1978u = z;
        HttpParams params = f1979v.getParams();
        HttpConnectionParams.setSocketBufferSize(params, 131072);
        f1979v.setParams(params);
    }

    public HttpDownloadTask(Context context, long j, SQLiteDatabase sQLiteDatabase, C0595l c0595l, File file) {
        super(context, j, sQLiteDatabase, c0595l, file);
    }

    /* renamed from: b */
    protected DownloadBlock mo805b(long j) {
        return new HttpDownloadBlock(j, this.e, this.r, this, this.s, f1979v);
    }

    /* renamed from: a */
    protected JSONObject mo804a(C0593c c0593c) {
        if (f1978u || c0593c != null) {
            JSONObject a = super.mo804a(c0593c);
            C0605o c0605o = (C0605o) c0593c;
            if (f1978u || c0605o != null) {
                a.putOpt(Headers.ETAG, c0605o.f2028h);
                a.putOpt("last_modified_time", c0605o.f2029i);
                return a;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    protected void mo806c(JSONObject jSONObject) {
        if (f1978u || jSONObject != null) {
            if (this.n == null) {
                this.n = new C0605o();
            }
            C0605o c0605o = (C0605o) this.n;
            c0605o.f2028h = jSONObject.optString(Headers.ETAG);
            c0605o.f2029i = jSONObject.optString("last_modified_time");
            super.mo806c(jSONObject);
            return;
        }
        throw new AssertionError();
    }
}
