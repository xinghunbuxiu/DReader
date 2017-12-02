package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.duokan.b.e;
import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.general.ReaderUi;

public class BookActionView extends FrameLayout {
    private final TextView a;
    private final CheckBox b;
    private BookAction c;

    public BookActionView(Context context) {
        this(context, null);
    }

    public BookActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BookActionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflate(context, g.bookshelf__book_action_view, this);
        this.a = (TextView) findViewById(f.bookshelf__book_action_view_v4__text);
        this.b = (CheckBox) findViewById(f.bookshelf__book_action_view__edit);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setEnabled(z);
        }
    }

    public void setAction(BookAction bookAction) {
        a(bookAction, -1.0f, false);
    }

    public void a(BookAction bookAction, float f) {
        a(bookAction, f, false);
    }

    public void a(BookAction bookAction, boolean z) {
        a(bookAction, -1.0f, z);
    }

    public void a(float f, boolean z, boolean z2) {
        if (z) {
            this.a.setText(getResources().getString(i.bookshelf__book_action_view__download_paused));
        } else {
            this.a.setText(((int) (100.0f * f)) + "%");
        }
    }

    private boolean a() {
        return this.c == BookAction.EDIT;
    }

    private boolean b() {
        return this.c != BookAction.EDIT;
    }

    private boolean c() {
        return this.c == BookAction.DOWNLOAD_PAUSED || this.c == BookAction.UPLOAD_PAUSED || this.c == BookAction.READ || this.c == BookAction.CAN_UPDATE || this.c == BookAction.DOWNLOAD || this.c == BookAction.DOWNLOADING || this.c == BookAction.DOWNLOAD_FAILED || this.c == BookAction.CAN_UPLOAD || this.c == BookAction.UPLOADING || this.c == BookAction.UPLOAD_FAILED || this.c == BookAction.GIFI;
    }

    private void a(BookAction bookAction, float f, boolean z) {
        int i;
        boolean z2 = true;
        int i2 = 0;
        switch (ac.a[bookAction.ordinal()]) {
            case 1:
                this.b.setChecked(z);
                break;
            case 2:
                this.a.setText(i.bookshelf__book_action_view__upload_paused);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#ff8400"));
                break;
            case 3:
                boolean z3;
                if (bookAction == BookAction.DOWNLOAD_PAUSED) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                a(f, true, z3);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#3aac34"));
                break;
            case 4:
                this.a.setText(i.bookshelf__book_action_view__uploading);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#ff8400"));
                break;
            case 5:
                if (bookAction != BookAction.DOWNLOADING) {
                    z2 = false;
                }
                a(f, false, z2);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#3aac34"));
                break;
            case 6:
                this.a.setText(i.bookshelf__book_action_view__read);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#4fabf1"));
                break;
            case 7:
                this.a.setText(i.bookshelf__shared__retry_upload);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#d63737"));
                break;
            case 8:
                this.a.setText(i.bookshelf__book_action_view__update);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#ff8400"));
                break;
            case 9:
                this.a.setText(i.bookshelf__shared__retry_download);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#d63737"));
                break;
            case 10:
                this.a.setText(i.bookshelf__book_action_view__connecting);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(getContext().getResources().getColor(c.general__shared__888888));
                break;
            case 11:
                this.a.setText(i.bookshelf__book_action_view__upload);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#ff8400"));
                break;
            case 12:
                this.a.setText(i.bookshelf__book_action_view__download_book);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#3aac34"));
                break;
            case 13:
                this.a.setText(i.bookshelf__book_action_view__download_book);
                ReaderUi.b(this.a, e.personal__purchased_book_download_button_bg);
                this.a.setTextColor(Color.parseColor("#3aac34"));
                break;
        }
        this.c = bookAction;
        setEnabled(c());
        setClickable(c());
        TextView textView = this.a;
        if (b()) {
            i = 0;
        } else {
            i = 4;
        }
        textView.setVisibility(i);
        CheckBox checkBox = this.b;
        if (!a()) {
            i2 = 4;
        }
        checkBox.setVisibility(i2);
    }
}
