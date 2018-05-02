package com.duokan.reader.domain.plugins.dict;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.ah;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.downloadcenter.C0780k;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.kingsoft.iciba.sdk2.KSCibaEngine;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.plugins.dict.j */
public class C1115j implements ai, C0780k {
    /* renamed from: a */
    public static final String f5405a = (ReaderEnv.get().getPluginsDirectory() + File.separator + "iciba" + File.separator + "dict");
    /* renamed from: b */
    public static final String f5406b = (ReaderEnv.get().getPluginsDirectory() + File.separator + "iciba" + File.separator + "voice/viki.amr");
    /* renamed from: c */
    private static final aj<C1115j> f5407c = new aj();
    /* renamed from: d */
    private KSCibaEngine f5408d = null;
    /* renamed from: e */
    private Context f5409e;

    /* renamed from: a */
    public static void m8417a(Context context) {
        f5407c.m709a(new C1115j(context));
    }

    /* renamed from: a */
    public static C1115j m8411a() {
        return (C1115j) f5407c.m707a();
    }

    private C1115j(Context context) {
        this.f5409e = context;
        C1016b.m7857p().m7872a((C0780k) this);
    }

    /* renamed from: b */
    public synchronized void m8422b() {
        ah.m865a(new C1116k(this));
    }

    /* renamed from: a */
    public synchronized void m8419a(Runnable runnable) {
        ah.m865a(new C1117l(this, runnable));
    }

    /* renamed from: a */
    public void m8421a(String str, C1123r c1123r) {
        UmengManager.get().onEvent("SEARCH_WORD_V2");
        m8419a(new C1118m(this, str, c1123r));
    }

    /* renamed from: a */
    public void m8420a(String str, C1119n c1119n) {
    }

    public void onTaskRunning(DownloadCenterTask downloadCenterTask) {
    }

    public void onTaskStatusChanged(DownloadCenterTask downloadCenterTask) {
        DownloadCenterTask[] i = C1016b.m7857p().m7893i();
        if (i.length > 0) {
            C1016b.m7857p().m7882b(i);
        }
    }

    /* renamed from: a */
    private String m8416a(JSONObject jSONObject) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(m8415a(jSONObject.getJSONArray("word_pl"), this.f5409e.getString(C0247i.plugins__dict__pl)));
            stringBuffer.append(m8415a(jSONObject.getJSONArray("word_past"), this.f5409e.getString(C0247i.plugins__dict__past)));
            stringBuffer.append(m8415a(jSONObject.getJSONArray("word_done"), this.f5409e.getString(C0247i.plugins__dict__done)));
            stringBuffer.append(m8415a(jSONObject.getJSONArray("word_ing"), this.f5409e.getString(C0247i.plugins__dict__ing)));
            stringBuffer.append(m8415a(jSONObject.getJSONArray("word_third"), this.f5409e.getString(C0247i.plugins__dict__third)));
            stringBuffer.append(m8415a(jSONObject.getJSONArray("word_er"), this.f5409e.getString(C0247i.plugins__dict__er)));
            stringBuffer.append(m8415a(jSONObject.getJSONArray("word_est"), this.f5409e.getString(C0247i.plugins__dict__est)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private String m8415a(JSONArray jSONArray, String str) {
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
