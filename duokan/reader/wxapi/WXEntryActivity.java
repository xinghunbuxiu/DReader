package com.duokan.reader.wxapi;

import android.app.Activity;
import android.os.Bundle;

import com.duokan.reader.DkReader;
import com.duokan.reader.domain.account.i;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DkReader.get().runWhenAppReady(new a(this));
    }

    public void onReq(BaseReq baseReq) {
        finish();
    }

    public void onResp(BaseResp baseResp) {
        if (baseResp instanceof Resp) {
            i.f().a((Resp) baseResp);
        }
        finish();
    }

    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(0, 0);
    }
}
