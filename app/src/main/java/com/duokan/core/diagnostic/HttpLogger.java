package com.duokan.core.diagnostic;

import android.text.TextUtils;
import android.util.Log;

import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.aq;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class HttpLogger {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());

    private static final String TAG = HttpLogger.class.getName();

    private static final ConcurrentLinkedQueue<HttpLogger> loggers = new ConcurrentLinkedQueue();

    private File file = null;

    private ConcurrentLinkedQueue<Logger> loggerQueue = new ConcurrentLinkedQueue();

    public HttpLogger() {
        loggers.add(this);
    }


    public void setFile(File file) {
        this.file = file;
    }


    public void printStackTraceString(LogLevel logLevel, String tag, String message) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Thread currentThread = Thread.currentThread();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        printWriter.println(currentThread.toString());
        for (StackTraceElement stackTraceElement : stackTrace) {
            printWriter.print("\t");
            printWriter.println(stackTraceElement.toString());
        }
        printWriter.flush();
        printWriter.close();
        print(logLevel, tag, message, stringWriter.toString());
    }


    public void printAllStackTraceString(LogLevel logLevel, String tag, String message) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        for (Entry entry : aq.m883b()) {
            Thread thread = (Thread) entry.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
            printWriter.println(thread.toString());
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                printWriter.print("\t");
                printWriter.println(stackTraceElement.toString());
            }
        }
        printWriter.flush();
        printWriter.close();
        print(logLevel, tag, message, stringWriter.toString());
    }


    public void printStackTrace(LogLevel logLevel, String str, String str2, Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
        print(logLevel, str, str2, stringWriter.toString());
    }


    public void print(LogLevel logLevel, String str, String str2, String str3) {
        c(logLevel, str, String.format(Locale.getDefault(), ">>>%s\n%s\n<<<", new Object[]{str2, str3}));
    }


    public void c(LogLevel logLevel, String error, String msg) {
        Logger logger = new Logger(logLevel, error, msg);
        this.loggerQueue.add(logger);
        printLogger(logger);
        printLogLevel(logLevel);
    }


    public void a(LogLevel logLevel, String str, String str2, Object... objArr) {
        String str3 = "";
        try {
            str3 = String.format(str2, objArr);
        } catch (Throwable th) {
            str3 = th.toString();
        }
        Logger logger = new Logger(logLevel, str, str3);
        this.loggerQueue.add(logger);
        printLogger(logger);
        printLogLevel(logLevel);
    }


    public void d() {
        if (!this.loggerQueue.isEmpty()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.loggerQueue;
            this.loggerQueue = new ConcurrentLinkedQueue();
            ah.m866a(new C0333g(this, concurrentLinkedQueue), TAG);
        }
    }


    public void e() {
        if (!this.loggerQueue.isEmpty()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.loggerQueue;
            this.loggerQueue = new ConcurrentLinkedQueue();
            try {
                ah.m866a(new C0334h(this, concurrentLinkedQueue), TAG).get();
            } catch (Throwable th) {
            }
        }
    }


    private void printLogLevel(LogLevel logLevel) {
        int obj = logLevel.ordinal() >= LogLevel.ERROR.ordinal() ? 1 : 0;
        int obj2 = logLevel.ordinal() < LogLevel.EVENT.ordinal() ? 0 : 1;
        int ordinal = logLevel.ordinal() >= LogLevel.DISASTER.ordinal() ? 1 : 0;
        if (ordinal != 0) {
            Iterator<HttpLogger> it = loggers.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        } else if (obj != 0) {
            e();
        } else if (obj2 != 0) {
            d();
            ;
        }
    }


    private static void printFile(Queue<Logger> queue, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            if (file != null) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                fileOutputStream = new FileOutputStream(file, true);
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(fileOutputStream), "utf-8"), false);
                for (Logger logger : queue) {
                    printWriter.println(logger.toString());
                }
                printWriter.flush();
                printWriter.close();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void printLogger(Logger logger) {
        String[] split = logger.toString().split("[\r\n\\u0085\\u2028\\u2029]+");
        int i = 0;
        while (i < split.length) {
            String str = i < 1 ? split[i] : logger.logLevel + split[i];
            if (logger.logLevel.ordinal() >= LogLevel.WARNING.ordinal()) {
                Log.e("logger", str);
            } else {
                Log.i("logger", str);
            }
            i++;
        }
    }

    class Logger {


        private final Thread currentThread = UIdleHandler.getCurrentThread();

        private final long timeMillis = System.currentTimeMillis();

        private final LogLevel logLevel;

        private final String error;

        private final String msg;

        private final String logInfo;

        public Logger(LogLevel logLevel, String error, String msg) {
            String arg3;
            this.logLevel = logLevel;
            this.error = error;
            this.msg = msg;
            Locale locale = Locale.getDefault();
            String format = "[%s]%s";
            Object[] objArr = new Object[2];
            objArr[0] = this.logLevel.name();
            if (TextUtils.isEmpty(this.error)) {
                arg3 = "";
            } else {
                arg3 = String.format(Locale.getDefault(), "[%s]", new Object[]{this.error});
            }
            objArr[1] = arg3;
            this.logInfo = String.format(locale, format, objArr);
        }

        public String toString() {
            String format = SIMPLE_DATE_FORMAT.format(new Date(this.timeMillis));
            return String.format(Locale.getDefault(), "%s%s //@%s, %s", new Object[]{this.logInfo, this.msg, this.currentThread.toString(), format});
        }
    }
}
