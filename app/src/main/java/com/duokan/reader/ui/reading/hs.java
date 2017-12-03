package com.duokan.reader.ui.reading;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.general.jq;
import com.duokan.reader.ui.general.web.StorePageController;

import org.json.JSONArray;
import org.json.JSONObject;

class hs extends c {
    final /* synthetic */ jq a;
    final /* synthetic */ hq b;
    private String c = "";

    hs(hq hqVar, jq jqVar) {
        this.b = hqVar;
        this.a = jqVar;
    }

    protected void onSessionTry() {
        aa aaVar = new aa((WebSession) this, new ab(i.f().b(PersonalAccount.class)));
        com.duokan.reader.domain.bookshelf.c G = this.b.f.G();
        JSONArray a = com.duokan.reader.common.i.a((JSONObject) aaVar.a(G.H(), G.K()).a, "ui", new JSONArray());
        for (int i = 0; i < a.length(); i++) {
            JSONObject jSONObject = a.getJSONObject(i);
            CharSequence optString = jSONObject.optString("type", "text");
            String optString2 = jSONObject.optString("click", "");
            if (TextUtils.equals(optString, "button")) {
                this.c = optString2;
                return;
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.b.f.K()) {
        }
    }

    protected void onSessionFailed() {
        if (!this.b.f.K()) {
        }
    }

    protected void onSessionClosed() {
        super.onSessionClosed();
        this.a.dismiss();
        if (TextUtils.isEmpty(this.c)) {
            ((ReaderFeature) this.b.getContext().queryFeature(ReaderFeature.class)).prompt(this.b.getResources().getString(j.general__shared__network_error));
            return;
        }
        ActivatedController storePageController = new StorePageController(this.b.getContext());
        storePageController.loadUrl(this.c);
        ((ReaderFeature) this.b.getContext().queryFeature(ReaderFeature.class)).showPopup(storePageController);
    }
}
