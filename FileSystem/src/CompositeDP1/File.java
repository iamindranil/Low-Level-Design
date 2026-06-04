package CompositeDP1;

public class File implements FileSystem{
	String fileName;
	
	public File(String name) {
		this.fileName=name;
	}

	@Override
	public void ls() {
		// TODO Auto-generated method stub
		System.out.println("file Name "+fileName);
	}
	
}
