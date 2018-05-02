package com.duokan.common;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.sys.p025a.IPermissionsResultListener;

/* renamed from: com.duokan.common.l */
final class C0271l implements IPermissionsResultListener {
    /* renamed from: a */
    final /* synthetic */ String f455a;
    /* renamed from: b */
    final /* synthetic */ String f456b;
    /* renamed from: c */
    final /* synthetic */ BaseActivity f457c;

    C0271l(String str, String str2, BaseActivity mActivity) {
        this.f455a = str;
        this.f456b = str2;
        this.f457c = mActivity;
    }

    public void onSuccess() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("smsto:" + this.f455a));
            if (!TextUtils.isEmpty(this.f456b)) {
                intent.putExtra("sms_body", this.f456b);
            }
            this.f457c.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFail() {
    }
}
