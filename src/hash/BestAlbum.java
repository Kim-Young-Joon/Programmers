package hash;

import java.util.*;

// 코딩테스트 연습 - 해시 - 베스트 앨범
public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                int play = map.get(genres[i]);
                map.put(genres[i], play + plays[i]);
            }
            else
                map.put(genres[i], plays[i]);
        }
        String []sortedGenres = new String[map.size()];
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int i = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            sortedGenres[i++] = entry.getKey();
        }

        HashMap<Integer, Integer> mostSong = new HashMap<>();
        for (int j = 0; j < sortedGenres.length; j++) {
            for (int z = 0; z < genres.length; z++) {
                if (genres[z].equals(sortedGenres[j])) {
                    mostSong.put(z, plays[z]);
                }
            }

            List<Map.Entry<Integer, Integer>> entryList2 = new LinkedList<>(mostSong.entrySet());
            entryList2.sort(new Comparator<Map.Entry<Integer, Integer>>() {

                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            i = 0;
            for(Map.Entry<Integer, Integer> entry : entryList2){
                if (i == 2)
                    break;
                ans.add(entry.getKey());
                i++;
            }
            mostSong.clear();
        }
        answer = new int[ans.size()];
        for (i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    // 다른 버전으로 작성해본 코드
    public int[] solution2(String[] genres, int[] plays) {
        HashMap<String, Integer> myData = new HashMap<>();
        String category = ""; // 각각의 장르를 담을 변수

        // 장르별 재생횟수 저장
        for(int index = 0; index < genres.length; index++) {
            category = genres[index];

            // 삼항 연산자를 이용, 해당 장르가 이미 있을 경우 기존 값에 더하고, 없을 경우 새로 추가
            myData.put(category, myData.containsKey(category) ? myData.get(category) + plays[index] : plays[index]);
        }

        Set<String> keySet = myData.keySet(); // key 값 받아오기
        ArrayList<String> order = new ArrayList<>(); // 많이 재생 된 장르부터 순서대로
        while(myData.size() != 0) {
            String maxGenre = "";
            int maxPlay = 0;
            // HashMap 의 key 값을 이용하여, 남아 있는 장르 중 가장 많이 재생된 장르를 찾는다
            for(String key : keySet) {
                if(myData.get(key) > maxPlay) {
                    maxGenre = key;
                    maxPlay = myData.get(key);
                }
            }
            order.add(maxGenre);
            myData.remove(maxGenre);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(String str : order) {
            int maxNum = 0, secondNum = 0; // 장르 재생 횟수를 담을 변수 (가장 큰 것, 그 다음)
            int selectIndex1 = 0, selectIndex2 = 0; // 저장할 인덱스
            for(int i = genres.length - 1; i >=0; i--) {
                if(genres[i] == str && plays[i] >= maxNum) {
                    maxNum = plays[i];
                    selectIndex1 = i;
                } else if(genres[i] == str && plays[i] >= secondNum) {
                    secondNum = plays[i];
                    selectIndex2 = i;
                }
            }
            ans.add(selectIndex1);
            ans.add(selectIndex2);
        }

        int[] answer = new int[ans.size()];
        int i = 0;
        for(int num : ans) {
            answer[i++] = num;
        }

        return answer;
    }

    public static void main(String[] args) {
        BestAlbum myTest = new BestAlbum();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(myTest.solution(genres, plays)));
    }
}
