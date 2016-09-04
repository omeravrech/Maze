package io;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class MyCompressorOutputStream extends OutputStream
{
	DataOutputStream out;
	
	public MyCompressorOutputStream(OutputStream out)
	{
		this.out = new DataOutputStream(out);
	}

	public void write(byte[] bytes) throws IOException
	{
		byte lastAppearance = bytes[0];
		int counter = 0;
		
		for (byte b : bytes)
		{
			if ((b == lastAppearance) && (counter < 256))
				counter++;
			else
			{
			//  write all bytes + converting integers to array of bytes
				out.write(counter);
				out.write(lastAppearance);
				counter = 1;
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
