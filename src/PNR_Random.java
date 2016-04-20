import java.util.Random;
import java.util.Set; 
class PNR_Random
{
    private String PNR;
    public String getPNR()
	{
		return PNR;
	}
	public void setPNR(String pnr)
	{
		this.PNR = pnr;
	}
    public void generatePNR()
    {
    	GetPNR pr = new GetPNR();
    	pr.compute();
    	Set<String> X = pr.getSet();
        while(true)
        {
            PNR = "";
            Random random = new Random();
            for(int i=0;i<10;i++)
            {
                int p = random.nextInt(9)+1;
                PNR+=p;
            }
            boolean x = X.add(PNR);
            if(!x)
            	continue;
            else
            	return;
        }
    }
}