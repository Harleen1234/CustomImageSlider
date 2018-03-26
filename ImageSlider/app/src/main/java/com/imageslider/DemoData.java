package com.imageslider;

import java.util.ArrayList;
import java.util.List;

public class DemoData {

private Boolean status;
private List<Datum> data = new ArrayList<Datum>();

/**
* 
* @return
* The status
*/
public Boolean getStatus() {
return status;
}

/**
* 
* @param status
* The status
*/
public void setStatus(Boolean status) {
this.status = status;
}

/**
* 
* @return
* The data
*/
public List<Datum> getData() {
return data;
}

/**
* 
* @param data
* The data
*/
public void setData(List<Datum> data) {
this.data = data;
}

}