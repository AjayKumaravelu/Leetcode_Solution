class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> ans = new ArrayList<>();

        // for (int i = 0; i < n; i++) {
        //     // case 1: when it is empty or it does not overlap
        //     if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]) {
        //         ans.add(new int[]{intervals[i][0], intervals[i][1]});
        //     }
        //     // case 2: if it overlaps with the previous interval
        //     else {
        //         ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
        //     }
        // }


        for(int i = 0; i < n; i++){
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]){
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            }else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
