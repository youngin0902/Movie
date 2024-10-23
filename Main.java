
package netflix;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Member m = Member.getInstance();
        m.memberGuide();
        //회원가입

        Purchase p = Purchase.getInstance();
        p.purchaseQuestion();
        //1. 도서목록 확인  2. 결제수단 선택 3. 결제완료

        Loading l = new Loading();
        l.loading();
        //로딩

    }
}