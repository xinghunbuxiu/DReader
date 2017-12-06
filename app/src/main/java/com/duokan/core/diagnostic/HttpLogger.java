package com.duokan.core.diagnostic;

import android.text.TextUtils;
import android.util.Log;

import com.duokan.core.sys.AIdleOperation;
import com.duokan.core.sys.StackTracesInfo;
import com.duokan.core.sys.ah;

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
    private ConcurrentLinkedQueue<Logger> linkedQueue = new ConcurrentLinkedQueue();
    private File file = null;

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
        for (Entry entry : StackTracesInfo.getAllSortStackTraces()) {
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

    public void printStackTrace(LogLevel logLevel, String tag, String message, Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
        print(logLevel, tag, message, stringWriter.toString());
    }

    public void print(LogLevel logLevel, String tag, String message, String message2) {
        c(logLevel, tag, String.format(Locale.getDefault(), ">>>%s\n%s\n<<<", new Object[]{message, message2}));
    }

    public void c(LogLevel logLevel, String tag, String message) {
        Logger logger = new Logger(logLevel, tag, message);
        this.linkedQueue.add(logger);
        printLogger(logger);
        pringtLogLevel(logLevel);
    }

    public void a(LogLevel logLevel, String str, String str2, Object... objArr) {
        String str3 = "";
        try {
            str3 = String.format(str2, objArr);
        } catch (Throwable th) {
            str3 = th.toString();
        }
        Logger iVar = new Logger(logLevel, str, str3);
        this.linkedQueue.add(iVar);
        printLogger(iVar);
        pringtLogLevel(logLevel);
    }

    public void d() {
        if (!this.linkedQueue.isEmpty()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.linkedQueue;
            this.linkedQueue = new ConcurrentLinkedQueue();
            ah.future(new g(this, concurrentLinkedQueue), TAG);
        }
    }

    public void e() {
        if (!this.linkedQueue.isEmpty()) {
           final ConcurrentLinkedQueue concurrentLinkedQueue = this.linkedQueue;
            this.linkedQueue = new ConcurrentLinkedQueue();
            try {
                ah.future(new Runnable() {
                    @Override
                    public void run() {
                        printFile(concurrentLinkedQueue,file);
                    }
                }, TAG).get();
            } catch (Throwable th) {
            }
        }
    }
    private void pringtLogLevel(LogLevel logLevel) {
        int obj = logLevel.ordinal() >= LogLevel.ERROR.ordinal() ? 1 : 0;
        int obj2 = logLevel.ordinal() < LogLevel.EVENT.ordinal() ? 0 : 1;
        int obj3 = logLevel.ordinal() >= LogLevel.DISASTER.ordinal() ? 1 : 0;
        if (obj3 != 0) {
            Iterator<HttpLogger> loggerIterator = loggers.iterator();
            while (loggerIterator.hasNext()) {
                loggerIterator.next().e();
            }
        } else if (obj != 0) {
            e();
        } else if (obj2 != 0) {
            d();
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
            String str = i < 1 ? split[i] : logger.logInfo + split[i];
            if (logger.logLevel.ordinal() >= LogLevel.WARNING.ordinal()) {
                Log.e("logger", str);
            } else {
                Log.i("logger", str);
            }
            i++;
        }
    }

    class Logger {
        private final Thread currentThread = AIdleOperation.getCurrentThread();
        private final long timeMillis = System.currentTimeMillis();
        private final LogLevel logLevel;
        private final String error;
        private final String msg;
        private final String logInfo;

        /**
         * @param logLevel
         * @param error
         * @param msg
         */
        public Logger(LogLevel logLevel, String error, String msg) {
            String arg3;
            this.logLevel = logLevel;
            this.error = error;
            this.msg = msg;
            Locale locale = Locale.getDefault();
            String format = "[%s]%s";
            Object[] args = new Object[2];
            args[0] = this.logLevel.name();
            if (TextUtils.isEmpty(this.error)) {
                arg3 = "";
            } else {
                arg3 = String.format(Locale.getDefault(), "[%s]", new Object[]{this.error});
            }
            args[1] = arg3;
            this.logInfo = String.format(locale, format, args);
        }

        public String toString() {
            String format = SIMPLE_DATE_FORMAT.format(new Date(this.timeMillis));
            return String.format(Locale.getDefault(), "%s%s //@%s, %s", new Object[]{this.logInfo, this.msg, this.currentThread.toString(), format});
        }
    }
}
