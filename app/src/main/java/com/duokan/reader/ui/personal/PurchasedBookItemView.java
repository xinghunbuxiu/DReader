package com.duokan.reader.ui.personal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.BookActionAssistant;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;
import com.duokan.reader.ui.bookshelf.ab;
import com.duokan.reader.ui.bookshelf.ay;
import com.duokan.reader.ui.store.DkCloudBookStatusHelper;
import com.duokan.reader.ui.store.DkCloudBookStatusHelper.StoreBookStatus;
import com.duokan.reader.ui.store.o;

import java.util.LinkedList;

public class PurchasedBookItemView extends RelativeLayout {
    static final /* synthetic */ boolean a = (!PurchasedBookItemView.class.desiredAssertionStatus());
    private static final LinkedList b = new LinkedList();
    private static kb c = null;
    private BookActionView d = null;
    private DkCloudStoreBook e = null;
    private boolean f = false;
    private boolean g = false;

    public PurchasedBookItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(DkCloudStoreBook dkCloudStoreBook, boolean z, boolean z2) {
        this.e = dkCloudStoreBook;
        this.f = z;
        this.g = z2;
        if (this.d != null) {
            b();
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.d = (BookActionView) findViewById(f.bookshelf__purchased_book_item_view__action_view);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b.remove(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.add(this);
        if (c == null) {
            c = new kb();
            ai.a().a(c);
            ai.a().a(c);
        }
    }

    private void a(boolean z) {
        if (this.d != null && this.e != null) {
            if (z) {
                b();
                return;
            }
            c b = ai.a().b(this.e.getBookUuid());
            if (b != null) {
                this.d.a((1.0f * b.m()) / 100.0f, b.X(), true);
            }
        }
    }

    private void b() {
        if (this.e == null) {
            this.d.setOnClickListener(null);
        } else if (this.f) {
            this.d.a(BookAction.EDIT, this.g);
        } else if (this.e instanceof DkCloudPurchasedBook) {
            StoreBookStatus b = DkCloudBookStatusHelper.b(this.e.getBookUuid());
            this.d.setEnabled(true);
            switch (ka.a[b.ordinal()]) {
                case 1:
                    this.d.setAction(BookAction.CAN_UPDATE);
                    break;
                case 2:
                    this.d.setAction(BookAction.READ);
                    break;
                case 3:
                    c b2 = ai.a().b(this.e.getBookUuid());
                    if (b2 != null) {
                        ab a = BookActionAssistant.a(DkApp.get(), b2);
                        this.d.a(a.a, a.c);
                        break;
                    }
                    break;
                case 4:
                    this.d.setAction(this.e.getBookSourceType() == DkStoreBookSourceType.GIFT ? BookAction.GIFI : BookAction.DOWNLOAD);
                    break;
                case 5:
                    this.d.setEnabled(false);
                    this.d.setAction(BookAction.CONNECTING);
                    break;
                default:
                    if (!a) {
                        throw new AssertionError();
                    }
                    break;
            }
            this.d.setOnClickListener(new js(this, b));
        } else {
            if (o.a().a(this.e.getBookUuid())) {
                this.d.setAction(BookAction.CONNECTING);
            } else {
                this.d.setAction(BookAction.READ);
            }
            this.d.setOnClickListener(new jt(this));
        }
    }

    private static void d(PurchasedBookItemView purchasedBookItemView, DkCloudStoreBook dkCloudStoreBook) {
        ((ReaderFeature) MyContextWrapper.getFeature(DkApp.get()).queryFeature(ReaderFeature.class)).openBook(dkCloudStoreBook.getBookUuid(), null);
    }

    private static void e(PurchasedBookItemView purchasedBookItemView, DkCloudStoreBook dkCloudStoreBook) {
        purchasedBookItemView.d.setEnabled(false);
        purchasedBookItemView.d.setAction(BookAction.CONNECTING);
        o.a().b(dkCloudStoreBook.getBookUuid());
        a.a().a(dkCloudStoreBook.getBookUuid(), false, new ju(dkCloudStoreBook, purchasedBookItemView));
    }

    private static void f(PurchasedBookItemView purchasedBookItemView, DkCloudStoreBook dkCloudStoreBook) {
        c b = ai.a().b(dkCloudStoreBook.getBookUuid());
        if (!b.ai()) {
            return;
        }
        if (b.s() == BookPackageType.EPUB) {
            ay.a(ManagedApp.get().getTopActivity(), b.C(), new jx(purchasedBookItemView, dkCloudStoreBook, b));
        } else {
            DkCloudStorage.a().a(b.H(), new jz(b));
        }
    }
}
