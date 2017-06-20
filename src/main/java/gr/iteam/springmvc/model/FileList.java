package gr.iteam.springmvc.model;

import java.util.List;

public class FileList {

	List<File> file;

	List<Folder> folder;
	
	String name;

	public FileList() {

	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<Folder> getFolder() {
		return folder;
	}

	public void setFolder(List<Folder> folder) {
		this.folder = folder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FileList [file=" + file + ", folder=" + folder + ", name=" + name + "]";
	}

}
