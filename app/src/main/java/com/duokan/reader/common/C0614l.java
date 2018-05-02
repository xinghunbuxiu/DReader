package com.duokan.reader.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.duokan.reader.common.l */
public class C0614l {
    /* renamed from: a */
    public static Bitmap m2797a(String str, int i) {
        Bitmap createBitmap;
        try {
            Map hashMap = new HashMap();
            hashMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashMap.put(EncodeHintType.MARGIN, Integer.valueOf(0));
            BitMatrix a = C0614l.m2798a(new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i, i, hashMap));
            int width = a.getWidth();
            int height = a.getHeight();
            int[] iArr = new int[(width * height)];
            for (int i2 = 0; i2 < height; i2++) {
                for (int i3 = 0; i3 < width; i3++) {
                    if (a.get(i3, i2)) {
                        iArr[(i2 * height) + i3] = -16777216;
                    } else {
                        iArr[(i2 * height) + i3] = -1;
                    }
                }
            }
            createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return createBitmap;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    private static BitMatrix m2798a(BitMatrix bitMatrix) {
        int[] enclosingRectangle = bitMatrix.getEnclosingRectangle();
        int i = enclosingRectangle[2] + 1;
        int i2 = enclosingRectangle[3] + 1;
        BitMatrix bitMatrix2 = new BitMatrix(i, i2);
        bitMatrix2.clear();
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (bitMatrix.get(enclosingRectangle[0] + i3, enclosingRectangle[1] + i4)) {
                    bitMatrix2.set(i3, i4);
                }
            }
        }
        return bitMatrix2;
    }
}
