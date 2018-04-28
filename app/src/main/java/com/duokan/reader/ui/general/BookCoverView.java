package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0243e;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;

public class BookCoverView extends FrameLayout {
    /* renamed from: a */
    private String f6757a = null;
    /* renamed from: b */
    private String f6758b = null;
    /* renamed from: c */
    private String f6759c = null;
    /* renamed from: d */
    private Drawable f6760d;
    /* renamed from: e */
    private Drawable f6761e;
    /* renamed from: f */
    private Drawable f6762f = null;
    /* renamed from: g */
    private Drawable f6763g = null;
    /* renamed from: h */
    private final PicView f6764h;
    /* renamed from: i */
    private final TextView f6765i;
    /* renamed from: j */
    private int f6766j = 0;
    /* renamed from: k */
    private C1343o f6767k = null;

    public enum CoverFrameStatus {
        NORMAL,
        TRIAL,
        RECOMMENDED,
        FREE,
        TIMING,
        TIMEOUT,
        CMREAD
    }

    public enum CoverSource {
        NONE,
        COVER,
        ONLINE_COVER,
        BOOK,
        BOOK_NAME
    }

    public BookCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.obtainStyledAttributes(attributeSet, new int[]{16842964}).recycle();
        this.f6764h = new PicView(context);
        this.f6764h.setPicStretch(PicStretch.SCALE_FILL);
        this.f6765i = new DkLabelView(context, null);
        this.f6765i.setTextSize(0, getResources().getDimension(C0242d.general_font__shared__e));
        this.f6765i.setTextColor(-1);
        this.f6765i.setMaxLines(2);
        this.f6765i.setGravity(49);
        this.f6765i.setBackgroundColor(getResources().getColor(C0241c.general__shared__book_cover_bg));
        this.f6767k = C1340l.m10931a(getContext()).m10935a().m10956a(new C1382y(this));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.f6764h, layoutParams);
        addView(this.f6765i, layoutParams);
        m9918c();
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
    }

    public void setBookName(String str) {
        if (!TextUtils.equals(this.f6757a, str)) {
            this.f6757a = str;
            this.f6765i.setText(this.f6757a);
            requestLayout();
        }
    }

    public void setCoverStatusDrawable(Drawable drawable) {
        this.f6763g = drawable;
    }

    public void setCoverBackgroundResource(int i) {
        this.f6764h.setDefaultPic(i);
    }

    public void setCoverForegroundDrawable(Drawable drawable) {
        if (drawable != null) {
            this.f6760d = drawable;
            invalidate();
        }
    }

    public void setCoverUri(String str) {
        if (!TextUtils.equals(this.f6758b, str)) {
            this.f6758b = str;
            this.f6765i.setVisibility(8);
            this.f6767k.m10958a(str).m10960a(this.f6764h.getDrawable());
            requestLayout();
        }
    }

    public void setOnlineCoverUri(String str) {
        if (!TextUtils.equals(this.f6759c, str)) {
            this.f6759c = str;
            this.f6765i.setVisibility(8);
            this.f6767k.m10961b(str).m10960a(this.f6764h.getDrawable());
            requestLayout();
        }
    }

    /* renamed from: a */
    public void m9919a() {
        m9918c();
    }

    public void setCover(C0800c c0800c) {
        this.f6762f = C1340l.m10931a(getContext()).m10934a(c0800c);
        this.f6763g = C1340l.m10931a(getContext()).m10937c(c0800c);
        setBookName(c0800c.ay());
        m9918c();
        this.f6765i.setBackgroundResource(C1340l.m10931a(getContext()).m10938d(c0800c));
        setCoverBackgroundResource(C0243e.general__book_cover_view__duokan_cover);
        this.f6767k.m10955a(c0800c).m10960a(this.f6764h.getDrawable());
    }

    public void setCover(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        if (dkCloudNoteBookInfo != null) {
            Object bookCoverUrl = dkCloudNoteBookInfo.getBookCoverUrl();
            if (TextUtils.isEmpty(bookCoverUrl)) {
                setBookName(dkCloudNoteBookInfo.getTitle());
                m9918c();
                this.f6765i.setBackgroundResource(C1340l.m10931a(getContext()).m10933a(dkCloudNoteBookInfo.getBookFormat()));
                setCoverBackgroundResource(C0243e.general__book_cover_view__duokan_cover);
                requestLayout();
                return;
            }
            setCoverUri(bookCoverUrl);
        }
    }

    public void setDefaultCoverTitleColor(int i) {
        this.f6765i.setTextColor(i);
    }

    public void setDefaultCoverTitleSize(float f) {
        this.f6765i.setTextSize(f);
    }

    public void setDefaultCover(int i) {
        this.f6765i.setBackgroundResource(i);
    }

    public void setDefaultCoverColor(int i) {
        this.f6765i.setBackgroundColor(i);
    }

    /* renamed from: b */
    public final boolean m9920b() {
        return this.f6764h.m10152a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f6760d.setState(getDrawableState());
        invalidate();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f6762f != null) {
            Rect rect = new Rect(0, 0, this.f6762f.getIntrinsicWidth(), this.f6762f.getIntrinsicHeight());
            canvas.save();
            canvas.translate((float) ((this.f6764h.getRight() - rect.width()) + 6), (float) (((long) this.f6764h.getBottom()) - Math.round(1.5d * ((double) rect.height()))));
            this.f6762f.setBounds(rect);
            this.f6762f.draw(canvas);
            canvas.restore();
        }
        if (this.f6763g != null) {
            Rect rect2 = new Rect(this.f6764h.getLeft(), this.f6764h.getTop(), this.f6764h.getRight(), this.f6764h.getBottom());
            canvas.save();
            int intrinsicWidth = this.f6763g.getIntrinsicWidth();
            int intrinsicHeight = this.f6763g.getIntrinsicHeight();
            if (intrinsicWidth > getWidth() / 2 || intrinsicHeight > getHeight() / 2) {
                intrinsicHeight = Math.min(getWidth() / 2, getHeight() / 2);
                intrinsicWidth = intrinsicHeight;
            }
            rect2.top--;
            rect2.left = (rect2.right - intrinsicWidth) + 1;
            rect2.bottom = intrinsicHeight + rect2.top;
            this.f6763g.setBounds(rect2);
            this.f6763g.draw(canvas);
            canvas.restore();
        }
        if (this.f6766j != 0) {
            canvas.save();
            canvas.clipRect(new Rect(getPaddingLeft(), getPaddingRight(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom()));
            canvas.drawColor(this.f6766j);
            canvas.restore();
        }
        if (this.f6760d != null && isEnabled()) {
            rect = new Rect(0, 0, this.f6764h.getWidth(), this.f6764h.getHeight());
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            canvas.clipRect(rect);
            this.f6760d.setBounds(rect);
            this.f6760d.draw(canvas);
            canvas.restore();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 0) {
            size = getResources().getDimensionPixelSize(C0242d.general__shared__cover_list_width);
        }
        mode = Math.round(((float) size) * 1.3333334f);
        int i3 = (int) (((double) size) * 0.15d);
        int i4 = (int) (((double) mode) * 0.2d);
        int i5 = (int) (((double) size) * 0.15d);
        if (!(this.f6765i.getPaddingLeft() == i3 && this.f6765i.getPaddingTop() == i4 && this.f6765i.getPaddingRight() == i5 && this.f6765i.getPaddingBottom() == 0)) {
            this.f6765i.setPadding(i3, i4, i5, 0);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
    }

    /* renamed from: c */
    private void m9918c() {
        if (this.f6761e == null) {
            Drawable stateListDrawable = new StateListDrawable();
            Drawable colorDrawable = new ColorDrawable(getContext().getResources().getColor(C0241c.general__shared__00000066));
            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
            stateListDrawable.addState(new int[]{16842913}, colorDrawable);
            stateListDrawable.addState(new int[0], new ColorDrawable(0));
            this.f6761e = stateListDrawable;
        }
        this.f6760d = this.f6761e;
    }
}
