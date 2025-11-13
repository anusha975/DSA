class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList();

        if (heights.length == 0 || heights[0].length == 0)
            return result;

        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] atlantic = new boolean[rows][cols];
        boolean[][] pacific = new boolean[rows][cols];

        for (int i = 0; i < cols; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, atlantic);
            dfs(heights, rows - 1, i, Integer.MIN_VALUE, pacific);
        }

        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, atlantic);
            dfs(heights, i, cols - 1, Integer.MIN_VALUE, pacific);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (atlantic[i][j] && pacific[i][j])
                    result.add(List.of(i, j));

            }
        }

        return result;

    }

    public void dfs(int[][] heights, int row, int col, int prev, boolean[][] reachable) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length
                || heights[row][col] < prev || reachable[row][col])
            return;

        reachable[row][col] = true;
        dfs(heights, row + 1, col, heights[row][col], reachable);
        dfs(heights, row - 1, col, heights[row][col], reachable);
        dfs(heights, row, col + 1, heights[row][col], reachable);
        dfs(heights, row, col - 1, heights[row][col], reachable);
    }
}
