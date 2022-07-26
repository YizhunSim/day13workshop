package sg.edu.nus.iss.day13workshop.services;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

  private File dataDir = new File("directory");

  public File getDataDir(){
    return dataDir;
  }

  public void setDataDir(File dataDir){
    this.dataDir = dataDir;
  }

  public boolean isDataDirValid(){
    return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite();
  }

  public boolean save(){
		return false;
	}

	public void read(String fileId){

	}
}
