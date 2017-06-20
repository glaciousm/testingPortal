package gr.iteam.springmvc.model;

public class Folder {
	String name;
	String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Folder() {

	}

	@Override
	public String toString() {
		return "Folder [name=" + name + ", path=" + path + "]";
	}

}
