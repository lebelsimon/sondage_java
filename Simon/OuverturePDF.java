import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class OuverturePDF
{    
    public static File access(String fileNameInJAR, String extension) throws IOException
    {
        InputStream in = OuverturePDF.class.getClass().getResourceAsStream(fileNameInJAR);
        File f = File.createTempFile("JAR_", extension);
        FileOutputStream out = new FileOutputStream(f);
        
        byte[] buf = new byte[1024];
        for (int n; (n=in.read(buf))!=-1; out.write(buf, 0, n));
        
        out.close();
        in.close();
        return f;
    }
    
    public static void main(String[] args) throws IOException
    {
        Desktop.getDesktop().open(access("/manuel.pdf",".pdf"));
    }
}