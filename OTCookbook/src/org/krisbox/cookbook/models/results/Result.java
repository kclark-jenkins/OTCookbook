package org.krisbox.cookbook.models.results;

public class Result {
	private final long id;
	private final String result;
	
	public Result(long id, String result){
		this.id = id;
		this.result = result;
	}
	
	public long   getId(){return id;}
	public String getResult(){return result;}
}
