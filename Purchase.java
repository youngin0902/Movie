package netflix;

import java.util.Scanner;
import java.util.Calendar;

public class Purchase {
    int num;
    int num1;
    String[] pays = {"카카오페이", "토스", "계좌이체", "무통장입금"};
    String[] packages = {"베이직", "스탠다드", "프리미엄"};
    int [] price = {5000, 7000, 10000};
    Scanner sc = new Scanner(System.in);
    private static Purchase p;
    public static Purchase getInstance(){
        if(p == null){
            p = new Purchase();
        }
        return p;
    }
    public static void freeInstance(){
        p = null;
    }
    private Purchase(){

    }

    public void purchaseQuestion() {
        Member m = Member.getInstance();

        System.out.println(m.name+"님 안녕하세요. \n이용권을 구매하시겠습니까?"
                +"\n[1] 예 \t [2] 아니요");

        String answer = "";
        for(;;){
            answer = sc.next();





            if (answer.equals("1") || answer.equals("예")) {
                System.out.println(" ");
                System.out.println("===이용권 안내===");
                String[] packagess = {"1. 베이직 5000원", "2. 스탠다드 7000원", "3. 프리미엄 10000원"};
                for (String string : packagess) {
                    System.out.println(string);
                }
                System.out.print("원하시는 이용권의 번호를 입력해주세요 : ");
                num = sc.nextInt();
                if (num < 1 || num > 3) {
                    System.out.print("잘못된 번호입니다. 다시 입력해주세요.");

                } else {
                    pay();
                }
            }else if(answer.equals("2")||answer.equals("아니오")){
                System.out.println("이용권 구매가 종료되었습니다.");
                System.exit(0);
            }else{
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }

    }

    private void pay() {
        Member m = Member.getInstance();
        Calendar cal = Calendar.getInstance();
        System.out.println(" ");
        System.out.println("===결제수단 안내===");
        String[] pay = {"1. 카카오페이", "2. 토스", "3. 계좌이체", "4. 무통장입금"};
        for (String string : pay) {
            System.out.println(string);
        }
        for (;;) {

            System.out.print("결제수단 번호를 입력해 주세요 : ");
            num1 = sc.nextInt();
            if (num1 < 1 || num1 > 4) {
                System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            } else {
                System.out.print("비밀번호를 입력해주세요 : ");
                String pass = sc.next();
                if (pass.equals(m.pw)) {
                    System.out.println("\n=================================================================\n");
                    System.out.println("결제 진행중입니다. 잠시만 기다려주세요");
                    System.out.println("\n=================================================================\n");
                    Loading l = new Loading();
                    l.loading();
                    System.out.println("["+pays[num1-1]+"] 으로(로) "+ "["+price[num - 1]+"]"+" 을(를) 결제했습니다.");
                    System.out.println("["+packages[num - 1]+"]"+"이용권 구매가 완료되었습니다.");

                    System.exit(0);
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                }
            }
        }
    }


}
