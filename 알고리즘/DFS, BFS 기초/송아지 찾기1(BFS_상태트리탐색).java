import java.util.*;

/**
 * 송아지 찾기 1 : 상태트리 BFS 탐색
 * 내 위치와 송아지의 위치 정보가 주어질 때,
 * 내가 송아지를 찾기 위한 최소 이동 횟수를 구하기
 * 나는 한번에 앞으로 1칸, 뒤로 1칸, 앞으로 5칸을 이동할 수 있다.
 */
public class Main {
    static int[] dr = {1, -1, 5};
    static int[] moveCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        moveCount = new int[10001];

        bfs(start, end);

        System.out.println(moveCount[end] - 1);
    }

    private static void bfs(int start, int end) {
        // 탐색 시작 : 내 위치
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        moveCount[start] = 1;

        while(!queue.isEmpty()) {
            // 같은 레벨의 노드들을 순회하며 탐색
            for(int i=0; i<queue.size(); i++) {
                int now = queue.poll();

                // 내 위치가 송아지의 위치와 같아질 경우 탐색 종료
                if(now == end) {
                    return;
                }

                for(int j=0; j<3; j++) {
                    int cr = now + dr[j];   // 다음 이동할 노드

                    // 만약 다음 이동할 노드가 범위안에 있고 아직 방문하지 않았다면
                    if(cr >= 1 && cr <= 10000 && moveCount[cr] == 0) {
                        // 큐에 다음 이동할 노드를 넣어주고, 해당 노드의 이동 횟수에 현재 노드의 이동 횟수보다 1 증가한 값을 넣어줌
                        queue.add(cr);
                        moveCount[cr] = moveCount[now] + 1;
                    }
                }
            }
        }
    }
}