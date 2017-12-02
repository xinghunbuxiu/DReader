package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.duokan.b.i;
import com.duokan.core.ui.FrameScrollView;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.cloud.DkCloudRedeemBenefit;
import com.duokan.reader.ui.general.DkBigFaceView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.deprecatedDkTextView;

public class GiftView extends FrameLayout {
    private Paint a;
    private Path b;
    private TextView c;
    private View d;
    private deprecatedDkTextView e;
    private TextView f;

    public GiftView(Context context) {
        this(context, null);
    }

    public GiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.b = new Path();
        setWillNotDraw(false);
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(0.0f);
        this.a.setStyle(Style.STROKE);
    }

    public void setGiftCart(DkCloudRedeemBenefit dkCloudRedeemBenefit) {
        ((DkBigFaceView) findViewById(f.reading__gift_view__face)).setUser(dkCloudRedeemBenefit.getGiver());
        this.e.setText(dkCloudRedeemBenefit.getMessage());
        String str = TextUtils.isEmpty(dkCloudRedeemBenefit.getGiver().mNickName) ? dkCloudRedeemBenefit.getGiver().mUserId : dkCloudRedeemBenefit.getGiver().mNickName;
        this.f.setText(getResources().getString(i.reading__gift_view__from, new Object[]{str, ReaderUi.a(getContext(), dkCloudRedeemBenefit.getWordUpdatedTime().getTime(), false)}));
    }

    public void setStatusColor(int i) {
        int argb = Color.argb(Math.min(255, Color.alpha(i) * 2), Color.red(i), Color.green(i), Color.blue(i));
        this.c.setTextColor(argb);
        this.e.setTextColor(argb);
        this.f.setTextColor(i);
        this.a.setColor(i);
        invalidate();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.c = (TextView) findViewById(f.reading__gift_view__label);
        this.d = findViewById(f.reading__gift_view__space);
        this.e = (deprecatedDkTextView) findViewById(f.reading__gift_view__msg);
        this.f = (TextView) findViewById(f.reading__gift_view__from);
        ((FrameScrollView) findViewById(f.reading__gift_view__scroll)).setMaxOverScrollHeight(dv.g(getContext()));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int b = dv.b(getContext(), 10.0f);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        float width = (float) ((((getWidth() - paddingLeft) - paddingRight) / 2) + paddingLeft);
        float top = (float) ((((this.d.getTop() + this.d.getBottom()) / 2) - (b / 2)) + paddingTop);
        float f = (1.0f + top) + ((float) b);
        this.b.reset();
        this.b.moveTo((float) paddingLeft, f);
        this.b.lineTo(width - ((float) b), f);
        this.b.lineTo(width, top);
        this.b.lineTo(((float) b) + width, f);
        this.b.lineTo((float) (getWidth() - paddingRight), f);
        float bottom = (float) ((this.f.getBottom() + 1) + paddingTop);
        this.b.moveTo((float) paddingLeft, bottom);
        this.b.lineTo((float) (getWidth() - paddingRight), bottom);
        canvas.drawPath(this.b, this.a);
    }
}
