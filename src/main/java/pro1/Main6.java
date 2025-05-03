package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

public class Main6 {

    public static void main(String[] args) {
        System.out.println(idOfBestTeacher("KIKM",2024));
    }

    public static long idOfBestTeacher(String department, int year)
    {
        // TODO 6.1 (navazuje na TODO 3):
        //  - Stáhni seznam akcí na katedře (jiná data nepoužívat)
        //  - Najdi učitele s nejvyšším "score" a vrať jeho ID

        String json = Api.getActionsByDepartment(department, year);
        ActionsList actions = new Gson().fromJson(json, ActionsList.class);

        HashMap<Long,Integer> map = new HashMap<>();
        AtomicLong maxId = new AtomicLong(-1);
        actions.items.stream().forEach(a -> {
            map.put(a.teacherId,map.getOrDefault(a.teacherId,0)+a.personsCount);
            if(maxId.get() != -1){
                if(map.get(maxId.get())< map.get(a.teacherId))
                    maxId.set(a.teacherId);
            }else{
                maxId.set(a.teacherId);
            }
        });
        return maxId.get();
    }
}