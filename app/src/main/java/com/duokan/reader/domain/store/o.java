package com.duokan.reader.domain.store;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.common.webservices.duokan.y;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.bookshelf.iw;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener;
import com.duokan.reader.domain.cloud.push.b;
import com.mipay.sdk.Mipay;

import org.json.JSONObject;

import java.util.List;

public class o implements ah, classc.IConnectChanged, iw, MessageWakeupListener {
    private static final ai a = new ai();
    private final Context b;
    private final b c;
    private final String d;
    private boolean e = true;
    private boolean f = false;

    private o(Context context, b bVar, com.duokan.reader.domain.bookshelf.ai aiVar) {
        this.b = context;
        this.c = bVar;
        this.e = ReaderEnv.get().getPrefBoolean(PrivatePref.PERSONAL, "fiction_subscription", true);
        this.f = ReaderEnv.get().getPrefBoolean(PrivatePref.PERSONAL, "subscription_update", false);
        this.c.a(MessageSubType.FICTION_UPDATE, (MessageWakeupListener) this);
        this.d = p.i().m() == 3 ? "subscribe_chapter_update_in" : "subscribe_chapter_update";
        DkApp.get().runWhenAppReady(new p(this));
    }

    public static o a() {
        return (o) a.a();
    }

    public static void a(Context context, b bVar, com.duokan.reader.domain.bookshelf.ai aiVar) {
        a.a(new o(context, bVar, aiVar));
    }

    public boolean b() {
        return this.e;
    }

    public void a(boolean z) {
        if (this.e != z) {
            this.e = z;
            ReaderEnv.get().setPrefBoolean(PrivatePref.PERSONAL, "fiction_subscription", this.e);
            ReaderEnv.get().commitPrefs();
            b(false);
            c();
        }
    }

    public void onConnectivityChanged(classc.ConnectivityReceiver connectivity) {
        c();
    }

    public void onItemsChanged() {
        com.duokan.core.sys.ah.a(new q(this));
    }

    public void a(MessageSubType messageSubType, Object obj, boolean z) {
        try {
            if (messageSubType == MessageSubType.FICTION_UPDATE) {
                JSONObject jSONObject = new JSONObject((String) obj);
                String string = jSONObject.getJSONObject("action_params").getString("fiction_id");
                String string2 = jSONObject.getString(Mipay.KEY_MESSAGE);
                c b = com.duokan.reader.domain.bookshelf.ai.a().b(string);
                a.c().a(LogLevel.EVENT, "push", "setDrawable fiction has new chapters(bookUuid:%s, chapterName:%s).", string, string2);
                if (b != null && b.k() && b.i() != BookState.CLOUD_ONLY) {
                    com.duokan.reader.domain.bookshelf.ai.a().c(b);
                    ((ej) b).a(false, null, null);
                }
            }
        } catch (Throwable e) {
            a.c().a(LogLevel.ERROR, "push", "unexpected exception!", e);
        }
    }

    private void c() {
        if (!this.f && f.b().e()) {
            int i;
            boolean z = this.e;
            List d = this.c.d();
            c[] j = com.duokan.reader.domain.bookshelf.ai.a().j();
            for (i = 0; i < j.length; i++) {
                if (j[i] instanceof ej) {
                    boolean z2;
                    ej ejVar = (ej) j[i];
                    y yVar = new y(ejVar.H());
                    String str = this.d + yVar.a();
                    if (z && a(ejVar) && yVar.b() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (d.contains(str)) {
                            d.remove(str);
                        } else {
                            a(str, z2);
                        }
                    } else if (!z2 && d.contains(str)) {
                        a(str, false);
                        d.remove(str);
                    }
                }
            }
            for (i = 0; i < d.size(); i++) {
                String str2 = (String) d.get(i);
                if (str2.startsWith(this.d)) {
                    a(str2, false);
                }
            }
            b(true);
        }
    }

    private void b(boolean z) {
        if (this.f != z) {
            this.f = z;
            ReaderEnv.get().setPrefBoolean(PrivatePref.PERSONAL, "subscription_update", this.f);
            ReaderEnv.get().commitPrefs();
        }
    }

    private boolean a(ej ejVar) {
        if (ejVar.bc().j || System.currentTimeMillis() - ejVar.ax() >= 1296000000 || ejVar.i() == BookState.CLOUD_ONLY) {
            return false;
        }
        return true;
    }

    private void a(String str, boolean z) {
        if (z) {
            this.c.c(str);
        } else {
            this.c.d(str);
        }
    }
}
