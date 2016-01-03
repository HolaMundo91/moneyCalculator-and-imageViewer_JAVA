package kata4;

import java.io.File;

public class Kata4 {

    public static void main(String[] args) {
        
        String path = "C:\\Users\\usuario\\Documents";
        File file = new File(path);
        
        String[] fileList = file.list();
        
        for( String fileList1 : fileList ){
            // System.out.println(fileList1);
        }
        
            print( file.listFiles(),"" );
        
    }

    private static void print(File[] listFiles, String ident) {

        if ( listFiles == null ){
            return;
        }
        
        for( File listFile : listFiles ){
            System.out.println( ident+ (listFile.isDirectory()? "+" : " ") +listFile.getName() );
            if( listFile.isFile() || listFile.isHidden() ) continue;
                print ( listFile.listFiles(), ident + " " );
        }
        
    }
}
