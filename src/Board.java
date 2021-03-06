import java.util.ArrayList;
//import java.util.Currency;

public
 class Board {
    public char[][] layout;
    public ArrayList<Space> spacesAva;
    public ArrayList<Space> spacesLit;

    public Board(char[][] newBoard, ArrayList<Space> ava, ArrayList<Space> lit){

        this.spacesAva = ava;
        this.spacesLit = lit;
        layout = new char[newBoard.length][newBoard[0].length];
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                layout[i][j]=newBoard[i][j];
            }
        }
    }

    public String toString(){
        String toReturn = "";
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                toReturn+=layout[i][j];
            }
            toReturn+='\n';
        }
        return toReturn;
    }

    public char getPosition(int row, int col){
        return layout[row][col];
    }

    public void updatePosition(char newChar, int row, int col){
        layout[row][col] = newChar;
    }

    public boolean isBoardValid(ArrayList<Space> bulbLocations, ArrayList<Space> wallLocations){
        boolean bulbsValid = this.areBulbsValid(bulbLocations);
        boolean wallsValid = this.areWallsValid(wallLocations);
        boolean boardValid = this.checkForUnlitSpaces();

        return bulbsValid && wallsValid && boardValid;
    }

    public boolean areBulbsValid(ArrayList<Space> bulbSpaces){
        boolean valid = true;
        int counter = 0;
        Space currSpace;
        while (valid && counter<bulbSpaces.size()){
            currSpace = bulbSpaces.get(counter);
            valid = this.isRowValid(currSpace.x, currSpace.y);
            if (valid) {
                valid = this.isColValid(currSpace.x, currSpace.y);
            }
            counter +=1;
        }
        return valid;
    }

    public boolean areWallsValid(ArrayList<Space> wallSpaces){
        int counter = 0;
        int numBulbs = 0;
        int currX;
        int currY;
        int currWallNum;
        boolean valid = true;
        Space currSpace;
        char currChar;

        while (valid && counter < wallSpaces.size()){
            currSpace = wallSpaces.get(counter);
            currX = currSpace.x;
            currY = currSpace.y;
            currChar = this.getPosition(currX,currY);
            if (Character.isDigit(currChar)){
                currWallNum = currChar-48;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if ((i==0 || j==0) && ((currX+i) >= 0) && ((currY+j) >= 0)
                                && ((currX+i) < this.layout.length) && ((currY+j) < this.layout[0].length)){
                            if (this.getPosition(currX+i,currY+j)=='b'){
                                numBulbs += 1;
                            }
                        }
                    }
                }
                if (numBulbs!= currWallNum){
                    valid = false;
                }
            }
            numBulbs = 0;
            counter++;
        }
        return valid;
    }

    public boolean isRowValid(int rowNum, int colNum){
        boolean valid = true;
        boolean noWall = true;
        int counter = colNum-1;
        while (valid && noWall && counter >= 0){
            if (this.getPosition(rowNum, counter) == 'b'){
                valid = false;
            }else {
                if (Character.isDigit(this.getPosition(rowNum, counter))){
                    noWall = false;
                }
            }
            counter -= 1;
        }
        counter = colNum+1;
        while (valid && noWall && counter < this.layout[rowNum].length){
            if (this.getPosition(rowNum,counter) == 'b'){
                valid = false;
            }else {
                if (Character.isDigit(this.getPosition(rowNum, counter))){
                    noWall = false;
                }
            }
            counter+=1;
        }
        return valid;
    }

    public boolean isColValid(int rowNum, int colNum){
        boolean valid = true;
        boolean noWall = true;
        int counter = rowNum-1;
        while (valid && noWall && counter >= 0){
            if (this.getPosition(counter, rowNum) == 'b'){
                valid = false;
            }else {
                if (Character.isDigit(this.getPosition(counter, colNum))){
                    noWall = false;
                }
            }
            counter -= 1;
        }
        counter = rowNum+1;
        while (valid && noWall && counter < this.layout.length){
            if (this.getPosition(rowNum,counter) == 'b'){
                valid = false;
            }else {
                if (Character.isDigit(this.getPosition(counter, rowNum))){
                    noWall = false;
                }
            }
            counter+=1;
        }
        return valid;
    }

    public boolean validatePartialSolution(ArrayList<Space> bulbLocations, ArrayList<Space> wallLocations){
        return this.areBulbsValid(bulbLocations) && this.areWallsValid(wallLocations);
    }

    public boolean checkForUnlitSpaces(){
        boolean valid = true;
        for (int i = 0; i < this.layout.length; i++) {
            for (int j = 0; j < this.layout[i].length; j++) {
                if (valid && layout[i][j]=='_'){
                    valid = false;
                }
            }
        }
        return valid;
    }

}