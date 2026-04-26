class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rowCheck = validateDuplicateInRow(board);
        boolean colCheck = validateDuplicateInCol(board);
        boolean matrixCheck = validateDuplicateInMatrix(board);

        return rowCheck && colCheck && matrixCheck;
    }

    boolean validateDuplicateInRow(char[][] board) {
        for(int i=0; i<9;i++) {
            char[] row = board[i];
            Set nums = new HashSet();
            for(char num: row) {
                if(num == '.') {
                    continue;
                }
                if(nums.contains(num)) {
                    return false;
                }
                nums.add(num);
            }
        }
        return true;
    }

    boolean validateDuplicateInCol(char[][] board) {
        for(int i=0; i<9;i++) {
            char[] row = board[i];
            Set nums = new HashSet();
            for(int j=0; j<9 ; j++) {
                char num = board[j][i];
                if(num == '.') {
                    continue;
                }
                if(nums.contains(num)) {
                    return false;
                }
                nums.add(num);
            }
        }
        return true;
    }

    boolean validateDuplicateInMatrix(char[][] board) {
        int rowStart = 0;
        int colStart = 0;
        while(rowStart<9 && colStart<9) {
            Set nums = new HashSet();
            for(int i=rowStart; i<rowStart+3 && i<9; i++) {
                for(int j=colStart; j<colStart+3 && j<9; j++){
                    char num = board[i][j];
                    if(num == '.') {
                        continue;
                    }
                    if(nums.contains(num)) {
                        return false;
                    }
                    nums.add(num);
                }
            }
            rowStart+=3;
            if(rowStart == 9) {
                colStart+=3;
                rowStart = 0;
            }
            if(colStart == 9) {
                break;
            }
        }
        return true;
    }
}
