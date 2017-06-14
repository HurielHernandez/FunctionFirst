package function.client;
public class AccessChanger
{
    String s[] = null;
    
    public String[] convert(String[] s)
    {
    	for(int i = 0; i < s.length; i++)
    		if(s[i].contains("//"))
    			s[i] = s[i].split("//")[0].replaceAll("->", ".") + "//" + s[i].split("//")[1];
    		else  			
    			s[i] = s[i].replaceAll("->", ".");
    		
        return s;
    }
    
    public static void main(String[] args)
    {
    	String[] m ={ "Test* t = new Test();","t->a = 1;","t->b = 2;","t->go(); // a=1, b=2 --> a=2, b=3"};
    	
    	AccessChanger ac = new AccessChanger();
    	m = ac.convert(m);
    	
    	for(int i = 0; i < m.length; i++)
    		System.out.println(m[i]);
    }
}
    