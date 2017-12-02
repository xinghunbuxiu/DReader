package com.duokan.reader;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.b.e;
import com.duokan.b.i;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.bookshelf.js;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import miui.assistant.index.AssistContentIndex;
import miui.assistant.index.AssistContentItem;
import miui.assistant.index.IndexCallback;
import miui.assistant.index.IndexStatus;

public final class MiuiAssistContent {

    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ List a;

        AnonymousClass1(List list) {
            this.a = list;
        }

        public void run() {
            try {
                List arrayList = new ArrayList(this.a.size());
                for (c access$000 : this.a) {
                    arrayList.add(MiuiAssistContent.from(access$000));
                }
                AssistContentIndex.getDefaultIndex().batchIndexItems(DkApp.get(), arrayList, new IndexCallback(this) {
                    final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = r1;
                    }

                    public void onIndexed(IndexStatus indexStatus) {
                    }
                });
            } catch (Throwable th) {
            }
        }
    }

    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ c a;
        final /* synthetic */ String b;

        AnonymousClass2(c cVar, String str) {
            this.a = cVar;
            this.b = str;
        }

        public void run() {
            try {
                AssistContentItem access$000 = MiuiAssistContent.from(this.a);
                if (access$000 != null) {
                    if (!TextUtils.isEmpty(this.b)) {
                        access$000.setContentDescription(this.b);
                    }
                    AssistContentIndex.getDefaultIndex().indexItem(DkApp.get(), access$000, new IndexCallback(this) {
                        final /* synthetic */ AnonymousClass2 a;

                        {
                            this.a = r1;
                        }

                        public void onIndexed(IndexStatus indexStatus) {
                        }
                    });
                }
            } catch (Throwable th) {
            }
        }
    }

    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ c a;

        AnonymousClass3(c cVar) {
            this.a = cVar;
        }

        public void run() {
            try {
                AssistContentIndex.getDefaultIndex().deleteIndexItem(DkApp.get(), this.a.aF() + "", new IndexCallback(this) {
                    final /* synthetic */ AnonymousClass3 a;

                    {
                        this.a = r1;
                    }

                    public void onIndexed(IndexStatus indexStatus) {
                    }
                });
            } catch (Throwable th) {
            }
        }
    }

    final class AnonymousClass4 extends WebSession {
        final /* synthetic */ BookFormat a;
        final /* synthetic */ File b;

        AnonymousClass4(BookFormat bookFormat, File file) {
            this.a = bookFormat;
            this.b = file;
        }

        protected void onSessionTry() {
            try {
                InputStream openRawResource;
                switch (this.a) {
                    case EPUB:
                        openRawResource = DkApp.get().getTopActivity().getResources().openRawResource(e.general__shared__cover_epub);
                        break;
                    case PDF:
                        openRawResource = DkApp.get().getTopActivity().getResources().openRawResource(e.general__shared__cover_pdf);
                        break;
                    default:
                        openRawResource = DkApp.get().getTopActivity().getResources().openRawResource(e.general__shared__cover_txt);
                        break;
                }
                OutputStream fileOutputStream = new FileOutputStream(this.b);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openRawResource.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        openRawResource.close();
                        return;
                    }
                }
            } catch (Throwable th) {
            }
        }

        protected void onSessionSucceeded() {
        }

        protected void onSessionFailed() {
        }
    }

    public static void insert(List list) {
        if (list.size() >= 1) {
            ah.a(new AnonymousClass1(list), "miuiAssist");
        }
    }

    public static void insert(c cVar, String str) {
        ah.a(new AnonymousClass2(cVar, str), "miuiAssist");
    }

    public static void delete(c cVar) {
        ah.a(new AnonymousClass3(cVar), "miuiAssist");
    }

    private static AssistContentItem from(c cVar) {
        try {
            AssistContentItem assistContentItem = new AssistContentItem();
            assistContentItem.setCardName(DkApp.get().getString(i.general__shared__duokan));
            assistContentItem.setType("book");
            assistContentItem.setUniqueId(cVar.aF() + "");
            assistContentItem.setTitle(cVar.aw());
            assistContentItem.setContentDescription(formatReadingPosition(DkApp.get(), cVar.D()));
            if (!TextUtils.isEmpty(cVar.h()) && new File(Uri.parse(cVar.h()).getPath()).exists()) {
                assistContentItem.setIcon(cVar.h());
            } else if (cVar.ai()) {
                assistContentItem.setIcon(cVar.g());
            } else {
                assistContentItem.setIcon(getUriForDefaultCover(cVar.q()));
            }
            assistContentItem.setUri(generateBookIntentUri(DkApp.get(), cVar));
            assistContentItem.setMoreUri(generateBookshelfIntentUri(DkApp.get()));
            JSONObject jSONObject = new JSONObject();
            if (cVar.o() == BookType.SERIAL && ((ej) cVar).ba() > 0) {
                jSONObject.put("update", DkApp.get().getString(i.miui_assistant__shared__update));
            }
            if (!TextUtils.isEmpty(cVar.B())) {
                jSONObject.put("author", cVar.B());
            }
            assistContentItem.setExtrasJson(jSONObject.toString());
            return assistContentItem;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String generateBookIntentUri(Context context, c cVar) {
        Intent intent = new Intent();
        intent.setClass(context, DkApp.get().getReaderActivityClass());
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("duokan-reader://reading/" + cVar.H()));
        return intent.toUri(0);
    }

    private static String generateBookshelfIntentUri(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, DkApp.get().getReaderActivityClass());
        intent.setAction("com.duokan.reader.actions.SHOW_BOOKSHELF");
        return intent.toUri(0);
    }

    private static String formatReadingPosition(Context context, js jsVar) {
        if (jsVar.a()) {
            return context.getResources().getString(i.bookshelf__bookshelf_item_view__unread);
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        return String.format(context.getResources().getString(i.bookshelf__bookshelf_item_view__read_s), new Object[]{decimalFormat.format((double) jsVar.e)});
    }

    private static String getUriForDefaultCover(BookFormat bookFormat) {
        File file;
        switch (bookFormat) {
            case EPUB:
                file = new File(ReaderEnv.get().getDownloadedCoverDirectory(), "epub_default_cover");
                break;
            case PDF:
                file = new File(ReaderEnv.get().getDownloadedCoverDirectory(), "pdf_default_cover");
                break;
            default:
                file = new File(ReaderEnv.get().getDownloadedCoverDirectory(), "txt_default_cover");
                break;
        }
        if (file.exists()) {
            return Uri.fromFile(file).toString();
        }
        new AnonymousClass4(bookFormat, file).open();
        return Uri.fromFile(file).toString();
    }
}
