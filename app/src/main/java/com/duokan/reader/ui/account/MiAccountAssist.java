package com.duokan.reader.ui.account;

import android.content.Context;

import com.duokan.c.j;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.MiGuestAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;
import com.duokan.reader.domain.account.bf;
import com.duokan.reader.domain.account.bg;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.general.jq;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.general.web.cg;

import java.util.LinkedList;

public class MiAccountAssist implements ah, bf {
    private static final ai a = new ai();
    private final Context b;
    private final i c;
    private final LinkedList d = new LinkedList();

    public class MergeAccountController extends StorePageController {
        private final a mAccount;
        private boolean mFinished = false;
        private final b mLoginListener;

        public MergeAccountController(IFeature featrue, a aVar, b bVar) {
            super(featrue);
            this.mAccount = aVar;
            this.mLoginListener = bVar;
        }

        protected void onDetachFromStub() {
            super.onDetachFromStub();
            if (!this.mFinished) {
                this.mFinished = true;
                if (this.mLoginListener != null) {
                    this.mLoginListener.a(this.mAccount, "");
                }
            }
        }

        protected jq initWaitingDialog() {
            jq jqVar = new jq(getContext());
            jqVar.a(getString(j.account__shared__duokan_logging_in));
            return jqVar;
        }

        protected cg newJavascriptImpl() {
            return new i();
        }
    }

    private MiAccountAssist(Context context, i iVar) {
        this.b = context;
        this.c = iVar;
        MiAccount.a((bf) this);
        MiGuestAccount.a((bf) this);
    }

    public static void a(Context context, i iVar) {
        a.a(new MiAccountAssist(context, iVar));
    }

    public void b(a aVar, b bVar) {
        c(aVar, bVar);
    }

    public void a(a aVar, b bVar) {
        this.d.add(bVar);
        if (this.d.size() <= 1) {
            if (!f.b().e()) {
                a(aVar, this.b.getString(j.report_no_network_error));
            } else if (MiAccount.a(this.b)) {
                ((MiAccount) aVar).a(new a(this), 0);
            } else {
                a(aVar, "");
            }
        }
    }

    public void a(MiAccount miAccount, b bVar) {
        this.d.add(bVar);
        if (!f.b().e()) {
            a((a) miAccount, this.b.getString(j.report_no_network_error));
        } else if (MiAccount.a(this.b)) {
            jq jqVar = new jq(DkApp.get().getTopActivity());
            jqVar.a(this.b.getString(j.account__shared__duokan_logging_in));
            jqVar.a(true);
            jqVar.setCancelOnBack(false);
            jqVar.setCancelOnTouchOutside(false);
            jqVar.show();
            miAccount.a(new b(this, jqVar), 0);
        } else {
            a((a) miAccount, "");
        }
    }

    public void b(MiAccount miAccount, b bVar) {
        this.d.add(bVar);
        if (f.b().e()) {
            try {
                com.duokan.reader.domain.statistics.a.k().b("login", "mi_account", "login_local");
            } catch (Throwable th) {
            }
            miAccount.e(new c(this));
            return;
        }
        a((a) miAccount, this.b.getString(j.report_no_network_error));
    }

    private void c(a aVar, b bVar) {
        this.d.add(bVar);
        if (this.d.size() <= 1) {
            if (f.b().e()) {
                MiAccount miAccount = (MiAccount) aVar;
                if (miAccount.n()) {
                    a(miAccount);
                    return;
                } else {
                    b(miAccount);
                    return;
                }
            }
            a(aVar, this.b.getString(j.report_no_network_error));
        }
    }

    private void a(MiAccount miAccount) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            a((a) miAccount, "");
            return;
        }
        jq jqVar = new jq(topActivity);
        jqVar.a(this.b.getString(j.account__shared__duokan_logging_in));
        jqVar.a(true);
        jqVar.setCancelOnBack(false);
        jqVar.setCancelOnTouchOutside(false);
        jqVar.show();
        miAccount.f(new d(this, jqVar, topActivity));
    }

    private void b(MiAccount miAccount) {
        miAccount.g(new ActivatedController(this));
    }

    private void a(a aVar) {
        TaskHandler.a(new f(this, aVar));
    }

    private void a(a aVar, String str) {
        TaskHandler.postTask(new g(this, aVar, str));
    }

    private boolean a(a aVar, boolean z) {
        return a(aVar, z, new h(this));
    }

    public boolean a(a aVar, boolean z, bg bgVar) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null) {
            return false;
        }
        IFeature a = MyContextWrapper.getFeature(topActivity);
        if (a == null) {
            return false;
        }
        ReaderFeature readerFeature = (ReaderFeature) a.queryFeature(ReaderFeature.class);
        if (readerFeature == null) {
            return false;
        }
        ActivatedController mergeAccountController = new MergeAccountController(a, aVar, bgVar);
        mergeAccountController.loadUrl(p.i().L() + (z ? "&autoLogin=1" : ""));
        readerFeature.showPopup(mergeAccountController);
        return true;
    }
}
