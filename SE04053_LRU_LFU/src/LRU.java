
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nvhun
 */
public class LRU {

    private String result = "";
    private int count = 0;
    private int temp = 0, currentTime = 0;
    private String resultSearch = "";

    private void addElement(ArrayList<String> list) {
        count++;
        result += "[" + count + "] ";
        for (String s : list) {
            result += s + "   ";
        }
        result += "\n";
    }

    private void reset() {
        result = "";
        count = 0;
    }
    public String[] arr;

    public String returnLRU(String sizeStr, String inputStr) {

        reset();
        arr = inputStr.split(" ");
        try {
            int size = Integer.valueOf(sizeStr);
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < arr.length; i++) {
                if (list.size() < size + 1) {
                    if (list.contains(arr[i])) {
                        list.remove(arr[i]);
                        list.add(arr[i]);
                    } else if (list.size() < size) {
                        list.add(arr[i]);
                    } else if (list.size() == size) {
                        list.remove(0);
                        list.add(arr[i]);
                    }

                    addElement(list);
                    currentTime++;
                    if (temp == currentTime) {
                        ArrayList<String> listSearch = new ArrayList<String>();
                        listSearch.add(arr[i]);
                        addElementSearch(listSearch);
                    }

                }
            }

        } catch (Exception e) {

        }
        return result;
    }
    
    private void addElementSearch(ArrayList<String> list) {

        resultSearch += "[" + currentTime + "] ";
        for (String s : list) {
            resultSearch += s + "   ";
        }
        resultSearch += "\n";
    }
    
    public void setLineSearch(int search){
        temp = search;
    }
    
    public String returnSearchValue(){
        return resultSearch;
    }

}
