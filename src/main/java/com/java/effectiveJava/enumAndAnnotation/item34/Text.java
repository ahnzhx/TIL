package com.java.effectiveJava.enumAndAnnotation.item34;

import java.util.Set;

public class Text {
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUGH = 1 << 3;

    // 매개변수 styles는 0개 이상의 STYLE_ 상수를 비트별 OR한 값이다.
    // 이러한 집합을 bit field 라고 한다.
    public void applyStyles(int styles){}

}

class Text2{
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // 어떤 Set을 넘겨도 되지만, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles){}
}
