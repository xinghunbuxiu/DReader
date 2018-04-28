package com.duokan.reader.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.duokan.reader.DkReader;
import com.duokan.reader.domain.payment.C1104t;
import com.duokan.reader.domain.payment.PaymentManager;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    /* renamed from: a */
    private IWXAPI f11629a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DkReader.get().runWhenAppReady(new C1559b(this));
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f11629a.handleIntent(intent, this);
    }

    public void onReq(BaseReq baseReq) {
    }

    public void onResp(BaseResp baseResp) {
        C1104t c = PaymentManager.m8331a().m8354c();
        if (c != null) {
            c.mo1510a(baseResp);
        }
        finish();
    }
}
