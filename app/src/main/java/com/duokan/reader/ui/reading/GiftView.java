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
import com.duokan.core.ui.FrameScrollView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.cloud.DkCloudRedeemBenefit;
import com.duokan.reader.ui.general.DkBigFaceView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.deprecatedDkTextView;

public class GiftView extends FrameLayout {
    /* renamed from: a */
    private Paint f9099a;
    /* renamed from: b */
    private Path f9100b;
    /* renamed from: c */
    private TextView f9101c;
    /* renamed from: d */
    private View f9102d;
    /* renamed from: e */
    private deprecatedDkTextView f9103e;
    /* renamed from: f */
    private TextView f9104f;

    public GiftView(Context context) {
        this(context, null);
    }

    public GiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9099a = new Paint();
        this.f9100b = new Path();
        setWillNotDraw(false);
        this.f9099a.setAntiAlias(true);
        this.f9099a.setStrokeWidth(0.0f);
        this.f9099a.setStyle(Style.STROKE);
    }

    public void setGiftCart(DkCloudRedeemBenefit dkCloudRedeemBenefit) {
        ((DkBigFaceView) findViewById(C0244f.reading__gift_view__face)).setUser(dkCloudRedeemBenefit.getGiver());
        this.f9103e.setText(dkCloudRedeemBenefit.getMessage());
        String str = TextUtils.isEmpty(dkCloudRedeemBenefit.getGiver().mNickName) ? dkCloudRedeemBenefit.getGiver().mUserId : dkCloudRedeemBenefit.getGiver().mNickName;
        this.f9104f.setText(getResources().getString(C0247i.reading__gift_view__from, new Object[]{str, ReaderUi.m10159a(getContext(), dkCloudRedeemBenefit.getWordUpdatedTime().getTime(), false)}));
    }

    public void setStatusColor(int i) {
        int argb = Color.argb(Math.min(255, Color.alpha(i) * 2), Color.red(i), Color.green(i), Color.blue(i));
        this.f9101c.setTextColor(argb);
        this.f9103e.setTextColor(argb);
        this.f9104f.setTextColor(i);
        this.f9099a.setColor(i);
        invalidate();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f9101c = (TextView) findViewById(C0244f.reading__gift_view__label);
        this.f9102d = findViewById(C0244f.reading__gift_view__space);
        this.f9103e = (deprecatedDkTextView) findViewById(C0244f.reading__gift_view__msg);
        this.f9104f = (TextView) findViewById(C0244f.reading__gift_view__from);
        ((FrameScrollView) findViewById(C0244f.reading__gift_view__scroll)).setMaxOverScrollHeight(AnimUtils.getMaxOverScrollHeight(getContext()));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int b = AnimUtils.m1932b(getContext(), 10.0f);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        float width = (float) ((((getWidth() - paddingLeft) - paddingRight) / 2) + paddingLeft);
        float top = (float) ((((this.f9102d.getTop() + this.f9102d.getBottom()) / 2) - (b / 2)) + paddingTop);
        float f = (1.0f + top) + ((float) b);
        this.f9100b.reset();
        this.f9100b.moveTo((float) paddingLeft, f);
        this.f9100b.lineTo(width - ((float) b), f);
        this.f9100b.lineTo(width, top);
        this.f9100b.lineTo(((float) b) + width, f);
        this.f9100b.lineTo((float) (getWidth() - paddingRight), f);
        float bottom = (float) ((this.f9104f.getBottom() + 1) + paddingTop);
        this.f9100b.moveTo((float) paddingLeft, bottom);
        this.f9100b.lineTo((float) (getWidth() - paddingRight), bottom);
        canvas.drawPath(this.f9100b, this.f9099a);
    }
}
