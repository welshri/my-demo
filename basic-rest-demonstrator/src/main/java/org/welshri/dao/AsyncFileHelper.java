package org.welshri.dao;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class AsyncFileHelper {
	
	public static final String REPO_ROOT  = "/home/richard/data/persistence";
/*	
 * TODO helped when work in progress but superceded now
 * 
	public static void main(String[] args) throws InterruptedException {
		AsyncFileHelper asyncFileHelper = new AsyncFileHelper();
		String dataString = "This is some hard coded data for testing a nio data writing";
		//StringBuffer sBuffer = new StringBuffer(dataString);
		//StringBuilder sBuilder = new StringBuilder(dataString);
		
		Map<Integer, S> targets = new HashMap<>();
		for (int counter=0; counter<3; counter++) {
			Path target = Paths.get(REPO_ROOT + String.valueOf(counter) + ".txt" );
			targets.put(new Integer(counter), target);
		}
		
		
		
		//Assuming that we are not creating so many files that its a problem for the filesystem,
		//seems faster write a new file each time. Assuming not HDFS. Assuming no saturation concerns.
		for (Integer key : targets.keySet() ) {
			asyncFileHelper.writeData(targets.get(key), (dataString + String.valueOf(key) + "\n").getBytes());
		}
		
		Thread.sleep(3000); //so we dont exit before we see some output for debugging purposes
	}
*/
	public void writeData(final String target, final byte[] data) {
		Path path = Paths.get(target);
		if (!Files.exists(path)) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 0;
		buffer.put(data);
		buffer.flip();

		AsynchronousFileChannel fileChannel = null;

		try {
			fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
			fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {

				@Override
				public void completed(Integer result, ByteBuffer attachment) {
					System.out.println("bytes written: " + result);
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					System.out.println("Write failed");
					exc.printStackTrace();
				}
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * TODO use Optional?
	 * @param target
	 * @return
	 */
	public List<String> getData(final String target) {
		Path path = Paths.get(target);
		List<String> data = null;
		if (Files.exists(path)) {
			try {
				data = Files.readAllLines(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}

}
