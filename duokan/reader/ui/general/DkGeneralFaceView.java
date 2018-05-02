package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.bh;

public class DkGeneralFaceView extends FrameLayout {
    private String a = null;
    private String b = null;
    private final es c;
    private final gw d;
    private final ImageView e;

    public DkGeneralFaceView(Context context) {
        super(context, null);
        this.d = new gw(context);
        this.c = new es(this.d);
        this.c.a(getResources().getDrawable(e.personal__shared__avatar_small));
        this.e = new ImageView(getContext());
        this.e.setBackgroundDrawable(this.c);
        addView(this.e, new LayoutParams(-1, -1));
    }

    public DkGeneralFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new gw(context);
        this.c = new es(this.d);
        this.c.a(getResources().getDrawable(e.personal__shared__avatar_small));
        this.e = new ImageView(getContext());
        this.e.setBackgroundDrawable(this.c);
        addView(this.e);
    }

    public void setUser(User user) {
        this.a = user.mUserId;
        this.b = user.mIconUrl;
        a();
    }

    public void setMiAccount(MiAccount miAccount) {
        setUser(miAccount.o().e.a);
        a();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#ff8400"));
        canvas.drawCircle((float) ((getLeft() + getRight()) / 2), (float) ((getTop() + getBottom()) / 2), (float) ((getRight() - getLeft()) / 2), paint);
    }

    private void a() {
        if (TextUtils.isEmpty(this.a)) {
            this.d.a(getAnonymousAccountDefaultFaceRes());
            this.d.a(this.b);
        } else if (DkPublic.isXiaomiId(this.a)) {
            this.d.a(getMiAccountDefaultFaceRes());
            this.d.a(bh.a(this.b, 150));
        } else {
            this.d.a(getAnonymousAccountDefaultFaceRes());
            this.d.a(this.b);
        }
    }

    private int getMiAccountDefaultFaceRes() {
        return e.personal__shared__avatar_small;
    }

    private int getAnonymousAccountDefaultFaceRes() {
        return e.comment__guest_avatar;
    }
}
