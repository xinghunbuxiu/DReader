package com.duokan.reader.ui.personal;

import android.os.AsyncTask;

import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.jq;

class ax extends AsyncTask {
    final /* synthetic */ FlowChargingTransferChoice a;
    final /* synthetic */ jq b;
    final /* synthetic */ aw c;

    ax(aw awVar, FlowChargingTransferChoice flowChargingTransferChoice, jq jqVar) {
        this.c = awVar;
        this.a = flowChargingTransferChoice;
        this.b = jqVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    protected Void a(Void... voidArr) {
        if (this.c.b == BookAction.UPLOAD_FAILED) {
            iz.a().a(this.c.c, this.a);
        } else if (this.c.b == BookAction.UPLOAD_PAUSED) {
            iz.a().a(this.c.c, this.a);
        } else if (this.c.b == BookAction.CAN_UPLOAD) {
        }
        return null;
    }

    protected void a(Void voidR) {
        super.onPostExecute(voidR);
        this.b.dismiss();
    }
}
