package com.duokan.reader.ui.bookshelf;

import android.content.Context;

import com.duokan.reader.common.download.DownloadFailCode;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.micloud.i;

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

    public static ab a(Context context, i iVar) {
        ab abVar = new ab();
        if (iVar != null) {
            if (iVar.j()) {
                abVar.a = BookAction.UPLOAD_PAUSED;
                abVar.c = ((float) iVar.F()) / ((float) iVar.C());
                abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__upload_paused);
            } else if (iVar.m()) {
                abVar.a = BookAction.UPLOAD_FAILED;
                abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__upload_failed);
            } else {
                abVar.a = BookAction.UPLOADING;
                abVar.c = ((float) iVar.F()) / ((float) iVar.C());
                abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__uploading);
            }
        }
        return abVar;
    }

    public static ab a(Context context, c cVar) {
        ab abVar = new ab();
        if (cVar == null) {
            return abVar;
        }
        float f;
        if (cVar.s() == BookPackageType.EPUB_OPF) {
            if (cVar.V()) {
                if (cVar.X()) {
                    abVar.c = cVar.m() / 100.0f;
                    abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__download_paused);
                } else {
                    abVar.c = cVar.m() / 100.0f;
                    abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__downloading);
                }
            }
            if (cVar.i() == BookState.CLOUD_ONLY) {
                abVar.a = BookAction.DOWNLOAD;
                abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__undownload);
            } else if (cVar.ai() && cVar.au()) {
                abVar.a = BookAction.CAN_UPDATE;
                abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__update);
            } else {
                abVar.a = BookAction.READ;
                f = cVar.D().e;
            }
        } else if (cVar.as()) {
            abVar.a = BookAction.CONNECTING;
            abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__connecting);
        } else if (cVar.V()) {
            if (cVar.X()) {
                abVar.a = BookAction.DOWNLOAD_PAUSED;
                abVar.c = cVar.m() / 100.0f;
                abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__download_paused);
            } else if (cVar.Y()) {
                abVar.a = BookAction.DOWNLOAD_FAILED;
                if (cVar.n() == DownloadFailCode.MD5_MISMATCH) {
                    abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__download_failed_md5_mismatch);
                } else {
                    abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__download_failed);
                }
            } else {
                abVar.a = BookAction.DOWNLOADING;
                abVar.c = cVar.m() / 100.0f;
                abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__downloading);
            }
        } else if (cVar.i() == BookState.CLOUD_ONLY) {
            abVar.a = BookAction.DOWNLOAD;
            abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__undownload);
        } else if (cVar.ai() && cVar.au()) {
            abVar.a = BookAction.CAN_UPDATE;
            abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__update);
        } else {
            i b = iz.a().b(cVar.e());
            if (b == null) {
                BookAction bookAction = (iz.a().d() && iz.a().a(cVar)) ? BookAction.CAN_UPLOAD : BookAction.READ;
                abVar.a = bookAction;
                f = cVar.D().e;
            } else if (b.j()) {
                abVar.a = BookAction.UPLOAD_PAUSED;
                abVar.c = ((float) b.F()) / ((float) b.C());
                abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__upload_paused);
            } else if (b.m()) {
                abVar.a = BookAction.UPLOAD_FAILED;
                abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__upload_failed);
            } else {
                abVar.a = BookAction.UPLOADING;
                abVar.c = ((float) b.F()) / ((float) b.C());
                abVar.b = a(context, com.duokan.b.i.bookshelf__general_shared__uploading);
            }
        }
        return abVar;
    }

    private static String a(Context context, int i) {
        return context.getString(i);
    }
}
