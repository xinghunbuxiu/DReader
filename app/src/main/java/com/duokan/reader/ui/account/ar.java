package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import cn.kuaipan.android.utils.Base64;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ManagedApp;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.general.be;

public class ar extends bp {
    /* renamed from: i */
    private final String f5815i;
    /* renamed from: j */
    private final String f5816j;
    /* renamed from: k */
    private final String f5817k;
    /* renamed from: l */
    private bu f5818l;

    public ar(AppContext appContext, String str, String str2, String str3, String str4, bu buVar) {
        super(appContext, str, "", "", str4, str2, buVar);
        this.f5815i = str;
        this.f5816j = str2;
        this.f5817k = str3;
        this.f5818l = buVar;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            m8884d();
            m8891f();
        }
    }

    /* renamed from: a */
    protected void mo1571a(String str) {
    }

    /* renamed from: a */
    protected void mo1570a() {
    }

    /* renamed from: f */
    private void m8891f() {
        ManagedApp.get().addOnRunningStateChangedListener(this);
        if (TextUtils.isEmpty(this.f5816j)) {
            m8892g();
        } else {
            m8880a(this.f5816j, new as(this));
        }
    }

    /* renamed from: a */
    private void m8886a(Bitmap bitmap) {
        String str = this.f5815i;
        Object obj = -1;
        switch (str.hashCode()) {
            case -478408322:
                if (str.equals("weixin_timeline")) {
                    obj = 2;
                    break;
                }
                break;
            case 113011944:
                if (str.equals("weibo")) {
                    obj = null;
                    break;
                }
                break;
            case 1157722907:
                if (str.equals("weixin_friend")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                m8889b(bitmap);
                return;
            default:
                m8890c(bitmap);
                return;
        }
    }

    /* renamed from: b */
    private void m8889b(Bitmap bitmap) {
        bd atVar = new at(this, getActivity(), "", "", "", this.f5818l, bitmap);
        atVar.setOnShowListener(new av(this));
        atVar.show();
    }

    /* renamed from: c */
    private void m8890c(Bitmap bitmap) {
        ThirdWeiXin thirdWeiXin = new ThirdWeiXin();
        boolean equals = this.f5815i.equals("weixin_timeline");
        if (!equals || TextUtils.isEmpty(this.e)) {
            thirdWeiXin.share("", this.e, "", bitmap, false, equals);
        } else {
            thirdWeiXin.shareWithSummary(bitmap, this.e);
        }
        m8885e();
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    /* renamed from: g */
    private void m8892g() {
        if (TextUtils.isEmpty(this.f5817k)) {
            m8893h();
        }
        try {
            byte[] decode = Base64.decode(this.f5817k, 0);
            m8886a(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        } catch (Throwable th) {
            m8893h();
        }
    }

    /* renamed from: h */
    private void m8893h() {
        CharSequence string = getString(C0258j.gen_bitmap_fail);
        if (this.f5818l != null) {
            this.f5818l.mo1845b(string);
            this.f5818l = null;
            return;
        }
        be.m10287a(getContext(), string, 0).show();
    }
}
