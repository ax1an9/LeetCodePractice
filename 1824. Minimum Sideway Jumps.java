class Solution {
    public int minSideJumps(int[] obstacles) {
        final int inf = 0x3fffffff;
        int[] f = {1, 0, 1};//到达前一个点每个跑道的最小侧跳次数
        for (int i = 1; i < obstacles.length; ++i) {
            for (int j = 0; j < 3; ++j) {//给当前点的障碍跑道打上inf
                if (obstacles[i] == j + 1) {
                    f[j] = inf;
                    break;
                }
            }
            int x = Math.min(f[0], Math.min(f[1], f[2])) + 1;//统计从上一步经过侧跳到当前点的最小值
            for (int j = 0; j < 3; ++j) {//找出从上一步无需测侧跳的最小测跳数
                if (obstacles[i] != j + 1) {
                    f[j] = Math.min(f[j], x);
                }
            }
        }
        return Math.min(f[0], Math.min(f[1], f[2]));//返回到达终点的最小值
    }
}
