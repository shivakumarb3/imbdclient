package apitutorial.imbdclient;



public class Datamodel {
	float rate;
	int votes;

	Datamodel()
	{
		
	}
	Datamodel(float rate, int votes)
	{
		this.rate=rate;
		this.votes=votes;
	}
	public float getRate() {
		return this.rate;
	}
	public void setRate(float rate)
	{
		this.rate=rate;
	}
	public void setVotes(int votes)
	{
		this.votes=votes;
	}
	public int getVotes()
	{
		return this.votes;
	}
}

