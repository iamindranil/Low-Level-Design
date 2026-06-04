package CompositeDP1;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
	String directoryName;
	List<FileSystem>fileSystemList;
	
	
	public Directory(String name) {
		this.directoryName=name;
		fileSystemList=new ArrayList<FileSystem>();
	}
	
	public void add(FileSystem fileSystemObj) {
		fileSystemList.add(fileSystemObj);
	}
	
	@Override
	public void ls() {
		// TODO Auto-generated method stub
		for(FileSystem fileSystemObj:fileSystemList) {
			fileSystemObj.ls();
		}
	}
}
