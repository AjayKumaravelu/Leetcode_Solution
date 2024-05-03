class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Revisions = version1.split("\\.");
        String[] v2Revisions = version2.split("\\.");

        int n = Math.max(v1Revisions.length, v2Revisions.length);

        for (int i = 0; i < n; i++) {
            int v1 = i < v1Revisions.length ? Integer.parseInt(v1Revisions[i]) : 0;
            int v2 = i < v2Revisions.length ? Integer.parseInt(v2Revisions[i]) : 0;

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }

        return 0;
    }
}