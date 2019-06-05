import java.io.*;

class Assignment51{
    public static int dfn_count = 1;
    public static LinkedList[] adjList;
    public static boolean[] visited;
    public static int number = 0;

    public static void  main(String[] args) {
		int[]           x, y;
		int				vertex_num, edge_num, pos, BC_num;
		String          s;
        long			starttime, elapsedtime;
		
		try {
			// read in the input
            BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));

			s = rd.readLine();
			pos = s.indexOf(" ");
			vertex_num = Integer.parseInt(s.substring(0, pos));
            edge_num = Integer.parseInt(s.substring(pos + 1));
            
			x = new int[edge_num];
            y = new int[edge_num];
            
			for (int i = 0; i < edge_num; i++) {
				s = rd.readLine();
				pos = s.indexOf(" ");
				x[i] = Integer.parseInt(s.substring(0, pos));
				y[i] = Integer.parseInt(s.substring(pos + 1));
            }
            
			rd.close();
			rd = null;

            starttime = System.nanoTime();
            
            adjList = new LinkedList[vertex_num];
            visited = new boolean[vertex_num];
    
            // 링크드리스트 초기화
            for(int i=0; i<vertex_num; i++){
                adjList[i] = new LinkedList();  
            }
    
            // 인접리스트의 첫번째에 자기 자신을 넣어줌
            for(int i=0; i<vertex_num; i++){
                adjList[i].append(i);
            }
    
            // 인접리스트 만들기
            for(int i=0; i<edge_num; i++){
                adjList[x[i]].append(y[i]);
                adjList[y[i]].append(x[i]);
            }
    
            for(int i = 0; i<vertex_num; i++){
                visited[i] = false;
            }

            int[] dfn = new int[vertex_num];
            int[] low = new int[vertex_num];

            for(int i = 0; i< vertex_num; i++){
                dfn[i] = 0;
            }

            findBC(4, -1, dfn, low);
        
			elapsedtime = System.nanoTime() - starttime;
			
			// output the elapsed time to stdout in seconds
			System.out.println(Double.toString((double)elapsedtime / 1000000000));

			// write the output
			
			wr.write(Integer.toString(number));
			wr.close();
		}
		catch (Exception e) {
			// if the code throws any exception, stack trace will be output and the program will halt
			e.printStackTrace();
			System.out.println("Error.");
		}
    }
    public static void findBC(int v, int parent, int[] dfn, int[] low){
        dfn[v] = dfn_count++;
        low[v] = dfn[v];
        visited[v] = true;
        for(Node e= adjList[v].first.next; e!=null; e = e.next){
            if(e.data == parent || dfn[v] < dfn[e.data]){
                continue;
            }
            if(visited[e.data]){
                low[v] = Math.min(low[v],dfn[e.data]);
            }
            else{
                findBC(e.data, v, dfn, low);
                low[v] = Math.min(low[v],low[e.data]);
                if(low[e.data]>=dfn[v]){
                    number++;
                }
            }
        }
        System.out.println(low[v]);
    }
}