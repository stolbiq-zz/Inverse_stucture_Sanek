package grafica;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ExtFileFilter extends FileFilter {

    String ext;

    ExtFileFilter(String ext) {
        this.ext = ext;
    }

    public boolean accept(File pathname) {
        String extension = getExtension(pathname);
        return extension.equals(ext);
    }

    private String getExtension(File pathname) {
        String filename = pathname.getPath();
        int i = filename.lastIndexOf('.');
        if ( i>0 && i<filename.length()-1 ) {
            return filename.substring(i+1).toLowerCase();
        }
        return "";
    }

	@Override
	public String getDescription() {
		return null;
	}
}