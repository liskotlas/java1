package ru.progwards.java2.lessons.threads;

import java.math.BigInteger;

public class Summator{
    static BigInteger resultOut = BigInteger.ZERO;
    int  count;
    BigInteger  start = BigInteger.ZERO;
    BigInteger  finish = BigInteger.ZERO;

    public Summator(int  count){
        this.count = count;
    }

    public static void setSum(BigInteger  summa){
        synchronized (resultOut){
            resultOut = resultOut.add(summa);
//            System.out.println(resultOut);
        }
    }



    public BigInteger  sum(BigInteger  number){
        Thread[] threads = new Thread[count];

        for (int i = 1; i <= count; i++) {
            BigInteger  all = number.divide(BigInteger.valueOf(count));
            finish = all.multiply(BigInteger.valueOf(i));
            start = finish.subtract(all).add(BigInteger.ONE);
            if (i == count) {
                finish = number;
            }
                threads[i-1] = new Thread(new SummatorThred(start, finish));
                threads[i-1].start();


        }
            for (Thread thread : threads){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return resultOut;
    }



    public static void main(String[] args) {
        System.out.println(new Summator(5).sum(BigInteger.valueOf(1000)));
    }
}

class SummatorThred implements Runnable{
    BigInteger  start = BigInteger.ZERO;
    BigInteger  finish = BigInteger.ZERO;
    BigInteger  result = BigInteger.ZERO;



    public SummatorThred(BigInteger  start, BigInteger  finish){
//        System.out.println(start + " - " + finish);
         this.start = start;
         this.finish = finish;
    }

    private void Summa (BigInteger  start, BigInteger finish){
        for(BigInteger  i = start; i.compareTo(finish) <= 0; i = i.add(BigInteger.ONE)){
            result = result.add(i);
        }
        Summator.setSum(result);
    }
    @Override
    public void run() {
        Summa(start, finish);

    }
}
