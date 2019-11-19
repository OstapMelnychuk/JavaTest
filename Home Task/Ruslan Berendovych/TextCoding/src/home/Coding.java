package home;

public class Coding {
    private StringBuilder input;
    private char[] alphabet;
    private int[] dec;
    private String[] bin;
//Конструктор.
    public Coding(String input) {
        this.input = new StringBuilder();
        this.input.append(input);
        this.alphabet = new char[26];
        inAlphabet();
        code();
    }
//Кодування слова.Заміна символів на код АСКІ та знаходження індекса масиву.
    public int[] code(){
        String str = input.toString().toLowerCase().trim().replace("\n","").replace(" ","");
        input = new StringBuilder().append(str);
        dec = new int[input.length()];
        char[] arr = input.toString().toCharArray();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < alphabet.length; j++){
                if(arr[i] == alphabet[j]){
                    dec[i] = j;
                }
            }
        }
//        for(int i = 0; i < dec.length; i++){
//            System.out.print(dec[i] + ".");
//        }
//        System.out.println();
        return dec;
    }
//Декодування.Виведення символів за їх індексом в масиві.
    public void decode(){
        for(int i = 0; i < dec.length; i++) {
            System.out.print(alphabet[dec[i]] + ".");
        }
    }


//Кодування індексів в двійковий код.
    public void binar(){
        bin = new String[dec.length];
        for (int i = 0; i < bin.length; i++){
            bin[i] = Integer.toBinaryString(dec[i]);
        }
        for (int i = 0; i < bin.length; i++){
            System.out.print(bin[i] + ".");
        }
        System.out.println();
    }

//Декодування індексів з двійкової в десяткову СЧ.
    public void decimal(){
        for(int i = 0; i < bin.length; i++){
            dec[i] = Integer.parseInt(bin[i],2);
        }
//        for(int i = 0; i < dec.length; i++){
//            System.out.print(dec[i] + ".");
//        }
//        System.out.println();

    }

//Ініціалізація масиву символів a-z.
    private void inAlphabet(){
        int index = 0;
        for(int i = 97; i < 123; i++, index++){
            alphabet[index] = (char) i;
        }
    }
}


/*
    public void binar(){
        bin = new String[dec.length];
        for (int i = 0; i < bin.length;i++){
            bin[i] = "";
        }
        for(int i = 0; i < dec.length; i++){
            if(dec[i] == 0){
                bin[i] = "0";
            }else {
                while (dec[i] != 0) {
                    b = dec[i] % 2;
                    bin[i] = b + bin[i];
                    dec[i] = dec[i] / 2;
                }
            }
        }
        for (int i = 0; i < bin.length;i++){
            System.out.print(bin[i] + ".");
        }

    }
*/
