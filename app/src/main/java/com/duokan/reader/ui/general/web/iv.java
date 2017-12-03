package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.as;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.common.i;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.jq;
import com.sina.weibo.sdk.exception.WeiboAuthException;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class iv implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    iv(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        jq jqVar = (jq) TaskHandler.postTask(new iw(this));
        JSONObject jSONObject = new JSONObject(this.a);
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        String string = jSONObject.getString("msgid");
        JSONArray a = i.a(jSONObject2, "books", null);
        boolean l;
        if (a != null) {
            int i = 0;
            boolean z = true;
            while (i < a.length()) {
                boolean z2;
                JSONObject jSONObject3 = a.getJSONObject(i);
                Object b = i.b(jSONObject3, "bookUuid");
                l = c.l(b);
                a.c().b(!TextUtils.isEmpty(b));
                if (TextUtils.isEmpty(b)) {
                    z2 = z;
                } else {
                    String b2;
                    if (l) {
                        b2 = i.b(jSONObject3, "chapters");
                    } else {
                        b2 = "";
                    }
                    if (l) {
                        a.c().a(LogLevel.EVENT, "store", "purchased setDrawable couple of serial chapters(book: %s, chapters: %s)", b, b2);
                    } else {
                        a.c().a(LogLevel.EVENT, "store", "purchased setDrawable book(book: %s)", b);
                    }
                    com.duokan.core.sys.i iVar = new com.duokan.core.sys.i();
                    this.b.a(new ix(this, l, b2, b, iVar));
                    if (((Boolean) iVar.a()).booleanValue()) {
                        z2 = z;
                    } else {
                        a.c().a(LogLevel.ERROR, "store", "fail to update setDrawable purchased book(%s)", b);
                        z2 = false;
                    }
                }
                i++;
                z = z2;
            }
            this.b.a(new jc(this, new jb(this, jqVar, z, string)));
            return;
        }
        CharSequence b3 = i.b(jSONObject2, "bookUuid");
        l = c.l(b3);
        ArrayList arrayList = new ArrayList();
        if (l) {
            JSONArray a2 = i.a(jSONObject2, "chapters", new JSONArray());
            if (a2.length() > 0) {
                arrayList.ensureCapacity(a2.length());
                for (int i2 = 0; i2 < a2.length(); i2++) {
                    arrayList.add(a2.getString(i2));
                }
            }
            a.c().a(LogLevel.EVENT, "store", "purchased setDrawable couple of serial chapters(book: %s, chapters: %s)", b3, aa.a((String[]) arrayList.toArray(new String[0])));
        } else if (TextUtils.equals(b3, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE)) {
            a.c().c(LogLevel.EVENT, "store", "purchased setDrawable couple of books");
        } else {
            a.c().a(LogLevel.EVENT, "store", "purchased setDrawable book(book: %s)", b3);
        }
        Semaphore semaphore = new Semaphore(0);
        this.b.a(new je(this, l, b3, semaphore, arrayList));
        semaphore.acquire();
        if (!l) {
            Semaphore semaphore2 = new Semaphore(0);
            this.b.a(new jj(this, semaphore2));
            semaphore2.acquire();
        }
        this.b.a(new jl(this, string, jqVar));
    }
}
