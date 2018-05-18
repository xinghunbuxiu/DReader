package com.duokan.reader.ui.general;

import android.content.Context;
import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.core.app.ae;
import com.duokan.core.app.af;
import com.duokan.core.app.ag;
import com.duokan.core.app.ah;
import com.duokan.p023b.C0241c;

public class ap extends ak implements ac, ae, ag {
    
    private int f603a = -1;
    
    private int okLabelResid = -1;
    
    private String okLabelStr = null;
    
    private int f606d = -1;
    
    private int f607e = -1;
    
    private int f608f = -1;
    
    private String f609g = null;
    
    private af f610h = null;
    
    private ad f611i = null;
    
    private ah f612j = null;

    public ap(Context context) {
        super(context);
    }

    public final void setOkLabelResid(int resid) {
        this.okLabelResid = resid;
    }

    public final void setOkLabel(String okLabel) {
        this.okLabelStr = okLabel;
    }

    public final void setNoLabel(int resid) {
        this.f606d = addButtonView(getContext().getString(resid), getContext().getResources().getColor(C0241c.general__shared__c6));
    }

    public final void setNoLabel(String str) {
        this.f606d = addButtonView(str, getContext().getResources().getColor(C0241c.general__shared__c6));
    }

    public final void setCancelLabel(int i) {
        this.f608f = i;
    }

    public final void setCancelLabel(String str) {
        this.f609g = str;
    }

    public void open(af afVar) {
        if (!isOpened()) {
            setCancelOnBack(false);
            setCancelOnTouchOutside(false);
            this.f610h = afVar;
            show();
        }
    }

    public void open(ad adVar) {
        if (!isOpened()) {
            setCancelOnBack(true);
            setCancelOnTouchOutside(false);
            this.f611i = adVar;
            show();
        }
    }

    public void open(ah ahVar) {
        if (!isOpened()) {
            this.f612j = ahVar;
            show();
        }
    }

    protected void onButtonClicked(int i) {
        if (!isShowing()) {
            return;
        }
        if (i == this.f603a) {
            onOk();
            notifyOk();
            dismiss();
        } else if (i == this.f606d) {
            onNo();
            notifyNo();
            dismiss();
        } else if (i == this.f607e) {
            cancel();
        }
    }

    protected void onCancel() {
        notifyCancel();
        super.onCancel();
        this.f610h = null;
        this.f611i = null;
        this.f612j = null;
    }

    public void show() {
        if (-1 != this.f608f) {
            this.f607e = addButtonView(getContext().getString(this.f608f), getContext().getResources().getColor(C0241c.general__shared__c6));
        } else if (this.f609g != null) {
            this.f607e = addButtonView(this.f609g, getContext().getResources().getColor(C0241c.general__shared__c6));
        }
        if (-1 != this.okLabelResid) {
            this.f603a = addButtonView(getContext().getString(this.okLabelResid), getContext().getResources().getColor(C0241c.general__shared__c1));
        } else if (this.okLabelStr != null) {
            this.f603a = addButtonView(this.okLabelStr, getContext().getResources().getColor(C0241c.general__shared__c1));
        }
        super.show();
    }

    private void notifyOk() {
        if (this.f610h != null) {
            this.f610h.onOk(this);
        }
        if (this.f611i != null) {
            this.f611i.mo1553a(this);
        }
        if (this.f612j != null) {
            this.f612j.mo1562a(this);
        }
    }

    private void notifyNo() {
        if (this.f612j != null) {
            this.f612j.mo1567b(this);
        }
    }

    private void notifyCancel() {
        if (this.f611i != null) {
            this.f611i.mo1554b(this);
        }
        if (this.f612j != null) {
            this.f612j.mo1565c(this);
        }
    }

    protected void onOk() {
    }

    protected void onNo() {
    }
}
