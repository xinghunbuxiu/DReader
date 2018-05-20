package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.sys.as;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.ui.general.ja;
import org.json.JSONObject;

class ix implements as {
    /* renamed from: a */
    final /* synthetic */ String f8021a;
    /* renamed from: b */
    final /* synthetic */ ci f8022b;

    ix(ci ciVar, String str) {
        this.f8022b = ciVar;
        this.f8021a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        ja jaVar = (ja) UThread.m1035a(new iy(this));
        af afVar = new af();
        JSONObject jSONObject = new JSONObject(this.f8021a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        String b = C0611i.m2793b(jSONObject, "bookUuid");
        int optInt = jSONObject.optInt("chapterIndex", -1);
        String optString = jSONObject.optString("trace_id", "");
        String optString2 = jSONObject.optString("_track_", "");
        Object b2 = ai.m3980a().m3906b(b);
        try {
            ReaderFeature readerFeature;
            Object a;
            if (C0800c.m4140l(b)) {
                DkStoreBookDetail dkStoreBookDetail;
                if (jSONObject.has("detail")) {
                    dkStoreBookDetail = new DkStoreBookDetail(jSONObject.getJSONObject("detail"));
                } else {
                    dkStoreBookDetail = null;
                }
                if (dkStoreBookDetail == null || TextUtils.isEmpty(dkStoreBookDetail.getOpfUri())) {
                    if (b2 != null && b2.m4233i() == BookState.NORMAL) {
                        afVar.mo975a(b2);
                    }
                } else if (b2 != null) {
                    afVar.mo975a(b2);
                } else {
                    readerFeature = (ReaderFeature) this.f8022b.f7581b.getContext().queryFeature(ReaderFeature.class);
                    if (readerFeature == null || readerFeature.getReadingBook() == null || !TextUtils.equals(dkStoreBookDetail.getBook().getBookUuid(), readerFeature.getReadingBook().getId())) {
                        a = ai.m3980a().m3869a(dkStoreBookDetail);
                        a.m4235j(optString);
                        afVar.mo975a(a);
                    } else {
                        afVar.mo975a(readerFeature.getReadingBook());
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
                    afVar.mo975a(b2);
                } else if (dkStoreFictionDetail == null || optInt >= dkStoreFictionDetail.getToc().length) {
                    UThread.runOnThread(new iz(this, b, optString, afVar));
                    synchronized (afVar) {
                        afVar.wait();
                    }
                } else {
                    readerFeature = (ReaderFeature) this.f8022b.f7581b.getContext().queryFeature(ReaderFeature.class);
                    if (readerFeature == null || readerFeature.getReadingBook() == null || !TextUtils.equals(dkStoreFictionDetail.getFiction().getBookUuid(), readerFeature.getReadingBook().getId())) {
                        a = (ee) ai.m3980a().m3874a(dkStoreFictionDetail);
                        a.m4235j(optString);
                        a.m4406a(dkStoreFictionDetail);
                        afVar.mo975a(a);
                    } else {
                        afVar.mo975a(readerFeature.getReadingBook());
                    }
                }
            }
            UThread.runOnThread(new jb(this, jaVar, afVar, string, optString2, optInt));
        } catch (Throwable th) {
            Throwable th2 = th;
            UThread.runOnThread(new jb(this, jaVar, afVar, string, optString2, optInt));
        }
    }
}
