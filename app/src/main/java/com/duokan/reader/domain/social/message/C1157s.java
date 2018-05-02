package com.duokan.reader.domain.social.message;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;

/* renamed from: com.duokan.reader.domain.social.message.s */
class C1157s implements C1140y {
    /* renamed from: a */
    final /* synthetic */ C1156r f5582a;

    C1157s(C1156r c1156r) {
        this.f5582a = c1156r;
    }

    /* renamed from: a */
    public void mo1519a(boolean z) {
        this.f5582a.f5574b.f5571a.mo1521a(z, false);
        this.f5582a.f5574b.f5572b.f5569g = this.f5582a.f5577e;
        ReaderEnv.get().setPrefString(PrivatePref.PERSONAL, "latest_unread_message_threshold_pref_" + this.f5582a.f5573a.f2362c, this.f5582a.f5574b.f5572b.f5569g);
    }
}
