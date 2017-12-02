package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;

import com.duokan.b.d;
import com.duokan.b.e;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkRenderInfo;
import com.duokan.kernel.epublib.DKFileInfo;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.bitmap.a;
import com.duokan.reader.domain.document.a.o;

import org.apache.http.HttpStatus;

import java.io.File;

public class x {
    private final Context a;

    public x(Context context) {
        this.a = context;
    }

    public Context a() {
        return this.a;
    }

    public Resources b() {
        return this.a.getResources();
    }

    public Bitmap a(String str, Config config, String str2) {
        Bitmap a;
        Options options = new Options();
        options.inPreferredConfig = config;
        Bitmap bitmap = null;
        File file = new File(Uri.parse(str).getPath());
        if (!file.exists()) {
            bitmap = null;
        } else if (file.getName().toLowerCase().endsWith("epub")) {
            DkeBook dkeBook = new DkeBook(file.toString(), ReaderEnv.get().getTempDirectory().toString(), null, (byte[][]) null);
            if (dkeBook.isValid()) {
                DKFileInfo dKFileInfo = new DKFileInfo();
                dkeBook.getBookCover(dKFileInfo);
                if (dKFileInfo.dataLength > 0) {
                    a = a.a(a(), dKFileInfo.data, 0, dKFileInfo.data.length, options);
                } else {
                    a = null;
                }
                dkeBook.close();
            } else {
                a = null;
            }
            if (a == null) {
                a = BitmapFactory.decodeResource(b(), e.general__book_cover_view__duokan_cover, options);
            }
            bitmap = a;
        } else if (file.getName().toLowerCase().endsWith("pdf")) {
            DkpBook openBook = o.c().a().openBook(file.getAbsolutePath());
            openBook.setDefaultFont(ReaderEnv.get().getSystemFontFileZh().getAbsolutePath(), 134);
            openBook.setDefaultFont(ReaderEnv.get().getSystemFontFileEn().getAbsolutePath(), 0);
            int dimension = (int) b().getDimension(d.general__shared__cover_grid_width);
            int dimension2 = (int) b().getDimension(d.general__shared__cover_grid_height);
            float max = Math.max((1.0f * ((float) dimension)) / ((float) openBook.getPageWidth(1)), (1.0f * ((float) dimension2)) / ((float) openBook.getPageHeight(1)));
            Bitmap c = a.c(Math.round(((float) openBook.getPageWidth(1)) * max), Math.round(((float) openBook.getPageHeight(1)) * max), config);
            c.eraseColor(-1);
            DkRenderInfo dkRenderInfo = new DkRenderInfo();
            dkRenderInfo.mPageNum = 1;
            dkRenderInfo.mPageRect = new DkBox(0.0f, 0.0f, (float) openBook.getPageWidth(1), (float) openBook.getPageHeight(1));
            dkRenderInfo.mScale = max;
            dkRenderInfo.mBitmap = c;
            openBook.renderFixedPage(dkRenderInfo);
            openBook.close();
            bitmap = a.c(dimension, dimension2, config);
            Canvas canvas = new Canvas(bitmap);
            Rect rect = new Rect(0, 0, dimension, dimension2);
            Rect rect2 = new Rect(0, 0, c.getWidth(), c.getHeight());
            if (c.getWidth() > c.getHeight()) {
                dimension2 = (c.getWidth() - c.getHeight()) / 2;
                rect2.set(dimension2, 0, c.getWidth() - dimension2, c.getHeight());
            }
            canvas.drawBitmap(c, rect2, rect, null);
            c.recycle();
        }
        if (bitmap == null || bitmap.getWidth() <= HttpStatus.SC_MULTIPLE_CHOICES) {
            return bitmap;
        }
        a = Bitmap.createScaledBitmap(bitmap, HttpStatus.SC_MULTIPLE_CHOICES, Math.round((300.0f / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight())), false);
        bitmap.recycle();
        return a;
    }
}
