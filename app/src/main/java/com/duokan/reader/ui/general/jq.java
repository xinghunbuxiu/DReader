package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.duokan.b.b;
import com.duokan.b.g;
import com.duokan.core.app.d;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.t;
import com.duokan.core.ui.f;
import com.duokan.reader.ReaderEnv;

import org.apache.http.HttpStatus;

public class jq extends f {
    private final View a;
    private final TextView b;
    private Animation c = null;
    private Animation d = null;
    private Runnable e = null;
    private Runnable f = null;

    public jq(Context context) {
        super(context);
        this.a = LayoutInflater.from(context).inflate(g.general__waiting_dialog_view, null);
        this.b = (TextView) this.a.findViewById(com.duokan.b.f.general__waiting_dialog_view__text);
        if (ReaderEnv.get().forHd()) {
            this.a.setLayoutParams(new LayoutParams(-2, -2));
            setEnterAnimation(17432576);
            setExitAnimation(17432577);
            setGravity(17);
        } else {
            setEnterAnimation(b.general__shared__push_down_in);
            setExitAnimation(b.general__shared__push_down_out);
            setGravity(80);
        }
        setDimAmount(0.0f);
        this.a.setVisibility(4);
        setContentView(this.a);
        setCancelOnTouchOutside(false);
    }

    public static jq a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return a(context, charSequence, charSequence2, false);
    }

    public static jq a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return a(context, charSequence, charSequence2, z, false, null);
    }

    public static jq a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        return a(context, charSequence, charSequence2, z, z2, null);
    }

    public static jq a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, d dVar) {
        jq jqVar = new jq(context);
        jqVar.a(charSequence2);
        jqVar.setCancelOnBack(z2);
        jqVar.setCancelOnTouchOutside(false);
        jqVar.open(dVar);
        return jqVar;
    }

    public void a(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public void a(boolean z) {
    }

    public void a(int i) {
        this.f = null;
        if (this.e != null) {
            a.c().b(isShowing());
            return;
        }
        super.show();
        this.e = new jr(this);
        t.a(this.e, (long) i);
    }

    public void setEnterAnimation(int i) {
        this.c = AnimationUtils.loadAnimation(getContext(), i);
    }

    public void setExitAnimation(int i) {
        this.d = AnimationUtils.loadAnimation(getContext(), i);
        this.d.setFillAfter(true);
    }

    public void open(d dVar) {
        super.open(dVar);
        show();
    }

    public void show() {
        a((int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    public void dismiss() {
        boolean z = true;
        a c;
        if (!isShowing()) {
            a.c().b(this.e == null);
            c = a.c();
            if (this.f != null) {
                z = false;
            }
            c.b(z);
        } else if (this.f != null) {
            c = a.c();
            if (this.e != null) {
                z = false;
            }
            c.b(z);
        } else if (this.e == null) {
            c = a.c();
            if (this.a.getVisibility() != 0) {
                z = false;
            }
            c.b(z);
            this.a.setVisibility(4);
            this.f = new js(this);
            if (this.d != null) {
                this.d.setAnimationListener(new jt(this));
                this.a.startAnimation(this.d);
                return;
            }
            t.b(this.f);
        } else {
            c = a.c();
            if (this.a.getVisibility() == 0) {
                z = false;
            }
            c.b(z);
            this.e = null;
            super.dismiss();
        }
    }
}
