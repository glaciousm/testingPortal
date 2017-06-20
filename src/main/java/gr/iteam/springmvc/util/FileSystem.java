package gr.iteam.springmvc.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gr.iteam.springmvc.model.FileList;
import gr.iteam.springmvc.model.Folder;

public class FileSystem {
	
	public static FileList fileNameList(String name){
		
		FileList fileListModel = new FileList();
		List<gr.iteam.springmvc.model.File> fileList = new ArrayList<>();
		List<Folder> folderList = new ArrayList<>();
		File folder = new File("//192.168.1.20/Training Material/" + name);
		File[] listOfFiles = folder.listFiles();
		
		fileListModel.setName(name);
		
		for (File file : listOfFiles) {
			if (file.isFile()) {
				gr.iteam.springmvc.model.File fileModel = new gr.iteam.springmvc.model.File();
				fileModel.setName(file.getName());
				fileModel.setPath(file.getAbsolutePath());
				fileList.add(fileModel);
			} else if(file.isDirectory()){
				Folder folderModel = new Folder();
				folderModel.setName(file.getName());
				folderModel.setPath(file.getAbsolutePath());
				folderList.add(folderModel);
			}
		}
		
		fileListModel.setFile(fileList);
		fileListModel.setFolder(folderList);
		
		return fileListModel;
	}
	
	public static FileList fileNameList(){
		
		
		return fileNameList("");
	}

}
