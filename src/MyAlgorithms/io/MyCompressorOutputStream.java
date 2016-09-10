package MyAlgorithms.io;

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
			if ((b == lastAppearance) && (counter < 255))
				counter++;
			else
			{
			//  write all bytes + converting integers to array of bytes
				write((byte)counter);
				write(lastAppearance);
				counter = 1;
				lastAppearance = b;
			}

		}
		write((byte)counter);
		write(lastAppearance);
	}
	public void write(byte b) throws IOException
	{
		out.write(b);
	}
	@Override
	public void write(int n) throws IOException {
		out.write(n);
	}

}
