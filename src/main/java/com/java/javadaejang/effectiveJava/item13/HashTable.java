package com.java.javadaejang.effectiveJava.item13;

import java.util.Map;

public class HashTable implements Cloneable {
    private Map.Entry[] buckets ;

    private static class Entry{
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy(){
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }

        Entry bestDeepCopy(){
            Entry result = new Entry(key, value, next);
            for(Entry p = result; p.next != null; p = p.next)
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            return result;
        }
    }

    @Override
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
