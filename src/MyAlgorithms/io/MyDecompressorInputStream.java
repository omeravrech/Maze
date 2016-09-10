package MyAlgorithms.io;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	DataInputStream in;
	
	public MyDecompressorInputStream(InputStream in) {
		this.in = new DataInputStream(in);
	}
	
	@Override
	public int read() throws IOException
	{
		return in.read();
	}
	
	public int read(byte[] bytes) throws IOException
	{	
		int counter;
		int index = 0;
		byte b;
		
		while (((counter = read()) != -1) && ((b = (byte)read()) != -1))
		{
			for (counter = counter & 0xFF;counter > 0; counter--,index++)
				if (index > bytes.length)
					return -1;
				else
					bytes[index] = b;
		}
		return 0;
	}
}
