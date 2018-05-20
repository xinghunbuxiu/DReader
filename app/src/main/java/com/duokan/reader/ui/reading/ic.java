package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.ja;
import com.duokan.reader.ui.general.web.StorePageController;
import org.json.JSONArray;
import org.json.JSONObject;

class ic extends WebSession {
    /* renamed from: a */
    final /* synthetic */ ja f10379a;
    /* renamed from: b */
    final /* synthetic */ ia f10380b;
    /* renamed from: c */
    private String f10381c = "";

    ic(ia iaVar, C0657i c0657i, ja jaVar) {
        this.f10380b = iaVar;
        this.f10379a = jaVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0652z c0652z = new C0652z((WebSession) this, new al(C0709k.m3476a().m3502b(PersonalAccount.class)));
        C0800c G = this.f10380b.f.mo1992G();
        JSONArray a = C0611i.m2788a((JSONObject) c0652z.m3056a(G.getId(), G.m4159L()).f2058a, "ui", new JSONArray());
        for (int i = 0; i < a.length(); i++) {
            JSONObject jSONObject = a.getJSONObject(i);
            CharSequence optString = jSONObject.optString("type", "text");
            String optString2 = jSONObject.optString("click", "");
            if (TextUtils.equals(optString, "button")) {
                this.f10381c = optString2;
                return;
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.f10380b.f.mo1994K()) {
        }
    }

    protected void onSessionFailed() {
        if (!this.f10380b.f.mo1994K()) {
        }
    }

    protected void onSessionClosed() {
        super.onSessionClosed();
        this.f10379a.dismiss();
        if (TextUtils.isEmpty(this.f10381c)) {
            ((ReaderFeature) this.f10380b.getContext().queryFeature(ReaderFeature.class)).prompt(this.f10380b.getResources().getString(C0258j.general__shared__network_error));
            return;
        }
        ActivatedController storePageController = new StorePageController(this.f10380b.getContext());
        storePageController.loadUrl(this.f10381c);
        ((ReaderFeature) this.f10380b.getContext().queryFeature(ReaderFeature.class)).showPopup(storePageController);
    }
}
