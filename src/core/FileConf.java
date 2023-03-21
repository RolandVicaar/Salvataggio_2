package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class FileConf {
	private Properties p = new Properties();
	private String path;
	
	public FileConf() {
		
	}
	
	public FileConf(String path) throws FileNotFoundException, IOException{    // con exception è uguale
		this.path = path;
		InputStream is = new FileInputStream(new File(this.path));
		p.load(is);
	}
	
	public void swPath(String path) {this.path = path;}
	public void add(String key,String value) {this.p.put(key,value);}
	public void modify(String key,String value) {this.p.put(key,value);}
	public void delete(String key) {p.remove(key);}
	public void reset() {this.p.clear();}
	public String getData(String key) {
		return this.p.getProperty(key);
	}
	
	public Set<String> getKeys(){
		return this.p.stringPropertyNames();
	}
	
	public String keys() {
		return this.p.toString();
	}
	
	public void save() {
		try {
			p.store(new FileOutputStream(new File(this.path)),"");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
