package com.duokan.reader.common.p039e;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/* renamed from: com.duokan.reader.common.e.a */
public class C0606a {
    /* renamed from: a */
    public static String m2774a(Node node) {
        Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
        Writer stringWriter = new StringWriter();
        newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        String stringWriter2 = stringWriter.toString();
        if (node instanceof Document) {
            return stringWriter2;
        }
        Matcher matcher = Pattern.compile("\\<\\?.*\\?\\>(.*)", 32).matcher(stringWriter2);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return stringWriter2;
    }

    /* renamed from: a */
    public static Document m2776a(String str) {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static Element m2778b(String str) {
        try {
            Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Object createElement = newDocument.createElement(str);
            newDocument.appendChild(createElement);
            return createElement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static long m2773a(Node node, String str) {
        return Long.valueOf(C0606a.m2780c(node, str)).longValue();
    }

    /* renamed from: b */
    public static int m2777b(Node node, String str) {
        return Integer.valueOf(C0606a.m2780c(node, str)).intValue();
    }

    /* renamed from: a */
    public static String m2775a(Node node, String str, String str2) {
        String c = C0606a.m2780c(node, str);
        return c != null ? c : str2;
    }

    /* renamed from: c */
    public static String m2780c(Node node, String str) {
        Node g = C0606a.m2784g(node, str);
        if (g != null) {
            return g.getTextContent();
        }
        return null;
    }

    /* renamed from: b */
    public static Element m2779b(Node node, String str, String str2) {
        Element d = C0606a.m2781d(node, str);
        d.setTextContent(str2);
        return d;
    }

    /* renamed from: d */
    public static Element m2781d(Node node, String str) {
        Object createElement = node.getOwnerDocument().createElement(str);
        node.appendChild(createElement);
        return createElement;
    }

    /* renamed from: e */
    public static boolean m2782e(Node node, String str) {
        return C0606a.m2783f(node, str) != null;
    }

    /* renamed from: f */
    public static Element m2783f(Node node, String str) {
        Node g = C0606a.m2784g(node, str);
        if (g instanceof Element) {
            return (Element) g;
        }
        return null;
    }

    /* renamed from: g */
    public static Node m2784g(Node node, String str) {
        if (!node.hasChildNodes()) {
            return null;
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeName().equals(str)) {
                return firstChild;
            }
        }
        return null;
    }
}
