/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.fileio;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileIO {

    private File encFile, decFile;

    
    public void setDecFile(File newFile) {
        this.decFile = newFile;
    }

   
    public void setDecFile(Path path) {
        this.decFile = new File(path.toString());
    }

   
    public void setEncFile(File newFile) {
        this.encFile = newFile;
    }

    
    public void setEncFile(Path path) {
        this.encFile = new File(path.toString());
    }

  
    public File getDecFile() {
        return this.decFile;
    }

   
    public File getEncFile() {
        return this.encFile;
    }

   
    public void cleanup() {
        this.decFile = null;
        this.encFile = null;
    }
    
    public boolean isEncrypted(File file) {
        
        return file.getName().endsWith("aes");
    }

  
    public boolean isEncrypted(Path path) {
        return path.endsWith("aes");
    }
    public boolean isValidFile(Path path){
        return (Files.exists(path) && !Files.isDirectory(path));
    }

}
