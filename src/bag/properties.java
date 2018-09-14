package bag;

public class properties { //Properties类
  int strNum=0;
  int wordNum=0;
  int lineNum=0;
  int codeLine=0;    //代码行
  int blankLine=0;   //空行
  int commentLine=0; //注释行
  
public int getCodeLine() {
	return codeLine;
}
public void setCodeLine(int codeLine) {
	this.codeLine = codeLine;
}
public int getBlankLine() {
	return blankLine;
}
public void setBlankLine(int blankLine) {
	this.blankLine = blankLine;
}
public int getCommentLine() {
	return commentLine;
}
public void setCommentLine(int commentLine) {
	this.commentLine = commentLine;
}
    public int getStrNum() {
	  return strNum;
}
    public void setStrNum(int strNum) {
	  this.strNum = strNum;
}
    public int getWordNum() {
	  return wordNum;
}
    public void setWordNum(int wordNum) {
	  this.wordNum = wordNum;
}
    public int getLineNum() {
	  return lineNum;
}
    public void setLineNum(int lineNum) {
	  this.lineNum = lineNum;
}
}
