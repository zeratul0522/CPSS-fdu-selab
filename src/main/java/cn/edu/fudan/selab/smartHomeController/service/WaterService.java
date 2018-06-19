package cn.edu.fudan.selab.smartHomeController.service;

import cn.edu.fudan.selab.smartHomeController.utility.Parameters;

import java.util.ArrayList;

public interface WaterService {

    public boolean is_boiled();

    public boolean book_water(String name);

    public String now_first(ArrayList<String> arrayList);

    public boolean drink_water(ArrayList<String> arrayList);

    public String get_list(ArrayList<String> arrayList);
}
