package com.duokan.reader.domain.b;

import android.app.Activity;
import android.content.Context;

import com.duokan.b.i;
import com.duokan.reader.common.c.f;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ap;

class k extends ap {
    final /* synthetic */ Activity a;
    final /* synthetic */ n b;
    final /* synthetic */ b c;

    k(b bVar, Context context, Activity activity, n nVar) {
        this.c = bVar;
        this.a = activity;
        this.b = nVar;
        super(context);
    }

    protected void onOk() {
        if (f.b().d()) {
            this.c.a(FlowChargingTransferChoice.NoTransfer);
            this.c.a(this.a);
        } else {
            ap lVar = new l(this, this.a);
            lVar.setTitle(i.reading__reading_menu_bottom_view_epub__confirm_download_font_title);
            lVar.setPrompt(i.reading__reading_menu_bottom_view_epub__confirm_download_font_prompt);
            lVar.setCancelLabel(i.general__shared__cancel);
            lVar.setOkLabel(i.general__shared__confirm);
            lVar.setCancelOnTouchOutside(false);
            lVar.setCancelOnBack(false);
            lVar.show();
        }
        this.b.a();
        super.onOk();
    }

    protected void onCancel() {
        this.c.a(this.a);
        a.d().d("showAnimation");
        this.b.b();
        super.onCancel();
    }
}
