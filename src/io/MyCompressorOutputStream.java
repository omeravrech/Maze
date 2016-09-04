package io;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class MyCompressorOutputStream extends OutputStream
{
	BufferedOutputStream out;
	
	public MyCompressorOutputStream(OutputStream out)
	{
		this.out = new BufferedOutputStream(out);
	}

	public void write(byte[] bytes) throws IOException
	{
		int lastAppearance = -1;
		int counter = 0;
		
		for (byte b : bytes)
		{
			if ((b == lastAppearance) && (counter < 256))
				counter++;
			else
			{
			//  write all bytes + converting integers to array of bytes
				write(counter);
				write(lastAppearance);
				counter = 0;
				lastAppearance = b;
			}
		}
	}

	@Override
	public void write(int b) throws IOException
	{
		out.write(b);
	}

}
