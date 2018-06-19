package cn.edu.fudan.selab.smartHomeController.service;

import cn.edu.fudan.selab.smartHomeController.utility.Parameters;

import java.util.ArrayList;

final class ServiceWater implements WaterService {




    public boolean is_boiled()
    {
        return true;
    }

    public boolean book_water(String name)
    {
        Parameters.WaterList.add(name);
        return true;
    }

    public String now_first(ArrayList<String> arrayList)
    {
        return arrayList.get(0);
    }

    public boolean drink_water(ArrayList<String> arrayList)
    {
        arrayList.remove(0);
        return true;
    }

    public String get_list(ArrayList<String> arrayList)
    {
        return arrayList.toString();
    }



}
