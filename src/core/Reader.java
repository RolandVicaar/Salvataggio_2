package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Reader {
	private String userHome = System.getProperty("user.home");
	private String rootPath = userHome + "\\Documenti\\Salvataggio";
	
	public Reader() {
		this.createRoot();
	}
	
	private void createRoot() {
		File root = new File(this.rootPath);
		System.out.println(root.getAbsolutePath());
		if(!root.exists()) {
			root.mkdir();
		}
	}
	
	public void save(Studente std) throws Exception{
		File save = new File(this.rootPath+"/studente.reader");
		if(!save.exists())save.createNewFile();
	FileOutputStream fos = new FileOutputStream(save);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(std);
	oos.flush();
	oos.close();
	
	}
	
	public Studente load() throws Exception{
		File load = new File(this.rootPath+"/studente.reader");
		FileInputStream fls = new FileInputStream(load);
		ObjectInputStream ois = new ObjectInputStream(fls);
		Studente std =(Studente) ois.readObject();
		return std;
		
	}

}
