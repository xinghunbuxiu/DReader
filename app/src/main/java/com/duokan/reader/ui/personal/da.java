package com.duokan.reader.ui.personal;

import android.content.Intent;
import android.net.Uri;
import com.duokan.core.sys.p025a.IPermissionsResultListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import java.io.File;

class da implements IPermissionsResultListener {
    /* renamed from: a */
    final /* synthetic */ ct f8444a;

    da(ct ctVar) {
        this.f8444a = ctVar;
    }

    public void onSuccess() {
        new File(this.f8444a.f8427e).getParentFile().mkdirs();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(new File(this.f8444a.f8427e)));
        if (DkPublic.isIntentAvailable(this.f8444a.f8423a.getBaseContext(), intent)) {
            this.f8444a.f8423a.startActivityForResult(intent, this.f8444a.f8424b);
        } else {
            this.f8444a.f8428f.mo1895a(this.f8444a.f8423a.getString(C0258j.general__unsupported_intent));
        }
    }

    public void onFail() {
    }
}
