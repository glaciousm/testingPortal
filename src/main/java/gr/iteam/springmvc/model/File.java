package gr.iteam.springmvc.model;

public class File {
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

	public File() {

	}

	@Override
	public String toString() {
		return "File [name=" + name + ", path=" + path + "]";
	}

}
