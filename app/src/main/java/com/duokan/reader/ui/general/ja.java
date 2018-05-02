package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.duokan.core.app.OnCancelListener;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.C0343f;
import com.duokan.p023b.C0240b;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ReaderEnv;
import org.apache.http.HttpStatus;

public class ja extends C0343f {
    /* renamed from: a */
    private final View f7422a;
    /* renamed from: b */
    private final TextView f7423b;
    /* renamed from: c */
    private Animation f7424c = null;
    /* renamed from: d */
    private Animation f7425d = null;
    /* renamed from: e */
    private Runnable f7426e = null;
    /* renamed from: f */
    private Runnable f7427f = null;

    public ja(Context context) {
        super(context);
        this.f7422a = LayoutInflater.from(context).inflate(C0245g.general__waiting_dialog_view, null);
        this.f7423b = (TextView) this.f7422a.findViewById(C0244f.general__waiting_dialog_view__text);
        if (ReaderEnv.get().forHd()) {
            this.f7422a.setLayoutParams(new LayoutParams(-2, -2));
            setEnterAnimation(17432576);
            setExitAnimation(17432577);
            setGravity(17);
        } else {
            setEnterAnimation(C0240b.general__shared__push_down_in);
            setExitAnimation(C0240b.general__shared__push_down_out);
            setGravity(80);
        }
        setDimAmount(0.0f);
        this.f7422a.setVisibility(4);
        setContentView(this.f7422a);
        setCancelOnTouchOutside(false);
    }

    /* renamed from: a */
    public static ja m10830a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return m10831a(context, charSequence, charSequence2, false);
    }

    /* renamed from: a */
    public static ja m10831a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return m10833a(context, charSequence, charSequence2, z, false, null);
    }

    /* renamed from: a */
    public static ja m10832a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        return m10833a(context, charSequence, charSequence2, z, z2, null);
    }

    /* renamed from: a */
    public static ja m10833a(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, OnCancelListener onCancelListener) {
        ja jaVar = new ja(context);
        jaVar.m10843a(charSequence2);
        jaVar.setCancelOnBack(z2);
        jaVar.setCancelOnTouchOutside(false);
        jaVar.open(onCancelListener);
        return jaVar;
    }

    /* renamed from: a */
    public void m10843a(CharSequence charSequence) {
        this.f7423b.setText(charSequence);
    }

    /* renamed from: a */
    public void m10844a(boolean z) {
    }

    /* renamed from: a */
    public void m10842a(int i) {
        this.f7427f = null;
        if (this.f7426e != null) {
            WebLog.init().w(isShowing());
            return;
        }
        super.show();
        this.f7426e = new jb(this);
        UThread.postDelayed(this.f7426e, (long) i);
    }

    public void setEnterAnimation(int i) {
        this.f7424c = AnimationUtils.loadAnimation(getContext(), i);
    }

    public void setExitAnimation(int i) {
        this.f7425d = AnimationUtils.loadAnimation(getContext(), i);
        this.f7425d.setFillAfter(true);
    }

    public void open(OnCancelListener onCancelListener) {
        super.open(onCancelListener);
        show();
    }

    public void show() {
        m10842a((int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    public void dismiss() {
        boolean z = true;
        WebLog c;
        if (!isShowing()) {
            WebLog.init().w(this.f7426e == null);
            c = WebLog.init();
            if (this.f7427f != null) {
                z = false;
            }
            c.w(z);
        } else if (this.f7427f != null) {
            c = WebLog.init();
            if (this.f7426e != null) {
                z = false;
            }
            c.w(z);
        } else if (this.f7426e == null) {
            c = WebLog.init();
            if (this.f7422a.getVisibility() != 0) {
                z = false;
            }
            c.w(z);
            this.f7422a.setVisibility(4);
            this.f7427f = new jc(this);
            if (this.f7425d != null) {
                this.f7425d.setAnimationListener(new jd(this));
                this.f7422a.startAnimation(this.f7425d);
                return;
            }
            UThread.post(this.f7427f);
        } else {
            c = WebLog.init();
            if (this.f7422a.getVisibility() == 0) {
                z = false;
            }
            c.w(z);
            this.f7426e = null;
            super.dismiss();
        }
    }
}
