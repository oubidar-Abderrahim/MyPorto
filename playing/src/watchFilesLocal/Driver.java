import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class Driver {
		
	public static void main(String[] args) {

		// TODO: Change to following line to point to your input directory
		Path myDir = Paths.get("c:/my_test_folder/data");

		while (true) {
			try {
				// create the watcher service and register for events
				WatchService watcher = myDir.getFileSystem().newWatchService();
				myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,
						StandardWatchEventKinds.ENTRY_DELETE,
						StandardWatchEventKinds.ENTRY_MODIFY);

				// let's grab a watch key
				WatchKey watchKey = watcher.take();

				// now let's process the events pending for this watch key
				List<WatchEvent<?>> events = watchKey.pollEvents();
				for (WatchEvent event : events) {
					
					// get the file name for the event
					Path fileName = (Path) event.context();
					
					// determine the type of event and call appropriate handler method
					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
						handleCreatedFile(fileName);
					}
					if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
						handleDeletedFile(fileName);
					}
					if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
						handleModifiedFile(fileName);
					}
				}

			} catch (Exception e) {
				System.out.println("Error: " + e.toString());
			}
		}
	}

	// HELPER METHODS
		
	private static void handleCreatedFile(Path fileName) {
		System.out.println("File created: " + fileName);
	}
	
	private static void handleDeletedFile(Path fileName) {
		System.out.println("File deleted: " + fileName);
	}

	private static void handleModifiedFile(Path fileName) {
		System.out.println("File modified: " + fileName);
	}
}
