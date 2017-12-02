package com.duokan.reader.ui.general;

import android.content.Context;

import com.duokan.b.c;
import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.core.app.ae;
import com.duokan.core.app.af;
import com.duokan.core.app.ag;

public class ap extends ak implements ab, ad, af {
    private int a = -1;
    private int b = -1;
    private String c = null;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private String g = null;
    private ae h = null;
    private ac i = null;
    private ag j = null;

    public ap(Context context) {
        super(context);
    }

    public final void setOkLabel(int i) {
        this.b = i;
    }

    public final void setOkLabel(String str) {
        this.c = str;
    }

    public final void setNoLabel(int i) {
        this.d = addButtonView(getContext().getString(i), getContext().getResources().getColor(c.general__shared__c6));
    }

    public final void setCancelLabel(int i) {
        this.f = i;
    }

    public final void setCancelLabel(String str) {
        this.g = str;
    }

    public void open(ae aeVar) {
        if (!isOpened()) {
            setCancelOnBack(false);
            setCancelOnTouchOutside(false);
            this.h = aeVar;
            show();
        }
    }

    public void open(ac acVar) {
        if (!isOpened()) {
            setCancelOnBack(true);
            setCancelOnTouchOutside(false);
            this.i = acVar;
            show();
        }
    }

    public void open(ag agVar) {
        if (!isOpened()) {
            this.j = agVar;
            show();
        }
    }

    protected void onButtonClicked(int i) {
        if (!isShowing()) {
            return;
        }
        if (i == this.a) {
            onOk();
            notifyOk();
            dismiss();
        } else if (i == this.d) {
            onNo();
            notifyNo();
            dismiss();
        } else if (i == this.e) {
            cancel();
        }
    }

    protected void onCancel() {
        notifyCancel();
        super.onCancel();
        this.h = null;
        this.i = null;
        this.j = null;
    }

    public void show() {
        if (-1 != this.f) {
            this.e = addButtonView(getContext().getString(this.f), getContext().getResources().getColor(c.general__shared__c6));
        } else if (this.g != null) {
            this.e = addButtonView(this.g, getContext().getResources().getColor(c.general__shared__c6));
        }
        if (-1 != this.b) {
            this.a = addButtonView(getContext().getString(this.b), getContext().getResources().getColor(c.general__shared__c1));
        } else if (this.c != null) {
            this.a = addButtonView(this.c, getContext().getResources().getColor(c.general__shared__c1));
        }
        super.show();
    }

    private void notifyOk() {
        if (this.h != null) {
            this.h.onOk(this);
        }
        if (this.i != null) {
            this.i.a(this);
        }
        if (this.j != null) {
            this.j.a(this);
        }
    }

    private void notifyNo() {
        if (this.j != null) {
            this.j.b(this);
        }
    }

    private void notifyCancel() {
        if (this.i != null) {
            this.i.b(this);
        }
        if (this.j != null) {
            this.j.c(this);
        }
    }

    protected void onOk() {
    }

    protected void onNo() {
    }
}
