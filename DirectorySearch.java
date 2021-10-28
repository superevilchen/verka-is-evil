
import java.io.File;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DirectorySearch {
	
	private String fileExt;
	private List<String> fileList;
	
	public DirectorySearch(String fileExt, List<String> fileList) {
		this.fileExt = fileExt;
		this.fileList = fileList;
	} 
	    
	    private void getDirectory(String directory) {
			File f = new File(directory);
			
			if (f.exists()) {
				
				Queue<File> queue = null;
				String[] files = f.list();
				
				queue = Stream.of(files)
						.map(fi -> new File(directory + "/" + fi))
						.collect(Collectors.toCollection(PriorityQueue::new));
				
				
				while (!queue.isEmpty()) {
					File temp = queue.remove();
					if (temp.toString().endsWith(fileExt)) {
						fileList.add(temp.toString());
					}
					
					if (temp.isDirectory()) {
						getDirectory(temp.toString());
					}
			}
	    }
}
}
