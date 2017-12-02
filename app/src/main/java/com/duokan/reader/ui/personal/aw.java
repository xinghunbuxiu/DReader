package com.duokan.reader.ui.personal;

import android.app.Activity;

import com.duokan.c.j;
import com.duokan.common.a;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.micloud.i;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.general.jq;

class aw implements cm {
    final /* synthetic */ Activity a;
    final /* synthetic */ BookAction b;
    final /* synthetic */ i c;
    final /* synthetic */ av d;

    aw(av avVar, Activity activity, BookAction bookAction, i iVar) {
        this.d = avVar;
        this.a = activity;
        this.b = bookAction;
        this.c = iVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            jq jqVar = new jq(this.a);
            jqVar.a(this.a.getResources().getString(j.bookshelf__upload_books_view__prepair_uploading));
            jqVar.setCancelOnBack(false);
            jqVar.setCancelOnTouchOutside(false);
            jqVar.show();
            UmengManager.get().onEvent("V3_SHELF_BOOK_ACTION", "UploadAttempt");
            a.a(new ax(this, flowChargingTransferChoice, jqVar), new Void[0]);
        }
    }
}
