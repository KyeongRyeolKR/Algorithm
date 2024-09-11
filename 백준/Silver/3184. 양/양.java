import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static char[][] map;
    static boolean[][] visited;
    static int r;
    static int c;
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        int s = 0;
        int w = 0;

        for(int i=0; i<r; i++){
            String temp = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(!visited[i][j] && !(map[i][j] == '#')){
                    answer[0] = 0;
                    answer[1] = 0;
                    int[] x = dfs(i, j);
                    if(!(x[0] == 0 && x[1] == 0)){
                        if(x[1] >= x[0]){
                            w += x[1];
                        }else {
                            s += x[0];
                        }
                    }

                }
            }
        }

        System.out.println(s);
        System.out.println(w);
    }

    public static int[] dfs(int row, int col){
        visited[row][col] = true;

        if(map[row][col] == 'o') {
            answer[0]++;
        }
        if(map[row][col] == 'v') {
            answer[1]++;
        }

        for(int i=0; i<4; i++){
            int nx = row+ dr[i];
            int ny = col+ dc[i];
            if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }
            if(visited[nx][ny] || map[nx][ny]=='#') {
                continue;
            }

            dfs(nx,ny);
        }

        return answer;
    }
}