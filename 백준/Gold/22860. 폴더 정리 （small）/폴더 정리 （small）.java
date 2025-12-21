import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * BOJ 22860 폴더 정리 (small)
 * * Logic:
 * 1. 폴더와 파일의 계층 구조를 HashMap<String, List<Node>>로 구성합니다.
 * (폴더 이름은 고유하다고 가정할 수 있는 입력 형식입니다.)
 * 2. 쿼리로 주어지는 경로의 '마지막 폴더'를 시작점으로 DFS 탐색을 수행합니다.
 * 3. 탐색 중 파일을 만나면 Set에 넣어 종류를, 변수로 총 개수를 카운트합니다.
 */
public class Main {

  // 폴더 및 파일 정보를 담을 노드 클래스
  static class Node {
    String name;
    boolean isFolder;

    Node(String name, boolean isFolder) {
      this.name = name;
      this.isFolder = isFolder;
    }
  }

  // 파일 시스템 트리 구조 저장 (Key: 부모 폴더 이름, Value: 자식 리스트)
  static Map<String, List<Node>> fileSystem = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 폴더 개수
    int m = Integer.parseInt(st.nextToken()); // 파일 개수

    // 파일 시스템 정보 입력
    for (int i = 0; i < n + m; i++) {
      st = new StringTokenizer(br.readLine());
      String parent = st.nextToken();
      String child = st.nextToken();
      int type = Integer.parseInt(st.nextToken()); // 1: 폴더, 0: 파일

      fileSystem.putIfAbsent(parent, new ArrayList<>());
      fileSystem.get(parent).add(new Node(child, type == 1));
    }

    int q = Integer.parseInt(br.readLine()); // 쿼리 개수
    StringBuilder sb = new StringBuilder();

    // 쿼리 처리
    for (int i = 0; i < q; i++) {
      String queryPath = br.readLine();
      String[] pathParts = queryPath.split("/");
      String targetFolder = pathParts[pathParts.length - 1]; // 경로의 마지막 부분이 타겟 폴더

      // 결과 계산을 위한 저장소 초기화
      Set<String> distinctFiles = new HashSet<>();
      int[] totalFiles = {0}; // Call by reference 효과를 위해 배열 사용

      // DFS 탐색 시작
      dfs(targetFolder, distinctFiles, totalFiles);

      sb.append(distinctFiles.size()).append(" ").append(totalFiles[0]).append("\n");
    }

    System.out.print(sb);
  }

  /**
   * 깊이 우선 탐색(DFS)으로 하위 폴더를 순회하며 파일을 수집합니다.
   *
   * @param currentFolder 현재 탐색 중인 폴더 이름
   * @param distinctFiles 파일의 종류(중복 제거)를 저장할 Set
   * @param totalFiles    파일의 총 개수를 저장할 배열 (index 0 사용)
   */
  private static void dfs(String currentFolder, Set<String> distinctFiles, int[] totalFiles) {
    // 현재 폴더 하위에 아무것도 없으면 리턴
    if (!fileSystem.containsKey(currentFolder)) {
      return;
    }

    for (Node child : fileSystem.get(currentFolder)) {
      if (child.isFolder) {
        // 폴더면 재귀적으로 더 깊이 탐색
        dfs(child.name, distinctFiles, totalFiles);
      } else {
        // 파일이면 개수 세기 및 종류 저장
        distinctFiles.add(child.name);
        totalFiles[0]++;
      }
    }
  }
}