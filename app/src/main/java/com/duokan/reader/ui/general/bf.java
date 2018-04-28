package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.bd;

public abstract class bf extends FrameLayout {
    /* renamed from: a */
    protected final eq f6773a;
    /* renamed from: b */
    protected final gl f6774b;
    /* renamed from: c */
    protected final ImageView f6775c;
    /* renamed from: d */
    protected final ImageView f6776d;
    /* renamed from: e */
    private String f6777e = null;
    /* renamed from: f */
    private String f6778f = null;

    /* renamed from: a */
    protected abstract ImageView mo1731a(Context context);

    protected abstract int getAnonymousAccountDefaultFaceRes();

    protected abstract int getMiAccountDefaultFaceRes();

    public bf(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet);
        this.f6774b = new gl(context);
        this.f6775c = mo1731a(context);
        this.f6773a = new eq(this.f6774b);
        this.f6776d = new ImageView(getContext());
        this.f6776d.setBackgroundDrawable(this.f6773a);
        addView(this.f6776d, new LayoutParams(i, i2, 17));
        addView(this.f6775c, new LayoutParams(-2, -2, 85));
        this.f6775c.setVisibility(4);
    }

    public void setDefaultPic(int i) {
        this.f6774b.m10713a(i);
    }

    public void setDefaultPic(Drawable drawable) {
        this.f6774b.m10722b(drawable);
    }

    public void setUser(User user) {
        this.f6777e = user.mUserId;
        this.f6778f = user.mIconUrl;
        if (user.mIsVip) {
            this.f6775c.setVisibility(0);
        } else {
            this.f6775c.setVisibility(4);
        }
        m9928b();
    }

    /* renamed from: a */
    public void m9930a() {
        this.f6777e = null;
        this.f6778f = null;
        this.f6775c.setVisibility(4);
        m9928b();
    }

    public void setUserIconUsingLocalImage(String str) {
        if (!str.startsWith("file://")) {
            str = "file://" + str;
        }
        this.f6778f = str;
        m9928b();
    }

    public void setMiAccount(C0672a c0672a) {
        try {
            if (c0672a instanceof PersonalAccount) {
                setUser(((PersonalAccount) c0672a).m3274s().f5458a);
            } else if (c0672a instanceof UserAccount) {
                setUser(((UserAccount) c0672a).mo849s().f5458a);
            }
        } catch (Throwable th) {
        }
        m9928b();
    }

    /* renamed from: b */
    private void m9928b() {
        if (TextUtils.isEmpty(this.f6777e)) {
            this.f6774b.m10713a(getAnonymousAccountDefaultFaceRes());
            this.f6774b.m10720a(this.f6778f);
        } else if (DkPublic.isXiaomiId(this.f6777e)) {
            this.f6774b.m10713a(getMiAccountDefaultFaceRes());
            this.f6774b.m10720a(DkPublic.isXiaomiGuestId(this.f6777e) ? this.f6778f : bd.m3401a(this.f6778f, 150));
        } else {
            setDefaultPic(getAnonymousAccountDefaultFaceRes());
            this.f6774b.m10720a(this.f6778f);
        }
    }
}
