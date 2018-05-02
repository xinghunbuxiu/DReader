package com.duokan.common;

import android.content.Intent;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.sys.p025a.IPermissionsResultListener;

/* renamed from: com.duokan.common.k */
final class C0270k implements IPermissionsResultListener {
    /* renamed from: a */
    final /* synthetic */ String f453a;
    /* renamed from: b */
    final /* synthetic */ BaseActivity f454b;

    C0270k(String str, BaseActivity mActivity) {
        this.f453a = str;
        this.f454b = mActivity;
    }

    public void onSuccess() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("sms_body", this.f453a);
            intent.setType("vnd.android-dir/mms-sms");
            this.f454b.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFail() {
    }
}
