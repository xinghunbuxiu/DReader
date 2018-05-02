package com.duokan.reader;

import android.graphics.drawable.Drawable;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.ui.C0457r;
import com.duokan.reader.ui.bookshelf.he;
import com.duokan.reader.ui.bookshelf.hi;
import com.duokan.reader.ui.reading.su;

public class EmptyReaderFeature implements ReaderFeature {

    class Holder {
        /* renamed from: a */
        static final EmptyReaderFeature f1454a = new EmptyReaderFeature();

        private Holder() {
        }
    }

    private EmptyReaderFeature() {
    }

    public static EmptyReaderFeature get() {
        return Holder.f1454a;
    }

    public boolean navigateSmoothly(String str) {
        return false;
    }

    public boolean navigateSmoothly(String str, Runnable runnable) {
        return false;
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        return false;
    }

    public C0457r getTheme() {
        return null;
    }

    public boolean pushHalfPage(ActivatedController c0303e) {
        return false;
    }

    public boolean pushHalfPageSmoothly(ActivatedController c0303e, Runnable runnable) {
        return false;
    }

    public boolean pushPage(ActivatedController c0303e) {
        return false;
    }

    public boolean pushPageSmoothly(ActivatedController c0303e, Runnable runnable) {
        return false;
    }

    public boolean pushFloatingPage(ActivatedController c0303e) {
        return false;
    }

    public boolean pushFloatingPageSmoothly(ActivatedController c0303e, Runnable runnable) {
        return false;
    }

    public boolean showPopup(ActivatedController c0303e) {
        return false;
    }

    public boolean showPopup(ActivatedController c0303e, int i, int i2) {
        return false;
    }

    public boolean showPopupSmoothly(ActivatedController c0303e, Runnable runnable) {
        return false;
    }

    public int getScreenTimeout() {
        return 0;
    }

    public void setScreenTimeout(int i) {
    }

    public BrightnessMode getScreenBrightnessMode() {
        return null;
    }

    public void setScreenBrightnessMode(BrightnessMode brightnessMode) {
    }

    public float[] getScreenBrightnessRange() {
        return new float[0];
    }

    public float getScreenBrightness() {
        return 0.0f;
    }

    public void setScreenBrightness(float f) {
    }

    public BrightnessMode getKeyboardBrightnessMode() {
        return null;
    }

    public void setKeyboardBrightnessMode(BrightnessMode brightnessMode) {
    }

    public float getKeyboardBrightness() {
        return 0.0f;
    }

    public void setKeyboardBrightness(float f) {
    }

    public void switchNightMode(boolean z, boolean z2) {
    }

    public boolean inNightMode() {
        return false;
    }

    public void switchEyesSavingMode(boolean z) {
    }

    public Drawable getHeaderBackground() {
        return null;
    }

    public C0800c getReadingBook() {
        return null;
    }

    public su getReadingFeature() {
        return null;
    }

    public float[] getEyesSavingModeDensity() {
        return new float[0];
    }

    public void addSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
    }

    public void removeSystemUiConditioner(SystemUiConditioner systemUiConditioner) {
    }

    public void updateSystemUi(boolean z) {
    }

    public void prompt(String str) {
    }

    public void prompt(String str, int i) {
    }

    public void openBook(C0800c c0800c) {
    }

    public void openBook(C0800c c0800c, C0896a c0896a, Runnable runnable) {
    }

    public void openBook(String str, C0896a c0896a) {
    }

    public void shareBooks(ActivatedController c0303e, C0800c... c0800cArr) {
    }

    public void downloadBooks(C0800c... c0800cArr) {
    }

    public void goHome(Runnable runnable) {
    }

    public void showBookHomePage(IFeature mFeature, String str, String str2, boolean z, String str3) {
    }

    public void showMenuFromBottom(hi hiVar) {
    }

    public void showMenuFromTop(he heVar) {
    }

    public long getTotalActiveTime() {
        return 0;
    }

    public int getPageCount() {
        return 0;
    }

    public void setQuitOnBack(boolean z) {
    }
}
