package com.duokan.reader.ui.personal;

import android.app.Activity;
import com.duokan.common.C0259a;
import com.duokan.p024c.C0258j;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.general.ja;

class ap implements cm {
    /* renamed from: a */
    final /* synthetic */ Activity f8274a;
    /* renamed from: b */
    final /* synthetic */ BookAction f8275b;
    /* renamed from: c */
    final /* synthetic */ C1068i f8276c;
    /* renamed from: d */
    final /* synthetic */ ao f8277d;

    ap(ao aoVar, Activity activity, BookAction bookAction, C1068i c1068i) {
        this.f8277d = aoVar;
        this.f8274a = activity;
        this.f8275b = bookAction;
        this.f8276c = c1068i;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            ja jaVar = new ja(this.f8274a);
            jaVar.m10843a(this.f8274a.getResources().getString(C0258j.bookshelf__upload_books_view__prepair_uploading));
            jaVar.setCancelOnBack(false);
            jaVar.setCancelOnTouchOutside(false);
            jaVar.show();
            UmengManager.get().onEvent("V3_SHELF_BOOK_ACTION", "UploadAttempt");
            C0259a.m568a(new aq(this, flowChargingTransferChoice, jaVar), new Void[0]);
        }
    }
}
