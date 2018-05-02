package com.duokan.reader.ui.surfing;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.personal.ae;
import com.duokan.reader.ui.personal.bg;
import com.duokan.reader.ui.personal.ck;
import com.duokan.reader.ui.personal.it;
import com.duokan.reader.ui.personal.kg;
import com.duokan.reader.ui.personal.mh;
import com.duokan.reader.ui.store.bv;
import com.mipay.sdk.Mipay;

class ab implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ f d;

    ab(f fVar, String str, boolean z, Runnable runnable) {
        this.d = fVar;
        this.a = str;
        this.b = z;
        this.c = runnable;
    }

    public void run() {
        int indexOf = this.a.indexOf(47);
        if (indexOf >= 0 && indexOf < this.a.length() - 1) {
            if (this.a.substring(indexOf + 1).startsWith(Mipay.KEY_MESSAGE)) {
                if (this.a.substring(indexOf + 1).substring(Mipay.KEY_MESSAGE.length()).equals("/feed")) {
                    a(null, new ck(this.d.getContext(), true), this.b, true, this.c);
                } else if (this.a.substring(indexOf + 1).substring(Mipay.KEY_MESSAGE.length()).equals("/notification")) {
                    a(null, new ck(this.d.getContext(), false), this.b, true, this.c);
                } else {
                    a(null, new ck(this.d.getContext(), false), this.b, true, this.c);
                }
            } else if (this.a.substring(indexOf + 1).equals("favourite")) {
                a(MiAccount.class, bv.a(this.d.getContext()), this.b, false, this.c);
            } else if (this.a.substring(indexOf + 1).equals("coupons")) {
                a(PersonalAccount.class, bv.c(this.d.getContext()), this.b, false, this.c);
            } else if (this.a.substring(indexOf + 1).equals("cash")) {
                a(PersonalAccount.class, bv.d(this.d.getContext()), this.b, false, this.c);
            } else if (this.a.substring(indexOf + 1).equals("reward")) {
                a(PersonalAccount.class, bv.e(this.d.getContext()), this.b, false, this.c);
            } else if (this.a.substring(indexOf + 1).equals("feedback")) {
                a(MiAccount.class, new bg(this.d.getContext(), false), this.b, false, this.c);
            } else if (this.a.substring(indexOf + 1).equals("task")) {
                if (!ReaderEnv.get().getPrefBoolean(PrivatePref.PERSONAL, "is_in_task_page", false)) {
                    if (this.b) {
                        this.d.a(this.c);
                        return;
                    }
                    this.d.j();
                    if (this.c != null) {
                        this.c.run();
                    }
                }
            } else if (this.a.substring(indexOf + 1).equals("purchased")) {
                if (i.f().c() == null || i.f().c().i()) {
                    r2 = new kg(this.d.getContext());
                } else {
                    r2 = new ae(this.d.getContext());
                }
                a(PersonalAccount.class, r2, this.b, false, this.c);
            } else if (this.a.substring(indexOf + 1).equals("notes")) {
                if (i.f().c() == null || i.f().c().i()) {
                    r2 = new StorePageController(this.d.getContext());
                    r2.loadUrl(p.i().I());
                } else {
                    r2 = new mh(this.d.getContext());
                }
                a(PersonalAccount.class, r2, this.b, false, this.c);
            } else if (this.a.substring(indexOf + 1).equals("settings")) {
                a(new it(this.d.getContext()), this.b, false, this.c);
            }
        }
    }

    private void a(Class cls, ActivatedController activatedControllerVar, boolean z, boolean z2, Runnable runnable) {
        if (cls == null) {
            a(activatedControllerVar, z, z2, runnable);
        } else {
            i.f().a(cls, new ac(this, activatedControllerVar, z, z2, runnable));
        }
    }

    private void a(ActivatedController activatedControllerVar, boolean z, boolean z2, Runnable runnable) {
        if (!z) {
            if (z2) {
                ((ReaderFeature) this.d.getContext().queryFeature(ReaderFeature.class)).pushHalfPage(activatedControllerVar);
            } else {
                ((ReaderFeature) this.d.getContext().queryFeature(ReaderFeature.class)).pushPage(activatedControllerVar);
            }
            TaskHandler.PostTask(runnable);
        } else if (z2) {
            ((ReaderFeature) this.d.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(activatedControllerVar, runnable);
        } else {
            ((ReaderFeature) this.d.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(activatedControllerVar, runnable);
        }
    }
}
