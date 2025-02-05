import java.util.Random;

public class ThreeThreads {
    public static void main(String[] args) {
        // สร้างสามเธรด
        Thread thread1 = new Thread(new Task(1), "Thread 1");
        Thread thread2 = new Thread(new Task(2), "Thread 2");
        Thread thread3 = new Thread(new Task(3), "Thread 3");

        // เริ่มเธรด
        thread1.start();
        thread2.start();
        thread3.start();

        // การสังเกตพฤติกรรมเริ่มต้น:
        // ก่อนที่จะเพิ่ม Thread.sleep() เธรดจะทำงานพร้อมกันแต่ไม่มีการหน่วงเวลา
        // ลำดับของผลลัพธ์ไม่สามารถคาดเดาได้และอาจแตกต่างกันในแต่ละครั้งที่รัน
        // แต่ตัวเลขจากแต่ละเธรดจะปรากฏตามลำดับ (1 ถึง 50) โดยไม่มีการขัดจังหวะ

        // การสังเกตพฤติกรรมใหม่:
        // หลังจากเพิ่ม Thread.sleep() เธรดยังคงทำงานพร้อมกัน แต่มีการหน่วงเวลาแบบสุ่ม
        // ลำดับของผลลัพธ์จะยิ่งไม่สามารถคาดเดาได้มากขึ้นเนื่องจากการหน่วงเวลาแบบสุ่ม
        // ตัวเลขจากแต่ละเธรดอาจสลับกันบ่อยขึ้น แสดงถึงผลของการหน่วงเวลา
    }
}

class Task implements Runnable {
    private int threadNumber;
    private Random random = new Random();

    public Task(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("thread #" + threadNumber + ": " + i);
            try {
                // หน่วงเวลาสุ่มระหว่าง 0 ถึง 100 มิลลิวินาที
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

/*
คำอธิบายเกี่ยวกับมัลติเธรดใน Java:
- มัลติเธรดช่วยให้หลายเธรดทำงานพร้อมกันในโปรแกรมเดียว
- แต่ละเธรดทำงานอย่างอิสระและสามารถทำงานต่างๆ พร้อมกันได้
- Java Virtual Machine (JVM) จะจัดการการทำงานของเธรด ซึ่งอาจทำให้ลำดับการทำงานแตกต่างกันในแต่ละครั้งที่รัน
- ลำดับของผลลัพธ์เปลี่ยนแปลงเพราะตัวจัดการเธรดของ JVM ตัดสินใจว่าจะให้เธรดใดทำงานในแต่ละเวลา ซึ่งการตัดสินใจนี้อาจแตกต่างกัน
- การเพิ่ม Thread.sleep() ทำให้เกิดการหน่วงเวลา ทำให้ลำดับการทำงานยิ่งไม่สามารถคาดเดาได้มากขึ้นเนื่องจากเธรดถูกหยุดชั่วคราวในระยะเวลาสุ่ม
*/