package consoledemo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getString(String preMessage) {
        printPreMessage(preMessage);
        return scanner.nextLine();
    }

    /**
     * コンソールから入力された数値を取得する
     * 数値以外の値が渡された場合は、エラーメッセージを出力して0を返す
     *
     * @return コンソールから入力された数値
     */
    public int getInt(String preMessage) throws InputMismatchException {
        printPreMessage(preMessage);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        }
    }

    private void printPreMessage(String preMessage) {
        System.out.print(preMessage + " : ");
    }

}