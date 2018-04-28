package com.duokan.reader.ui.personal;

import android.os.AsyncTask;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ja;

class aq extends AsyncTask<Void, Void, Void> {
    /* renamed from: a */
    final /* synthetic */ FlowChargingTransferChoice f8278a;
    /* renamed from: b */
    final /* synthetic */ ja f8279b;
    /* renamed from: c */
    final /* synthetic */ ap f8280c;

    aq(ap apVar, FlowChargingTransferChoice flowChargingTransferChoice, ja jaVar) {
        this.f8280c = apVar;
        this.f8278a = flowChargingTransferChoice;
        this.f8279b = jaVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m11422a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m11423a((Void) obj);
    }

    /* renamed from: a */
    protected Void m11422a(Void... voidArr) {
        if (this.f8280c.f8275b == BookAction.UPLOAD_FAILED) {
            it.m4692a().m4718a(this.f8280c.f8276c, this.f8278a);
        } else if (this.f8280c.f8275b == BookAction.UPLOAD_PAUSED) {
            it.m4692a().m4718a(this.f8280c.f8276c, this.f8278a);
        } else if (this.f8280c.f8275b == BookAction.CAN_UPLOAD) {
        }
        return null;
    }

    /* renamed from: a */
    protected void m11423a(Void voidR) {
        super.onPostExecute(voidR);
        this.f8279b.dismiss();
    }
}
