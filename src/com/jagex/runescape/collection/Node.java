package com.jagex.runescape.collection;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class Node {

	public long id;
	public Node next;
	public Node previous;

	public void remove() {
		if (previous != null) {
			previous.next = next;
			next.previous = previous;
			next = null;
			previous = null;

		}
	}


}
