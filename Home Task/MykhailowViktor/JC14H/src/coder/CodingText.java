package coder;

class CodingText {
    private StringBuilder text;
    private StringBuilder textOut;
    private StringBuilder decodingText;
    private char[] alphabet;
    private char[] inverseAlphabet;

    CodingText(String text) {
        this.text = new StringBuilder();
        this.text.append(text);
        this.textOut = new StringBuilder();
        this.decodingText = new StringBuilder();
        this.alphabet = new char[26];
        this.inverseAlphabet = new char[26];
        initializeAlphabet();
    }

    private void initializeAlphabet() {
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) (97 + i);
        }
    }

    String myCoding() {
        String str = text.toString().toLowerCase().trim().replace("\n", "");
        text = new StringBuilder().append(str);
        char[] arr = text.toString().toCharArray();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (arr[i] == alphabet[j]) {
                    index = j;
                }
            }
            for (int k = 0; k < alphabet.length; k++) {
                inverseAlphabet[k] = (char) (122 - k);
            }
            if (arr[i] < 97 || arr[i] > 122) {
                textOut.append(arr[i]);
            } else {
                textOut.append(inverseAlphabet[index]);
            }
        }
        return textOut.toString();
    }

    String myDeCoding() {
        char[] arr = text.toString().toCharArray();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (arr[i] == alphabet[j]) {
                    index = j;
                }
            }
            for (int k = 0; k < alphabet.length; k++) {
                inverseAlphabet[k] = (char) (122 - k);
            }
            if (arr[i] < 97 || arr[i] > 122) {
                decodingText.append(arr[i]);
            } else {
                decodingText.append(alphabet[index]);
            }
        }
        return decodingText.toString();
    }
}
