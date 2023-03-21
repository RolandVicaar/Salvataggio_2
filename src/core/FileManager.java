package core;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;

public class FileManager {
	
	private String os = System.getProperty("os.name");
	private String userHome = System.getProperty("user.home");
	private String separator = System.getProperty("file.separator");
	private String rootPath = userHome + "\\Documenti\\Salvataggio";
	
	public FileManager() {
		this.createRoot();
	}
	
	
	public String getOs() {
		return this.os;
	}
	
	public String getHome() {
		return this.userHome;
	}
	
	public String getSeparator() {
		return this.separator;
	}
	
	private void createRoot() {
		File root = new File(this.rootPath);
		System.out.println(root.getAbsolutePath());
		if(!root.exists()) {
			root.mkdir();
		}
	}
	
	
	public void printHomeTree() {
		File file = new File(this.userHome);
		File[] lista = file.listFiles();
		for(File f : lista) {
			System.out.println(f.getName());
			System.out.println(f.getAbsolutePath() + "\n");
		}
	}

	public void saveStudente(Studente std) throws IOException {
		File save = new File(this.rootPath + "/studente.sp");
		if(!save.exists()) {
			save.createNewFile();
		}
		FileConf file = new FileConf(this.rootPath +"/studente.sp");
		file.add("Nome",std.getNome());
		file.add("Eta",String.valueOf(std.getEta()));
		file.save();
	}
	
	public Studente loadStudente() throws IOException {
	FileConf file = new FileConf(this.rootPath +"/studente.sp");
	Studente std = new Studente(file.getData("Nome"),Integer.parseInt(file.getData("Eta")));
//	Studente std = null;
//	System.out.println("FileManager: valore di eta in string"+ file.getData("Eta"));
//	System.out.println("FileManager: valore di chiavi in string"+ file.keys());
	return std;
	}
}
