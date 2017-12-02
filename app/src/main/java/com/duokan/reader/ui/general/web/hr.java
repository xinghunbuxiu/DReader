package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.b;

import org.json.JSONObject;

import java.util.concurrent.Callable;

class hr implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    hr(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        c b = ai.a().b(this.a);
        if (b != null) {
            switch (bw.b[b.i().ordinal()]) {
                case 1:
                    if (b.j() && (!b.V() || b.X())) {
                        jSONObject2.put("bookState", "NORMAL");
                        break;
                    }
                    jSONObject2.put("bookState", "UPGRADING");
                    break;
                    break;
                case 2:
                    if (b.j() && (!b.V() || b.X())) {
                        jSONObject2.put("bookState", "NORMAL");
                        break;
                    }
                    jSONObject2.put("bookState", "PULLING");
                    break;
                case 3:
                    jSONObject2.put("bookState", "CLOUDONLY");
                    break;
                default:
                    jSONObject2.put("bookState", "NORMAL");
                    break;
            }
            if (b.Q()) {
                jSONObject2.put("bookType", "TIMED");
            } else {
                jSONObject2.put("bookType", b.o().name());
            }
            jSONObject2.put("bookRevision", b.I());
            jSONObject.put("shelf", jSONObject2);
        }
        JSONObject jSONObject3 = new JSONObject();
        DkCloudPurchasedBook b2 = DkUserPurchasedBooksManager.a().b(this.a);
        if (b2 != null) {
            jSONObject3.put("date", b2.getPurchaseTimeInSeconds() * 1000);
            jSONObject3.put("revision", b == null ? "" : b.J());
            jSONObject.put("purchased", jSONObject3);
        }
        jSONObject3 = new JSONObject();
        DownloadCenterTask a = b.n().a(this.a);
        Object obj;
        if (b != null && b.o() == BookType.SERIAL && b.V()) {
            jSONObject3.put("progress", (double) b.m());
            if (b.X()) {
                obj = "PAUSED";
            } else {
                obj = "RUNNING";
            }
            jSONObject3.put("state", obj);
            jSONObject.put("download", jSONObject3);
        } else if (b != null && b.s() == BookPackageType.EPUB_OPF && b.V()) {
            jSONObject3.put("progress", (double) b.m());
            if (b.X()) {
                obj = "PAUSED";
            } else {
                obj = "RUNNING";
            }
            jSONObject3.put("state", obj);
            jSONObject.put("download", jSONObject3);
        } else if (a != null) {
            jSONObject3.put("progress", (double) a.j());
            if (a.b()) {
                obj = "PAUSED";
            } else if (a.d()) {
                obj = "RUNNING";
            } else if (a.h()) {
                obj = "FAILED";
            } else {
                obj = "OK";
            }
            jSONObject3.put("state", obj);
            jSONObject.put("download", jSONObject3);
        }
        return jSONObject.toString();
    }
}
