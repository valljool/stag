package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.SpecializationsList;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args){
        System.out.println(specializationDeadlines(2025));
    }

    public static String specializationDeadlines(int year){
        String json = Api.getSpecializations(year);
        SpecializationsList specializationsList = new Gson().fromJson(json,SpecializationsList.class);
        return specializationsList.items.stream()
                .map(t -> t.deadline.deadline)
                .distinct()
                .sorted(Comparator
                        .comparing((String s) -> Integer.parseInt(s.split("[.]")[2]))
                        .thenComparing(s ->Integer.parseInt(s.split("[.]")[1]))
                        .thenComparing(s ->Integer.parseInt(s.split("[.]")[0])))
                .collect(Collectors.joining(","));
    }
}
