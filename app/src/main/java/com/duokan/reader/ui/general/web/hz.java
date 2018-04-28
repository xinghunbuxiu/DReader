package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import java.util.concurrent.Callable;
import org.json.JSONObject;

class hz implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ String f7960a;
    /* renamed from: b */
    final /* synthetic */ ci f7961b;

    hz(ci ciVar, String str) {
        this.f7961b = ciVar;
        this.f7960a = str;
    }

    public /* synthetic */ Object call() {
        return m11185a();
    }

    /* renamed from: a */
    public String m11185a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        C0800c b = ai.m3980a().m3906b(this.f7960a);
        if (b != null) {
            switch (b.m4233i()) {
                case UPDATING:
                    if (b.mo1037j() && (!b.m4171X() || b.m4173Z())) {
                        jSONObject2.put("bookState", "NORMAL");
                        break;
                    }
                    jSONObject2.put("bookState", "UPGRADING");
                    break;
                    break;
                case PULLING:
                    if (b.mo1037j() && (!b.m4171X() || b.m4173Z())) {
                        jSONObject2.put("bookState", "NORMAL");
                        break;
                    }
                    jSONObject2.put("bookState", "PULLING");
                    break;
                case CLOUD_ONLY:
                    jSONObject2.put("bookState", "CLOUDONLY");
                    break;
                default:
                    jSONObject2.put("bookState", "NORMAL");
                    break;
            }
            if (b.m4166S()) {
                jSONObject2.put("bookType", "TIMED");
            } else {
                jSONObject2.put("bookType", b.m4242o().name());
            }
            jSONObject2.put("bookRevision", b.m4157J());
            jSONObject.put("shelf", jSONObject2);
        }
        JSONObject jSONObject3 = new JSONObject();
        DkCloudPurchasedBook a = DkUserPurchasedBooksManager.m5029a().m5052a(this.f7960a);
        if (a != null) {
            jSONObject3.put("date", a.getPurchaseTimeInSeconds() * 1000);
            jSONObject3.put("revision", b == null ? "" : b.m4158K());
            jSONObject.put("purchased", jSONObject3);
        }
        jSONObject3 = new JSONObject();
        DownloadCenterTask a2 = C1016b.m7857p().m7866a(this.f7960a);
        Object obj;
        if (b != null && b.m4242o() == BookType.SERIAL && b.m4171X()) {
            jSONObject3.put("progress", (double) b.m4240m());
            if (b.m4173Z()) {
                obj = "PAUSED";
            } else {
                obj = "RUNNING";
            }
            jSONObject3.put("state", obj);
            jSONObject.put("download", jSONObject3);
        } else if (b != null && b.m4247s() == BookPackageType.EPUB_OPF && b.m4171X()) {
            jSONObject3.put("progress", (double) b.m4240m());
            if (b.m4173Z()) {
                obj = "PAUSED";
            } else {
                obj = "RUNNING";
            }
            jSONObject3.put("state", obj);
            jSONObject.put("download", jSONObject3);
        } else if (a2 != null) {
            jSONObject3.put("progress", (double) a2.m7796j());
            if (a2.m7788b()) {
                obj = "PAUSED";
            } else if (a2.m7790d()) {
                obj = "RUNNING";
            } else if (a2.m7794h()) {
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
