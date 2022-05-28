import java.util.*;

public class ya_ch2_gc {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //Количество вакансий
        int number_job = in.nextInt();
        ArrayList<Type_job> arrayList_job = new ArrayList<Type_job>();

        for (int i = 0; i < number_job; i++){
            String str = in.next();
            String[] split_str = (str.split(","));
            Type_job type_job = new Type_job(split_str[0],Integer.parseInt(split_str[1]));
            arrayList_job.add(type_job);
        }

        int number_worker = in.nextInt();
        ArrayList<Type_worker> arrayList_worker = new ArrayList<Type_worker>();

        for (int i = 0; i < number_worker; i++){
            String str = in.next();
            String[] split_str = str.split(",");
            Type_worker type_worker = new Type_worker(split_str[0], split_str[1],
                    Integer.parseInt(split_str[2]), Integer.parseInt(split_str[3]));
            arrayList_worker.add(type_worker);
        }

//        НИКАКАЯ СОРТИИРОВКА
        ArrayList sorted_workers = new ArrayList<>();

//        testList.sort(Comparator.comparing(ClassName::getFieldName).reversed());
        arrayList_worker.sort(Comparator.comparing(Type_worker::getCount_task).reversed().thenComparing(Comparator.comparing(Type_worker::getCount_mistake)));
//        for (int i = 0; i < number_worker; i++){
//            arrayList_worker.get(i).getType_job();
//        }
        arrayList_job.forEach(j ->{
            final int[] i = {0};
            arrayList_worker.forEach(w -> {
                if (j.getName_job().equals(w.getType_job())) {
                    while (i[0] < j.getCount_worker()) {
                        sorted_workers.add(w.getName_worker());
                        i[0]++;
                    }
                }
            });
        });
        Collections.sort(sorted_workers);
        sorted_workers.forEach(System.out::println);
//        arrayList_worker.forEach(x-> System.out.println(x.getName_worker() +" "+ x.getCount_task() +" "+ x.getCount_mistake()));
//        arrayList_job.sort();
//        Collections.sort(arrayList_job(0).);
//        arrayList_job.get(0);

        System.out.println();
    }
}

class Type_job {
    String name_job;
    int count_worker;

    public Type_job(String name_job, int count_worker) {
        this.name_job = name_job;
        this.count_worker = count_worker;
    }

    public String getName_job() {
        return name_job;
    }

    public void setName_job(String name_job) {
        this.name_job = name_job;
    }

    public int getCount_worker() {
        return count_worker;
    }

    public void setCount_worker(int count_worker) {
        this.count_worker = count_worker;
    }
}
class Type_worker{
    String name_worker;
    String type_job;
    int count_task;
    int count_mistake;

    public Type_worker(String name_worker, String type_job, int count_task, int count_mistake) {
        this.name_worker = name_worker;
        this.type_job = type_job;
        this.count_task = count_task;
        this.count_mistake = count_mistake;
    }

    public String getName_worker() {
        return name_worker;
    }

    public void setName_worker(String name_worker) {
        this.name_worker = name_worker;
    }

    public String getType_job() {
        return type_job;
    }

    public void setType_job(String type_job) {
        this.type_job = type_job;
    }

    public int getCount_task() {
        return count_task;
    }

    public void setCount_task(int count_task) {
        this.count_task = count_task;
    }

    public int getCount_mistake() {
        return count_mistake;
    }

    public void setCount_mistake(int count_mistake) {
        this.count_mistake = count_mistake;
    }
}