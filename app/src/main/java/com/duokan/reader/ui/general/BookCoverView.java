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

import com.duokan.b.c;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;

public class BookCoverView extends FrameLayout {
    private String a = null;
    private String b = null;
    private String c = null;
    private Drawable d;
    private Drawable e;
    private Drawable f = null;
    private Drawable g = null;
    private final PicView h;
    private final TextView i;
    private int j = 0;
    private o k = null;

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
        this.h = new PicView(context);
        this.h.setPicStretch(PicStretch.SCALE_FILL);
        this.i = new DkLabelView(context, null);
        this.i.setTextSize(0, getResources().getDimension(d.general_font__shared__e));
        this.i.setTextColor(-1);
        this.i.setMaxLines(2);
        this.i.setGravity(49);
        this.i.setBackgroundColor(getResources().getColor(c.general__shared__book_cover_bg));
        this.k = l.a(getContext()).a().a(new y(this));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.h, layoutParams);
        addView(this.i, layoutParams);
        c();
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
    }

    public void setBookName(String str) {
        if (!TextUtils.equals(this.a, str)) {
            this.a = str;
            this.i.setText(this.a);
            requestLayout();
        }
    }

    public void setCoverStatusDrawable(Drawable drawable) {
        this.g = drawable;
    }

    public void setCoverBackgroundResource(int i) {
        this.h.setDefaultPic(i);
    }

    public void setCoverForegroundDrawable(Drawable drawable) {
        if (drawable != null) {
            this.d = drawable;
            invalidate();
        }
    }

    public void setCoverUri(String str) {
        if (!TextUtils.equals(this.b, str)) {
            this.b = str;
            this.i.setVisibility(8);
            this.k.a(str).a(this.h.getDrawable());
            requestLayout();
        }
    }

    public void setOnlineCoverUri(String str) {
        if (!TextUtils.equals(this.c, str)) {
            this.c = str;
            this.i.setVisibility(8);
            this.k.b(str).a(this.h.getDrawable());
            requestLayout();
        }
    }

    public void a() {
        c();
    }

    public void setCover(com.duokan.reader.domain.bookshelf.c cVar) {
        this.f = l.a(getContext()).a(cVar);
        this.g = l.a(getContext()).b(cVar);
        setBookName(cVar.aw());
        c();
        this.i.setBackgroundResource(l.a(getContext()).c(cVar));
        setCoverBackgroundResource(e.general__book_cover_view__duokan_cover);
        this.k.a(cVar).a(this.h.getDrawable());
    }

    public void setCover(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        if (dkCloudNoteBookInfo != null) {
            Object bookCoverUrl = dkCloudNoteBookInfo.getBookCoverUrl();
            if (TextUtils.isEmpty(bookCoverUrl)) {
                setBookName(dkCloudNoteBookInfo.getTitle());
                c();
                this.i.setBackgroundResource(l.a(getContext()).a(dkCloudNoteBookInfo.getBookFormat()));
                setCoverBackgroundResource(e.general__book_cover_view__duokan_cover);
                requestLayout();
                return;
            }
            setCoverUri(bookCoverUrl);
        }
    }

    public void setDefaultCoverTitleColor(int i) {
        this.i.setTextColor(i);
    }

    public void setDefaultCoverTitleSize(float f) {
        this.i.setTextSize(f);
    }

    public void setDefaultCover(int i) {
        this.i.setBackgroundResource(i);
    }

    public void setDefaultCoverColor(int i) {
        this.i.setBackgroundColor(i);
    }

    public final boolean b() {
        return this.h.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.d.setState(getDrawableState());
        invalidate();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f != null) {
            Rect rect = new Rect(0, 0, this.f.getIntrinsicWidth(), this.f.getIntrinsicHeight());
            canvas.save();
            canvas.translate((float) ((this.h.getRight() - rect.width()) + 6), (float) (((long) this.h.getBottom()) - Math.round(1.5d * ((double) rect.height()))));
            this.f.setBounds(rect);
            this.f.draw(canvas);
            canvas.restore();
        }
        if (this.g != null) {
            Rect rect2 = new Rect(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            canvas.save();
            int intrinsicWidth = this.g.getIntrinsicWidth();
            int intrinsicHeight = this.g.getIntrinsicHeight();
            if (intrinsicWidth > getWidth() / 2 || intrinsicHeight > getHeight() / 2) {
                intrinsicHeight = Math.min(getWidth() / 2, getHeight() / 2);
                intrinsicWidth = intrinsicHeight;
            }
            rect2.top--;
            rect2.left = (rect2.right - intrinsicWidth) + 1;
            rect2.bottom = intrinsicHeight + rect2.top;
            this.g.setBounds(rect2);
            this.g.draw(canvas);
            canvas.restore();
        }
        if (this.j != 0) {
            canvas.save();
            canvas.clipRect(new Rect(getPaddingLeft(), getPaddingRight(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom()));
            canvas.drawColor(this.j);
            canvas.restore();
        }
        if (this.d != null && isEnabled()) {
            rect = new Rect(0, 0, this.h.getWidth(), this.h.getHeight());
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            canvas.clipRect(rect);
            this.d.setBounds(rect);
            this.d.draw(canvas);
            canvas.restore();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 0) {
            size = getResources().getDimensionPixelSize(d.general__shared__cover_list_width);
        }
        mode = Math.round(((float) size) * 1.3333334f);
        int i3 = (int) (((double) size) * 0.15d);
        int i4 = (int) (((double) mode) * 0.2d);
        int i5 = (int) (((double) size) * 0.15d);
        if (!(this.i.getPaddingLeft() == i3 && this.i.getPaddingTop() == i4 && this.i.getPaddingRight() == i5 && this.i.getPaddingBottom() == 0)) {
            this.i.setPadding(i3, i4, i5, 0);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
    }

    private void c() {
        if (this.e == null) {
            Drawable stateListDrawable = new StateListDrawable();
            Drawable colorDrawable = new ColorDrawable(getContext().getResources().getColor(c.general__shared__00000066));
            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
            stateListDrawable.addState(new int[]{16842913}, colorDrawable);
            stateListDrawable.addState(new int[0], new ColorDrawable(0));
            this.e = stateListDrawable;
        }
        this.d = this.e;
    }
}
