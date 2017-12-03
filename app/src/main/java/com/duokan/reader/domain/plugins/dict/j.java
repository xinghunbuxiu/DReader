package com.duokan.reader.domain.plugins.dict;

import android.content.Context;

import com.duokan.b.i;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.k;
import com.kingsoft.iciba.sdk2.KSCibaEngine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class j implements ah, k {
    public static final String a = (ReaderEnv.get().getPluginsDirectory() + File.separator + "iciba" + File.separator + "dict");
    public static final String b = (ReaderEnv.get().getPluginsDirectory() + File.separator + "iciba" + File.separator + "voice/viki.amr");
    private static final ai c = new ai();
    private KSCibaEngine d = null;
    private Context e;

    public static void a(Context context) {
        c.a(new j(context));
    }

    public static j a() {
        return (j) c.a();
    }

    private j(Context context) {
        this.e = context;
        b.n().a((k) this);
    }

    public synchronized void b() {
        com.duokan.core.sys.ah.a(new k(this));
    }

    public synchronized void a(Runnable runnable) {
        com.duokan.core.sys.ah.a(new l(this, runnable));
    }

    public void a(String str, r rVar) {
        UmengManager.get().onEvent("SEARCH_WORD_V2");
        a(new m(this, str, rVar));
    }

    public void a(String str, n nVar) {
    }

    public void a(DownloadCenterTask downloadCenterTask) {
    }

    public void b(DownloadCenterTask downloadCenterTask) {
        DownloadCenterTask[] i = b.n().i();
        if (i.length > 0) {
            b.n().b(i);
        }
    }

    private String a(JSONObject jSONObject) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(a(jSONObject.getJSONArray("word_pl"), this.e.getString(i.plugins__dict__pl)));
            stringBuffer.append(a(jSONObject.getJSONArray("word_past"), this.e.getString(i.plugins__dict__past)));
            stringBuffer.append(a(jSONObject.getJSONArray("word_done"), this.e.getString(i.plugins__dict__done)));
            stringBuffer.append(a(jSONObject.getJSONArray("word_ing"), this.e.getString(i.plugins__dict__ing)));
            stringBuffer.append(a(jSONObject.getJSONArray("word_third"), this.e.getString(i.plugins__dict__third)));
            stringBuffer.append(a(jSONObject.getJSONArray("word_er"), this.e.getString(i.plugins__dict__er)));
            stringBuffer.append(a(jSONObject.getJSONArray("word_est"), this.e.getString(i.plugins__dict__est)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private String a(JSONArray jSONArray, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jSONArray.length(); i++) {
            stringBuffer.append(jSONArray.getString(i));
        }
        if (stringBuffer.length() > 0) {
            return str + stringBuffer.toString();
        }
        return "";
    }
}
