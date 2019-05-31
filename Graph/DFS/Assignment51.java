import java.io.*;

class Assignment51{
    public static void  main(String[] args) {
		BufferedReader  rd = null;
		BufferedWriter  wr = null;
		int[]           x, y;
		int				vertex_num, edge_num, pos, i, BC_num;
		String          s;
		long			starttime, elapsedtime;
		
		try {
			// read in the input
			rd = new BufferedReader(new FileReader("input.txt"));
			s = rd.readLine();
			pos = s.indexOf(" ");
			vertex_num = Integer.parseInt(s.substring(0, pos));
			edge_num = Integer.parseInt(s.substring(pos + 1));
			x = new int[edge_num];
			y = new int[edge_num];
			for (i = 0; i < edge_num; i++) {
				s = rd.readLine();
				pos = s.indexOf(" ");
				x[i] = Integer.parseInt(s.substring(0, pos));
				y[i] = Integer.parseInt(s.substring(pos + 1));
			}
			rd.close();
			rd = null;

			// call SP.findSP and measure the elapsed time
			starttime = System.nanoTime();
			BC_num = DFS.findBC(vertex_num, edge_num, x, y);
			elapsedtime = System.nanoTime() - starttime;
			
			// output the elapsed time to stdout in seconds
			System.out.println(Double.toString((double)elapsedtime / 1000000000));

			// write the output
			wr = new BufferedWriter(new FileWriter("output.txt"));
			wr.write(Integer.toString(BC_num));
			wr.close();
			wr = null;
		}
		catch (Exception e) {
			// if the code throws any exception, stack trace will be output and the program will halt
			e.printStackTrace();
			System.out.println("Error.");
		}
		finally {
			if (rd != null) {
				try {
					rd.close();
				}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error.");
				}
			}
			if (wr != null) {
				try {
					wr.close();
				}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error.");
				}
			}
		}
	}
}