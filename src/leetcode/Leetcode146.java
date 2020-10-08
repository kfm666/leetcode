package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 /* 缓存容量  )
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 */
public class Leetcode146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println("----------1---------------");
        cache = new LRUCache( 1 /* 缓存容量 */ );
        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println("-------------3------------");
        cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }

    private static class LRUCache {

        private final int capacity;

        // 存储最新使用的数据或新put的数据,get之后把这个数据移到链表最前面
        private Node head;
        // 存储最久未使用的数据
        private Node tail;
        private Map<Integer,Node> map = new HashMap<>();
        private int size = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if(node == null){
                return -1;
            }
            return moveToHead(node);
        }

        public void put(int key, int value) {
            // 初始化链表
            if(head == null){
                initHead(key,value);
                return;
            }
            // 已经存在的key将其替换，并移动node到head
            if(map.containsKey(key)){
                if(map.get(key).getData() == value){
                    return;
                }
                replaceExistKey(key,value,map.get(key));
                return;
            }
            if(size + 1 > capacity ){
                removeLatest(key);
            }
            if(head == null){
                initHead(key,value);
                return;
            }
            // 不存在key则放入链表头部
            Node node = new Node(key,value);
            node.setNext(head);
            head.setPrev(node);
            head = node;
            map.put(key,node);
            ++size;
        }

        private void initHead(int key,int value){
            head = new Node(key,value);
            tail = head;
            map.put(key,head);
            ++size;
            return;
        }

        private void replaceExistKey(int key,int value,Node node){
            node.setData(value);
            moveToHead(node);
        }

        private int moveToHead(Node node){
            if(node.getPrev() == null){
                return node.getData();
            }
            if(node.getNext() == null){
                tail = node.getPrev();
                node.getPrev().setNext(null);
                node.setPrev(null);
                head.setPrev(node);
                node.setNext(head);
                head = node;
                return node.getData();
            }
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            node.setPrev(null);
            node.setNext(head);
            head.setPrev(node);
            head = node;
            return node.getData();
        }
        private void removeLatest(int key){
            if (tail == head){
                tail = head = null;
                --size;
                map.clear();
                return;
            }
            Node node = tail;
            tail = tail.getPrev();
            tail.setNext(null);
            node.setPrev(null);
            --size;
            map.remove(node.getKey());
        }

        private class Node{
            private Node prev;
            private Node next;
            private int data;
            private int key;

            public Node(int key,int data) {
                this.key = key;
                this.data = data;
            }

            public Node getPrev() {
                return prev;
            }

            public int getKey() {
                return key;
            }

            public void setPrev(Node prev) {
                this.prev = prev;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }
        }
    }
}
