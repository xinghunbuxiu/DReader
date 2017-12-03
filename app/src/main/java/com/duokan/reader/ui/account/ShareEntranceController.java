package com.duokan.reader.ui.account;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;

import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.store.DkStoreBook;
import com.duokan.reader.ui.general.hd;

import org.apache.http.protocol.HTTP;

import java.text.SimpleDateFormat;

public class ShareEntranceController extends hd {
    private ap a;

    public enum ShareType {
        TEXT,
        BITMAP,
        STATISTICS,
        COMMENT,
        NOTE,
        BOOK,
        NORMAL
    }

    public ShareEntranceController(IFeature featrue, String str, Bitmap bitmap) {
        this(featrue, new bd(ShareType.STATISTICS, new String[]{str}, null, null, bitmap, null), a(featrue, null, bitmap), null);
    }

    public ShareEntranceController(IFeature featrue, c cVar, String str, Bitmap bitmap, cz czVar) {
        this(featrue, new bd(bitmap != null ? ShareType.BITMAP : ShareType.TEXT, bitmap != null ? new String[]{cVar.aw(), str} : new String[]{cVar.aw(), "", str}, cVar.t().f, new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis())), bitmap, null), a(featrue, cVar, bitmap), czVar);
    }

    public ShareEntranceController(IFeature featrue, c cVar, a aVar, boolean z, cz czVar) {
        ShareType shareType = (!(aVar instanceof ef) || TextUtils.isEmpty(((ef) aVar).m())) ? ShareType.COMMENT : ShareType.NOTE;
        this(featrue, new bd(shareType, aVar instanceof ef ? new String[]{cVar.aw(), ((ef) aVar).m(), aVar.a(z)} : new String[]{cVar.aw(), "", aVar.a(z)}, cVar.t().f, new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(aVar.g())), null, null), a(featrue, cVar, null), czVar);
    }

    public ShareEntranceController(IFeature featrue, DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudComment dkCloudComment) {
        String a;
        int i = 2;
        ShareType shareType = TextUtils.isEmpty(dkCloudComment.getNoteText()) ? ShareType.COMMENT : ShareType.NOTE;
        String[] strArr = new String[]{dkCloudNoteBookInfo.getTitle(), dkCloudComment.getNoteText(), dkCloudComment.getSample()};
        if (dkCloudNoteBookInfo.isDuokanBookNote()) {
            p i2 = p.i();
            String str = "0";
            if (!dkCloudNoteBookInfo.isSerial()) {
                i = 1;
            }
            a = i2.a(str, i, dkCloudNoteBookInfo.getBookUuid(), null);
        } else {
            a = "";
        }
        this(featrue, new bd(shareType, strArr, a, new SimpleDateFormat("yyyy-MM-dd").format(dkCloudComment.getCreationDate()), null, null), new az(dkCloudNoteBookInfo), null);
    }

    public ShareEntranceController(IFeature featrue, String str, c cVar, Bitmap bitmap) {
        this(featrue, new bd(ShareType.BOOK, new String[]{cVar.aw(), "", cVar.t().d}, str, null, bitmap, null), a(featrue, cVar, bitmap), null);
    }

    public ShareEntranceController(IFeature featrue, String str, DkStoreBook dkStoreBook, String str2, Bitmap bitmap) {
        this(featrue, new bd(ShareType.BOOK, new String[]{dkStoreBook.getTitle(), dkStoreBook.getDescription(), str2}, str, null, bitmap, null), new ba(dkStoreBook), null);
    }

    private ShareEntranceController(IFeature featrue, bd bdVar, be beVar, cz czVar) {
        super(featrue);
        this.a = null;
        View view = new View(getContext());
        view.setBackgroundColor(0);
        setContentView(view);
        this.a = new ap(getContext(), true, new bb(this, bdVar, beVar, czVar));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z && this.a != null) {
            this.a.show();
        }
    }

    protected boolean onRequestDetach(ActivatedController activatedControllerVar) {
        if (super.onRequestDetach(activatedControllerVar) && getPopupCount() < 1) {
            requestDetach();
        }
        return true;
    }

    private void a(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setFlags(268435456);
        getContext().startActivity(Intent.createChooser(intent, getContext().getString(j.upload_ok)));
    }

    private void a(String str, bd bdVar, be beVar, cz czVar) {
        new ch(getContext(), getActivity(), str, bdVar, beVar, czVar).show();
    }

    private static be a(IFeature featrue, c cVar, Bitmap bitmap) {
        return new bc(cVar);
    }

    private String a(String[] strArr) {
        String str = "";
        if (!TextUtils.isEmpty(strArr[1])) {
            str = str + strArr[1] + "\n\n";
        }
        str = str + strArr[2];
        if (TextUtils.isEmpty(strArr[0])) {
            return str;
        }
        return str + "\n\n————" + String.format(getString(j.reading__export_notes_title), new Object[]{strArr[0]});
    }
}
