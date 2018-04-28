package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.general.ReaderUi;

public class BookActionView extends FrameLayout {
    /* renamed from: a */
    private final TextView f6015a;
    /* renamed from: b */
    private final CheckBox f6016b;
    /* renamed from: c */
    private BookAction f6017c;

    public BookActionView(Context context) {
        this(context, null);
    }

    public BookActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BookActionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflate(context, C0245g.bookshelf__book_action_view, this);
        this.f6015a = (TextView) findViewById(C0244f.bookshelf__book_action_view_v4__text);
        this.f6016b = (CheckBox) findViewById(C0244f.bookshelf__book_action_view__edit);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setEnabled(z);
        }
    }

    public void setAction(BookAction bookAction) {
        m9058a(bookAction, -1.0f, false);
    }

    /* renamed from: a */
    public void m9063a(BookAction bookAction, float f) {
        m9058a(bookAction, f, false);
    }

    /* renamed from: a */
    public void m9064a(BookAction bookAction, boolean z) {
        m9058a(bookAction, -1.0f, z);
    }

    /* renamed from: a */
    public void m9062a(float f, boolean z) {
        if (z) {
            this.f6015a.setText(getResources().getString(C0247i.bookshelf__book_action_view__download_paused));
        } else {
            this.f6015a.setText(((int) (100.0f * f)) + "%");
        }
    }

    /* renamed from: a */
    private boolean m9059a() {
        return this.f6017c == BookAction.EDIT;
    }

    /* renamed from: b */
    private boolean m9060b() {
        return this.f6017c != BookAction.EDIT;
    }

    /* renamed from: c */
    private boolean m9061c() {
        return this.f6017c == BookAction.DOWNLOAD_PAUSED || this.f6017c == BookAction.UPLOAD_PAUSED || this.f6017c == BookAction.READ || this.f6017c == BookAction.CAN_UPDATE || this.f6017c == BookAction.DOWNLOAD || this.f6017c == BookAction.DOWNLOADING || this.f6017c == BookAction.DOWNLOAD_FAILED || this.f6017c == BookAction.CAN_UPLOAD || this.f6017c == BookAction.UPLOADING || this.f6017c == BookAction.UPLOAD_FAILED || this.f6017c == BookAction.GIFI;
    }

    /* renamed from: a */
    private void m9058a(BookAction bookAction, float f, boolean z) {
        int i;
        int i2 = 0;
        switch (ai.f6096a[bookAction.ordinal()]) {
            case 1:
                this.f6016b.setChecked(z);
                break;
            case 2:
                this.f6015a.setText(C0247i.bookshelf__book_action_view__upload_paused);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#ff8400"));
                break;
            case 3:
                m9062a(f, true);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#3aac34"));
                break;
            case 4:
                this.f6015a.setText(C0247i.bookshelf__book_action_view__uploading);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#ff8400"));
                break;
            case 5:
                m9062a(f, false);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#3aac34"));
                break;
            case 6:
                this.f6015a.setText(C0247i.bookshelf__book_action_view__read);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#4fabf1"));
                break;
            case 7:
                this.f6015a.setText(C0247i.bookshelf__shared__retry_upload);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#d63737"));
                break;
            case 8:
                this.f6015a.setText(C0247i.bookshelf__book_action_view__update);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#ff8400"));
                break;
            case 9:
                this.f6015a.setText(C0247i.bookshelf__shared__retry_download);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#d63737"));
                break;
            case 10:
                this.f6015a.setText(C0247i.bookshelf__book_action_view__connecting);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(getContext().getResources().getColor(C0241c.general__shared__888888));
                break;
            case 11:
                this.f6015a.setText(C0247i.bookshelf__book_action_view__upload);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#ff8400"));
                break;
            case 12:
                this.f6015a.setText(C0247i.bookshelf__book_action_view__download_book);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#3aac34"));
                break;
            case 13:
                this.f6015a.setText(C0247i.bookshelf__book_action_view__download_book);
                ReaderUi.m10164b(this.f6015a, C0243e.personal__purchased_book_download_button_bg);
                this.f6015a.setTextColor(Color.parseColor("#3aac34"));
                break;
        }
        this.f6017c = bookAction;
        setEnabled(m9061c());
        setClickable(m9061c());
        TextView textView = this.f6015a;
        if (m9060b()) {
            i = 0;
        } else {
            i = 4;
        }
        textView.setVisibility(i);
        CheckBox checkBox = this.f6016b;
        if (!m9059a()) {
            i2 = 4;
        }
        checkBox.setVisibility(i2);
    }
}
