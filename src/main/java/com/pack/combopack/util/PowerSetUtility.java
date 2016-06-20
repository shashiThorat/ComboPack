package com.pack.combopack.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PowerSetUtility {
	
	public static <T> List<List<T>> genratePowerSet(Collection<T> list) {
		
		
		  List<List<T>> ps = new ArrayList<List<T>>();
		  if(list==null || list.isEmpty())
			  return ps;
		  ps.add(new ArrayList<T>());   // add the empty set
		 
		  // for every item in the original list
		  for (T item : list) {
		    List<List<T>> newPs = new ArrayList<List<T>>();
		 
		    for (List<T> subset : ps) {
		      // copy all of the current powerset's subsets
		      newPs.add(subset);
		 
		      // plus the subsets appended with the current item
		      List<T> newSubset = new ArrayList<T>(subset);
		      newSubset.add(item);
		      newPs.add(newSubset);
		    }
		 
		    // powerset is now powerset of list.subList(0, list.indexOf(item)+1)
		    ps = newPs;
		  }
		  return ps;
		}

}
