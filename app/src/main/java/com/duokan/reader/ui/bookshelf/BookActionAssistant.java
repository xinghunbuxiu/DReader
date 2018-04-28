package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.download.DownloadFailCode;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.micloud.C1068i;

public class BookActionAssistant {

    public enum BookAction {
        EDIT,
        READ,
        CONNECTING,
        CAN_UPDATE,
        DOWNLOAD,
        DOWNLOADING,
        DOWNLOAD_PAUSED,
        DOWNLOAD_FAILED,
        CAN_UPLOAD,
        UPLOADING,
        UPLOAD_PAUSED,
        UPLOAD_FAILED,
        GIFI
    }

    /* renamed from: a */
    public static ah m9056a(Context context, C1068i c1068i) {
        ah ahVar = new ah();
        if (c1068i != null) {
            if (c1068i.m2295j()) {
                ahVar.f6093a = BookAction.UPLOAD_PAUSED;
                ahVar.f6095c = ((float) c1068i.m8210F()) / ((float) c1068i.m8207C());
                ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__upload_paused);
            } else if (c1068i.m2298m()) {
                ahVar.f6093a = BookAction.UPLOAD_FAILED;
                ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__upload_failed);
            } else {
                ahVar.f6093a = BookAction.UPLOADING;
                ahVar.f6095c = ((float) c1068i.m8210F()) / ((float) c1068i.m8207C());
                ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__uploading);
            }
        }
        return ahVar;
    }

    /* renamed from: a */
    public static ah m9055a(Context context, C0800c c0800c) {
        ah ahVar = new ah();
        if (c0800c != null) {
            if (c0800c.m4247s() == BookPackageType.EPUB_OPF) {
                if (c0800c.m4171X()) {
                    if (c0800c.m4173Z()) {
                        ahVar.f6095c = c0800c.m4240m() / 100.0f;
                        ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__download_paused);
                    } else {
                        ahVar.f6095c = c0800c.m4240m() / 100.0f;
                        ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__downloading);
                    }
                }
                if (c0800c.m4233i() == BookState.CLOUD_ONLY) {
                    ahVar.f6093a = BookAction.DOWNLOAD;
                    ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__undownload);
                } else if (c0800c.ak() && c0800c.aw()) {
                    ahVar.f6093a = BookAction.CAN_UPDATE;
                    ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__update);
                } else {
                    ahVar.f6093a = BookAction.READ;
                }
            } else if (c0800c.au()) {
                ahVar.f6093a = BookAction.CONNECTING;
                ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__connecting);
            } else if (c0800c.m4171X()) {
                if (c0800c.m4173Z()) {
                    ahVar.f6093a = BookAction.DOWNLOAD_PAUSED;
                    ahVar.f6095c = c0800c.m4240m() / 100.0f;
                    ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__download_paused);
                } else if (c0800c.aa()) {
                    ahVar.f6093a = BookAction.DOWNLOAD_FAILED;
                    if (c0800c.m4241n() == DownloadFailCode.MD5_MISMATCH) {
                        ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__download_failed_md5_mismatch);
                    } else {
                        ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__download_failed);
                    }
                } else {
                    ahVar.f6093a = BookAction.DOWNLOADING;
                    ahVar.f6095c = c0800c.m4240m() / 100.0f;
                    ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__downloading);
                }
            } else if (c0800c.m4233i() == BookState.CLOUD_ONLY) {
                ahVar.f6093a = BookAction.DOWNLOAD;
                ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__undownload);
            } else if (c0800c.ak() && c0800c.aw()) {
                ahVar.f6093a = BookAction.CAN_UPDATE;
                ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__update);
            } else {
                C1068i b = it.m4692a().m4726b(c0800c.m4222e());
                if (b == null) {
                    ahVar.f6093a = BookAction.READ;
                } else if (b.m2295j()) {
                    ahVar.f6093a = BookAction.UPLOAD_PAUSED;
                    ahVar.f6095c = ((float) b.m8210F()) / ((float) b.m8207C());
                    ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__upload_paused);
                } else if (b.m2298m()) {
                    ahVar.f6093a = BookAction.UPLOAD_FAILED;
                    ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__upload_failed);
                } else {
                    ahVar.f6093a = BookAction.UPLOADING;
                    ahVar.f6095c = ((float) b.m8210F()) / ((float) b.m8207C());
                    ahVar.f6094b = m9057a(context, C0247i.bookshelf__general_shared__uploading);
                }
            }
        }
        return ahVar;
    }

    /* renamed from: a */
    private static String m9057a(Context context, int i) {
        return context.getString(i);
    }
}
