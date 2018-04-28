package com.duokan.reader.ui.personal;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.expandable.C1293a;
import com.duokan.reader.ui.general.expandable.ViewMode;

public class ks {
    /* renamed from: a */
    private final Context f8832a;

    public ks(Context context) {
        this.f8832a = context;
    }

    /* renamed from: a */
    public View m12091a(DkCloudStoreBook dkCloudStoreBook, View view, ViewGroup viewGroup, C1293a c1293a, int i, int i2) {
        return m12092a(dkCloudStoreBook, view, viewGroup, c1293a, i, i2, null);
    }

    /* renamed from: a */
    public View m12092a(DkCloudStoreBook dkCloudStoreBook, View view, ViewGroup viewGroup, C1293a c1293a, int i, int i2, String str) {
        View inflate;
        if (view == null || view.findViewById(C0244f.bookshelf__purchased_book_item_view__cover) == null) {
            inflate = LayoutInflater.from(m12090a()).inflate(C0245g.bookshelf__purchased_book_item_view, viewGroup, false);
        } else {
            inflate = view;
        }
        BookCoverView bookCoverView = (BookCoverView) inflate.findViewById(C0244f.bookshelf__purchased_book_item_view__cover);
        bookCoverView.m9919a();
        bookCoverView.setOnlineCoverUri(dkCloudStoreBook.getCoverUri());
        bookCoverView.setCoverBackgroundResource(C0243e.general__book_cover_view__duokan_cover);
        int color = this.f8832a.getResources().getColor(C0241c.general__shared__ed6c00);
        ((TextView) inflate.findViewById(C0244f.bookshelf__purchased_book_item_view__first_line)).setText(ReaderUi.m10156a(dkCloudStoreBook.getTitle(), str, color));
        TextView textView = (TextView) inflate.findViewById(C0244f.bookshelf__purchased_book_item_view__second_line);
        if (!TextUtils.isEmpty(dkCloudStoreBook.getAuthorLine())) {
            textView.setVisibility(0);
            textView.setText(ReaderUi.m10156a(dkCloudStoreBook.getAuthorLine(), str, color));
        } else if (TextUtils.isEmpty(dkCloudStoreBook.getEditorLine())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(ReaderUi.m10156a(dkCloudStoreBook.getEditorLine(), str, color));
        }
        ((TextView) inflate.findViewById(C0244f.bookshelf__purchased_book_item_view__third_line)).setText(ReaderUi.m10159a(m12090a(), dkCloudStoreBook.getPurchaseTimeInSeconds() * 1000, false));
        if (c1293a == null || c1293a.mo1714f() != ViewMode.Edit) {
            ((PurchasedBookItemView) inflate).m11370a(dkCloudStoreBook, false, false);
        } else {
            ((PurchasedBookItemView) inflate).m11370a(dkCloudStoreBook, true, c1293a.mo1713b(i, i2));
        }
        if (dkCloudStoreBook.getBookSourceType() == DkStoreBookSourceType.GIFT) {
            inflate.findViewById(C0244f.bookshelf__purchased_book_item_view__is_gift).setVisibility(0);
        } else {
            inflate.findViewById(C0244f.bookshelf__purchased_book_item_view__is_gift).setVisibility(8);
        }
        return inflate;
    }

    /* renamed from: a */
    public Context m12090a() {
        return this.f8832a;
    }
}
