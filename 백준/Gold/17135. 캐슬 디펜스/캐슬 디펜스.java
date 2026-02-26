import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,D;
    static int[][] ground;
    static boolean[] visited;
    static int[] sel;
    static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        ground = new int[M][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M;j++){
                ground[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        sel = new int[3];//궁수는 3명
        visited = new boolean[M]; //N행 M열
        dfs(0,sel,0);    
        
        System.out.println(count);
    }

    private static void dfs(int idx, int[] sel, int start){
        if(idx == 3){
            checkD(sel);
            return;
        }

        for(int i = start; i < M; i++){
            if(visited[i]) continue;

            sel[idx] = i;
            visited[i] = true;

            dfs(idx+1, sel, i+1);
            visited[i] = false;
        }
    }

    private static void checkD(int[] sel){
        //set1. 궁수랑 1인 거리를 구함
        //D안에 위치하고 거리가 가장 짧고 y값이 작은(왼쪽에 위치한)
        //처치 숫자 증가
        //0으로 바꿈s
    	
    	//복사
    	int[][] map = new int[M][N];
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			map[j][i] = ground[j][i];
    		}
    	}

        int cnt = 0;
        
        for(int arrowy = N; arrowy > 0; arrowy--){
        	
        	//일단 mark를 이용해서 확인
        	boolean[][] mark = new boolean[M][N];
        	
            for(int k = 0;  k < sel.length; k++){
            int min = Integer.MAX_VALUE;
            int bestx = -1;
            int besty = -1;


            for(int i = 0; i < arrowy; i++){
                for(int j = 0; j < M; j++){
                    if(map[j][i] == 1){
                        int ex = j;
                        int ey = i;

                        int dist = Math.abs(arrowy - ey) + Math.abs(sel[k] - ex);
                
                        //만약에 min이 여러개면 왼쪽에 위치한 것
                        if (dist > D) continue;

                        
                        if (dist < min || (dist == min && ex < bestx)) {     
                        	min = dist;
                            bestx = ex;
                            besty = ey;
                        }                  
                    }
      
                }  
            }
            
            if(bestx != -1 && besty!= -1) {
            	mark[bestx][besty] = true; 
                
            }
         }
         //3명의 궁수는 동시에 처리
         for(int x = 0; x < M; x++) {
           for(int y = 0; y < arrowy; y++) {
            		if(mark[x][y] && map[x][y] == 1) {
            			map[x][y] = 0;
            			cnt++;
            		}
            	}
            }
        }

        count = Math.max(cnt, count);  
    }
    
}

