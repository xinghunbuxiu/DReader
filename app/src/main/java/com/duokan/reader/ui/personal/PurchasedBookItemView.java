package com.duokan.reader.ui.personal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ManagedApp;
import com.duokan.p023b.C0244f;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;
import com.duokan.reader.ui.bookshelf.be;
import com.duokan.reader.ui.store.C1502o;
import com.duokan.reader.ui.store.DkCloudBookStatusHelper;
import com.duokan.reader.ui.store.DkCloudBookStatusHelper.StoreBookStatus;
import java.util.LinkedList;

public class PurchasedBookItemView extends RelativeLayout {
    /* renamed from: a */
    static final /* synthetic */ boolean f8223a = (!PurchasedBookItemView.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final LinkedList<PurchasedBookItemView> f8224b = new LinkedList();
    /* renamed from: c */
    private static kp f8225c = null;
    /* renamed from: d */
    private BookActionView f8226d = null;
    /* renamed from: e */
    private DkCloudStoreBook f8227e = null;
    /* renamed from: f */
    private boolean f8228f = false;
    /* renamed from: g */
    private boolean f8229g = false;

    public PurchasedBookItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public void m11370a(DkCloudStoreBook dkCloudStoreBook, boolean z, boolean z2) {
        this.f8227e = dkCloudStoreBook;
        this.f8228f = z;
        this.f8229g = z2;
        if (this.f8226d != null) {
            m11363b();
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8226d = (BookActionView) findViewById(C0244f.bookshelf__purchased_book_item_view__action_view);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f8224b.remove(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f8224b.add(this);
        if (f8225c == null) {
            f8225c = new kp();
            ai.m3980a().m3889a(f8225c);
            ai.m3980a().m3887a(f8225c);
        }
    }

    /* renamed from: a */
    private void m11361a(boolean z) {
        if (this.f8226d != null && this.f8227e != null) {
            if (z) {
                m11363b();
                return;
            }
            C0800c b = ai.m3980a().m3906b(this.f8227e.getBookUuid());
            if (b != null) {
                this.f8226d.m9062a(b.m4240m() / 100.0f, b.m4173Z());
            }
        }
    }

    /* renamed from: b */
    private void m11363b() {
        if (this.f8227e == null) {
            this.f8226d.setOnClickListener(null);
        } else if (this.f8228f) {
            this.f8226d.m9064a(BookAction.EDIT, this.f8229g);
        } else if (this.f8227e instanceof DkCloudPurchasedBook) {
            StoreBookStatus b = DkCloudBookStatusHelper.m15238b(this.f8227e.getBookUuid());
            this.f8226d.setEnabled(true);
            switch (ko.f8821a[b.ordinal()]) {
                case 1:
                    this.f8226d.setAction(BookAction.CAN_UPDATE);
                    break;
                case 2:
                    this.f8226d.setAction(BookAction.READ);
                    break;
                case 3:
                    C0800c b2 = ai.m3980a().m3906b(this.f8227e.getBookUuid());
                    if (b2 != null) {
                        this.f8226d.m9062a(b2.m4240m() / 100.0f, b2.m4173Z());
                        break;
                    }
                    break;
                case 4:
                    this.f8226d.setAction(this.f8227e.getBookSourceType() == DkStoreBookSourceType.GIFT ? BookAction.GIFI : BookAction.DOWNLOAD);
                    break;
                case 5:
                    this.f8226d.setEnabled(false);
                    this.f8226d.setAction(BookAction.CONNECTING);
                    break;
                default:
                    if (!f8223a) {
                        throw new AssertionError();
                    }
                    break;
            }
            this.f8226d.setOnClickListener(new kg(this, b));
        } else {
            if (C1502o.m15410a().m15434a(this.f8227e.getBookUuid())) {
                this.f8226d.setAction(BookAction.CONNECTING);
            } else {
                this.f8226d.setAction(BookAction.READ);
            }
            this.f8226d.setOnClickListener(new kh(this));
        }
    }

    /* renamed from: d */
    private static void m11367d(PurchasedBookItemView purchasedBookItemView, DkCloudStoreBook dkCloudStoreBook) {
        ((ReaderFeature) AppContext.getAppContext(DkApp.get()).queryFeature(ReaderFeature.class)).openBook(dkCloudStoreBook.getBookUuid(), null);
    }

    /* renamed from: e */
    private static void m11368e(PurchasedBookItemView purchasedBookItemView, DkCloudStoreBook dkCloudStoreBook) {
        purchasedBookItemView.f8226d.setEnabled(false);
        purchasedBookItemView.f8226d.setAction(BookAction.CONNECTING);
        C1502o.m15410a().m15435b(dkCloudStoreBook.getBookUuid());
        C1176a.m8695a().m8703a(dkCloudStoreBook.getBookUuid(), false, new ki(dkCloudStoreBook, purchasedBookItemView));
    }

    /* renamed from: f */
    private static void m11369f(PurchasedBookItemView purchasedBookItemView, DkCloudStoreBook dkCloudStoreBook) {
        C0800c b = ai.m3980a().m3906b(dkCloudStoreBook.getBookUuid());
        if (!b.ak()) {
            return;
        }
        if (b.m4247s() == BookPackageType.EPUB) {
            be.m9188a(ManagedApp.get().getTopActivity(), b.m4151D(), new kl(purchasedBookItemView, dkCloudStoreBook, b));
        } else {
            DkCloudStorage.m4994a().m5014a(b.m4156I(), new kn(b));
        }
    }
}
