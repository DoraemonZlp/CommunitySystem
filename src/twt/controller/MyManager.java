package twt.controller;

import java.util.ArrayList;
import java.util.List;

import twt.controller.dao.imp.IManager;

public class MyManager implements Runnable{
	boolean mdf=false;
	List<IManager> managers=new ArrayList<IManager>();
	public MyManager() {
		
	}
	public void AddMgr(IManager m) {
		managers.add(m);
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(IManager m:managers) {
				m.Commit();
			}
		}
		
	}
	
	
}
