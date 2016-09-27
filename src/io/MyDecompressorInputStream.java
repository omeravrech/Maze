package io;

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

		System.out.println("array size = " + bytes.length);
		int index = 0;
		int counter;
		byte b;
		
		while (((counter = read()) != -1) && ((b = (byte)read()) != -1))
			if ((index >= bytes.length))
				return -1;
			else
				for (counter = counter & 0xFF;counter > 0; counter--)
					bytes[index++] = b;
		
		return index;
	}
}
