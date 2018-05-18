package com.duokan.reader.domain.store;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.ah;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0562i;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.bookshelf.iq;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener;
import com.mipay.sdk.Mipay;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.store.o */
public class C1189o implements ai, C0562i, iq, MessageWakeupListener {
    /* renamed from: a */
    private static final aj<C1189o> f5670a = new aj();
    /* renamed from: b */
    private final Context f5671b;
    /* renamed from: c */
    private final C0857b f5672c;
    /* renamed from: d */
    private final String f5673d;
    /* renamed from: e */
    private boolean f5674e = true;
    /* renamed from: f */
    private boolean f5675f = false;

    private C1189o(Context context, C0857b c0857b, com.duokan.reader.domain.bookshelf.ai aiVar) {
        this.f5671b = context;
        this.f5672c = c0857b;
        this.f5674e = ReaderEnv.get().getPrefBoolean(PrivatePref.PERSONAL, "fiction_subscription", true);
        this.f5675f = ReaderEnv.get().getPrefBoolean(PrivatePref.PERSONAL, "subscription_update", false);
        this.f5672c.m5680a(MessageSubType.FICTION_UPDATE, (MessageWakeupListener) this);
        this.f5673d = C0641o.m2934i().m2986m() == 3 ? "subscribe_chapter_update_in" : "subscribe_chapter_update";
        DkApp.get().runWhenAppReady(new C1190p(this));
    }

    /* renamed from: a */
    public static C1189o m8727a() {
        return (C1189o) f5670a.m707a();
    }

    /* renamed from: a */
    public static void m8728a(Context context, C0857b c0857b, com.duokan.reader.domain.bookshelf.ai aiVar) {
        f5670a.m709a(new C1189o(context, c0857b, aiVar));
    }

    /* renamed from: b */
    public boolean m8738b() {
        return this.f5674e;
    }

    /* renamed from: a */
    public void m8737a(boolean z) {
        if (this.f5674e != z) {
            this.f5674e = z;
            ReaderEnv.get().setPrefBoolean(PrivatePref.PERSONAL, "fiction_subscription", this.f5674e);
            ReaderEnv.get().commitPrefs();
            m8733b(false);
            m8734c();
        }
    }

    /* renamed from: a */
    public void mo949a(C0559f c0559f) {
        m8734c();
    }

    public void onItemsChanged() {
        ah.m865a(new C1191q(this));
    }

    /* renamed from: a */
    public void mo785a(MessageSubType messageSubType, Object obj, boolean z) {
        try {
            if (messageSubType == MessageSubType.FICTION_UPDATE) {
                JSONObject jSONObject = new JSONObject((String) obj);
                String string = jSONObject.getJSONObject("action_params").getString("fiction_id");
                String string2 = jSONObject.getString(Mipay.KEY_MESSAGE);
                C0800c b = com.duokan.reader.domain.bookshelf.ai.m3980a().m3906b(string);
                WebLog.init().a(LogLevel.EVENT, "push", "a fiction has new chapters(bookUuid:%s, chapterName:%s).", string, string2);
                if (b != null && b.mo1038k() && b.m4233i() != BookState.CLOUD_ONLY) {
                    com.duokan.reader.domain.bookshelf.ai.m3980a().m3918c(b);
                    ((ee) b).m4410a(false, null, null);
                }
            }
        } catch (Throwable e) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "push", "unexpected exception!", e);
        }
    }

    /* renamed from: c */
    private void m8734c() {
        if (!this.f5675f && C0559f.m2476b().m2486e()) {
            int i;
            boolean z = this.f5674e;
            List d = this.f5672c.m5691d();
            C0800c[] j = com.duokan.reader.domain.bookshelf.ai.m3980a().m3935j();
            for (i = 0; i < j.length; i++) {
                if (j[i] instanceof ee) {
                    boolean z2;
                    ee eeVar = (ee) j[i];
                    C0650x c0650x = new C0650x(eeVar.getId());
                    String str = this.f5673d + c0650x.m3046a();
                    if (z && m8732a(eeVar) && c0650x.m3047b() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (d.contains(str)) {
                            d.remove(str);
                        } else {
                            m8731a(str, z2);
                        }
                    } else if (!z2 && d.contains(str)) {
                        m8731a(str, false);
                        d.remove(str);
                    }
                }
            }
            for (i = 0; i < d.size(); i++) {
                String str2 = (String) d.get(i);
                if (str2.startsWith(this.f5673d)) {
                    m8731a(str2, false);
                }
            }
            m8733b(true);
        }
    }

    /* renamed from: b */
    private void m8733b(boolean z) {
        if (this.f5675f != z) {
            this.f5675f = z;
            ReaderEnv.get().setPrefBoolean(PrivatePref.PERSONAL, "subscription_update", this.f5675f);
            ReaderEnv.get().commitPrefs();
        }
    }

    /* renamed from: a */
    private boolean m8732a(ee eeVar) {
        if (eeVar.be().f3516j || System.currentTimeMillis() - eeVar.az() >= 1296000000 || eeVar.m4233i() == BookState.CLOUD_ONLY) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m8731a(String str, boolean z) {
        if (z) {
            this.f5672c.m5690c(str);
        } else {
            this.f5672c.m5692d(str);
        }
    }
}
