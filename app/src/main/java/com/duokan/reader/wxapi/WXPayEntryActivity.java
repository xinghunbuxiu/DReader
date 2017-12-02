package com.duokan.reader.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.duokan.reader.DkReader;
import com.duokan.reader.domain.payment.PaymentManager;
import com.duokan.reader.domain.payment.t;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DkReader.get().runWhenAppReady(new b(this));
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a.handleIntent(intent, this);
    }

    public void onReq(BaseReq baseReq) {
    }

    public void onResp(BaseResp baseResp) {
        t c = PaymentManager.a().c();
        if (c != null) {
            c.a(baseResp);
        }
        finish();
    }
}
