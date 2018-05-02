package com.duokan.reader.common.e;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

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

public class a {
    public static String a(Node node) {
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

    public static Document a(String str) {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Element b(String str) {
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

    public static long a(Node node, String str) {
        return Long.valueOf(c(node, str)).longValue();
    }

    public static int b(Node node, String str) {
        return Integer.valueOf(c(node, str)).intValue();
    }

    public static String a(Node node, String str, String str2) {
        String c = c(node, str);
        return c != null ? c : str2;
    }

    public static String c(Node node, String str) {
        Node g = g(node, str);
        if (g != null) {
            return g.getTextContent();
        }
        return null;
    }

    public static Element b(Node node, String str, String str2) {
        Element d = d(node, str);
        d.setTextContent(str2);
        return d;
    }

    public static Element d(Node node, String str) {
        Object createElement = node.getOwnerDocument().createElement(str);
        node.appendChild(createElement);
        return createElement;
    }

    public static boolean e(Node node, String str) {
        return f(node, str) != null;
    }

    public static Element f(Node node, String str) {
        Node g = g(node, str);
        if (g instanceof Element) {
            return (Element) g;
        }
        return null;
    }

    public static Node g(Node node, String str) {
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
