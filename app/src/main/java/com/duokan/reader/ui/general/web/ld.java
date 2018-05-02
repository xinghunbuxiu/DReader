package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.as;
import com.mipay.sdk.Mipay;
import org.json.JSONObject;

class ld implements as {
    /* renamed from: a */
    final /* synthetic */ String f8137a;
    /* renamed from: b */
    final /* synthetic */ lc f8138b;

    ld(lc lcVar, String str) {
        this.f8138b = lcVar;
        this.f8137a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f8137a);
        if (jSONObject.optInt(Mipay.KEY_RESULT) != 0) {
            WebLog.init().c(LogLevel.ERROR, "tts_payment", "purchase_failed");
            this.f8138b.f8136a.val$payResult[0] = "0";
        } else {
            this.f8138b.f8136a.val$payResult[1] = jSONObject.optString("trans_id");
            if (TextUtils.isEmpty(this.f8138b.f8136a.val$payResult[1])) {
                WebLog.init().c(LogLevel.ERROR, "tts_payment", "empty_trans_id");
                this.f8138b.f8136a.val$payResult[0] = "0";
            }
        }
        this.f8138b.f8136a.val$purchaseSession.open();
    }
}
