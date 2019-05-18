class SP {

	// define this method
    public static int findSP(int n, int m, int[] x, int[] y, int u, int v, int[] ans) {
        //모든 vertex의 인접한 vertex의 정보를 담은 링크드리스트를 만든다.
        LinkedList[] adjList = new LinkedList[n];
        for(int i=0; i<n; i++){
            adjList[i] = new LinkedList();
        }
        for(int i=0; i<m; i++){
            adjList[x[i]].append(y[i]);
            adjList[y[i]].append(x[i]);
        }

        //방문 정보를 담을 배열과 큐를 선언한다.
        boolean[] visited = new boolean[n];
        Circular_queue queue = new Circular_queue(n);
        for(int i=0; i<n; i++) visited[i] = false;
    
        //큐에 시작 vertex를 넣는다.
        queue.enqueue(u);
        visited[u] = true;

        //최단경로를 저장할 배열과, 최단경로의 크기를 저장한다.
        int[] path = new int[n];
        
        int[] distance_array = new int[n];
        int distance = 0;


        path[u] = u;
        distance_array[u] = 0;

        //큐에서 뺀 값을 저장할 변수를 만든다.
        int out;
        int check = 0;

        //while문을 돌린다.
        while(!queue.isEmpty()){
            out = queue.dequeue();
            if(out == v){
                check = 1;
                break;
            }
            for(Node e = adjList[out].first; e != null; e = e.next){
                if(visited[e.data] == false){
                    visited[e.data] = true;
                    queue.enqueue(e.data);
                    path[e.data] = out;
                    distance_array[e.data] = distance_array[out] + 1;
                }
            }
        }
        if(check == 1){
            distance = distance_array[v];
            int[] real_path = new int[distance+1];
            real_path[distance] = v;
            for(int i=distance; i>0; i--){
                real_path[i-1] = path[real_path[i]];
            }
            for(int i=0; i<=distance; i++){
                ans[i] = real_path[i];
            }
            
            return distance+1;
        }
        else{
            return -1;
        }
    }
    
}