class Solution {

    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                boolean isEntrance = row != entrance[0] || col != entrance[1];
                boolean isEdge =
                    row == 0 || row == m - 1 || col == 0 || col == n - 1;
                if (isEntrance && isEdge) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (
                        newRow >= 0 &&
                        newRow < m &&
                        newCol >= 0 &&
                        ewCol < n &&
                        maze[newRow][newCol] == '.'
                    ) {
                        maze[newRow][newCol] = '+';
                        queue.add(new int[] { newRow, newCol });
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
