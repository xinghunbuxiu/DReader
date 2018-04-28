package com.duokan.reader.ui.account;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.store.DkStoreBook;
import com.duokan.reader.ui.general.gs;
import java.text.SimpleDateFormat;
import org.apache.http.protocol.HTTP;

public class ShareEntranceController extends gs {
    /* renamed from: a */
    private ab f5749a;

    public enum ShareType {
        TEXT,
        BITMAP,
        STATISTICS,
        COMMENT,
        NOTE,
        BOOK,
        NORMAL
    }

    public ShareEntranceController(IFeature mFeature, String str, Bitmap bitmap) {
        this(mFeature, new ap(ShareType.STATISTICS, new String[]{str}, null, null, bitmap, null), m8815a(mFeature, null, bitmap), null);
    }

    public ShareEntranceController(IFeature mFeature, C0800c c0800c, String str, Bitmap bitmap, cp cpVar) {
        this(mFeature, new ap(bitmap != null ? ShareType.BITMAP : ShareType.TEXT, bitmap != null ? new String[]{c0800c.ay(), str} : new String[]{c0800c.ay(), "", str}, c0800c.m4248t().f2708f, new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis())), bitmap, null), m8815a(mFeature, c0800c, bitmap), cpVar);
    }

    public ShareEntranceController(IFeature mFeature, C0800c c0800c, C0798a c0798a, boolean z, cp cpVar) {
        ShareType shareType = (!(c0798a instanceof ea) || TextUtils.isEmpty(((ea) c0798a).m4384m())) ? ShareType.COMMENT : ShareType.NOTE;
        this(mFeature, new ap(shareType, c0798a instanceof ea ? new String[]{c0800c.ay(), ((ea) c0798a).m4384m(), c0798a.m3715a(z)} : new String[]{c0800c.ay(), "", c0798a.m3715a(z)}, c0800c.m4248t().f2708f, new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(c0798a.m3730g())), null, null), m8815a(mFeature, c0800c, null), cpVar);
    }

    public ShareEntranceController(IFeature mFeature, DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudComment dkCloudComment) {
        String a;
        int i = 2;
        ShareType shareType = TextUtils.isEmpty(dkCloudComment.getNoteText()) ? ShareType.COMMENT : ShareType.NOTE;
        String[] strArr = new String[]{dkCloudNoteBookInfo.getTitle(), dkCloudComment.getNoteText(), dkCloudComment.getSample()};
        if (dkCloudNoteBookInfo.isDuokanBookNote()) {
            C0641o i2 = C0641o.m2934i();
            String str = "0";
            if (!dkCloudNoteBookInfo.isSerial()) {
                i = 1;
            }
            a = i2.m2954a(str, i, dkCloudNoteBookInfo.getBookUuid(), null);
        } else {
            a = "";
        }
        this(mFeature, new ap(shareType, strArr, a, new SimpleDateFormat("yyyy-MM-dd").format(dkCloudComment.getCreationDate()), null, null), new al(dkCloudNoteBookInfo), null);
    }

    public ShareEntranceController(IFeature mFeature, String str, C0800c c0800c, Bitmap bitmap) {
        this(mFeature, new ap(ShareType.BOOK, new String[]{c0800c.ay(), "", c0800c.m4248t().f2706d}, str, null, bitmap, null), m8815a(mFeature, c0800c, bitmap), null);
    }

    public ShareEntranceController(IFeature mFeature, String str, DkStoreBook dkStoreBook, String str2, Bitmap bitmap) {
        this(mFeature, new ap(ShareType.BOOK, new String[]{dkStoreBook.getTitle(), dkStoreBook.getDescription(), str2}, str, null, bitmap, null), new am(dkStoreBook), null);
    }

    private ShareEntranceController(IFeature mFeature, ap apVar, aq aqVar, cp cpVar) {
        super(mFeature);
        this.f5749a = null;
        View view = new View(getContext());
        view.setBackgroundColor(0);
        setContentView(view);
        this.f5749a = new ab(getContext(), true, new an(this, apVar, aqVar, cpVar));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z && this.f5749a != null) {
            this.f5749a.show();
        }
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (super.onRequestDetach(c0303e) && getPopupCount() < 1) {
            requestDetach();
        }
        return true;
    }

    /* renamed from: a */
    private void m8820a(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setFlags(268435456);
        getContext().startActivity(Intent.createChooser(intent, getContext().getString(C0258j.upload_ok)));
    }

    /* renamed from: a */
    private void m8821a(String str, ap apVar, aq aqVar, cp cpVar) {
        new bx(getContext(), getActivity(), str, apVar, aqVar, cpVar).show();
    }

    /* renamed from: a */
    private static aq m8815a(IFeature mFeature, C0800c c0800c, Bitmap bitmap) {
        return new ao(c0800c);
    }

    /* renamed from: a */
    private String m8817a(String[] strArr) {
        String str = "";
        if (!TextUtils.isEmpty(strArr[1])) {
            str = str + strArr[1] + "\n\n";
        }
        str = str + strArr[2];
        if (TextUtils.isEmpty(strArr[0])) {
            return str;
        }
        return str + "\n\n————" + String.format(getString(C0258j.reading__export_notes_title), new Object[]{strArr[0]});
    }
}
