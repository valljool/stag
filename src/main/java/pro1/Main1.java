package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(emptyActionsCount("KIKM",2024));
    }

    public static long emptyActionsCount(String department, int year)
    {
        String json = Api.getActionsByDepartment(department,year);
        ActionsList actions= new Gson().fromJson(json, ActionsList.class);
        System.out.println("aa");
        return -1; // TODO 1.1: Vrať počet akcí, které mají 0 přihlášených studentů
    }
}