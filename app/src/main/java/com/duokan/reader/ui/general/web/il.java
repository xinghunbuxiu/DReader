package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.af;
import com.duokan.core.sys.as;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.i;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.ui.general.jq;

import org.json.JSONObject;

class il implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    il(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        jq jqVar = (jq) TaskHandler.postTask(new im(this));
        af afVar = new af();
        JSONObject jSONObject = new JSONObject(this.a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        String b = i.b(jSONObject, "bookUuid");
        int optInt = jSONObject.optInt("chapterIndex", -1);
        String optString = jSONObject.optString("trace_id", "");
        Object b2 = ai.a().b(b);
        try {
            ReaderFeature readerFeature;
            Object a;
            if (c.k(b)) {
                DkStoreBookDetail dkStoreBookDetail;
                if (jSONObject.has("detail")) {
                    dkStoreBookDetail = new DkStoreBookDetail(jSONObject.getJSONObject("detail"));
                } else {
                    dkStoreBookDetail = null;
                }
                if (dkStoreBookDetail == null || TextUtils.isEmpty(dkStoreBookDetail.getOpfUri())) {
                    if (b2 != null && b2.i() == BookState.NORMAL) {
                        afVar.a(b2);
                    }
                } else if (b2 != null) {
                    afVar.a(b2);
                } else {
                    readerFeature = (ReaderFeature) this.b.b.getContext().queryFeature(ReaderFeature.class);
                    if (readerFeature == null || readerFeature.getReadingBook() == null || !TextUtils.equals(dkStoreBookDetail.getBook().getBookUuid(), readerFeature.getReadingBook().H())) {
                        a = ai.a().a(dkStoreBookDetail);
                        a.j(optString);
                        afVar.a(a);
                    } else {
                        afVar.a(readerFeature.getReadingBook());
                    }
                }
            } else {
                DkStoreFictionDetail dkStoreFictionDetail;
                if (jSONObject.has("detail")) {
                    dkStoreFictionDetail = new DkStoreFictionDetail(jSONObject.getJSONObject("detail"));
                } else {
                    dkStoreFictionDetail = null;
                }
                if (b2 != null) {
                    afVar.a(b2);
                } else if (dkStoreFictionDetail == null || optInt >= dkStoreFictionDetail.getToc().length) {
                    TaskHandler.postTask(new in(this, b, optString, afVar));
                    synchronized (afVar) {
                        afVar.wait();
                    }
                } else {
                    readerFeature = (ReaderFeature) this.b.b.getContext().queryFeature(ReaderFeature.class);
                    if (readerFeature == null || readerFeature.getReadingBook() == null || !TextUtils.equals(dkStoreFictionDetail.getFiction().getBookUuid(), readerFeature.getReadingBook().H())) {
                        a = (ej) ai.a().a(dkStoreFictionDetail);
                        a.j(optString);
                        a.a(dkStoreFictionDetail);
                        afVar.a(a);
                    } else {
                        afVar.a(readerFeature.getReadingBook());
                    }
                }
            }
            TaskHandler.postTask(new ip(this, jqVar, afVar, string, optInt));
        } catch (Throwable th) {
            Throwable th2 = th;
            TaskHandler.postTask(new ip(this, jqVar, afVar, string, optInt));
        }
    }
}
