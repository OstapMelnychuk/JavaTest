public class Text4 {
    private StringBuilder inPutText;
    private StringBuilder outPutText;
    private StringBuilder outPutTextNew;

    public Text4(String inPutText) {
        this.inPutText = new StringBuilder();
        this.inPutText.append(inPutText);
        this.outPutText = new StringBuilder();
    }
    public String text4Code (){
        char index = ' ';
        String str = inPutText.toString();
        inPutText = new StringBuilder(str);
        char [] inputArray = inPutText.toString().toCharArray();
        for (int i = 0; i<inputArray.length;i++){
            if (i % 2 == 0){
                 index = inputArray [i+1];
            }
            else {index = inputArray[i-1];}

            outPutText.append(index);}


        return outPutText.toString();

    }
    public String Text4Decode (){
        char index = ' ';
        String str = inPutText.toString();
        inPutText = new StringBuilder(str);
        char [] inputArray = inPutText.toString().toCharArray();
        for (int i = 0; i<inputArray.length;i++){
            if (i % 2 != 0){
                index = inputArray [i-1];
            }
            else {index = inputArray[i+1];}

            outPutText.append(index);}


        return outPutText.toString();
    }
}

