package CompositeDP1;

public class Main {
	
	public static void main(String[] args) {
		Directory movieDirectory=new Directory("Movie");
		FileSystem border=new File("Border");
		movieDirectory.add(border);
		
		Directory comedyMovieDirectory=new Directory("ComedyMovie");
		FileSystem heraPheri=new File("Hera Pheri");
		comedyMovieDirectory.add(heraPheri);
		
		movieDirectory.add(comedyMovieDirectory);
		
		movieDirectory.ls();
	}

}
