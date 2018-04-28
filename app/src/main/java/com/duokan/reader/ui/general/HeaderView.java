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
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ui.C0435s;

public class HeaderView extends FrameLayout {
    /* renamed from: a */
    private final ImageView f6865a;
    /* renamed from: b */
    private final LinearLayout f6866b;
    /* renamed from: c */
    private final LinearLayout f6867c;
    /* renamed from: d */
    private final LinearLayout f6868d;
    /* renamed from: e */
    private final TextView f6869e;
    /* renamed from: f */
    private final TextView f6870f;
    /* renamed from: g */
    private final er f6871g;
    /* renamed from: h */
    private final View f6872h;
    /* renamed from: i */
    private int f6873i;
    /* renamed from: j */
    private dj f6874j;

    public HeaderView(Context context) {
        this(context, null);
    }

    @TargetApi(14)
    public HeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6873i = -1;
        this.f6874j = null;
        inflate(context, C0245g.general__header_view, this);
        this.f6865a = (ImageView) findViewById(C0244f.general__header_view__back);
        this.f6866b = (LinearLayout) findViewById(C0244f.general__header_view__left_buttons);
        this.f6867c = (LinearLayout) findViewById(C0244f.general__header_view__right_buttons);
        this.f6868d = (LinearLayout) findViewById(C0244f.general__header_view__center_buttons);
        this.f6869e = (TextView) findViewById(C0244f.general__header_view__left_title);
        this.f6869e.getPaint().setFakeBoldText(true);
        this.f6870f = (TextView) findViewById(C0244f.general__header_view__center_title);
        this.f6870f.getPaint().setFakeBoldText(true);
        this.f6865a.setOnClickListener(new di(this));
        this.f6872h = new View(getContext());
        this.f6872h.setBackgroundColor(getResources().getColor(C0241c.general__shared__page_header_divider));
        addView(this.f6872h, new LayoutParams(-1, 1, 80));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842964});
        if (!obtainStyledAttributes.hasValue(0)) {
            setBackgroundColor(getContext().getResources().getColor(C0241c.general__shared__ffffff));
        }
        obtainStyledAttributes.recycle();
        this.f6871g = new er(context);
        setWillNotDraw(false);
    }

    public boolean getHasBackButton() {
        return this.f6865a.getVisibility() == 0;
    }

    public void setHasBackButton(boolean z) {
        this.f6865a.setVisibility(z ? 0 : 8);
    }

    public void setOnBackListener(dj djVar) {
        this.f6874j = djVar;
    }

    public void setBackDrawable(Drawable drawable) {
        this.f6865a.setImageDrawable(drawable);
    }

    public void setLeftTitle(int i) {
        this.f6869e.setText(i);
    }

    public void setLeftTitle(String str) {
        this.f6869e.setText(str);
    }

    public TextView getCenterTitleView() {
        return this.f6870f;
    }

    public void setCenterTitle(int i) {
        this.f6870f.setText(i);
    }

    public void setCenterTitle(String str) {
        this.f6870f.setText(str);
    }

    public void setTitleTextColor(int i) {
        this.f6869e.setTextColor(i);
        this.f6870f.setTextColor(i);
    }

    public void setTitleTextSize(float f) {
        this.f6869e.setTextSize(0, f);
    }

    public void setCenterTitleNoticeNum(int i) {
        this.f6871g.m10570a("" + i);
        invalidate();
    }

    /* renamed from: a */
    public TextView m10144a(String str) {
        View a = m10141a(getContext(), str);
        this.f6866b.addView(a, new LinearLayout.LayoutParams(-2, -1));
        return a;
    }

    /* renamed from: a */
    public void m10146a(View view) {
        this.f6867c.addView(view, 0, new LinearLayout.LayoutParams(-2, -1));
    }

    /* renamed from: a */
    public ImageView m10143a(Drawable drawable) {
        View imageView = new ImageView(getContext());
        imageView.setImageDrawable(drawable);
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setMinimumWidth(dv.m1932b(getContext(), 40.0f));
        this.f6867c.addView(imageView, 0, new LinearLayout.LayoutParams(-2, -1));
        return imageView;
    }

    /* renamed from: b */
    public TextView m10148b(String str) {
        View a = m10141a(getContext(), str);
        this.f6867c.addView(a, 0, new LinearLayout.LayoutParams(-2, -1));
        return a;
    }

    /* renamed from: a */
    public void m10147a(String str, OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(str)) {
            View textView = new TextView(getContext());
            textView.setTextSize(16.0f);
            textView.setPadding(dv.m1932b(getContext(), 15.0f), 0, dv.m1932b(getContext(), 15.0f), 0);
            textView.setGravity(17);
            textView.setText(str);
            textView.setSingleLine(true);
            textView.setTextColor(getResources().getColorStateList(C0241c.general__shared__666666_selected));
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            this.f6868d.addView(textView, new LinearLayout.LayoutParams(-2, -1));
        }
    }

    public ViewGroup getCenterButtonView() {
        return this.f6868d;
    }

    /* renamed from: a */
    public void m10145a() {
        this.f6867c.removeAllViews();
    }

    public void setBottomLineColor(int i) {
        this.f6872h.setVisibility(0);
        this.f6872h.setBackgroundColor(i);
    }

    public void setBottomLineHeight(int i) {
        this.f6872h.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.f6872h.getLayoutParams();
        layoutParams.height = i;
        this.f6872h.setLayoutParams(layoutParams);
    }

    protected void onMeasure(int i, int i2) {
        int pageHeaderHeight = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderHeight();
        int pageHeaderPaddingTop = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderPaddingTop();
        if (getPaddingTop() != pageHeaderPaddingTop) {
            setPadding(0, pageHeaderPaddingTop, 0, 0);
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(pageHeaderHeight, 1073741824));
        pageHeaderPaddingTop = getMeasuredWidth() - (Math.max((this.f6865a.getVisibility() == 8 ? 0 : this.f6865a.getMeasuredWidth()) + this.f6866b.getMeasuredWidth(), this.f6867c.getMeasuredWidth()) * 2);
        if (this.f6873i != pageHeaderPaddingTop) {
            this.f6873i = pageHeaderPaddingTop;
            this.f6870f.setMaxWidth(this.f6873i);
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(pageHeaderHeight, 1073741824));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!TextUtils.isEmpty(this.f6870f.getText())) {
            canvas.save();
            Rect a = dv.m1904a(new Rect(), this.f6870f, (View) this);
            this.f6871g.setBounds(new Rect(a.right - (this.f6871g.getIntrinsicWidth() / 2), a.top - (this.f6871g.getIntrinsicHeight() / 2), a.right + (this.f6871g.getIntrinsicWidth() / 2), a.top + (this.f6871g.getIntrinsicHeight() / 2)));
            this.f6871g.draw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: a */
    private TextView m10141a(Context context, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, getResources().getDimension(C0242d.general_font__shared__t3));
        textView.setTextColor(getResources().getColor(C0241c.general__shared__c5));
        textView.setText(str);
        textView.setGravity(17);
        int b = dv.m1932b(getContext(), 15.0f);
        textView.setPadding(b, 0, b, 0);
        return textView;
    }
}
