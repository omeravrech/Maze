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
	
	public int read(byte[] b) throws IOException
	{
			
			int k = 0;
			byte value = -2;
			byte count = -2;
			while(b.length > k)
			{
				value = (byte) in.read();
				count = (byte) in.read();
				for (int i = 0; i < count; i++)
				{
					b[k] = value;
					k++;
				}
			}
			return (int) value;
	}
}
