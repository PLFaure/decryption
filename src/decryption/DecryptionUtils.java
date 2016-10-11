package decryption;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
/**
 * 
 * @author Theo
 *
 */
public class DecryptionUtils
{  
    public String slideString(String text, int nb)
    {
        int []  temp= new int[text.length()];
        String output = "";
        for(int i=0;i<temp.length;i++)
        {
            temp[i]=( (int)text.charAt(i))+nb;
            if (temp[i]>122)
                temp[i]=temp[i]-26;
            output=output + ((char) temp[i]);  
       
        }
        return output;
    }
   
    public String textSplicer(String text, int nb)
    {
        String[]  slices= new String [nb];
        String output = "";
        int j=0;
        for (j=0;j<nb;j++)
        {
            slices[j%nb]="";  
        }
        j=0;
        for (int i=0;i<text.length();i++)
        {
            slices[j%nb]=slices[j%nb]+text.charAt(i);
            j++;
        }
        j=0;
        for (j=0;j<nb;j++)
        {
            output += slices[j%nb];
            output += "\n";
        }
        return output;
    }
 
   
    public String spliceJoiner(String file) {
 
        ArrayList<String> splices = new ArrayList<String>();
        try {
            readfile(file, splices);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        String text = merge(splices);
        return text;
   
    }
 
    private void readfile(String file, List<String> splices) throws IOException
    {
            BufferedReader in = new BufferedReader(new FileReader(file)) ;
            String line;
            while ((line = in.readLine()) != null)
            {
                splices.add(line);
            }
            in.close();
 
    }
   
    private String merge(List<String> splices)
    {
        String text = "";
        int idx=0;;
        while(idx<splices.get(0).length())
        {
            for(int i=0;i<splices.size();i++)
            {
                if(idx<splices.get(i).length())
                    text=text+splices.get(i).charAt(idx);
            }
            idx++;
        }
        return text;
    }
}