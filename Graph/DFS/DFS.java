class DFS{
    public static int findBC(int vertex_num, int edge_num, int[] x, int[] y){
        LinkedList[] adjList = new LinkedList[vertex_num];
        boolean[] visited = new boolean[vertex_num];
        int[] DFS_com = new int[vertex_num];
        int index=0;

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

        for(int i=0; i<vertex_num; i++){
            if(!visited[i]){
                doDFS(i, visited, DFS_com, adjList, i);
            }
        }

        /* for(int i=0; i<vertex_num; i++){
            System.out.println(i);
        } */
        
        return 0;
    }
    public static void doDFS(int v, boolean[] visited,int[] DFS_com, LinkedList[] adjList, int i){
        visited[v] = true;
        DFS_com[i] = v;
        System.out.println(i);
        i++;
        for(Node e = adjList[v].first.next; e!=null; e = e.next){
            if(!visited[e.data]){
                doDFS(e.data, visited, DFS_com, adjList, i);
            } 
        }
    }
}