import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(10);
        Task task1 = new Task(1000);
        Task task2 = new Task(10000);
        Future<Integer> r1 = e.submit(task1);
        Future<Integer> r2 = e.submit(task2);
        e.shutdown();
        int sum = 0;
        while(true){
            if(r1.isDone()&&r2.isDone()){
                try {
                    System.out.println("task1===="+r1.get());
                    System.out.println("task2===="+r2.get());
                    sum = r1.get()+r2.get();
                    break;
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                }
            }

        }
        System.out.println("sum====="+sum);

        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable<Integer>{
    private int count;
    public Task(int count){
        this.count = count;
    }
    @Override
    public Integer call() throws Exception {
        System.out.println("子进程正在进行计算");
        Thread.sleep(1000);
        int sum = 0;
        for(int i=0;i<count;i++){
            sum += i;
        }
        return sum;
    }
}