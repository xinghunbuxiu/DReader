package com.duokan.reader.common.download;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.http.Headers;

import com.duokan.reader.common.c.a;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.io.File;

class HttpDownloadTask extends DownloadTask {
    static final /* synthetic */ boolean u;
    private static final DefaultHttpClient v = a.b().a(HttpDownloadTask.class.getName());

    static {
        boolean z;
        if (HttpDownloadTask.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        u = z;
        HttpParams params = v.getParams();
        HttpConnectionParams.setSocketBufferSize(params, 131072);
        v.setParams(params);
    }

    public HttpDownloadTask(Context context, long j, SQLiteDatabase sQLiteDatabase, l lVar, File file) {
        super(context, j, sQLiteDatabase, lVar, file);
    }

    protected DownloadBlock b(long j) {
        return new HttpDownloadBlock(j, this.e, this.r, this, this.s, v);
    }

    protected JSONObject a(c cVar) {
        if (u || cVar != null) {
            JSONObject a = super.a(cVar);
            o oVar = (o) cVar;
            if (u || oVar != null) {
                a.putOpt(Headers.ETAG, oVar.h);
                a.putOpt("last_modified_time", oVar.i);
                return a;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    protected void c(JSONObject jSONObject) {
        if (u || jSONObject != null) {
            if (this.n == null) {
                this.n = new o();
            }
            o oVar = (o) this.n;
            oVar.h = jSONObject.optString(Headers.ETAG);
            oVar.i = jSONObject.optString("last_modified_time");
            super.c(jSONObject);
            return;
        }
        throw new AssertionError();
    }
}
