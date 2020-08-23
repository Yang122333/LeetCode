public class MineClearance {
    public static void main(String[] args) {

    }

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return null;
        }
        int[][] numbers = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'M') {

                }
            }
        }
    }

    public void recursion(char[][] chars, int[][] number, int high, int low) {
        if (high < 0 || high > chars.length - 1 ||
                low < 0 || low > chars[0].length ||
                chars[high][low] == 'B') {
            return;
        }
        if (number[high][low] != 0) {
            chars[high][low] = (char) ('0' + number[high][low]);
            return;
        }
        chars[high][low] = 'B';
        recursion(chars, number, ++high, low);
        recursion(chars, number, ++high, ++low);
        recursion(chars, number, --high, low);
        recursion(chars, number, high, --low);
        recursion(chars, number, ++high, low);
    }
}
