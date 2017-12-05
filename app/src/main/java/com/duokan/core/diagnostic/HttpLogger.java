package com.duokan.core.diagnostic;

import android.util.Log;

import com.duokan.core.sys.StackTracesInfo;
import com.duokan.core.sys.ah;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HttpLogger {
    private static final String TAG = HttpLogger.class.getName();
    private static final ConcurrentLinkedQueue<HttpLogger> loggers = new ConcurrentLinkedQueue();
    private File file = null;
    private ConcurrentLinkedQueue linkedQueue = new ConcurrentLinkedQueue();

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

    public void c(LogLevel logLevel, String str, String str2) {
        Logger iVar = new Logger(logLevel, str, str2);
        this.linkedQueue.add(iVar);
        a(iVar);
        a(logLevel);
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
        a(iVar);
        a(logLevel);
    }

    public void d() {
        if (!this.linkedQueue.isEmpty()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.linkedQueue;
            this.linkedQueue = new ConcurrentLinkedQueue();
            ah.a(new g(this, concurrentLinkedQueue), TAG);
        }
    }

    public void e() {
        if (!this.linkedQueue.isEmpty()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.linkedQueue;
            this.linkedQueue = new ConcurrentLinkedQueue();
            try {
                ah.a(new h(this, concurrentLinkedQueue), TAG).get();
            } catch (Throwable th) {
            }
        }
    }

    private void a(LogLevel logLevel) {
        Object obj;
        Object obj2 = 1;
        Object obj3 = logLevel.ordinal() >= LogLevel.DISASTER.ordinal() ? 1 : null;
        if (logLevel.ordinal() >= LogLevel.ERROR.ordinal()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (logLevel.ordinal() < LogLevel.EVENT.ordinal()) {
            obj2 = null;
        }
        if (obj3 != null) {
            Iterator it = loggers.iterator();
            while (it.hasNext()) {
                ((HttpLogger) it.next()).e();
            }
        } else if (obj != null) {
            e();
        } else if (obj2 != null) {
            d();
        }
    }

    private static void b(Queue queue, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        if (file != null) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(fileOutputStream), "utf-8"), false);
                    for (Logger iVar : queue) {
                        printWriter.println(iVar.toString());
                    }
                    printWriter.flush();
                    printWriter.close();
                    fileOutputStream2 = null;
                    if (null != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th2) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    private static void a(Logger logger) {
        String[] split = logger.toString().split("[\r\n\\u0085\\u2028\\u2029]+");
        int i = 0;
        while (i < split.length) {
            String str = i < 1 ? split[i] : logger.g + split[i];
            if (logger.d.ordinal() >= LogLevel.WARNING.ordinal()) {
                Log.e("logger", str);
            } else {
                Log.i("logger", str);
            }
            i++;
        }
    }
}
