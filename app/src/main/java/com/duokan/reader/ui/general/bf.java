package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.bh;

public abstract class bf extends FrameLayout {
    protected final es a;
    protected final gw b;
    protected final ImageView c;
    protected final ImageView d;
    private String e = null;
    private String f = null;

    protected abstract ImageView a(Context context);

    protected abstract int getAnonymousAccountDefaultFaceRes();

    protected abstract int getMiAccountDefaultFaceRes();

    public bf(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet);
        this.b = new gw(context);
        this.c = a(context);
        this.a = new es(this.b);
        this.d = new ImageView(getContext());
        this.d.setBackgroundDrawable(this.a);
        addView(this.d, new LayoutParams(i, i2, 17));
        addView(this.c, new LayoutParams(-2, -2, 85));
        this.c.setVisibility(4);
    }

    public void setDefaultPic(int i) {
        this.b.a(i);
    }

    public void setDefaultPic(Drawable drawable) {
        this.b.b(drawable);
    }

    public void setUser(User user) {
        this.e = user.mUserId;
        this.f = user.mIconUrl;
        if (user.mIsVip) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(4);
        }
        b();
    }

    public void a() {
        this.e = null;
        this.f = null;
        this.c.setVisibility(4);
        b();
    }

    public void setUserIconUsingLocalImage(String str) {
        if (!str.startsWith("file://")) {
            str = "file://" + str;
        }
        this.f = str;
        b();
    }

    public void setMiAccount(a aVar) {
        try {
            if (aVar instanceof PersonalAccount) {
                setUser(((PersonalAccount) aVar).s().a);
            } else if (aVar instanceof UserAccount) {
                setUser(((UserAccount) aVar).s().a);
            }
        } catch (Throwable th) {
        }
        b();
    }

    private void b() {
        if (TextUtils.isEmpty(this.e)) {
            this.b.a(getAnonymousAccountDefaultFaceRes());
            this.b.a(this.f);
        } else if (DkPublic.isXiaomiId(this.e)) {
            this.b.a(getMiAccountDefaultFaceRes());
            this.b.a(DkPublic.isXiaomiGuestId(this.e) ? this.f : bh.a(this.f, 150));
        } else {
            setDefaultPic(getAnonymousAccountDefaultFaceRes());
            this.b.a(this.f);
        }
    }
}
