import java.util.*;

public class ProducerConsumer {
    final ArrayList<Integer> items =  new ArrayList<Integer>(10);
    final Object lock = new Object();
    final int capacity = 5;


    public static void main(String[] args) 
    {
        ProducerConsumer m = new ProducerConsumer();
      
        Thread[] t = new Thread[10];

        for (int producer_count = 0; producer_count < 5; producer_count++) 
        { 
            t[producer_count] = new Thread(m.new Producer(producer_count+1));
            t[producer_count].start();
        }

        for (int consumer_count = 0; consumer_count < 5; consumer_count++) 
        { 
            t[consumer_count+5] = new Thread(m.new Consumer(consumer_count+1));
            t[consumer_count+5].start();
        }

    }

    class Producer implements Runnable
    {
        int producerNo;
        int value = 0;

        public Producer(int producerNo)
        {
            this.producerNo = producerNo;
        }

        @Override
        public void run() 
        {
            for (int i=1;i<=capacity ;i++ ) 
            {
                try 
                {
                    produce();
                } 
                catch (InterruptedException e) 
                { 
                    e.printStackTrace();
                }
            }
            
        }

        public void produce() throws InterruptedException 
        {
            synchronized (lock)
            {
                while(items.size() == capacity)
                {
                    lock.wait();
                }
                items.add(++value);
                System.out.println( "Producer " + producerNo + " produced "+value);
                Thread.sleep(1000);
                lock.notify();
            }
        }
    }

    class Consumer implements Runnable
    {
        int consumerNo;

        public Consumer(int consumerNo)
        {
            this.consumerNo = consumerNo;
        }

        @Override
        public void run() 
        {
            for (int i=1;i<=capacity ;i++ ) 
            {
                try 
                {
                    consume();
                } 
                catch (InterruptedException e) 
                { 
                    e.printStackTrace();
                }
            }
        }

        public void consume() throws InterruptedException 
        {
       
            synchronized (lock)
            {
                while (items.size() == 0)
                {
                    lock.wait();
                }
                System.out.println( "Consumer " + consumerNo + " consumed "+items.remove(0));
                Thread.sleep(1000);
                lock.notify();
            }
        }
    }
}
