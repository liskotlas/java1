package ru.progwards.java2.lessons.threads;

public class Summator{
    static Integer resultOut = 0;
    int count = 0;
    int start;
    int finish;

    public Summator(int count){
        this.count = count;
    }

    public static void setSum(int summa){
        synchronized (resultOut){
            resultOut += summa;
//            System.out.println(resultOut);
        }
    }



    public int sum(int number){
        Thread[] threads = new Thread[count];

        for (int i = 1; i <= count; i++) {
            int all = number / count;
            finish = all * i;
            start = finish - all + 1;
            if (i == count) {
                finish = number;
            }
//                System.out.println(start + " - " + finish);
                threads[i-1] = new Thread(new SummatorThred(start, finish));
                threads[i-1].start();

        }
            for (int a = 0; a < count; a++){
                try {
                    threads[a].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return resultOut;
    }



    public static void main(String[] args) {
        System.out.println(new Summator(5).sum(1000));
    }
}

class SummatorThred implements Runnable{
    int start = 0;
    int finish = 0;
    int result;



    public SummatorThred(int start, int finish){
//        System.out.println(start + " - " + finish);
         this.start = start;
         this.finish = finish;
    }

    private void Summa (int start, int finish){
        for(int i = start; i <= finish; i++){
            result +=i;
        }
        Summator.setSum(result);
    }
    @Override
    public void run() {
        Summa(start, finish);

    }
}
