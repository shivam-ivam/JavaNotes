package Stacks;

import java.util.*;


class Stacks{

    // --------- stack creation using arraylist -----------//
    static class StackArrayList{
        static ArrayList<Integer> list = new ArrayList<>();
        public boolean isEmpty(){
            return list.size() == 0;
        }
        public void push(int data) {
            list.add(data);
        }
        public int pop() {
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public int peek() {
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    // ------------ stack creation using linked list --------------//
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class StackLinkedList{
        static Node head = null;
        // ---------------- is empty --------------------------//
        public boolean isEmpty(){
            return head == null;
        }
        // ----------------push -------------------------//
        public void push(int data) {
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        // -------------- pop ----------------//
        public int pop() {
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        // -------------peek ------- //
        public int peek() {
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    
    ////// ------------- reverse a string using stack
    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        while (str != "") {
            s.push(str.charAt(0)); 
            str = str.substring(1);
        }
        StringBuilder result = new StringBuilder("");
        while (!s.empty()) {
            result.append(s.pop());
        }
        return result.toString();
    }

    // -----------push at bottom of stack

    public static void pushAtBottom(StackArrayList s,int data) {
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int temp = s.pop();
        pushAtBottom(s, data);
        s.push(temp);
    }
    ////  --------------------- reverse a stack ---------------------- //
    public static void reverseStack(StackArrayList s) {
        if(s.isEmpty()){
            return;
        }
        int temp = s.pop();
        reverseStack(s);
        pushAtBottom(s, temp);
        // s.push(temp);
    }

    public static void main(String[] args) {
        StackArrayList stack1 = new StackArrayList();
        stack1.push(1);
        stack1.push(2);
        stack1.push(4);
        // pushAtBottom(stack1, 8);
        reverseStack(stack1);
        while(!stack1.isEmpty()){
             System.out.print(stack1.peek() + " ");
            stack1.pop();
        }

        // StackLinkedList stack2 = new StackLinkedList();
        // stack2.push(5);
        // stack2.push(7);
        // stack2.push(6);
        // while(!stack2.isEmpty()){
        //     System.out.print(stack2.peek() + " ");
        //     stack2.pop();
        // }
        /////---------------- stack using java collection framework ------------ //
        // Stack<Integer> s = new Stack<>();
        // s.push(3);
        // System.out.println(s.peek());
        // System.out.println(s.pop());

        // System.out.println(reverse("shivam"));
    }
}