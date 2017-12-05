package com.duokan.core.diagnostic;

import android.text.TextUtils;

import com.duokan.core.sys.AIdleOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logger {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    private final Thread currentThread = AIdleOperation.getCurrentThread();
    private final long timeMillis = System.currentTimeMillis();
    private final LogLevel logLevel;
    private final String error;
    private final String msg;
    private final String logInfo;

    /**
     *
     * @param logLevel
     * @param error
     * @param msg
     */
    public Logger(LogLevel logLevel, String error, String msg) {
        String str3;
        this.logLevel = logLevel;
        this.error = error;
        this.msg = msg;
        Locale locale = Locale.getDefault();
        String format = "[%s]%s";
        Object[] args = new Object[2];
        args[0] = this.logLevel.name();
        if (TextUtils.isEmpty(this.error)) {
            str3 = "";
        } else {
            str3 = String.format(Locale.getDefault(), "[%s]", new Object[]{this.error});
        }
        args[1] = str3;
        this.logInfo = String.format(locale, format, args);
    }

    public String toString() {
        String format = a.format(new Date(this.timeMillis));
        return String.format(Locale.getDefault(), "%s%s //@%s, %s", new Object[]{this.logInfo, this.msg, this.currentThread.toString(), format});
    }
}
