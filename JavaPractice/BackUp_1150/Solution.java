package BackUp_1150;
import java.util.*;

class Solution {
    public static int solution(int n, int k, int[] companyArr) {
        int answer=0;
        PriorityQueue<Cable> cableQue = new PriorityQueue<>();
        Set<Integer> selectedSet = new HashSet<>();

        for (int i=1; i<n; i++) {
            Cable cable = new Cable(i-1, i, companyArr[i]-companyArr[i-1]);
            cableQue.add(cable);
        }

        while (k > 0) {
            Cable selectedCable = cableQue.poll();

            if (selectedCable != null) {
                if (selectedSet.contains(selectedCable.left) || selectedSet.contains(selectedCable.right)) {
                    continue;
                } else {
                    int length = selectedCable.length;
                    int left = selectedCable.left;
                    int right = selectedCable.right;

                    answer += length;
                    selectedSet.add(left);
                    selectedSet.add(right);

                    if (left > 0 && right < n - 1) {
                        left = left - 1;
                        right = right + 1;

                        Cable newCable = new Cable(left, right, companyArr[right] - companyArr[left] - 2 * length);
                        cableQue.add(newCable);
                    }
                }
            }
            k--;
        }
        return answer;
    }

}

class Cable implements Comparable<Cable> {
    int left;
    int right;
    int length;

    public Cable(int left, int right, int length) {
        this.left = left;
        this.right = right;
        this.length = length;
    }

    @Override
    public int compareTo(Cable cable) {
        if (this.length == cable.length) {
            return cable.left - this.left;
        }
        else {
            return this.length - cable.length;
        }
        
    }
}