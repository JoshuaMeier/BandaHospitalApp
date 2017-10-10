/*
 * Project: BamdaHospitalApp
 * Version: Prototype v1
 * Author: Joshua Meier
 */

//importing libraries
import java.util.ArrayList;
import java.util.NoSuchElementException;

class D { //simple debugger for code. if want on set debugger to true
	static boolean debugger = true;
	public static void bug(String x){ //string printout
		if (debugger) {
			System.out.println(x);
		}
	}
	public static void bug(double x){ //double printout
		if (debugger) {
			System.out.println(x);
		}
	}
}

/*
 * ExceptionType is a doubly linked list that can iterate backward and
 * forward as well as keeps record of how many exception TYPES have been
 * declared.
 * Every time a new Exception is called in the log the DLL will create a
 * new node Excep (short for Exception [I was not sure if it was its own
 * class so the node is called Excep])
 * this is set up to be changed and is only a tentative solution.
 */

public class ExceptionType {

	private Excep head;
	private Excep tail;
	private int size;

	public ExceptionType() {
		size = 0;
	}

	/*
	 * This class declares all nodes known as Exceps. they have a link to
	 * the next and previous nodes. The data will be a ArrayList that holds
	 * all the times the specific exception is called.
	 * @author JoshuaMeier
	 */
	private class Excep {
		String excepName;
		Times times;
		Excep next;
		Excep prev;

		public Excep(String excepName, Times times, Excep next, Excep prev) {
			this.excepName = excepName;
			this.times = times;
			this.next = next;
			this.prev = prev;
		}

	}

	/**
     * returns the size of the linked list
     * @return int
     */
	public int size() {
		return size;
	}

	/**
     * return whether the list is empty or not
     * @return boolean
     */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
     * adds times at the starting of the linked list
     * @param times
     */
	public void addFirst(String excepName, Times times) {
		Excep tmp = new Excep(excepName, times, head, null);
		if(head != null) {
			head.prev = tmp;
		}
		if (tail == null) {
			tail = tmp;
		}
		size++;
		D.bug("Adding: " + times.toString());
	}

    /**
     * adds times at the end of the linked list
     * @param times
     */
	public void addLast(String excepName, Times times) {
		Excep tmp = new Excep(excepName, times, null, tail);
		if(tail != null) {
			tail.next = tmp;
		}
		tail = tmp;
		if(head == null) {
			head = tmp;
		}
		size++;
		D.bug("Adding: " + times.toString());
	}

	/**
     * this method walks forward through the linked list
     */
	public void iterateForward() {
		D.bug("iterating forward..");
		Excep tmp = head;
		while(tmp != null) {
			D.bug(tmp.times.toString());
			tmp = tmp.next;
		}
	}

	/**
     * this method walks backward through the linked list
     */
	public void iterateBackward() {
		D.bug("iterating backward..");
		Excep tmp = tail;
		while(tmp != null) {
			D.bug(tmp.times.toString());
			tmp = tmp.prev;
		}
	}

	/**
     * this method removes element from the start of the linked list
     * @return
     */
	public Times removeFirst() {
		if (size == 0) throw new NoSuchElementException();
		Excep tmp = head;
		head = head.next;
		head.prev = null;
		size--;
		D.bug("Deleted: " + tmp.times.toString());
		return tmp.times;
	}

	/**
     * this method removes element from the end of the linked list
     * @return
     */
	public Times removeLast() {
		if (size == 0) throw new NoSuchElementException();
		Excep tmp = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		D.bug("Deleted: " + tmp.times.toString());
		return tmp.times;
	}
}
