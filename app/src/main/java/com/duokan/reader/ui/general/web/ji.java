package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.C0299i;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.as;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.ja;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import org.json.JSONArray;
import org.json.JSONObject;

class ji implements as {
    /* renamed from: a */
    final /* synthetic */ String f8047a;
    /* renamed from: b */
    final /* synthetic */ ci f8048b;

    ji(ci ciVar, String str) {
        this.f8048b = ciVar;
        this.f8047a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        ja jaVar = (ja) UThread.m1035a(new jj(this));
        JSONObject jSONObject = new JSONObject(this.f8047a);
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        String string = jSONObject.getString("msgid");
        JSONArray a = C0611i.m2788a(jSONObject2, "books", null);
        boolean m;
        if (a != null) {
            int i = 0;
            boolean z = true;
            while (i < a.length()) {
                boolean z2;
                JSONObject jSONObject3 = a.getJSONObject(i);
                Object b = C0611i.m2793b(jSONObject3, "bookUuid");
                m = C0800c.m4141m(b);
                WebLog.init().w(!TextUtils.isEmpty(b));
                if (TextUtils.isEmpty(b)) {
                    z2 = z;
                } else {
                    String b2;
                    if (m) {
                        b2 = C0611i.m2793b(jSONObject3, "chapters");
                    } else {
                        b2 = "";
                    }
                    if (m) {
                        WebLog.init().a(LogLevel.EVENT, "store", "purchased a couple of serial chapters(book: %s, chapters: %s)", b, b2);
                    } else {
                        WebLog.init().a(LogLevel.EVENT, "store", "purchased a book(book: %s)", b);
                    }
                    C0299i c0299i = new C0299i();
                    this.f8048b.m11016a(new jk(this, m, b2, b, c0299i));
                    if (((Boolean) c0299i.m707a()).booleanValue()) {
                        z2 = z;
                    } else {
                        WebLog.init().a(LogLevel.ERROR, "store", "fail to update a purchased book(%s)", b);
                        z2 = false;
                    }
                }
                i++;
                z = z2;
            }
            this.f8048b.m11016a(new jp(this, new jo(this, jaVar, z, string)));
            return;
        }
        CharSequence b3 = C0611i.m2793b(jSONObject2, "bookUuid");
        m = C0800c.m4141m(b3);
        ArrayList arrayList = new ArrayList();
        if (m) {
            JSONArray a2 = C0611i.m2788a(jSONObject2, "chapters", new JSONArray());
            if (a2.length() > 0) {
                arrayList.ensureCapacity(a2.length());
                for (int i2 = 0; i2 < a2.length(); i2++) {
                    arrayList.add(a2.getString(i2));
                }
            }
            WebLog.init().a(LogLevel.EVENT, "store", "purchased a couple of serial chapters(book: %s, chapters: %s)", b3, C0652z.m3048a((String[]) arrayList.toArray(new String[0])));
        } else if (TextUtils.equals(b3, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE)) {
            WebLog.init().c(LogLevel.EVENT, "store", "purchased a couple of books");
        } else {
            WebLog.init().a(LogLevel.EVENT, "store", "purchased a book(book: %s)", b3);
        }
        Semaphore semaphore = new Semaphore(0);
        this.f8048b.m11016a(new jr(this, m, b3, semaphore, arrayList));
        semaphore.acquire();
        if (!m) {
            Semaphore semaphore2 = new Semaphore(0);
            this.f8048b.m11016a(new jw(this, semaphore2));
            semaphore2.acquire();
        }
        this.f8048b.m11016a(new jy(this, string, jaVar));
    }
}
