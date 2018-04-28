package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.duokan.p023b.C0243e;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.bd;

public class DkGeneralFaceView extends FrameLayout {
    /* renamed from: a */
    private String f6782a = null;
    /* renamed from: b */
    private String f6783b = null;
    /* renamed from: c */
    private final eq f6784c;
    /* renamed from: d */
    private final gl f6785d;
    /* renamed from: e */
    private final ImageView f6786e;

    public DkGeneralFaceView(Context context) {
        super(context, null);
        this.f6785d = new gl(context);
        this.f6784c = new eq(this.f6785d);
        this.f6784c.m10568a(getResources().getDrawable(C0243e.personal__shared__avatar_small));
        this.f6786e = new ImageView(getContext());
        this.f6786e.setBackgroundDrawable(this.f6784c);
        addView(this.f6786e, new LayoutParams(-1, -1));
    }

    public DkGeneralFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6785d = new gl(context);
        this.f6784c = new eq(this.f6785d);
        this.f6784c.m10568a(getResources().getDrawable(C0243e.personal__shared__avatar_small));
        this.f6786e = new ImageView(getContext());
        this.f6786e.setBackgroundDrawable(this.f6784c);
        addView(this.f6786e);
    }

    public void setUser(User user) {
        this.f6782a = user.mUserId;
        this.f6783b = user.mIconUrl;
        m9935a();
    }

    public void setMiAccount(MiAccount miAccount) {
        setUser(miAccount.mo848r().f2405e.f5458a);
        m9935a();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#ff8400"));
        canvas.drawCircle((float) ((getLeft() + getRight()) / 2), (float) ((getTop() + getBottom()) / 2), (float) ((getRight() - getLeft()) / 2), paint);
    }

    /* renamed from: a */
    private void m9935a() {
        if (TextUtils.isEmpty(this.f6782a)) {
            this.f6785d.m10713a(getAnonymousAccountDefaultFaceRes());
            this.f6785d.m10720a(this.f6783b);
        } else if (DkPublic.isXiaomiId(this.f6782a)) {
            this.f6785d.m10713a(getMiAccountDefaultFaceRes());
            this.f6785d.m10720a(bd.m3401a(this.f6783b, 150));
        } else {
            this.f6785d.m10713a(getAnonymousAccountDefaultFaceRes());
            this.f6785d.m10720a(this.f6783b);
        }
    }

    private int getMiAccountDefaultFaceRes() {
        return C0243e.personal__shared__avatar_small;
    }

    private int getAnonymousAccountDefaultFaceRes() {
        return C0243e.comment__guest_avatar;
    }
}
