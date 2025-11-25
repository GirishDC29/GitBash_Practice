package ApiScript;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import org.testng.annotations.Test;

public class test {
	@Test(priority  = 0)
public static void Frequency() {
//	Scanner s=new Scanner(System.in);
//	String a=s.next();
	String a="engineering" ;
	
	HashMap<Character, Integer> h=new HashMap<Character, Integer>();
	
	for(int i=0;i<a.length();i++) {
		if(!h.containsKey(a.charAt(i))) {
			h.put(a.charAt(i), 1);
		}
		else {
			int x=h.get(a.charAt(i));
			x++;
			h.put(a.charAt(i), x);
		}
	}
	int g=Collections.max(h.values());
	System.out.println(g);
	
	for(Entry<Character,Integer> o: h.entrySet()) {
		if(g==o.getValue()) {
			System.out.println(o);
		}		
	}
	
}
	@Test(priority  = 1)
	public void Rotation() {
		int [] r= {1,2,3,4,5};
		
		int k=2; //steps
		int n =r.length; //5
				
		int [] a=new int[n];
		int index=0;
		
		for(int i=n-k;i<n;i++) {
			a[index]=r[i];
			index++;
		}
		for(int i=0;i<n-k;i++) {
			a[index]=r[i];
			index++;
		}
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	@Test(priority  = 2)
	public void Array() {

		int[] a= {1,5,10,20,40,80};
		int[] b= {6,7,20,80,100};
		int[] c= {3,4,5,20,80,30,120};
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		ArrayList a3 = new ArrayList();
		
		
		for(int i=0;i<a.length;i++) {
					a1.add(a[i]);
				}
		
		for(int i=0;i<b.length;i++) {
			a2.add(b[i]);
		}
		
		for(int i=0;i<c.length;i++) {
			a3.add(c[i]);
		}
	
		a1.retainAll(a2);
		System.out.println(a2);
		System.out.println(a1);
		a1.retainAll(a3);
		System.out.println(a3);
		
		System.out.println(a1);
	}
}



