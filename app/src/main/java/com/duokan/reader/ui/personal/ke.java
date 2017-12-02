package com.duokan.reader.ui.personal;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.b.c;
import com.duokan.b.e;
import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.general.expandable.a;

public class ke {
    private final Context a;

    public ke(Context context) {
        this.a = context;
    }

    public View a(DkCloudStoreBook dkCloudStoreBook, View view, ViewGroup viewGroup, a aVar, int i, int i2) {
        return a(dkCloudStoreBook, view, viewGroup, aVar, i, i2, null);
    }

    public View a(DkCloudStoreBook dkCloudStoreBook, View view, ViewGroup viewGroup, a aVar, int i, int i2, String str) {
        View inflate;
        if (view == null || view.findViewById(f.bookshelf__purchased_book_item_view__cover) == null) {
            inflate = LayoutInflater.from(a()).inflate(g.bookshelf__purchased_book_item_view, viewGroup, false);
        } else {
            inflate = view;
        }
        BookCoverView bookCoverView = (BookCoverView) inflate.findViewById(f.bookshelf__purchased_book_item_view__cover);
        bookCoverView.a();
        bookCoverView.setOnlineCoverUri(dkCloudStoreBook.getCoverUri());
        bookCoverView.setCoverBackgroundResource(e.general__book_cover_view__duokan_cover);
        int color = this.a.getResources().getColor(c.general__shared__ed6c00);
        ((TextView) inflate.findViewById(f.bookshelf__purchased_book_item_view__first_line)).setText(ReaderUi.a(dkCloudStoreBook.getTitle(), str, color));
        TextView textView = (TextView) inflate.findViewById(f.bookshelf__purchased_book_item_view__second_line);
        if (!TextUtils.isEmpty(dkCloudStoreBook.getAuthorLine())) {
            textView.setVisibility(0);
            textView.setText(ReaderUi.a(dkCloudStoreBook.getAuthorLine(), str, color));
        } else if (TextUtils.isEmpty(dkCloudStoreBook.getEditorLine())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(ReaderUi.a(dkCloudStoreBook.getEditorLine(), str, color));
        }
        ((TextView) inflate.findViewById(f.bookshelf__purchased_book_item_view__third_line)).setText(ReaderUi.a(a(), dkCloudStoreBook.getPurchaseTimeInSeconds() * 1000, false));
        if (aVar == null || aVar.f() != ViewMode.Edit) {
            ((PurchasedBookItemView) inflate).a(dkCloudStoreBook, false, false);
        } else {
            ((PurchasedBookItemView) inflate).a(dkCloudStoreBook, true, aVar.b(i, i2));
        }
        if (dkCloudStoreBook.getBookSourceType() == DkStoreBookSourceType.GIFT) {
            inflate.findViewById(f.bookshelf__purchased_book_item_view__is_gift).setVisibility(0);
        } else {
            inflate.findViewById(f.bookshelf__purchased_book_item_view__is_gift).setVisibility(8);
        }
        return inflate;
    }

    public Context a() {
        return this.a;
    }
}
