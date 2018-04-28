package com.duokan.reader.ui.account;

import android.content.Intent;
import android.text.TextUtils;
import com.duokan.core.app.C0286x;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.ui.general.gs;
import com.duokan.reader.ui.general.ja;
import org.apache.http.protocol.HTTP;

public abstract class bp extends gs implements C0286x {
    /* renamed from: a */
    protected WebSession f5806a;
    /* renamed from: b */
    protected String f5807b;
    /* renamed from: c */
    protected String f5808c;
    /* renamed from: d */
    protected String f5809d;
    /* renamed from: e */
    protected String f5810e;
    /* renamed from: f */
    protected String f5811f;
    /* renamed from: g */
    protected boolean f5812g = false;
    /* renamed from: h */
    protected bu f5813h;
    /* renamed from: i */
    private ja f5814i;

    /* renamed from: a */
    protected abstract void mo1570a();

    /* renamed from: a */
    protected abstract void mo1571a(String str);

    public bp(IFeature mFeature, String str, String str2, String str3, String str4, String str5, bu buVar) {
        super(mFeature);
        this.f5807b = str;
        this.f5808c = str2;
        this.f5809d = str3;
        this.f5810e = str4;
        this.f5811f = str5;
        this.f5813h = buVar;
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (super.onRequestDetach(c0303e) && getPopupCount() < 1) {
            requestDetach();
        }
        return true;
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 == RunningState.FOREGROUND) {
            if (this.f5813h != null) {
                this.f5813h.mo1844a(getString(C0258j.share_succeed));
                this.f5813h = null;
            }
            ManagedApp.get().removeOnRunningStateChangedListener(this);
        }
    }

    /* renamed from: b */
    protected void m8881b() {
        m8884d();
        if (this.f5807b.endsWith("weibo") || TextUtils.isEmpty(this.f5809d) || TextUtils.isEmpty(this.f5810e) || TextUtils.isEmpty(this.f5811f) || TextUtils.isEmpty(this.f5808c)) {
            mo1570a();
        } else {
            m8883c();
        }
    }

    /* renamed from: c */
    protected void m8883c() {
        String str;
        ManagedApp.get().addOnRunningStateChangedListener(this);
        if (TextUtils.isEmpty(this.f5811f)) {
            str = " ";
        } else {
            str = this.f5811f;
        }
        m8880a(str, new bq(this));
    }

    /* renamed from: a */
    protected void m8880a(String str, bt btVar) {
        this.f5806a = new br(this, C0643q.f2173a, str, btVar);
        this.f5806a.open();
    }

    /* renamed from: b */
    protected void m8882b(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setFlags(268435456);
        getContext().startActivity(Intent.createChooser(intent, getContext().getString(C0258j.upload_ok)));
    }

    /* renamed from: d */
    protected void m8884d() {
        if (this.f5814i == null) {
            this.f5814i = new ja(getActivity());
            this.f5814i.setCancelOnBack(true);
            this.f5814i.setCancelOnTouchOutside(false);
            this.f5814i.m10843a(getActivity().getString(C0258j.general__shared__hard_working));
        }
        if (!this.f5814i.isShowing()) {
            this.f5814i.open(new bs(this));
        }
    }

    /* renamed from: e */
    protected void m8885e() {
        if (this.f5814i != null && this.f5814i.isShowing()) {
            this.f5814i.dismiss();
        }
    }
}
