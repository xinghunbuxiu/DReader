package com.duokan.reader.wxapi;

import android.app.Activity;
import android.os.Bundle;
import com.duokan.reader.DkReader;
import com.duokan.reader.domain.account.C0709k;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth$Resp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    /* renamed from: a */
    private IWXAPI f11628a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DkReader.get().runWhenAppReady(new C1558a(this));
    }

    public void onReq(BaseReq baseReq) {
        finish();
    }

    public void onResp(BaseResp baseResp) {
        if (baseResp instanceof SendAuth$Resp) {
            C0709k.m3476a().m3496a((SendAuth$Resp) baseResp);
        }
        finish();
    }

    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(0, 0);
    }
}
