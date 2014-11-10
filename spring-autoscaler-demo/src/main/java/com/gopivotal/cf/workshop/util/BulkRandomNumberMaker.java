package com.gopivotal.cf.workshop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class BulkRandomNumberMaker implements Callable<List<Long>> {
    private long number;

    public BulkRandomNumberMaker(long number) { this.number = number; }

    @Override
    public List<Long> call() throws Exception {
        List<Long> list = new ArrayList<Long>();
    	for (long l = 0; l < number; l++) {
            list.add(generateRandom());
        }
    	return list;
    }
    
    
	public static long generateRandom() {
		double random = Math.random() * 10000000;
		return (long)Math.round(random);
	}    
}