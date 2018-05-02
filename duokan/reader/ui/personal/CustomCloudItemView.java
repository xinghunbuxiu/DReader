package com.duokan.reader.ui.personal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.duokan.c.g;
import com.duokan.common.tools;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.bookshelf.BookActionAssistant;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;
import com.duokan.reader.ui.bookshelf.ab;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.ReaderUi;

import java.util.LinkedList;

public class CustomCloudItemView extends LinearLayout {
    private static final LinkedList a = new LinkedList();
    private static bb b = null;

    public CustomCloudItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.remove(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a.add(this);
        if (b == null) {
            b = new bb();
            ai.a().a(b);
            ai.a().a(b);
        }
    }

    private void b() {
        BookActionView bookActionView = (BookActionView) findViewById(g.bookshelf__custom_cloud_item_view__action);
        DkLabelView dkLabelView = (DkLabelView) findViewById(g.bookshelf__custom_cloud_item_view__split);
        DkLabelView dkLabelView2 = (DkLabelView) findViewById(g.bookshelf__custom_cloud_item_view__left_attr);
        DkLabelView dkLabelView3 = (DkLabelView) findViewById(g.bookshelf__custom_cloud_item_view__right_attr);
        if (bookActionView != null) {
            CustomCloudItem customCloudItem = (CustomCloudItem) getTag();
            ab a = BookActionAssistant.a(getContext(), customCloudItem.b());
            bookActionView.a(a.a, a.c);
            if (a.a == BookAction.DOWNLOADING) {
                dkLabelView3.setVisibility(0);
                dkLabelView.setVisibility(0);
                dkLabelView2.setText(tools.getByteSize(customCloudItem.e()));
                dkLabelView3.setText(ReaderUi.a(getContext(), customCloudItem.f(), false));
            } else if (a.a == BookAction.DOWNLOAD_FAILED || a.a == BookAction.DOWNLOAD_PAUSED) {
                dkLabelView3.setVisibility(4);
                dkLabelView.setVisibility(4);
                dkLabelView2.setText(a.b);
            } else if (a.a == BookAction.READ) {
                BookCoverView bookCoverView = (BookCoverView) findViewById(g.bookshelf__custom_cloud_item_view__cover);
                bookCoverView.setCover(customCloudItem.b());
                bookCoverView.a();
            }
        }
    }
}
