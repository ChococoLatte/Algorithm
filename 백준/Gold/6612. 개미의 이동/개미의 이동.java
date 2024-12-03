import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            // 첫 줄에서 나무 길이(L)와 개미 수(A) 읽기
            StringTokenizer st = new StringTokenizer(line);
            int L = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            // 개미의 위치와 방향 정보 저장
            List<Integer> positions = new ArrayList<>();
            int maxLeft = -1, maxRight = -1, leftCount = 0;

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int position = Integer.parseInt(st.nextToken());
                String direction = st.nextToken();

                positions.add(position);

                if (direction.equals("R")) {
                    maxRight = Math.max(maxRight, L - position); // 오른쪽으로 떨어지는 시간 계산
                } else {
                    maxLeft = Math.max(maxLeft, position); // 왼쪽으로 떨어지는 시간 계산
                    leftCount++;
                }
            }

            // 정렬 (positions를 정렬하여 초기 위치 추적)
            Collections.sort(positions);

            // 결과 계산
            int lastFallTime = Math.max(maxLeft, maxRight);
            StringBuilder result = new StringBuilder();
            result.append("The last ant will fall down in ").append(lastFallTime).append(" seconds - started at ");

            // 출력에 따라 처리
            if (maxLeft == maxRight) {
                // 두 개미가 동시에 떨어지는 경우
                result.append(positions.get(leftCount - 1)).append(" and ").append(positions.get(leftCount));
            } else if (maxLeft > maxRight) {
                // 왼쪽으로 떨어지는 개미가 마지막인 경우
                result.append(positions.get(leftCount - 1));
            } else {
                // 오른쪽으로 떨어지는 개미가 마지막인 경우
                result.append(positions.get(leftCount));
            }

            result.append(".");
            System.out.println(result);
        }
    }
}
