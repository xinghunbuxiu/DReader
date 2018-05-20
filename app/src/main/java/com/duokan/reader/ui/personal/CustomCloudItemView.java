package com.duokan.reader.ui.personal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.duokan.common.CommonUtils;
import com.duokan.p024c.C0255g;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.bookshelf.BookActionAssistant;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;
import com.duokan.reader.ui.bookshelf.ah;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.ReaderUi;
import java.util.LinkedList;

public class CustomCloudItemView extends LinearLayout {
    /* renamed from: a */
    private static final LinkedList<CustomCloudItemView> f8202a = new LinkedList();
    /* renamed from: b */
    private static au f8203b = null;

    public CustomCloudItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f8202a.remove(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f8202a.add(this);
        if (f8203b == null) {
            f8203b = new au();
            ai.m3980a().m3889a(f8203b);
            ai.m3980a().m3887a(f8203b);
        }
    }

    /* renamed from: b */
    private void m11350b() {
        BookActionView bookActionView = (BookActionView) findViewById(C0255g.bookshelf__custom_cloud_item_view__action);
        DkLabelView dkLabelView = (DkLabelView) findViewById(C0255g.bookshelf__custom_cloud_item_view__split);
        DkLabelView dkLabelView2 = (DkLabelView) findViewById(C0255g.bookshelf__custom_cloud_item_view__left_attr);
        DkLabelView dkLabelView3 = (DkLabelView) findViewById(C0255g.bookshelf__custom_cloud_item_view__right_attr);
        if (bookActionView != null) {
            CustomCloudItem customCloudItem = (CustomCloudItem) getTag();
            ah a = BookActionAssistant.m9055a(getContext(), customCloudItem.m11340b());
            bookActionView.m9063a(a.f6093a, a.f6095c);
            if (a.f6093a == BookAction.DOWNLOADING) {
                dkLabelView3.setVisibility(0);
                dkLabelView.setVisibility(0);
                dkLabelView2.setText(CommonUtils.m599a(customCloudItem.m11343e()));
                dkLabelView3.setText(ReaderUi.m10159a(getContext(), customCloudItem.m11344f(), false));
            } else if (a.f6093a == BookAction.DOWNLOAD_FAILED || a.f6093a == BookAction.DOWNLOAD_PAUSED) {
                dkLabelView3.setVisibility(4);
                dkLabelView.setVisibility(4);
                dkLabelView2.setText(a.f6094b);
            } else if (a.f6093a == BookAction.READ) {
                BookCoverView bookCoverView = (BookCoverView) findViewById(C0255g.bookshelf__custom_cloud_item_view__cover);
                bookCoverView.setCover(customCloudItem.m11340b());
                bookCoverView.m9919a();
            }
        }
    }
}
