package com.duokan.reader.ui.general;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.ITheme;

public class HeaderView extends FrameLayout {
    private final ImageView a;
    private final LinearLayout b;
    private final LinearLayout c;
    private final LinearLayout d;
    private final TextView e;
    private final TextView f;
    private final et g;
    private final View h;
    private int i;
    private dj j;

    public HeaderView(Context context) {
        this(context, null);
    }

    @TargetApi(14)
    public HeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = -1;
        this.j = null;
        inflate(context, g.general__header_view, this);
        this.a = (ImageView) findViewById(f.general__header_view__back);
        this.b = (LinearLayout) findViewById(f.general__header_view__left_buttons);
        this.c = (LinearLayout) findViewById(f.general__header_view__right_buttons);
        this.d = (LinearLayout) findViewById(f.general__header_view__center_buttons);
        this.e = (TextView) findViewById(f.general__header_view__left_title);
        this.e.getPaint().setFakeBoldText(true);
        this.f = (TextView) findViewById(f.general__header_view__center_title);
        this.f.getPaint().setFakeBoldText(true);
        this.a.setOnClickListener(new di(this));
        this.h = new View(getContext());
        this.h.setBackgroundColor(getResources().getColor(c.general__shared__page_header_divider));
        addView(this.h, new LayoutParams(-1, 1, 80));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842964});
        if (!obtainStyledAttributes.hasValue(0)) {
            setBackgroundColor(getContext().getResources().getColor(c.general__shared__ffffff));
        }
        obtainStyledAttributes.recycle();
        this.g = new et(context);
        setWillNotDraw(false);
    }

    public boolean getHasBackButton() {
        return this.a.getVisibility() == 0;
    }

    public void setHasBackButton(boolean z) {
        this.a.setVisibility(z ? 0 : 8);
    }

    public void setOnBackListener(dj djVar) {
        this.j = djVar;
    }

    public void setBackDrawable(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public void setLeftTitle(int i) {
        this.e.setText(i);
    }

    public void setLeftTitle(String str) {
        this.e.setText(str);
    }

    public TextView getCenterTitleView() {
        return this.f;
    }

    public void setCenterTitle(int i) {
        this.f.setText(i);
    }

    public void setCenterTitle(String str) {
        this.f.setText(str);
    }

    public void setTitleTextColor(int i) {
        this.e.setTextColor(i);
        this.f.setTextColor(i);
    }

    public void setTitleTextSize(float f) {
        this.e.setTextSize(0, f);
    }

    public void setCenterTitleNoticeNum(int i) {
        this.g.a("" + i);
        invalidate();
    }

    public TextView a(String str) {
        View a = a(getContext(), str);
        this.b.addView(a, new LinearLayout.LayoutParams(-2, -1));
        return a;
    }

    public void a(View view) {
        this.c.addView(view, 0, new LinearLayout.LayoutParams(-2, -1));
    }

    public ImageView a(Drawable drawable) {
        View imageView = new ImageView(getContext());
        imageView.setImageDrawable(drawable);
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setMinimumWidth(UTools.closeAnimation(getContext(), 40.0f));
        this.c.addView(imageView, 0, new LinearLayout.LayoutParams(-2, -1));
        return imageView;
    }

    public TextView b(String str) {
        View a = a(getContext(), str);
        this.c.addView(a, 0, new LinearLayout.LayoutParams(-2, -1));
        return a;
    }

    public void a(String str, OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(str)) {
            View textView = new TextView(getContext());
            textView.setTextSize(16.0f);
            textView.setPadding(UTools.closeAnimation(getContext(), 15.0f), 0, UTools.closeAnimation(getContext(), 15.0f), 0);
            textView.setGravity(17);
            textView.setText(str);
            textView.setSingleLine(true);
            textView.setTextColor(getResources().getColorStateList(c.general__shared__666666_selected));
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            this.d.addView(textView, new LinearLayout.LayoutParams(-2, -1));
        }
    }

    public ViewGroup getCenterButtonView() {
        return this.d;
    }

    public void a() {
        this.c.removeAllViews();
    }

    public void setBottomLineColor(int i) {
        this.h.setVisibility(0);
        this.h.setBackgroundColor(i);
    }

    public void setBottomLineHeight(int i) {
        this.h.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        layoutParams.height = i;
        this.h.setLayoutParams(layoutParams);
    }

    protected void onMeasure(int i, int i2) {
        int pageHeaderHeight = ((ITheme) MyContextWrapper.getFeature(getContext()).queryFeature(ITheme.class)).getTheme().getPageHeaderHeight();
        int pageHeaderPaddingTop = ((ITheme) MyContextWrapper.getFeature(getContext()).queryFeature(ITheme.class)).getTheme().getPageHeaderPaddingTop();
        if (getPaddingTop() != pageHeaderPaddingTop) {
            setPadding(0, pageHeaderPaddingTop, 0, 0);
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(pageHeaderHeight, 1073741824));
        pageHeaderPaddingTop = getMeasuredWidth() - (Math.max((this.a.getVisibility() == 8 ? 0 : this.a.getMeasuredWidth()) + this.b.getMeasuredWidth(), this.c.getMeasuredWidth()) * 2);
        if (this.i != pageHeaderPaddingTop) {
            this.i = pageHeaderPaddingTop;
            this.f.setMaxWidth(this.i);
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(pageHeaderHeight, 1073741824));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!TextUtils.isEmpty(this.f.getText())) {
            canvas.save();
            Rect a = UTools.getRect(new Rect(), this.f, (View) this);
            this.g.setBounds(new Rect(a.right - (this.g.getIntrinsicWidth() / 2), a.top - (this.g.getIntrinsicHeight() / 2), a.right + (this.g.getIntrinsicWidth() / 2), a.top + (this.g.getIntrinsicHeight() / 2)));
            this.g.draw(canvas);
            canvas.restore();
        }
    }

    private TextView a(Context context, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, getResources().getDimension(d.general_font__shared__t3));
        textView.setTextColor(getResources().getColor(c.general__shared__c5));
        textView.setText(str);
        textView.setGravity(17);
        int b = UTools.closeAnimation(getContext(), 15.0f);
        textView.setPadding(b, 0, b, 0);
        return textView;
    }
}
