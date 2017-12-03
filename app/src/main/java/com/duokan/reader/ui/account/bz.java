package com.duokan.reader.ui.account;

import android.content.Intent;
import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.core.app.IActivityRunStatusChanged;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.ui.general.hd;
import com.duokan.reader.ui.general.jq;

import org.apache.http.protocol.HTTP;

public abstract class bz extends hd implements IActivityRunStatusChanged {
    protected r a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected boolean g = false;
    protected ce h;
    private jq i;

    protected abstract void a();

    protected abstract void a(String str);

    public bz(IFeature featrue, String str, String str2, String str3, String str4, String str5, ce ceVar) {
        super(featrue);
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.h = ceVar;
    }

    protected boolean onRequestDetach(ActivatedController activatedControllerVar) {
        if (super.onRequestDetach(activatedControllerVar) && getPopupCount() < 1) {
            requestDetach();
        }
        return true;
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 == RunningState.FOREGROUND) {
            if (this.h != null) {
                this.h.a(getString(j.share_succeed));
                this.h = null;
            }
            ManagedApp.get().removeOnRunningStateChangedListener(this);
        }
    }

    protected void b() {
        d();
        if (this.b.endsWith("sina") || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.c)) {
            a();
        } else {
            c();
        }
    }

    protected void c() {
        String str;
        ManagedApp.get().addOnRunningStateChangedListener(this);
        if (TextUtils.isEmpty(this.f)) {
            str = " ";
        } else {
            str = this.f;
        }
        a(str, new ca(this));
    }

    private void a(String str, cd cdVar) {
        this.a = new cb(this, str, cdVar);
        this.a.open();
    }

    protected void b(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setFlags(268435456);
        getContext().startActivity(Intent.createChooser(intent, getContext().getString(j.upload_ok)));
    }

    protected void d() {
        if (this.i == null) {
            this.i = new jq(getActivity());
            this.i.setCancelOnBack(true);
            this.i.setCancelOnTouchOutside(false);
            this.i.a(getActivity().getString(j.general__shared__hard_working));
        }
        if (!this.i.isShowing()) {
            this.i.open(new cc(this));
        }
    }

    protected void e() {
        if (this.i != null && this.i.isShowing()) {
            this.i.dismiss();
        }
    }
}
